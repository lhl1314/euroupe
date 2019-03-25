package com.ouqicha.europebusiness.service.impl;

import com.google.common.collect.Sets;
import com.ouqicha.europebusiness.bean.entity.*;
import com.ouqicha.europebusiness.bean.vo.*;
import com.ouqicha.europebusiness.dao.*;
import com.ouqicha.europebusiness.service.LoginInfoService;
import com.ouqicha.europebusiness.service.UserInfoService;
import com.ouqicha.europebusiness.util.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    Mapper mapper;
    @Autowired
    RoleDao roleDao;

    @Autowired
    DialogueDao dialogueDao;
    @Autowired
    AccountRoleDao accountRoleDao;

    @Autowired
    SessionDao sessionDao;

    @Autowired
    PersonDao personDao;

    @Autowired
    LoginInfoService loginInfoService;

    @Autowired
    ImportExportDao importExportDao;


    //    @Autowired
//    JavaMailSender javaMailSender;
    @Override
    public AccountVO findByMobile(String userName) {
        AccountEntity entity = userInfoDao.findByMobile(userName);
//        e = (AccountEntity)entity;
        AccountVO desc = mapper.map(entity, AccountVO.class);
//        AccountVO desc1 = transforEntity(AccountVO.class, e);
        return desc;
    }

    @Override
    public AccountEntity findByMobile1(String userName) {
        AccountEntity entity = userInfoDao.findByMobile(userName);
        //AccountVO desc = mapper.map(entity, AccountVO.class);
        return entity;
    }

    //根据用户名获得用户的所有角色
    @Override
    public Set<String> queryUserRole(String userName) {
        AccountEntity user = userInfoDao.findByMobile(userName);
        if (user == null) {
            return Collections.emptySet();
        }
        Collection<AccountRoleEntity> roles = user.getAccountRolesById();
        List<String> roleList = new ArrayList<String>();
        for (AccountRoleEntity role : roles) {
            roleList.add(role.getRoleByRoleId().getRoleName());
        }
        return Sets.newHashSet(roleList);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        AccountEntity user = userInfoDao.findByMobile(userName);
        AccountVO vo = mapper.map(user, AccountVO.class);
        Collection<AccountRoleVO> roles = vo.getAccountRoles();
        Set<String> permissionSet = new HashSet<>();
        for (AccountRoleVO role : roles) {
            Collection<RolePermissionVO> permissions = role.getRole().getRolePermissions();
            for (RolePermissionVO rolePermissionVO : permissions) {
                PermissionVO permission = rolePermissionVO.getPermission();
                String permissionName = permission.getPermissionName();
                permissionSet.add(permissionName);
            }
        }
        return permissionSet;
    }

    @Override
    public void saveAccount(AccountEntity accountEntity) throws Exception {
        userInfoDao.saveOrUpdate(accountEntity);
    }

    @Override
    public List<AccountVO> getAllAccount() {
        List<AccountEntity> entities = userInfoDao.findAll();
        if (entities != null && !entities.isEmpty()) {
            List<AccountVO> voList = Utils.setDozerList(mapper, entities, AccountVO.class);
            return voList;
        }
        return null;
    }


    @Override
    public Page<AccountVO> getAccountByPage(int pageId, int pageSize) {
        Long count = userInfoDao.countOfAccount();
        int sqlCount = count.intValue();
        int pageTotal = (int) Math.ceil(sqlCount / pageSize);//总的页数
        List<AccountEntity> entities = userInfoDao.getByPageNum(pageId, pageSize);
        if (entities != null && !entities.isEmpty()) {
            List<AccountVO> voList = Utils.setDozerList(mapper, entities, AccountVO.class);
            PageControl<AccountVO> pageControl = new PageControl<>();
            Page<AccountVO> page = pageControl.setPage(pageId - 1, pageTotal, voList);
            return page;
        }
        return null;
    }

    @Override
    public Page<AccountVO> getAccountByPageAndState(int pageId, int pageSize, int state) {
        Long count = userInfoDao.countOfAccountByState(state);
        int sqlCount = count.intValue();
        int pageTotal = (int) Math.ceil(sqlCount / pageSize);//总的页数
        List<AccountEntity> entities = userInfoDao.getByPageAndState(pageId, pageSize, state);
        List<AccountVO> voList = Utils.setDozerList(mapper, entities, AccountVO.class);
        for (AccountVO vo:voList){
            Set<AccountRoleVO>newListSet=new HashSet<>();
            Collection<AccountRoleVO> voAccountRoles = vo.getAccountRoles();
            for (AccountRoleVO accountRoleVO:voAccountRoles){
                newListSet.add(accountRoleVO);
            }
            vo.setNewAccountRoleVoList(newListSet);
        }
        PageControl<AccountVO> pageControl = new PageControl<>();
        Page<AccountVO> page = pageControl.setPage(pageId - 1, pageTotal, voList);
        return page;
    }

    @Override
    public void deleteAccountRole(int accountRoleId) {
        AccountRoleEntity roleEntity = accountRoleDao.findOne(accountRoleId);
        accountRoleDao.deleteAccountRole(roleEntity);
    }


    @Override
    public void addAccountRole(AccountEntity entity, String roleIds) {
        if (roleIds != "") {
            String[] strings = roleIds.split(",");
            entity.setIsDelete(0);
            entity.setState(100);
            entity.setVip(0);
            userInfoDao.saveOrUpdate(entity);
            for (String s : strings) {
                Integer roleId = Integer.parseInt(s);
                RoleEntity role = roleDao.findPermissionByRole(roleId);//找一个角色
                AccountRoleEntity accountRoleEntity = new AccountRoleEntity();//找一个账户
                /**
                 * 账户角色中间表添加信息-----
                 */
                accountRoleEntity.setAccountByAccountId(entity);
                accountRoleEntity.setRoleByRoleId(role);
                accountRoleEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
                accountRoleEntity.setGmtUpdate(new Timestamp(System.currentTimeMillis()));
                accountRoleEntity.setIsDelete(0);
                accountRoleDao.saveOrUpdateAccountRole(accountRoleEntity);
            }
        }
    }

    @Override
    public void freezeOrUnfreezeUser(int id) {
        AccountEntity entity = userInfoDao.get(id);
        /**
         * isDelete字段代表是否被删除
         * 注意，登录的时候也要查询该字段，该用户是否已经被删除
         */
        if (entity.getIsDelete() == 1) {
            entity.setIsDelete(0);
        } else {
            entity.setIsDelete(1);
        }
        userInfoDao.saveOrUpdate(entity);
    }


    @Override
    public HashSet<AccountVO> getAdminAlsoReadDialogue(int acceptId,int orRead) {
//        List<DialogueEntity> dialoguesNoRead = dialogueDao.getDialoguesNoRead(orRead);
        List<DialogueEntity> dialoguesNoRead = dialogueDao.getMeNoRead(acceptId, orRead);
        dialogueDao.getMeNoRead(acceptId, orRead);
        HashSet<AccountVO> vos = new HashSet<>();
        for (DialogueEntity entity : dialoguesNoRead) {
            Integer sendId = entity.getSendId();//获取新信息的发送者
            AccountEntity accountEntity = userInfoDao.getOneByIdAndState(sendId, 1);
            if (accountEntity != null) {//找的是非管理员
                AccountVO vo = mapper.map(accountEntity, AccountVO.class);
                int noReadCount = dialogueDao.noReadCount(vo.getId(), 0).intValue();
                vo.setNoReadCount(noReadCount);
                vos.add(vo);
            }
        }
        for (AccountVO s : vos) {
            System.out.println(s);
        }
        return vos;
    }


    @Override
    public ResponseData<AccountVO> login(
            String name,
            String password,
            HttpSession httpSession) {
        ResponseData<AccountVO> responseData = new ResponseData<AccountVO>();

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);//shiro进行验证用户登陆合法性, 如果合法，则更新session表userid
        AccountVO accountVO = (AccountVO) subject.getPrincipal();
        Session session = subject.getSession();//
        if (null != session) {
            String sessionId = session.getId().toString();
            System.out.println("=======" + sessionId);
            accountVO.setToken(sessionId);
            int userId = accountVO.getId();
            sessionDao.updateSessionByUserId(userId, sessionId);
            loginInfoService.changLoginInfo(userId);
            /**
             * 设置一个HttpSession
             */
            httpSession.setAttribute(sessionId, accountVO);
        }
        responseData.setData(accountVO);
        responseData.setErrorCode(EnumResponse.LOGIN_PASSWORD_SUCCESS.getCode());//1
        responseData.setErrorMessage(EnumResponse.LOGIN_PASSWORD_SUCCESS.getMsg());//账号正确登录成功
        return responseData;
    }

    @Override
    public ResponseData<AccountVO> register(AccountEntity entity, String verifyCode, HttpSession session) {
        ResponseData<AccountVO> responseData = new ResponseData<AccountVO>();
        String o = (String) session.getAttribute("verifyCode");
        if (o != null && o != "") {
            if (o.equals(verifyCode)) {
                String passMd5 = MD5Util.getMD5(entity.getPassword());
                entity.setPassword(passMd5);
                entity.setIsDelete(0);//非删除状态
                entity.setState(1);//普通用户
                entity.setVip(0);//非管理员
                userInfoDao.saveOrUpdate(entity);
                AccountVO vo = mapper.map(entity, AccountVO.class);
                responseData.setErrorCode(EnumResponse.register_verify_code_success.getCode());
                responseData.setErrorMessage(EnumResponse.register_verify_code_success.getMsg());
                responseData.setData(vo);
                return responseData;
            } else {
                responseData.setErrorMessage(EnumResponse.register_verify_code_failed.getMsg());
                responseData.setErrorCode(EnumResponse.register_verify_code_failed.getCode());
                responseData.setData(null);
                return responseData;
            }
        }
        return null;
    }

    @Override
    public AccountVO findByMailBox(String mailBox) {
        AccountEntity entity = userInfoDao.findByEmail(mailBox);
        AccountVO vo = mapper.map(entity, AccountVO.class);
        return vo;
    }

    @Override
    public ResponseData<String> verifyPhoneOrEmailMessage(String msg, HttpSession session) {
        boolean b = Utils.checkEmail(msg);
        ResponseData<String> responseData = new ResponseData<>();
        if (b) {
            AccountEntity entity = userInfoDao.findByEmail(msg);
            if (entity != null) {
                responseData.setData(null);
                responseData.setErrorCode(EnumResponse.REGISTER_EMAIL_ALSO.getCode());
                responseData.setErrorMessage(EnumResponse.REGISTER_EMAIL_ALSO.getMsg());
                return responseData;
            } else {
                String verifyCode = Utils.getRandNumbers();
                session.setAttribute("verifyCode", verifyCode);
                sendEmail(msg, "验证码注册", verifyCode);
                responseData.setData(verifyCode);
                responseData.setErrorCode(EnumResponse.send_verifyCode_success.getCode());
                responseData.setErrorMessage(EnumResponse.send_verifyCode_success.getMsg());
                return responseData;
            }
        } else {
            //是手机号；
            AccountEntity mobile = userInfoDao.findByMobile(msg);
            if (mobile != null) {
                responseData.setData(null);
                responseData.setErrorCode(1);
                responseData.setErrorMessage("该手机号已经注册！");
                return responseData;
            } else {
                String code = SendPersonPhoneVerifyCode.sendCode(msg);
                session.setAttribute("verifyCode", code);
                responseData.setErrorCode(0);
                responseData.setData(code);
                responseData.setErrorMessage("手机号验证码发送成功！");
                return responseData;
            }
        }
    }

    @Override
    public ResponseData<String> sendFindAccountCode(String emailOrPhone, HttpSession session) {
        //中国个人 1
        //在欧华企 2
        //欧洲企业 3
        ResponseData<String> responseData = new ResponseData<>();
        boolean b = Utils.checkEmail(emailOrPhone);
        if (b) {
            //这是邮箱的发送验证码
            AccountEntity entity = userInfoDao.findByEmail(emailOrPhone);
            if (entity != null && !entity.getType().equals("1")) {
                //账户存在，而且欧洲企业
                String s = Utils.getRandNumbers();
                sendEmail(emailOrPhone, "企业找回账户密码", s);
                session.setAttribute("verifyCode", s);
                responseData.setErrorMessage("企业账户找回账户验证码发送成功！");
                responseData.setErrorCode(1);
                responseData.setData(s);
                return responseData;
            } else {
                responseData.setErrorMessage("该邮箱非企业注册账号");
                responseData.setErrorCode(0);
                responseData.setData(null);
                return responseData;
            }
        } else {
            //这个是中国个人找账号
            AccountEntity accountEntity = userInfoDao.findByMobile(emailOrPhone);
            if (accountEntity != null && accountEntity.getType().equals("1")) {
                //中国个人的账户
                String code = SendPersonPhoneVerifyCode.sendCode(emailOrPhone);
                if (code != null && code != "") {
                    session.setAttribute("verifyCode", code);
                    responseData.setData(code);
                    responseData.setErrorCode(1);
                    responseData.setErrorMessage("中国个人手机找回密码验证码发送成功");
                    return responseData;
                }
            } else {
                responseData.setErrorMessage("该手机号未注册");
                responseData.setErrorCode(0);
                responseData.setData(null);
                return responseData;
            }
        }

        return null;
    }

    @Override
    public ResponseData<String> updatePasswordAccount(String emailOrPhone, String verifyCode, String password, HttpSession session) {
        String o = (String) session.getAttribute("verifyCode");
        ResponseData<String> responseData = new ResponseData<>();
        if (o != null && o != "") {
            if (o.equals(verifyCode)) {
                boolean b = Utils.checkEmail(emailOrPhone);
                AccountEntity entity = null;
                if (b) {
                    //企业邮箱账户忘记密码的修改
                    entity = userInfoDao.findByEmail(emailOrPhone);
                    if (entity != null && !entity.getType().equals("1")) {
                        entity.setPassword(MD5Util.getMD5(password));
                        userInfoDao.saveOrUpdate(entity);
                        responseData.setErrorMessage("企业账户密码修改成功");
                        responseData.setErrorCode(1);
                    } else {
                        responseData.setErrorMessage("该邮箱未注册");
                        responseData.setErrorCode(0);
                    }
                } else {
                    //中国个人找回密码
                    entity = userInfoDao.findByMobile(emailOrPhone);
                    if (entity != null && entity.getType().equals("1")) {
                        entity.setPassword(MD5Util.getMD5(password));
                        userInfoDao.saveOrUpdate(entity);
                        responseData.setErrorMessage("中国个人忘记密码修改成功！");
                        responseData.setErrorCode(1);
                    } else {
                        responseData.setErrorMessage("该手机号未注册");
                        responseData.setErrorCode(0);
                    }
                }
                responseData.setData(null);
                return responseData;
            } else {
                //验证码错误
                responseData.setErrorMessage("验证码错误");
                responseData.setErrorCode(0);
                responseData.setData(null);
                return responseData;
            }
        }
        return null;
    }

    @Override
    public ResponseData<String> updateAccountPassword(HttpSession session, String oldPassword, String newPassword) {

        AccountVO user = (AccountVO) session.getAttribute("user");
        ResponseData<String> responseData = new ResponseData<>();
        if (user != null) {
            if (MD5Util.getMD5(oldPassword).equals(user.getPassword())) {
                user.setPassword(MD5Util.getMD5(newPassword));
                session.setAttribute("user", user);
                AccountEntity entity = mapper.map(user, AccountEntity.class);
                //修改密码
                userInfoDao.saveOrUpdate(entity);
                responseData.setData(null);
                responseData.setErrorMessage("密码修改成功");
                responseData.setErrorCode(0);
            } else {
                //旧的密码输入错误
                responseData.setData(null);
                responseData.setErrorMessage("旧密码输入错误");
                responseData.setErrorCode(1);
                return responseData;
            }
        }
        return null;
    }

    public void sendEmail(String sendTo, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom("1694190210@qq.com");
            helper.setTo(sendTo);
            helper.setSubject(subject);
            helper.setText(content, true);   //内容 带浮动的html，只要内联样式都可以
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseData<List<CompanyVO>> getAllBasicCompany(int pageNum, int pageSize) {
        ResponseData<List<CompanyVO>> responseData = new ResponseData<>();
        List<CompanyEntity> list = companyDao.getCompanyList(pageNum, pageSize);
        if (list != null && !list.isEmpty()) {
            List<CompanyVO> voList = Utils.setDozerList(mapper, list, CompanyVO.class);
            responseData.setData(voList);
            responseData.setErrorCode(0);
            responseData.setErrorMessage("企业列表");
            return responseData;
        }
        return null;
    }

    @Override
    public ResponseData<List<CompanyVO>> getCompanyFindLike(String msg) {
        ResponseData<List<CompanyVO>> responseData = new ResponseData<>();
        List<CompanyEntity> entities = companyDao.findLikeCompany(msg);
        if (entities != null && !entities.isEmpty()) {
            List<CompanyVO> voList = Utils.setDozerList(mapper, entities, CompanyVO.class);
            responseData.setData(voList);
            responseData.setErrorMessage("模糊企业查询结果");
            responseData.setErrorCode(0);
            return responseData;
        }
        return null;
    }

    @Override
    public ResponseData<CompanyVO> getOneCompanyBasic(int id) {
        ResponseData<CompanyVO> responseData = new ResponseData<>();
        CompanyEntity entity = companyDao.findOneById(id);
        if (entity != null) {
            CompanyVO vo = mapper.map(entity, CompanyVO.class);
            responseData.setData(vo);
            responseData.setErrorCode(0);
            responseData.setErrorMessage("企业详细信息");
            return responseData;
        } else {
            responseData.setData(null);
            responseData.setErrorCode(1);
            responseData.setErrorMessage("无");
            return null;
        }
    }

    @Override
    public ResponseData<AccountVO> improvePersonInformation(
            Integer accountId,
            String personName,
            String headImage,
            String sex,
            String duty,
            CompanyEntity companyEntity,
            HttpSession session) {
        ResponseData<AccountVO> responseData = new ResponseData<>();
        AccountEntity accountEntity = userInfoDao.get(accountId);
        companyDao.saveOrUpdateCompany(companyEntity);
        PersonEntity personEntity=new PersonEntity();
        personEntity.setHeaderImage(headImage);//上传个人头像
        personEntity.setSex(sex);
        personEntity.setDuty(duty);
        personEntity.setPersonName(personName);
        personEntity.setIsDelete(0);
        personEntity.setMobile(accountEntity.getMobile());
        personEntity.setCompanyByCompanyId(companyEntity);
        personDao.saveOrUpdate(personEntity);//添加person个人信息
        accountEntity.setPersonByPersonId(personEntity);
        accountEntity.setCompanyByCompanyId(companyEntity);
        userInfoDao.saveOrUpdate(accountEntity);//修改账户信息
        responseData.setErrorCode(1);
        responseData.setErrorMessage("个人信息完善成功");
        return responseData;
    }

    @Override
    public ResponseData<AccountVO> improveCompanyInformation(
            Integer accountId,
            CompanyEntity companyEntity,
            HttpSession session) {
        AccountEntity accountEntity = userInfoDao.get(accountId);
        companyEntity.setType(accountEntity.getType());
        companyDao.saveOrUpdateCompany(companyEntity);
        accountEntity.setCompanyByCompanyId(companyEntity);
        userInfoDao.saveOrUpdate(accountEntity);
        ResponseData<AccountVO> responseData = new ResponseData<>();
        responseData.setErrorCode(1);
        responseData.setErrorMessage("中国企业完善信息成功");
        return responseData;
    }

    @Override
    public ResponseData<AccountVO> improveEuropeCompanyInformation(
            Integer accountId, CompanyEntity companyEntity,
            ImportExportEntity importExportEntity,
            HttpSession session) {
        AccountEntity accountEntity = userInfoDao.get(accountId);
        companyDao.saveOrUpdateCompany(companyEntity);
        accountEntity.setCompanyByCompanyId(companyEntity);
        userInfoDao.saveOrUpdate(accountEntity);
        if (importExportEntity!=null){
            importExportEntity.setImportExportCompany(companyEntity);
            importExportEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));

            importExportDao.saveOrUpdate(importExportEntity);
        }
        ResponseData<AccountVO> responseData = new ResponseData<>();
        responseData.setErrorCode(1);
        responseData.setErrorMessage("欧洲企业信息完善成功");
        return responseData;
    }

    @Override
    public ResponseData<AccountVO> findOneAccount(int id) {
        AccountEntity entity = userInfoDao.get(id);
        if (entity != null) {
            AccountVO vo = mapper.map(entity, AccountVO.class);
            if (vo.getCompany() != null) {
                String productImages = vo.getCompany().getProductImage();
                if (productImages != null && !productImages.equals("")) {
                    String[] productImageArr = productImages.split("-");
                    List<String> productImagesList = Arrays.asList(productImageArr);
                    vo.getCompany().setProductImagesList(productImagesList);
                }
                String companyImages = vo.getCompany().getCompanyImage();
                if (companyImages != null && !companyImages.equals("")) {
                    String[] companyImageArr = companyImages.split("-");
                    List<String> companyImagesList = Arrays.asList(companyImageArr);
                    vo.getCompany().setCompanyImagesList(companyImagesList);
                }
            }
            ResponseData<AccountVO> data = new ResponseData<>();
            data.setData(vo);
            System.out.println("Vo===" + vo);
            data.setErrorMessage("账户的详细信息");
            data.setErrorCode(0);
            System.out.println("data===" + data);
            return data;
        }
        return null;
    }

    @Override
    public ResponseData<String> updateCompanyDetails(CompanyEntity companyEntity) {
        companyDao.saveOrUpdateCompany(companyEntity);
        ResponseData<String>data=new ResponseData<>();
        data.setErrorCode(1);
        data.setErrorMessage("我的中心完善企业信息");
        data.setData(null);
        return data;
    }

    @Override
    public ResponseData<String> updatePersonInformation(PersonEntity personEntity) {
        personDao.saveOrUpdate(personEntity);
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setErrorCode(0);
        responseData.setErrorMessage("修改个人详细信息成功");
        responseData.setData(null);
        return responseData;
    }


    /**
     * 判断session是否过期
     *
     * @param token
     * @return
     */
    public Integer judgeSession(String token) {
        Subject subject = SecurityUtils.getSubject();
        String sessionId = subject.getSession().getId().toString();
        if (sessionId != null && !sessionId.equals("")) {
            if (token.equals(sessionId)) {
                //session未过期，直接操作数据。
                SessionEntity session = sessionDao.findSession(token);
                int accountId = session.getId();
                return accountId;
            }
        }
        //过期直接让用户去登录好了，不返回数据。
        return null;
    }


    @Override
    public void adminUpdateAccount(AccountVO accountVO) {
        AccountEntity accountEntity = userInfoDao.get(accountVO.getId());
        if (accountEntity!=null){
            accountEntity.setMobile(accountVO.getMobile());
            accountEntity.setPassword(accountVO.getPassword());
            userInfoDao.saveOrUpdate(accountEntity);
        }
    }

    @Override
    public int forgetPasswordUpdate(String phone, String password) {
        AccountEntity entity = userInfoDao.findByMobile(phone);
        if (entity!=null){
            entity.setPassword(MD5Util.getMD5(password));
            userInfoDao.saveOrUpdate(entity);
            return 1;//修改成功
        }
        return 0;//用户不存在
    }
}

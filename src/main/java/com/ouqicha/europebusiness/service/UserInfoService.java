package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.ImportExportEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.bean.vo.PersonVO;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.util.Page;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserInfoService {

    /**
     * 根据电话号码获得 AccountVO 对象
     *
     * @param params 电话号码
     */
    public AccountVO findByMobile(String params);

    /**
     * 根据电话号码获得AccountEntity对象
     *
     * @param params 电话号码
     * @return
     */
    public AccountEntity findByMobile1(String params);

    /**
     * 根据用户名获得用户的所有角色
     *
     * @param userName 用户名
     */
    public Set<String> queryUserRole(String userName);

    /**
     * 获取该用户所有的角色以及权限
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 保存账号信息
     *
     * @param accountEntity
     */
    public void saveAccount(AccountEntity accountEntity) throws Exception;


    /**
     * 获取所有的账户信息
     *
     * @return
     */
    List<AccountVO> getAllAccount();

//    public <T> T transforEntity(Class<T> clazz, E e);

    /**
     * 账户的分页信息
     *
     * @param pageId
     * @param pageSize
     * @return
     */
    Page<AccountVO> getAccountByPage(int pageId, int pageSize);

    /**
     * 根据state的不同，获取不同的账户，例如用户或者管理员
     *
     * @param pageId
     * @param pageSize
     * @param state
     * @return
     */
    Page<AccountVO> getAccountByPageAndState(int pageId, int pageSize, int state);

    /**
     * 删除账户角色中间表
     *
     * @param accountRoleId
     */
    void deleteAccountRole(int accountRoleId);

    /**
     * 管理员添加账户角色信息
     *
     * @param entity
     * @param roleIds
     */
    void addAccountRole(AccountEntity entity, String roleIds);


    /**
     * 管理员冻结用户或者解冻，实际上是改变字段
     *
     * @param id
     */
    void freezeOrUnfreezeUser(int id);

    /**
     * 找到新留言的用户
     *
     * @param orRead
     * @return
     */
    HashSet<AccountVO> getAdminAlsoReadDialogue(int acceptId,int orRead);


    /**
     * app的接口
     */
    /**
     * 通过邮件找一个账户
     * @param mailBox
     * @return
     */
    AccountVO findByMailBox(String mailBox);
    /**
     * App的登录
     * @param name
     * @param password
     * @return
     */
    ResponseData<AccountVO>login(String name,String password,HttpSession session);

    /**
     * App入口的注册
     * @param entity
     * @return
     */
    ResponseData<AccountVO>register(AccountEntity entity, String verifyCode, HttpSession session);


    /**
     * 发送邮箱或者手机号验证码
     * @param msg
     * @return
     */
    ResponseData<String> verifyPhoneOrEmailMessage(String msg,HttpSession session);


    /**
     * 找回密码，发送手机号验证码
     * @param emailOrPhone
     * @param session
     * @return
     */
    ResponseData<String> sendFindAccountCode(String emailOrPhone,HttpSession session);


    /**
     * 发送验证码后修改账户密码
     * @param emailOrPhone
     * @param verifyCode
     * @param password
     * @return
     */
    ResponseData<String>updatePasswordAccount(String emailOrPhone,String verifyCode,String password,HttpSession session);


    /**
     * 登录状态下修改账户密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    ResponseData<String>updateAccountPassword(HttpSession session,String oldPassword,String newPassword);


    /**
     * 获取所有的企业信息，其实应该模糊查询企业信息
     * @return
     */
    ResponseData<List<CompanyVO>>getAllBasicCompany(int pageNum,int pageSize);

    /**
     * 模糊查询企业
     * @param msg
     * @return
     */
    ResponseData<List<CompanyVO>>getCompanyFindLike(String msg);

    /**
     * 获取一条企业的详细信息
     * @param id
     * @return
     */
    ResponseData<CompanyVO>getOneCompanyBasic(int id);


    /**
     * 完善个人信息
     * @param accountId
     */
    ResponseData<AccountVO> improvePersonInformation(
            Integer accountId,
            String headImage,
            String personName,
            String sex,
            String duty,
            CompanyEntity companyEntity,
            HttpSession session);


    /**
     * 完善中国企业信息
     * @param accountId
     * @param companyEntity

     * @return
     */
    ResponseData<AccountVO> improveCompanyInformation(
            Integer accountId,
            CompanyEntity companyEntity,
            HttpSession session
    );

    /**
     * 完善欧洲企业信息
     * @param accountId
     * @param companyEntity
     * @param importExportEntity
     * @return
     */
    ResponseData<AccountVO> improveEuropeCompanyInformation(
            Integer accountId,
            CompanyEntity companyEntity,
            ImportExportEntity importExportEntity,
            HttpSession session
           );

    /**
     * 找一个账户的详细信息
     * @param id
     * @return
     */
    ResponseData<AccountVO>findOneAccount(int id);

    /**
     * 我的---完善企业信息
     * @param companyEntity
     * @return
     */
    ResponseData<String>updateCompanyDetails(CompanyEntity companyEntity);

    /**
     * 修改个人的详细信息 person
     * @param personEntity
     * @return
     */
    ResponseData<String>updatePersonInformation(PersonEntity personEntity);


    /**
     * 修改管理账户密码
     * @param accountVO
     */
    void adminUpdateAccount(AccountVO accountVO);


    /**
     * 管理员忘记密码的修改
     * @param phone
     * @param password
     * @return
     */
    int  forgetPasswordUpdate(String phone,String password);
}

package com.ouqicha.europebusiness.controller.user;

import com.ouqicha.europebusiness.bean.entity.CompanyAuthenticationEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.DialogueEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.bean.vo.*;

import com.ouqicha.europebusiness.service.*;
import com.ouqicha.europebusiness.util.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:8:31
 */
@Controller
@RequestMapping(value = "/app/myself")
public class MyselfController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    CompanyService companyService;
    @Autowired
    CollectService collectService;
    @Autowired
    AdviceService adviceService;
    @Autowired
    HelpCenterService helpCenterService;
    @Autowired DialogueService dialogueService;

    @Autowired
    CompanyAuthenticationService companyAuthenticationService;

    /**
     * ------------需要验证token
     * 个人信息或者企业信息
     *
     * @param accountId
     */
    @RequestMapping(value = "/findOnePersonOrCompany")
    @ResponseBody
    public ResponseData<AccountVO> findOnePerson(
            @RequestParam(name = "token") String token,
            @RequestParam(name = "accountId") int accountId, HttpSession session) {
        String s = session.getId().toString();
        if (s.equals(token)) {
            ResponseData<AccountVO> data = userInfoService.findOneAccount(accountId);
            return data;
        } else {
            ResponseData<AccountVO> data = new ResponseData<>();
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }

    /**
     * 完善企业上传logo
     *
     * @param companyLogo
     * @return
     */
    @RequestMapping(value = "/uploadCompanyLogo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> uploadCompanyLogo(
            String token,
            HttpSession session,
            HttpServletRequest request,
            @RequestParam("companyLogo") MultipartFile companyLogo) throws IOException {
        ResponseData<String> data = new ResponseData<>();
        String sessionId = session.getId().toString();
        if (token.equals(sessionId)) {
            boolean b = Utils.uploadOneFile(request, companyLogo);
            if (b) {
                String companyLogoUrl = (String) request.getSession().getAttribute("imageUploadUrl");
                data.setData(companyLogoUrl);
                data.setErrorCode(1);
                data.setErrorMessage("企业logo上传成功");
            } else {
                data.setData(null);
                data.setErrorCode(0);
                data.setErrorMessage("企业logo上传失败");
            }
            return data;
        } else {
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }

    /**
     * 完善企业，上传企业产品图片
     *
     * @param companyProductImages
     * @return
     */
    @RequestMapping(value = "/uploadCompanyProductImages", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> uploadCompanyProductImages(
            String token,
            HttpSession session,
            HttpServletRequest request,
            @RequestParam("companyProductImages") MultipartFile[] companyProductImages) {
        String sessionId = session.getId().toString();
        ResponseData<String> data = new ResponseData<>();
        if (sessionId.equals(token)) {
            boolean b = Utils.uploadManyFiles(request, companyProductImages);
            if (b) {
                String companyProductImagesUrls = (String) request.getSession().getAttribute("imageUploadUrl");
                data.setErrorMessage("企业上传公司产品图片成功");
                data.setErrorCode(1);
                data.setData(companyProductImagesUrls);
            } else {
                data.setErrorMessage("企业上传公司产品图片失败");
                data.setErrorCode(0);
            }
            return data;
        } else {
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }

    /**
     * 我的---完善企业信息
     *
     * @param companyEntity
     * @return
     */
    @RequestMapping(value = "/updateCompanyDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> updateCompanyDetails(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @ModelAttribute CompanyEntity companyEntity) {
        String sessionId = session.getId().toString();
        if (token.equals(sessionId)) {
            ResponseData<String> data = userInfoService.updateCompanyDetails(companyEntity);
            return data;
        } else {
            ResponseData<String> data = new ResponseData<>();
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }

    @RequestMapping(value = "/findOnew")
    @ResponseBody
    public AccountVO findOnew(int id) {
        ResponseData<AccountVO> data = userInfoService.findOneAccount(id);
        AccountVO vo = data.getData();
        return vo;
    }

    @RequestMapping(value = "/fas")
    @ResponseBody
    public AccountVO fas() {
        AccountVO vo = new AccountVO();
        vo.setEmail("asdfasfas");
        CompanyVO companyVO = new CompanyVO();
        companyVO.setAddress("法师打发士大夫");
        companyVO.setCountry("dfasfa");
        return vo;
    }

    /**
     * ------------需要验证token
     * 修改个人的详细信息person表
     *
     * @return
     */
    @RequestMapping(value = "/updatePersonInformation")
    @ResponseBody
    public ResponseData<String> updatePersonInformation(PersonEntity personEntity) {
        ResponseData<String> responseData = userInfoService.updatePersonInformation(personEntity);
        return responseData;
    }


    /**
     * ------------需要验证token
     * 修改企业账户的详细信息
     *
     * @return
     */
    @RequestMapping(value = "/updateCompanyInformation")
    @ResponseBody
    public ResponseData<String> updateCompanyInformation(CompanyEntity companyEntity) {
        companyService.updateCompany(companyEntity);
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setData(null);
        responseData.setErrorMessage("修改企业详细信息成功");
        responseData.setErrorCode(0);
        return responseData;
    }


    /**
     * ------------需要验证token
     * app注销登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public ResponseData<String> loginOut(String token, HttpSession session) {
        String sessionId = session.getId();
        ResponseData<String> data = new ResponseData<>();
        if (sessionId.equals(token)) {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            data.setErrorCode(1);
            data.setErrorMessage("账户注销成功");
            data.setData(null);
        }
        return data;
    }

    /**
     * ------------需要验证token
     * 添加建议
     *
     * @param accountId
     * @param advice
     * @return
     */
    @RequestMapping(value = "/addAdvice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> addAdvice(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @RequestParam(name = "accountId") int accountId,
            @RequestParam(name = "advice") String advice) {
        boolean b = session.getId().equals(token);
        if (b){
            ResponseData<String> data = adviceService.addAdvice(accountId, advice);
            return data;
        }else {
            ResponseData<String> data = new ResponseData<>();
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }


    /**
     * ------------需要验证token
     * 添加收藏企业
     *
     * @param accountId
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/addCollectCompany", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> addCollectCompany(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @RequestParam(name = "accountId") int accountId,
            @RequestParam(name = "companyId") int companyId) {
        boolean b = session.getId().equals(token);
        if (b){
            ResponseData<String> data = collectService.addCollectCompany(accountId, companyId);
            return data;
        }else {
            ResponseData<String> data = new ResponseData<>();
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }
    /**
     * ------------需要验证token
     * 删除收藏-
     *
     * @param collectId
     * @return
     */
    @RequestMapping(value = "/deleteCollectCompany", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> deleteCollectCompany(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @RequestParam(name = "collectId") int collectId) {
        boolean b = session.getId().equals(token);
        if (b){
            return collectService.deleteCollectCompany(collectId);
        }else {
            ResponseData<String> data = new ResponseData<>();
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }


    /**
     * ------------需要验证token
     * 我的收藏
     *
     * @param accountId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/findMyCollectByPage", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<CollectVo>> findMyCollectByPage(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @RequestParam(name = "accountId", required = true) int accountId,
            @RequestParam(name = "pageNum", defaultValue = "1", required = true) int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "4", required = false) int pageSize) {
        boolean b = session.getId().equals(token);
        if (b){
            ResponseData<List<CollectVo>> data = collectService.findMyCollectByPage(accountId, pageNum, pageSize);
            return data;
        }else {
            ResponseData<List<CollectVo>> data = new ResponseData<>();
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }

    /**
     * ------------需要验证token
     * 帮助中心获取问题答案
     *
     * @return
     */
    @RequestMapping(value = "/getHelpCenterContent", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<HelpCenterHeaderVo>> getHelpCenterContent(String token, HttpSession session) {
        String sessionId = session.getId().toString();
        if (sessionId.equals(token)) {
            ResponseData<List<HelpCenterHeaderVo>> content = helpCenterService.getAllHelpCenterContent();
            return content;
        } else {
            ResponseData<List<HelpCenterHeaderVo>> a = new ResponseData<>();
            a.setData(null);
            a.setErrorMessage("请用户重新登录");
            a.setErrorCode(0);
            return a;
        }
    }

    /**
     * ------------需要验证token
     * 登录状态下修改账户的密码
     *
     * @param session
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping("/updateAccountPassword")
    public ResponseData<String> updateAccountPassword(
            String token,
            HttpSession session,
            @RequestParam(name = "oldPassword") String oldPassword,
            @RequestParam(name = "newPassword") String newPassword) {
        String sessionId = session.getId().toString();
        if (sessionId.equals(token)) {
            ResponseData<String> data = userInfoService.updateAccountPassword(session, oldPassword, newPassword);
            return data;
        } else {
            ResponseData<String> a = new ResponseData<>();
            a.setData(null);
            a.setErrorMessage("请用户重新登录");
            a.setErrorCode(0);
            return a;
        }
    }

    /**
     * 上传企业认证的图片资料
     *
     * @param authenticationImage
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadCompanyAuthenticationImage",method = RequestMethod.POST)
    public ResponseData<String> uploadCompanyAuthenticationImage(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @RequestParam("authenticationImage") MultipartFile authenticationImage,
            HttpServletRequest request) throws IOException {
        String sessionId = session.getId().toString();
        ResponseData<String> data = new ResponseData<>();
        if (sessionId.equals(token)) {
            boolean b = Utils.uploadOneFile(request, authenticationImage);

            if (b) {
                String s = (String) request.getSession().getAttribute("imageUploadUrl");
                data.setErrorMessage("认证图片上传成功");
                data.setErrorCode(1);
                data.setData(s);
                return data;
            } else {
                data.setErrorMessage("图片认证失败");
                data.setErrorCode(0);
                data.setData(null);
                return data;
            }
        } else {
            data.setData(null);
            data.setErrorMessage("请用户重新登录");
            data.setErrorCode(0);
            return data;
        }
    }

    /**
     * 企业申请认证
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/CompanyAuthentication",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> addCompanyAuthentication(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @ModelAttribute CompanyAuthenticationEntity entity,
            @RequestParam(name = "companyId") int companyId) {
        boolean b = session.getId().equals(token);
        if (b) {
            ResponseData<String> data = companyAuthenticationService.addCompanyAuthentication(entity, companyId);
            return data;
        } else {
            ResponseData<String> data = new ResponseData<>();
            data.setData(null);
            data.setErrorMessage("请用户重新登录");
            data.setErrorCode(0);
            return data;
        }

    }


    /**
     * 根据企业，获取该企业的认证信息
     *
     * @param companyId
     * @return
     */
    @RequestMapping(value = "/getOneCompanyAuthentication",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<CompanyAuthenticationVo> getOneCompanyAuthentication(
            @RequestParam(name = "token") String token,
            HttpSession session,
            @RequestParam(name = "companyId") int companyId) {
        boolean b = session.getId().equals(token);
        if (b) {
            ResponseData<CompanyAuthenticationVo> data = companyAuthenticationService.getOneCompanyAuthentication(companyId);
            return data;
        } else {
            ResponseData<CompanyAuthenticationVo> data = new ResponseData<>();
            data.setData(null);
            data.setErrorMessage("请用户重新登录");
            data.setErrorCode(0);
            return data;
        }
    }

    /**
     * 客服的对话
     */

    /**
     * 添加一条对话信息(前后都可以用)
     *
     * @param dialogueEntity
     * @return
     */
    @RequestMapping(value = "/addDialogue",method = RequestMethod.POST)
    @ResponseBody
    public  ResponseData<DialogueVo> addDialogue(
            HttpSession session,
            @RequestParam(name = "token") String token,
            @ModelAttribute DialogueEntity dialogueEntity) {
        boolean b = session.getId().equals(token);
        ResponseData<DialogueVo>data=new ResponseData<>();
        if (b){

            DialogueVo dialogueVo = dialogueService.addDialogue(dialogueEntity);
            data.setData(dialogueVo);
            data.setErrorCode(1);
            data.setErrorMessage("app用户留言成功");
            return data;
        }else {
            data.setData(null);
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            return data;
        }
    }

    /**
     * 获取所有的客服的id,根据id
     * @return
     */
    @RequestMapping(value = "/getAllKeFu")
    @ResponseBody
    public ResponseData<List<AccountVO>>getAllKeFu(
            HttpSession session,
            @RequestParam(name = "token") String token){
        String s = session.getId().toString();
        ResponseData<List<AccountVO>>data=new ResponseData<>();
        if (s.equals(token)){
            List<AccountVO> listKeFu = dialogueService.getAccountRoleListKeFu(3);
            data.setErrorCode(1);
            data.setErrorMessage("所有的客服账户");
            data.setData(listKeFu);
            return data;
        }else {
            data.setErrorCode(0);
            data.setErrorMessage("请用户重新登录");
            data.setData(null);
            return data;
        }
    }

    /**
     * 获取两个人之间的留言信息
     *
     * @param sendId
     * @param acceptId
     * @return
     */
    @RequestMapping(value = "/getDialogues",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<DialogueVo>> getDialogues(
            HttpSession session,
            @RequestParam(name = "token") String token,
            @RequestParam(name = "sendId") int sendId,
            @RequestParam(name = "acceptId") int acceptId) {
        ResponseData<List<DialogueVo>>data=new ResponseData<>();
        boolean b = session.getId().equals(token);
        if (b){
            List<DialogueVo> dialogues = dialogueService.getDialogues(sendId, acceptId);
            data.setErrorMessage("app获取对话信息成功");
            data.setErrorCode(1);
            data.setData(dialogues);
            return data;
        }else {
            data.setErrorMessage("请用户重新登录");
            data.setErrorCode(0);
            data.setData(null);
            return data;
        }
    }
}

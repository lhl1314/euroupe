package com.ouqicha.europebusiness.controller.user;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.ImportExportEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import com.ouqicha.europebusiness.bean.vo.*;

import com.ouqicha.europebusiness.service.LoginInfoService;
import com.ouqicha.europebusiness.service.UserInfoService;
import com.ouqicha.europebusiness.service.WorldCityService;
import com.ouqicha.europebusiness.util.Utils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.MediaSize;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 登录注册的控制层
 * Created with IDEA
 * author:lhl
 * Date:2019/3/4 0004
 * Time:9:43
 */
@Controller
@RequestMapping(value = "/app/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    LoginInfoService loginInfoService;

    @Autowired
    WorldCityService worldCityService;


    @RequestMapping(value = "/returnToken")
    @ResponseBody
    public ResponseData<String> returnToken(Session session){
        String token = session.getId().toString();
        ResponseData<String>data=new ResponseData<>();
        if (token!=null&&!token.equals("")) {
            data.setData(token);
            data.setErrorMessage("服务器返回客户端的token");
            data.setErrorCode(1);
        }else {
            data.setData(token);
            data.setErrorMessage("session失效，请退出app重新登录");
            data.setErrorCode(0);
        }
        return data;
    }

    /**---------------已测试
     * app用户的登录
     * 个人登录、手机号密码，
     * 或者企业邮箱密码
     *
     * @param name
     * @param password
     * @return登录测试成功
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<AccountVO> login(String name, String password,HttpSession session) {
        ResponseData<AccountVO> data = userInfoService.login(name, password,session);
        return data;
    }

    /**
     * 找回密码发送验证码--------已经测试
     *
     * @param emailOrPhone
     * @param session
     * @return成功
     */
    @RequestMapping(value = "/sendEmailOrPhoneToFindAccount",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> sendFindAccountCode(String emailOrPhone, HttpSession session) {
        ResponseData<String> data = userInfoService.sendFindAccountCode(emailOrPhone, session);
        return data;
    }
    /**--------------测试成功
     * 手机号发送验证码，修改密码
     *
     * @param phoneOrEmail
     * @param verifyCode
     * @param password
     * @return修改密码成功
     */
    @RequestMapping(value = "/updatePasswordAccount",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> updatePasswordAccount(
            @RequestParam(name = "phoneOrEmail") String phoneOrEmail,
            @RequestParam(name = "verifyCode") String verifyCode,
            @RequestParam(name = "password") String password, HttpSession session) {
        ResponseData<String> data = userInfoService.updatePasswordAccount(phoneOrEmail, verifyCode, password, session);
        return data;
    }

    /**------------测试成功
     * 注册。发送验证码，区分企业和个人
     * 发送验证码！如果该账户已经存在，不允许发送
     *
     * @param phoneOrEmail
     */
    @RequestMapping(value = "/verifyPhoneOrEmailMessage",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<String> verifyPhoneOrEmailMessage(String phoneOrEmail, HttpSession session) {
        ResponseData<String> responseData = userInfoService.verifyPhoneOrEmailMessage(phoneOrEmail, session);
        return responseData;
    }

    /**----------测试成功
     * 要求：用户的手机号注册和邮箱注册，必须唯一，注册完成直接完善账户信息
     * app用户的注册
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<AccountVO> register(
            @ModelAttribute AccountEntity entity, String verifyCode, HttpSession session) {
        ResponseData<AccountVO> data = userInfoService.register(entity, verifyCode, session);
        return data;
    }
    /**-------------测试成功
     * 完善个人信息前获取所有企业信息的列表
     */
    @RequestMapping(value = "/getBasicInformationCompany",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<CompanyVO>> getBasicInformationCompany(
            @RequestParam(name = "pageNum",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "10",required = false) int pageSize) {
        ResponseData<List<CompanyVO>> basicCompany = userInfoService.getAllBasicCompany(pageNum, pageSize);
        return basicCompany;
    }

    /**
     * 模糊查询获取企业列表
     *
     * @param msg
     * @return
     */
    @RequestMapping(value = "/getCompanyListLike",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<CompanyVO>> getCompanyListLike(String msg) {
        return userInfoService.getCompanyFindLike(msg);
    }

    /**
     *----------测试成功
     *获取某个企业的详细信息
     * @return
     */
    @RequestMapping(value = "/getCompanyBasic",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<CompanyVO> getCompanyBasic(int id) {
        ResponseData<CompanyVO> data = userInfoService.getOneCompanyBasic(id);
        return data;
    }

    /**---------测试成功
     * 获取一级国家地区
     *
     * @return
     */
    @RequestMapping(value = "/getCountryList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<CountryVo>> getCountryList(
            @RequestParam(name = "pageNum",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "10",required = false) int pageSize) {
        ResponseData<List<CountryVo>> data = worldCityService.getCountryList(pageNum, pageSize);
        return data;
    }

    /**测试成功
     * 获取省级地区
     *
     * @return
     */
    @RequestMapping(value = "/getProvinceList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<ProvinceVo>> getCountryList(
            @RequestParam(name = "countryId") int countryId,
            @RequestParam(name = "pageNum",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "10",required = false) int pageSize) {
        ResponseData<List<ProvinceVo>> data = worldCityService.getProvinceList(countryId,pageNum,pageSize);
        return data;
    }

    /**-------测试成功
     * 获取三级市区
     *
     * @param provinceId
     * @return
     */
    @RequestMapping(value = "/getAllCityByProvinceId",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<CityVo>> getAllCityByProvinceId(
            @RequestParam(name = "provinceId") int provinceId,
            @RequestParam(name = "pageNum",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "10",required = false) int pageSize) {
        ResponseData<List<CityVo>> data = worldCityService.getCityList(provinceId,pageNum,pageSize);
        return data;
    }

    /**--------测试成功
     * 获取四级县区
     *
     * @return
     */
    @RequestMapping(value = "/getAllPrefecture",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData<List<PrefectureVo>> getAllPrefecture(
            @RequestParam(name = "cityId") int cityId,
            @RequestParam(name = "pageNum",defaultValue = "1",required = true) int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "10",required = false) int pageSize) {
        return worldCityService.getPrefectureList(cityId,pageNum,pageSize);
    }

    /**
     * 上传个人或者企业的logo
     * @param logo
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadLogo")
    @ResponseBody
    public ResponseData<String> uploadLogo(@RequestParam("logo") MultipartFile logo,HttpServletRequest request) throws IOException {
        boolean b = Utils.uploadOneFile(request, logo);
        ResponseData<String>data=new ResponseData<>();
        if (b){
            String personOrCompanyLogo = (String) request.getSession().getAttribute("imageUploadUrl");
            data.setErrorCode(1);
            data.setErrorMessage("logo上传成功");
            data.setData(personOrCompanyLogo);
        }else {
            data.setErrorCode(0);
            data.setErrorMessage("logo上传失败，请重新上传");
            data.setData(null);
        }
        return data;
    }

    /**
     * 上传企业产品图片
     * @param productImages
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadCompanyProductImages")
    @ResponseBody
    public ResponseData<String>uploadCompanyProductImages(
            @RequestParam("productImages") MultipartFile[] productImages,HttpServletRequest request){
        ResponseData<String>data=new ResponseData<>();
        boolean b = Utils.uploadManyFiles(request, productImages);
        if (b) {
            String imageUrls = (String) request.getSession().getAttribute("imageUploadUrl");
            data.setErrorCode(1);
            data.setData(imageUrls);
            data.setErrorMessage("公司产品图片上传成功");
            return data;
        }
        data.setErrorMessage("公司产品图片上传失败");
        data.setErrorCode(0);
        data.setData(null);
        return data;
    }

    /**------------------测试成功
     * 完善中国个人信息
     *
     * @param accountVoId
     * @param companyEntity
     */
    @RequestMapping(value = "/improvePersonInformation",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<AccountVO> improvePersonInformation(
            @RequestParam(name = "accountVoId", required = true) Integer accountVoId,
            @RequestParam(name = "headImage") String headImage,
            @RequestParam(name = "personName") String personName,
            @RequestParam(name = "sex") String sex,
            @RequestParam(name = "duty") String duty,
            @ModelAttribute(value = "companyEntity") CompanyEntity companyEntity,
            HttpSession session){
            ResponseData<AccountVO> data = userInfoService.improvePersonInformation(accountVoId,headImage,personName,sex,duty,companyEntity,session);
            return data;
    }
    /**---------------测试成功
     * 中国企业注册后完善企业信息
     *
     * @param accountVoId
     * @param companyEntity
     */
    @RequestMapping(value = "/improveCompanyInformation",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<AccountVO> improveCompanyInformation(
            @RequestParam(name = "accountVoId") Integer accountVoId,
            @ModelAttribute CompanyEntity companyEntity,
            HttpSession session,
            HttpServletRequest request) throws IOException {
            ResponseData<AccountVO> data = userInfoService.improveCompanyInformation(accountVoId, companyEntity,session);
            return data;
    }

    /**
     * 注册时完善欧洲企业的信息
     *
     * @param accountVoId
     * @param companyEntity
     * @param importExportEntity
     */
    @RequestMapping(value = "/improveEuropeCompany",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData<AccountVO> improveEuropeCompany(
            @RequestParam(name = "accountVoId") Integer accountVoId,
            @ModelAttribute CompanyEntity companyEntity,
            @ModelAttribute ImportExportEntity importExportEntity,
            HttpSession session){
        ResponseData<AccountVO> data = userInfoService.improveEuropeCompanyInformation(accountVoId, companyEntity, importExportEntity,session);
            return data;
    }
    @RequiresAuthentication
    @RequestMapping(value = "/mustLogin")
    @ResponseBody
    public String mustLogin(){
        return "哈哈哈哈";
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String gsdagw(HttpSession session,String token){
        String s = session.getId();
        String o = (String) session.getAttribute(token);
        return "嗯嗯";
    }
}

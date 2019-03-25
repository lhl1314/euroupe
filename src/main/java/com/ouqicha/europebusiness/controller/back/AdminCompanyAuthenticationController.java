package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.vo.CompanyAuthenticationVo;
import com.ouqicha.europebusiness.service.CompanyAuthenticationService;
import com.ouqicha.europebusiness.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/19 0019
 * Time:16:07
 */
@Controller
@RequestMapping(value = "/admin/companyAuthentication")
public class AdminCompanyAuthenticationController {
    @Autowired
    CompanyAuthenticationService companyAuthenticationService;

    /**
     * 获取认证信息的分页
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/getCompanyAuthenticationByPage")
    public  String getCompanyAuthenticationByPage(
            @RequestParam(name = "pageId",defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "3",required = false) int pageSize,
            Model model){
        Page<CompanyAuthenticationVo> page = companyAuthenticationService.getCompanyAuthenticationVoByPage(pageNum, pageSize);
        model.addAttribute("page",page);
        return "authentication/CompanyAuthenticationList";
    }

    /**
     * 修改认证信息的状态，已认证还好是未认证
     * @param id
     */
    @RequestMapping(value = "/updateAuthentication")
    @ResponseBody
    public Integer updateAuthentication(int id){
        companyAuthenticationService.updateCompanyAuthentication(id);
        return id;
    }

    /**
     * 删除一条认证
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteAuthentication")
    @ResponseBody
    public Integer deleteAuthentication(int id){
        companyAuthenticationService.deleteAuthentication(id);
        return id;
    }

}

package com.ouqicha.europebusiness.controller.user;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/api/company")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public @ResponseBody
    ResponseData<List<CompanyEntity>> getCompanyList(Integer page, Integer rows){
        ResponseData<List<CompanyEntity>> responseData = new ResponseData<List<CompanyEntity>>();
        List<CompanyEntity> list = companyService.getCompanyList(page, rows);
        responseData.setData(list);
        return responseData;
    }
}

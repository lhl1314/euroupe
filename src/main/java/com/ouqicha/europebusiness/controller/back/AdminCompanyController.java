package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.vo.CompanyVO;
import com.ouqicha.europebusiness.service.CompanyService;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/15 0015
 * Time:9:08
 */
@Controller
@RequestMapping(value = "/admin/company")
public class AdminCompanyController {
    @Autowired
    CompanyService companyService;

    /**
     * 分页形式展现企业的基本信息
     *
     * @param pageId
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/getCompanyByPage")
    public String getCompanyByPage(
            @RequestParam(value = "pageId", defaultValue = "1", required = true) int pageId,
            @RequestParam(value = "pageSize", defaultValue = "4", required = false) int pageSize,
            Model model) {
        Page<CompanyVO> page = companyService.getCompanyByPage(pageId, pageSize);
        model.addAttribute("page", page);
        return "/company/company";
    }

    /**
     * 去添加企业信息的页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddCompanyUpload")
    public String toAddCompany() {
        return "company/addCompany";
    }

    /**
     * 企业详情
     *
     * @param id     用作查找企业
     * @param pageId 用作用户返回到之前的页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/getCompanyDetail")
    public String toFindCompanyDetail(int id, int pageId, Model model) {
        setModel(id, model);
        model.addAttribute("pageId", pageId);
        return "company/companyDetail";
    }

    /**
     * 跳转到修改企业信息的页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/toUpdateCompanyDetail")
    public String toUpdateCompanyDetail(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "pageId") int pageId,
            Model model) {
        setModel(id, model);
        model.addAttribute("pageId",pageId);
        return "company/updateCompany";
    }

    /**
     * 获取企业的信息，封装起来
     * @param id
     * @param model
     */
    public void setModel(int id, Model model) {
        CompanyVO vo = companyService.getCompanyDetail(id);
        String companyImage = vo.getCompanyImage();
        String productImage = vo.getProductImage();
        if (companyImage != null) {
            String[] strings = companyImage.split("-");
            List<String> companyImagesList = Arrays.asList(strings);
            model.addAttribute("companyImages", companyImagesList);
        }
        if (productImage != null) {
            String[] strings1 = productImage.split("-");
            List<String> productImagesList = Arrays.asList(strings1);
            model.addAttribute("productImages", productImagesList);
        }
        model.addAttribute("company", vo);
    }

    /**
     * 上传多图片和添加企业信息
     *
     * @param request
     * @param file
     * @param companyFiles
     * @param productFiles
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addCompanyOneAndMore")
    public String addCompanyOneAndMore(
            HttpServletRequest request,
            @ModelAttribute CompanyEntity companyEntity,
            @RequestParam("file") MultipartFile file,
            @RequestParam("companyFiles") MultipartFile[] companyFiles,
            @RequestParam("productFiles") MultipartFile[] productFiles,Model model) throws IOException {
        boolean b = Utils.uploadOneFile(request, file);
        if (b) {
            String urls = (String) request.getSession().getAttribute("imageUploadUrl");
            System.out.println("单个图片上传路径" + urls);
            companyEntity.setLogo(urls);
        }
        boolean b1 = Utils.uploadManyFiles(request, companyFiles);
        if (b1) {
            String urls = (String) request.getSession().getAttribute("imageUploadUrl");
            System.out.println("企业图片路径" + urls);
            companyEntity.setCompanyImage(urls);
        }
        boolean b2 = Utils.uploadManyFiles(request, productFiles);
        if (b2) {
            String urls = (String) request.getSession().getAttribute("imageUploadUrl");
            System.out.println("企业产品路径" + urls);
            companyEntity.setProductImage(urls);
        }
        if (b == true && b1 == true && b2 == true) {
            companyService.addCompany(companyEntity);
            model.addAttribute("msg","企业信息添加成功！");
            model.addAttribute("address","/admin/company/getCompanyByPage");
            return "/msg/msg";
        }
        model.addAttribute("msg","系统繁忙，企业信息添加失败，请稍后再试！");
        model.addAttribute("address","/admin/company/getCompanyByPage");
        return "/msg/msg";
    }

    /**
     * 修改企业的详情信息
     *
     * @param request
     * @param companyEntity
     * @param file
     * @param companyLogo
     * @param companyFiles
     * @param productFiles
     * @param oldCompanyImages
     * @param oldProductImages
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateCompanyDetail")
    @ResponseBody
    public Integer updateCompanyDetail(
            HttpServletRequest request,
            @ModelAttribute CompanyEntity companyEntity,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "companyLogo", required = false) String companyLogo,
            @RequestParam(value = "companyFiles", required = false) MultipartFile[] companyFiles,
            @RequestParam(value = "productFiles", required = false) MultipartFile[] productFiles,
            @RequestParam(value = "oldCompanyImages", required = false) String oldCompanyImages,
            @RequestParam(value = "oldProductImages", required = false) String oldProductImages) throws IOException {
        if (file != null) {
            boolean b = Utils.uploadOneFile(request, file);
            if (b) {
                String urls = (String) request.getSession().getAttribute("imageUploadUrl");
                System.out.println("企业新添加的logo图片" + urls);
                companyEntity.setLogo(urls);
            }
        } else {
            companyEntity.setLogo(companyLogo);
        }
        boolean b1 = Utils.uploadManyFiles(request, companyFiles);
        if (b1) {
            String urls = (String) request.getSession().getAttribute("imageUploadUrl");
            System.out.println("企业新添加的公司图片" + urls);
            String s = oldCompanyImages + urls;
            companyEntity.setCompanyImage(s);
        } else {
            companyEntity.setCompanyImage(oldCompanyImages);
        }
        boolean b2 = Utils.uploadManyFiles(request, productFiles);
        if (b2) {
            String urls = (String) request.getSession().getAttribute("imageUploadUrl");
            System.out.println("企业新添加的产品图片" + urls);
            String s = oldProductImages + urls;
            companyEntity.setProductImage(s);
        } else {
            companyEntity.setProductImage(oldProductImages);
        }
        companyService.updateCompany(companyEntity);
        return companyEntity.getId();
    }

    /**
     * 冻结或者解冻该企业
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/freezeOrUnfreezeCompany")
    @ResponseBody
    public String freezeCompany(int id) {
        companyService.freezeOrUnfreezeCompany(id);
        return Integer.toString(id);
    }
}

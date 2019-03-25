package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;
import com.ouqicha.europebusiness.bean.vo.HelpCenterHeaderVo;
import com.ouqicha.europebusiness.service.HelpCenterService;
import com.ouqicha.europebusiness.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/19 0019
 * Time:13:59
 */
@Controller
@RequestMapping(value = "/admin/help")
public class AdminHelpController {
    @Autowired
    HelpCenterService helpCenterService;

    /**
     * 获取所有的帮助中心的信息
     * @param model
     */
    @RequestMapping(value = "/getAllHelpByPage")
    public String getAllHelp(
            Model model,
            @RequestParam(name = "pageId",defaultValue = "1") int pageId,
            @RequestParam(name = "pageSize",defaultValue = "4") int pageSize){
        Page<HelpCenterHeaderVo> page = helpCenterService.getCenterHeaderByPage(pageId, pageSize);
        model.addAttribute("page",page);
        return "help/HelpCenterContent";
    }

    /**
     * 删除一个帮助标题
     * @param id
     */
    @RequestMapping(value = "/deleteHelpCenterHeader")
    @ResponseBody
    public String deleteHelpCenterHeader(int id){
        helpCenterService.deleteHelpCenterHeader(id);
        return Integer.toString(id);
    }

    /**
     * 删除一个帮助中心的问题答案
     * @param id
     */
    @RequestMapping(value = "/deleteHelpContent")
    @ResponseBody
    public Integer deleteHelpContent(int id) {
        helpCenterService.deleteHelpContent(id);
        return id;
    }

    /**
     * 添加一个帮助信息header的内容
     * @param helpCenterHeaderName
     * @param helpCenterEntity
     */
    @RequestMapping(value = "/addHelpHeaderContent")
    public String addHelpContent(
            @RequestParam(name = "helpCenterHeaderName") String helpCenterHeaderName,
            @ModelAttribute HelpCenterEntity helpCenterEntity){

        helpCenterService.addHelpCenterContent(helpCenterHeaderName, helpCenterEntity);
        return "redirect:/admin/help/getAllHelpByPage";
    }

    @RequestMapping(value = "/addHelpCenter")
    @ResponseBody
    public String addHelpCenter(
            int helpTitleId,
            HelpCenterEntity helpCenterEntity){
        helpCenterService.addHelpCenter(helpTitleId,helpCenterEntity);
        Integer id = helpCenterEntity.getId();
        return Integer.toString(id);
    }

}

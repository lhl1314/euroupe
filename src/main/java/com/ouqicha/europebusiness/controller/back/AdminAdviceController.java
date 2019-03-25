package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.AdviceVo;
import com.ouqicha.europebusiness.service.AdviceService;
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
 * Time:15:43
 */
@Controller
@RequestMapping(value = "/admin/advice")
public class AdminAdviceController {

    @Autowired
    AdviceService adviceService;

    /**
     * 分页显示用户的建议
     * @param pageNum
     * @param pageSize
     * @param model
     */
    @RequestMapping(value = "/findAdviceByPage")
    public String findAdviceByPage(
            @RequestParam(name = "pageId",defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize",defaultValue = "2",required = false) int pageSize,
            Model model){
        Page<AdviceVo> page = adviceService.getAllByPage(pageNum, pageSize);
        model.addAttribute("page",page);
        return "advice/advices";
    }


    /**
     * 删除建议
     * @param id
     */
    @RequestMapping(value = "/deleteAdvice")
    @ResponseBody
    public String deleteAdvice(int id){
        adviceService.deleteAdvice(id);
        return Integer.toString(id);
    }
}

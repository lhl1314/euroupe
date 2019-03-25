package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.service.UserInfoService;
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
 * Date:2019/2/21 0021
 * Time:9:45
 * 管理员操作用户的类
 */
@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController {
    @Autowired
    UserInfoService userInfoService;

    /**
     * 获取普通用户的分页数据
     *
     * @param model
     * @param pageId
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getPageUsers")
    public String getPageUsers(
            Model model,
            @RequestParam(name = "pageId", defaultValue = "1", required = true) int pageId,
            @RequestParam(name = "pageSize", defaultValue = "4", required = false) int pageSize) {
        Page<AccountVO> page = userInfoService.getAccountByPageAndState(pageId, pageSize, 1);
        model.addAttribute("page", page);
        return "/user/users";
    }

    /**
     * 冻结普通用户，使得不能登录本系统
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/freezeOrUnfreezeNormalUser")
    @ResponseBody
    public String freezeOrUnfreezeNormalUser(int id) {
        userInfoService.freezeOrUnfreezeUser(id);
        return Integer.toString(id);
    }
}

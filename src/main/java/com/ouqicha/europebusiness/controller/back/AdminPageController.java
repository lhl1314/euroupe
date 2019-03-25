package com.ouqicha.europebusiness.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**控制前端框架，页面的访问
 * Created with IDEA
 * author:lhl
 * Date:2019/1/29 0029
 * Time:14:41
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminPageController {
    @RequestMapping(value = "/left")
    public String left() {
        return "left";
    }

    @RequestMapping(value = "/top")
    public String top() {
        return "top";
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/bottom")
    public String bottom() {
        return "bottom";
    }
}

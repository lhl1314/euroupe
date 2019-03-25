package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.entity.DialogueEntity;
import com.ouqicha.europebusiness.bean.vo.*;
import com.ouqicha.europebusiness.service.DialogueService;
import com.ouqicha.europebusiness.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:13:36
 */
@Controller
@RequestMapping(value = "/admin/dialogue")
public class AdminDialogueController {
    @Autowired
    DialogueService dialogueService;
    @Autowired
    UserInfoService infoService;

    /**
     * 添加一条对话信息(前后都可以用)
     *
     * @param dialogueEntity
     * @return
     */
    @RequestMapping(value = "/addDialogue")
    @ResponseBody
    public DialogueVo addDialogue(@ModelAttribute DialogueEntity dialogueEntity) {
        DialogueVo dialogueVo = dialogueService.addDialogue(dialogueEntity);
        return dialogueVo;
    }

    /**
     * 获取两个人之间的留言信息（前后都可以用）
     *
     * @param sendId
     * @param acceptId
     * @return
     */
    @RequestMapping(value = "/getDialogues")
    @ResponseBody
    public List<DialogueVo> getDialogues(
            @RequestParam(name = "sendId") int sendId,
            @RequestParam(name = "acceptId") int acceptId) {
        List<DialogueVo> dialogues = dialogueService.getDialogues(sendId, acceptId);
        return dialogues;
    }

    /**
     * 获取有新留言的用户，需要客服去回复（只是后台用）
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/adminReplyDialogue")
    public String adminReplyDialogue(HttpSession session,Model model) {
        AccountVO o = (AccountVO) session.getAttribute("user");
        HashSet<AccountVO> vos = infoService.getAdminAlsoReadDialogue(o.getId(),0);
        model.addAttribute("voList", vos);
        return "kefu/kefu";
    }

}

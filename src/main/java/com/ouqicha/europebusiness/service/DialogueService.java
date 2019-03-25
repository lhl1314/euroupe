package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.DialogueEntity;
import com.ouqicha.europebusiness.bean.vo.AccountRoleVO;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.DialogueVo;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:13:40
 */
public interface DialogueService {
    /**
     * 添加一条对话信息
     *
     * @param entity
     * @return
     */
    DialogueVo addDialogue(DialogueEntity entity);

    /**
     * 获取留言信息
     *
     * @param sendId
     * @param acceptId
     * @return
     */
    List<DialogueVo> getDialogues(int sendId, int acceptId);

    /**
     * 获取所有的客服人员
     * @return
     */
    List<AccountVO>getAccountRoleListKeFu(int roleId);
}

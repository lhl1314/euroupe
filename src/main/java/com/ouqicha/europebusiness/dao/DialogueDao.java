package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.DialogueEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:11:16
 */
public interface DialogueDao {
    /**
     * 测试下
     * @return
     */
    List<DialogueEntity>findAll();

    /**
     * 添加信息
     * @param entity
     * @return
     */
    void add(DialogueEntity entity);

    /**
     * 修改会话信息
     * @param entity
     */
    void updateDialogue(DialogueEntity entity);

    /**
     * 找一条对话信息
     * @param id
     * @return
     */
    DialogueEntity findOne(int id);


    /**
     * 获取两个人之间的对话留言记录
     * @param sendConnectId
     * @param acceptConnectId
     * @return
     */
    List<DialogueEntity>getDialogues(String sendConnectId,String acceptConnectId);

    /**
     * 找到某个用户未读的信息数量
     * @param sendId
     * @param noRead
     * @return
     */
    Long noReadCount(int sendId,int noRead);


    /**
     * 获取所有的未读信息，通过这些去获取发送的用户
     * @param adminAlsoRead
     * @return
     */
    List<DialogueEntity>getDialoguesNoRead(int adminAlsoRead);

    List<DialogueEntity>getMeNoRead(int acceptId,int alsoRead);
}

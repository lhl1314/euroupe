package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.DialogueEntity;
import com.ouqicha.europebusiness.bean.vo.AccountRoleVO;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.DialogueVo;
import com.ouqicha.europebusiness.dao.AccountRoleDao;
import com.ouqicha.europebusiness.dao.DialogueDao;
import com.ouqicha.europebusiness.service.DialogueService;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/28 0028
 * Time:13:40
 */
@Service
public class DialogueServiceImpl implements DialogueService {
    @Autowired
    DialogueDao dialogueDao;
    @Autowired
    Mapper mapper;

    @Autowired
    AccountRoleDao accountRoleDao;

    @Override
    public DialogueVo addDialogue(DialogueEntity entity) {
        entity.setSendTime(new Timestamp(System.currentTimeMillis()));
        String connectId = Integer.toString(entity.getSendId()) + Integer.toString(entity.getAcceptId());
        entity.setConnectId(connectId);
        entity.setAdminAlsoRead(0);
        dialogueDao.add(entity);
        DialogueVo vo = mapper.map(entity, DialogueVo.class);
        return vo;
    }

    @Override
    public List<DialogueVo> getDialogues(int sendId, int acceptId) {
        String send = String.valueOf(sendId);
        String accept = String.valueOf(acceptId);
        String sendConnectId = send + accept;
        String acceptConnectId = accept + send;
        List<DialogueEntity> dialogues = dialogueDao.getDialogues(sendConnectId, acceptConnectId);
        List<DialogueVo> voList = new ArrayList<>();
        for (DialogueEntity entity : dialogues) {
            if (entity.getAdminAlsoRead() == 0) {
                entity.setAdminAlsoRead(1);
                dialogueDao.updateDialogue(entity);
            }
            DialogueVo vo = mapper.map(entity, DialogueVo.class);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<AccountVO> getAccountRoleListKeFu(int roleId) {
        List<AccountRoleEntity> entities = accountRoleDao.getRoleListAccount(roleId);
        List<AccountVO> voList=new ArrayList<>();
        for (AccountRoleEntity roleEntity:entities){
            AccountEntity account = roleEntity.getAccountByAccountId();
            if (account!=null){
                AccountVO vo = mapper.map(account, AccountVO.class);
                voList.add(vo);
            }
        }
        return voList;
    }
}

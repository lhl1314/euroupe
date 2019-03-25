package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.vo.AccountRoleVO;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/18 0018
 * Time:10:31
 */
public interface AccountRoleDao {
    /**
     * 添加或者修改账户角色表
     * @param accountRoleEntity
     */
    void saveOrUpdateAccountRole(AccountRoleEntity accountRoleEntity);
    /**
     * 删除中间表，账户角色
     * @param accountRoleEntity
     */
    void deleteAccountRole(AccountRoleEntity accountRoleEntity);

    /**
     * 在中间表中找到一个账户角色
     * @param id
     * @return
     */
    AccountRoleEntity findOne(int id);


    /**
     * 获取该角色的账户
     * @param roleId
     * @return
     */
    List<AccountRoleEntity>getRoleListAccount(int roleId);

}

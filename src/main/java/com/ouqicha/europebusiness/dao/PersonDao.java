package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.PersonEntity;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/6 0006
 * Time:13:50
 */
public interface PersonDao {
    /**
     * 添加或修改一条个人信息
     * @param personEntity
     */
    void saveOrUpdate(PersonEntity personEntity);

    /**
     * 获取一条个人信息
     * @param id
     * @return
     */
    PersonEntity getOne(int id);
}

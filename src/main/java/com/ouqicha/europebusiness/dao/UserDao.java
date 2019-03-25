package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.UserEntity;

public interface UserDao {
    public UserEntity Login(String LoginName, String Password);

    public UserEntity FindByEmail(String param);

    public Integer count(String param);

    public void saveOrUpdate(UserEntity T);

    public void save(UserEntity T) throws Exception;

    public void update(UserEntity T);

    public UserEntity get(Integer id);
}

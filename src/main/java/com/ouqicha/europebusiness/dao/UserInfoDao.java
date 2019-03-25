package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;

import java.util.List;

public interface UserInfoDao {
    public AccountEntity Login(String LoginName, String Password);

    /**
     * 通过邮件获取一个账户
     * @param param
     * @return
     */
    public AccountEntity findByEmail(String param);

    /**
     * 通过手机号查找账户
     * @param param
     * @return
     */
    public AccountEntity findByMobile(String param);

    public Integer count(String param);

    /**
     * 保存或者更新一个账户信息
     * @param accountEntity
     */
    public void saveOrUpdate(AccountEntity accountEntity);

    public void save(AccountEntity accountEntity) throws Exception;

    public void update(AccountEntity accountEntity);

    /**
     * 通过主键获取一个账户
     * @param id
     * @return
     */
    public AccountEntity get(Integer id);



    /**
     * 新增方法  显示所有的账户信息
     */
    List<AccountEntity>findAll();

    /**
     * 相当于limit获取数据，还有封装一个page类去包装数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<AccountEntity>getByPageNum(int pageNum,int pageSize);


    /**
     * 根据state的不同获取不同的账户、用户或者管理员
     * @param pageNum
     * @param pageSize
     * @param state
     * @return
     */
    List<AccountEntity>getByPageAndState(int pageNum,int pageSize,int state);

    /**
     *获取账户所具有的数量
     * @return
     */
    Long countOfAccount();

    /**
     * 根据state的不同获取在sql中的数量
     * @return
     */
    Long countOfAccountByState(int state);

    /**
     * 通过state去找对应的账户
     * @param state
     * @return
     */
    List<AccountEntity>findAccountByState(int state);


    /**
     * 找普通用户
     * @param id
     * @param state
     * @return
     */
    AccountEntity getOneByIdAndState(int id,int state);

}

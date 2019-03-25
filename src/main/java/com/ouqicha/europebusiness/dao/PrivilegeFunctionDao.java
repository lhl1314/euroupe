package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.PrivilegeFunctionEntity;
import com.ouqicha.europebusiness.bean.vo.PrivilegeFunctionVo;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/14 0014
 * Time:17:19
 */
public interface PrivilegeFunctionDao {
    /**
     * 获取一个特权信息
     * @param id
     * @return
     */
    PrivilegeFunctionEntity getOne(int id);
}

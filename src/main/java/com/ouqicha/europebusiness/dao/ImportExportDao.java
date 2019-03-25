package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.ImportExportEntity;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:14:35
 */
public interface ImportExportDao {
    /**
     * 为该欧企业添加进出口信息
     * @param importExportEntity
     */
    void saveOrUpdate(ImportExportEntity importExportEntity);
}

package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.ImportExportEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.ImportExportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:14:36
 */
@Repository
public class ImportExportDaoImpl implements ImportExportDao {
    @Autowired
    BaseDao<ImportExportEntity>baseDao;
    @Transactional
    @Override
    public void saveOrUpdate(ImportExportEntity importExportEntity) {
        baseDao.saveOrUpdate(importExportEntity);
    }
}

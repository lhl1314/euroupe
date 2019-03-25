package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AdviceEntity;
import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;
import com.ouqicha.europebusiness.bean.entity.HelpCenterHeaderEntity;
import com.ouqicha.europebusiness.bean.vo.*;
import com.ouqicha.europebusiness.dao.HelpCenterDao;
import com.ouqicha.europebusiness.dao.HelpCenterHeaderDao;
import com.ouqicha.europebusiness.service.HelpCenterService;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.PageControl;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:17:15
 */
@Service
public class HelpCenterServiceImpl implements HelpCenterService {
    @Autowired
    Mapper mapper;
    @Autowired
    HelpCenterDao helpCenterDao;
    @Autowired
    HelpCenterHeaderDao helpCenterHeaderDao;
    @Override
    public ResponseData<List<HelpCenterVo>> getHelpCenterBySerialNumber(int titleSerialNumber) {
        List<HelpCenterEntity> center = helpCenterDao.getHelpCenterBySerialNumber(titleSerialNumber);
        ResponseData<List<HelpCenterVo>>data=new ResponseData<>();
        data.setErrorCode(1);
        data.setErrorMessage("帮助中心返回数据成功");
        List<HelpCenterVo> voList = Utils.setDozerList(mapper, center, HelpCenterVo.class);
        data.setData(voList);
        return data;
    }

    @Override
    public ResponseData<List<HelpCenterHeaderVo>> getAllHelpCenterContent() {
        List<HelpCenterHeaderEntity> all = helpCenterHeaderDao.getAll();
        List<HelpCenterHeaderVo> voList = Utils.setDozerList(mapper, all, HelpCenterHeaderVo.class);
        ResponseData<List<HelpCenterHeaderVo>>data=new ResponseData<>();
        data.setData(voList);
        data.setErrorMessage("帮助中心所有信息返回成功");
        data.setErrorCode(1);
        return data;
    }

    @Override
    public List<HelpCenterHeaderVo> getAllHelpCenter() {
        List<HelpCenterHeaderEntity> all = helpCenterHeaderDao.getAll();
        List<HelpCenterHeaderVo> voList = Utils.setDozerList(mapper, all, HelpCenterHeaderVo.class);
        return voList;
    }

    @Override
    public Page<HelpCenterHeaderVo> getCenterHeaderByPage(int pageNum, int pageSize) {
        int sqlCount = helpCenterHeaderDao.HelpCount().intValue();

        int pageTotal = (int) Math.ceil(sqlCount / pageSize);//总的页数
        List<HelpCenterHeaderEntity> entityList = helpCenterHeaderDao.getByPage(pageNum, pageSize);
        List<HelpCenterHeaderVo> voList = Utils.setDozerList(mapper, entityList, HelpCenterHeaderVo.class);

        PageControl<HelpCenterHeaderVo> pageControl = new PageControl<>();
        Page<HelpCenterHeaderVo> page = pageControl.setPage(pageNum - 1, pageTotal, voList);
        return page;
    }

    @Override
    public void deleteHelpCenterHeader(int id) {
        helpCenterDao.deleteHelpContentByHeader(id);
        helpCenterHeaderDao.deleteHelpHeaderCenter(id);
    }

    @Override
    public void deleteHelpContent(int id) {
        helpCenterDao.deleteHelpCenter(id);
    }

    @Override
    public void addHelpCenterContent(String helpCenterHeaderName, HelpCenterEntity helpCenterEntity) {
        HelpCenterHeaderEntity entity=new HelpCenterHeaderEntity();
        entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        entity.setHelpCenterHeaderName(helpCenterHeaderName);
        helpCenterHeaderDao.saveOrUpdata(entity);


        helpCenterEntity.setTitle(helpCenterHeaderName);
        helpCenterEntity.setHelpCenterHeaderEntity(entity);
        helpCenterEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        helpCenterDao.saveOrUpdate(helpCenterEntity);
    }

    @Override
    public void addHelpCenter(int helpTitleId, HelpCenterEntity helpCenterEntity) {
        HelpCenterHeaderEntity one = helpCenterHeaderDao.getOne(helpTitleId);
        if (one!=null){
            helpCenterEntity.setHelpCenterHeaderEntity(one);
            helpCenterEntity.setTitle(one.getHelpCenterHeaderName());
        }
        helpCenterEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        helpCenterDao.saveOrUpdate(helpCenterEntity);
    }
}

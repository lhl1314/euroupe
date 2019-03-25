package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.CollectEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.PrivilegeFunctionEntity;
import com.ouqicha.europebusiness.bean.vo.CollectVo;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.dao.CollectDao;
import com.ouqicha.europebusiness.dao.CompanyDao;
import com.ouqicha.europebusiness.dao.PrivilegeFunctionDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.service.CollectService;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:14:34
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectDao collectDao;
    @Autowired
    Mapper mapper;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    PrivilegeFunctionDao privilegeFunctionDao;
    @Override
    public ResponseData<String> addCollectCompany(int accountId, int companyId) {
        AccountEntity entity = userInfoDao.get(accountId);
        if (entity!=null){
            String acId=String.valueOf(accountId)+String.valueOf(companyId);
            CollectEntity collectEntity = collectDao.findOnly(acId);
            ResponseData<String>responseData=new ResponseData<>();
            if (collectEntity!=null){
                responseData.setErrorCode(0);
                responseData.setErrorMessage("该企业已经添加过");
                responseData.setData(null);
                return responseData;
            }else {
                //查看vip特权
                int collectCount = collectDao.collectCount(accountId).intValue();
                PrivilegeFunctionEntity privilegeFunctionEntity = privilegeFunctionDao.getOne(2);
                int shouldCollectCount=privilegeFunctionEntity.getPrivilegeCount();
                if (entity.getVip()==1){
                    addCollect(accountId,acId,companyId);
                    responseData.setData(null);
                    responseData.setErrorMessage("VIP收藏企业成功");
                    responseData.setErrorCode(1);
                    return responseData;
                }else if (entity.getVip()==0 && collectCount<shouldCollectCount){
                    addCollect(accountId,acId,companyId);
                    responseData.setData(null);
                    responseData.setErrorMessage("普通账户收藏企业成功");
                    responseData.setErrorCode(1);
                    return responseData;
                }else {
                    responseData.setData(null);
                    responseData.setErrorMessage("特权不够，收藏失败");
                    responseData.setErrorCode(0);
                    return responseData;
                }
            }
        }
        return null;
    }

    /**
     * 添加收藏
     * @param accountId
     * @param acId
     * @param companyId
     */
    public void addCollect(int accountId,String acId,int companyId){
        CollectEntity collect=new CollectEntity();
        collect.setAccountId(accountId);
        collect.setAcId(acId);
        collect.setTimestamp(new Timestamp(System.currentTimeMillis()));
        CompanyEntity companyEntity = companyDao.findOneById(companyId);
        if (companyEntity!=null){
            collect.setCompanyEntity(companyEntity);
        }
        collectDao.saveOrUpdate(collect);
    }
    @Override
    public ResponseData<List<CollectVo>>  findMyCollectByPage(int accountId, int pageNum, int pageSize) {
        List<CollectEntity> entities = collectDao.getPageCollectEntity(accountId, pageNum, pageSize);
        List<CollectVo> voList = Utils.setDozerList(mapper, entities, CollectVo.class);
       ResponseData<List<CollectVo>>data=new ResponseData<>();
       data.setData(voList);
       data.setErrorMessage("我的收藏分页");
       data.setErrorCode(1);
       return data;
    }

    @Override
    public ResponseData<List<CollectVo>> getAllCollect() {
        List<CollectEntity> entities = collectDao.getAll();
        List<CollectVo> voList = Utils.setDozerList(mapper, entities, CollectVo.class);
        ResponseData<List<CollectVo>>responseData=new ResponseData<>();
        responseData.setErrorCode(0);
        responseData.setErrorMessage("企业收藏列表");
        responseData.setData(voList);
        return responseData;
    }

    @Override
    public ResponseData<String> deleteCollectCompany(int id) {
        collectDao.deleteCollectCompany(id);
        ResponseData<String>responseData=new ResponseData<>();
        responseData.setErrorCode(0);
        responseData.setErrorMessage("删除收藏成功");
        responseData.setData(null);
        return responseData;
    }
}

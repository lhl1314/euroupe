package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.vo.CollectVo;
import com.ouqicha.europebusiness.bean.vo.ResponseData;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:14:33
 */
public interface CollectService {

    /**
     * 添加收藏企业
     * @param accountId
     * @param companyId
     */
    ResponseData<String> addCollectCompany(int accountId, int companyId);

    /**
     * 删除我的收藏
     * @param id
     * @return
     */
    ResponseData<String>deleteCollectCompany(int id);

    /**
     * 我的收藏企业列表
     * @param accountId
     * @param pageNum
     * @param pageSize
     */
    ResponseData<List<CollectVo>>  findMyCollectByPage(int accountId,int pageNum,int pageSize);


    ResponseData<List<CollectVo>>getAllCollect();
}

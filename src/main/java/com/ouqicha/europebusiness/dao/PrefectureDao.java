package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.PrefectureEntity;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/5 0005
 * Time:16:43
 */
public interface PrefectureDao {
    /**
     * 获取三级地区的四级区域
     * @param cityId
     * @return
     */
    List<PrefectureEntity>getPrefectureList(int cityId);

    /**
     * 获取三级地区的四级分页区域
     * @param cityId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PrefectureEntity>getPrefectureListPage(int cityId,int pageNum,int pageSize);
}

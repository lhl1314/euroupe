package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.HelpCenterEntity;
import com.ouqicha.europebusiness.bean.vo.HelpCenterHeaderVo;
import com.ouqicha.europebusiness.bean.vo.HelpCenterVo;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.util.Page;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/12 0012
 * Time:17:14
 */
public interface HelpCenterService {
    /**
     * 获取帮助中心内容
     * @param titleSerialNumber
     * @return
     */
    ResponseData<List<HelpCenterVo>>getHelpCenterBySerialNumber(int titleSerialNumber);

    /**
     * 获取帮助中心所有信息
     * @return
     */
    ResponseData<List<HelpCenterHeaderVo>>getAllHelpCenterContent();


    /**
     * 后台
     */

    /**
     * 获取所有的帮助信息
     * @return
     */
    List<HelpCenterHeaderVo>getAllHelpCenter();

    /**
     * 获取分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<HelpCenterHeaderVo>getCenterHeaderByPage(int pageNum,int pageSize);

    /**
     * 删除一个帮助标题
     * @param id
     */
    void deleteHelpCenterHeader(int id);

    /**
     * 删除一个帮助中心的问题答案
     * @param id
     */
    void deleteHelpContent(int id);


    /**
     * 添加一个帮助信息的内容
     * @param helpCenterHeaderName
     * @param helpCenterEntity
     */
    void addHelpCenterContent(String helpCenterHeaderName,HelpCenterEntity helpCenterEntity);


    /**
     * 问题和答案的添加
     * @param helpCenterEntity
     */
    void addHelpCenter(int helpTitleId,HelpCenterEntity helpCenterEntity);
}

package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.AdviceVo;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.util.Page;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/8 0008
 * Time:16:46
 */
public interface AdviceService {
    /**
     * 添加建议
     * @param accountId
     * @param adviceContent
     * @return
     */
    ResponseData<String>addAdvice(int accountId,String adviceContent);


    /**
     * 获取分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<AdviceVo> getAllByPage(int pageNum, int pageSize);

    /**
     * 删除建议
     * @param id
     */
    void deleteAdvice(int id);
}

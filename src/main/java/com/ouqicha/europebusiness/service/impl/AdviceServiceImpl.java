package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AdviceEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.bean.vo.AdviceVo;
import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.dao.AdviceDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.service.AdviceService;
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
 * Date:2019/3/8 0008
 * Time:16:46
 */
@Service
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    AdviceDao adviceDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    Mapper mapper;
    @Override
    public ResponseData<String> addAdvice(int accountId, String adviceContent) {
        AdviceEntity adviceEntity=new AdviceEntity();
        adviceEntity.setAccountId(accountId);
        adviceEntity.setAdviceContent(adviceContent);
        adviceEntity.setAdviceTime(new Timestamp(System.currentTimeMillis()));
        adviceDao.addAdvice(adviceEntity);
        ResponseData<String>data=new ResponseData<>();
        data.setData(null);
        data.setErrorMessage("添加建议成功");
        data.setErrorCode(0);
        return data;
    }


    @Override
    public Page<AdviceVo> getAllByPage(int pageNum, int pageSize) {
        int count = adviceDao.sqlCount().intValue();
        int pageTotal = (int) Math.ceil(count / pageSize);//总的页数
        List<AdviceEntity> entityList = adviceDao.getAdvicePage(pageNum, pageSize);
        List<AdviceVo> voList = Utils.setDozerList(mapper, entityList, AdviceVo.class);
        for (AdviceVo vo:voList){
            AccountEntity entity = userInfoDao.get(vo.getAccountId());
            AccountVO accountVO = mapper.map(entity, AccountVO.class);
            vo.setAccountVO(accountVO);
        }
        PageControl<AdviceVo> pageControl = new PageControl<>();
        Page<AdviceVo> page = pageControl.setPage(pageNum - 1, pageTotal, voList);
        return page;
    }

    @Override
    public void deleteAdvice(int id) {
        adviceDao.deleteAdvice(id);
    }
}

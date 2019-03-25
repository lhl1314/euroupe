package com.ouqicha.europebusiness.controller.other;

import com.ouqicha.europebusiness.bean.vo.ResponseData;
import com.ouqicha.europebusiness.exception.ReturnFormat;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    Mapper mapper;

    protected ResponseData retContent(int status, Object data) {
        return ReturnFormat.retParam(status, data);
    }

    public <T> T transforEntity(Class<T> clazz, Object e){
        T desc = mapper.map(e, clazz);
        return desc;
    }
}

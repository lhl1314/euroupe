package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.dao.MainDao;
import com.ouqicha.europebusiness.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDao mainDao;

    @Override
    public String test() {
        return mainDao.getResult();
    }
}

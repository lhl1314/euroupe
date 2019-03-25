package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.bean.vo.RoleVO;
import com.ouqicha.europebusiness.dao.RoleDao;
import com.ouqicha.europebusiness.service.RoleAndPermissionService;
import com.ouqicha.europebusiness.util.Utils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/14 0014
 * Time:9:09
 */

@Service
public class RoleAndPermissionServiceImpl implements RoleAndPermissionService {
    @Autowired
    Mapper mapper;
    @Autowired
    RoleDao roleDao;

    @Override
    public List<RoleVO> findAllRoleAndPermissions() {
        List<RoleEntity> entities = roleDao.findAll();
        if (entities!=null&&!entities.isEmpty()){
            List<RoleVO> roleVOS = Utils.setDozerList(mapper, entities, RoleVO.class);
            return roleVOS;
        }
        return null;
    }

    @Override
    public RoleVO findPermissionsByRole(int roleId) {
        RoleEntity roleEntity = roleDao.findPermissionByRole(roleId);
        RoleVO roleVO = mapper.map(roleEntity, RoleVO.class);
        return roleVO;
    }
}

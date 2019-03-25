package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.RoleEntity;
import com.ouqicha.europebusiness.bean.vo.RoleVO;
import com.ouqicha.europebusiness.dao.RoleDao;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/14 0014
 * Time:9:07
 */
@Service
public interface RoleAndPermissionService {
    /**
     * 找到所有的角色和权限
     *
     * @return
     */
    List<RoleVO> findAllRoleAndPermissions();

    /**
     * 找到该角色所有的权限
     *
     * @param roleId
     * @return
     */
    RoleVO findPermissionsByRole(int roleId);
}

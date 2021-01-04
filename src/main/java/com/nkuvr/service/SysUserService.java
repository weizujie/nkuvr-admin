package com.nkuvr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nkuvr.entity.SysPerms;
import com.nkuvr.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author weizujie
 * @since 2021-01-04
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据角色 id 查询角色
     *
     * @param id 角色 id
     * @return List<SysPerms>
     */
    List<SysPerms> getPermsByRoleId(String id);

    /**
     * 查询一个用户下的所有角色
     *
     * @param primaryPrincipal 用户名
     * @return SysUser
     */
    SysUser getRolesByUsername(String primaryPrincipal);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser getByUsername(String username);
}

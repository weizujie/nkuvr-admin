package com.nkuvr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nkuvr.entity.SysPerms;
import com.nkuvr.entity.SysUser;
import com.nkuvr.mapper.SysUserMapper;
import com.nkuvr.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author weizujie
 * @since 2021-01-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 根据角色 id 查询角色
     *
     * @param id 角色 id
     * @return List<SysPerms>
     */
    @Override
    public List<SysPerms> getPermsByRoleId(String id) {
        return baseMapper.getPermsByRoleId(id);
    }

    /**
     * 查询一个用户下的所有角色
     *
     * @param primaryPrincipal 用户名
     * @return SysUser
     */
    @Override
    public SysUser getRolesByUsername(String primaryPrincipal) {
        return baseMapper.getRolesByUsername(primaryPrincipal);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return SysUser
     */
    @Override
    public SysUser getByUsername(String username) {
        return baseMapper.getByUsername(username);
    }
}

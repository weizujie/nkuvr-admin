package com.nkuvr.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nkuvr.entity.SysUser;
import com.nkuvr.service.SysUserService;
import com.nkuvr.utils.ResultUtil;
import com.nkuvr.utils.SaltUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理 前端控制器
 *
 * @author weizujie
 * @since 2021-01-04
 */
@Api(tags = "用户管理")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }


    /**
     * 用户列表
     *
     * @return ResultUtil
     */
    @ApiOperation("用户列表")
    @GetMapping("/getAll")
    @RequiresPermissions("sys:user:list")
    public ResultUtil getAll() {
        List<SysUser> users = sysUserService.list(null);
        return ResultUtil.success().data("items", users);
    }

    /**
     * 用户列表分页查询（不带条件）
     *
     * @param current 当前页
     * @param limit   每页显示的条数
     * @return R
     */
    @ApiOperation("用户列表分页查询(不带条件)")
    @GetMapping("/page/{current}/{limit}")
    @RequiresPermissions("sys:user:list")
    public ResultUtil page(@ApiParam(name = "current", value = "当前页") @PathVariable Long current,
                           @ApiParam(name = "limit", value = "每页显示的条数") @PathVariable Long limit) {
        // 创建 page 对象
        Page<SysUser> sysUserPage = new Page<>(current, limit);
        // 调用方法的时候，把分页所有数据封装到 pageTeacher 对象里面
        sysUserService.page(sysUserPage, null);
        long total = sysUserPage.getTotal(); // 总记录数
        List<SysUser> records = sysUserPage.getRecords(); // 数据 list 集合
        Map<String, Object> map = new HashMap<>();
        // 封装返回结果
        map.put("total", total);
        map.put("rows", records);
        return ResultUtil.success().data(map);
    }

    /**
     * 添加用户
     *
     * @param sysUser SysUser
     * @return R
     */
    @ApiOperation("添加用户")
    @PostMapping("/add")
    @RequiresPermissions("sys:user:insert")
    public ResultUtil add(@RequestBody SysUser sysUser) {
        // 判断注册的用户名是否存在数据库中，不存在则直接注册
        if (sysUserService.getByUsername(sysUser.getUsername()) == null) {
            // 生成随机 salt
            String salt = SaltUtil.getSalt(8);
            // 将随机 salt 保存到数据库
            sysUser.setSalt(salt);
            // 密码加密 (md5 + salt + hash散列)
            Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(), salt, 1024);
            sysUser.setPassword(md5Hash.toHex());
            sysUserService.save(sysUser);
            return ResultUtil.success();
        } else {
            throw new UnknownAccountException("该用户名已存在，请重新输入");
        }
    }

    /**
     * 根据 id 查询用户
     *
     * @param id 用户id
     * @return ResultUtil
     */
    @ApiOperation("用户详情")
    @GetMapping("/detail/{id}")
    public ResultUtil detail(@PathVariable("id") String id) {
        SysUser sysUser = sysUserService.getById(id);
        return ResultUtil.success().data("items", sysUser);
    }

    /**
     * 用户编辑
     * RequestBody 注解详解请看：https://blog.csdn.net/jiashanshan521/article/details/88244735
     *
     * @param sysUser SysUser
     * @return ResultUtil
     */
    @ApiOperation("用户编辑")
    @PutMapping("/edit")
    public ResultUtil edit(@RequestBody SysUser sysUser) {
        boolean flag = sysUserService.updateById(sysUser);
        if (flag) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error();
        }
    }

    /**
     * 逻辑删除用户（is_deleted=1）
     *
     * @param id 用户id
     * @return ResultUtil
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{id}")
    @RequiresPermissions("sys:user:delete")
    public ResultUtil deleteById(@PathVariable String id) {
        boolean flag = sysUserService.removeById(id);
        if (flag) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error();
        }
    }
}


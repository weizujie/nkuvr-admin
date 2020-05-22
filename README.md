<h1 align="center"><a href="https://github.com/weizujie/Nkuvr-Admin" target="_blank">Nkuvr-Admin</a></h1>

> :nerd_face: 大学生创新创业训练计划项目：数字校园 - 开放型实验室智慧管理平台，基于 SpringBoot + Mybatis + Shiro + Thymeleaf 开发的南滨实验室预约管理系统

------------------------------


# 实验室预约管理系统

## 一、需求分析

该系统的用户分为两种：管理员、学生

以下针对两种用户分别描述其功能需求

### 1、管理员功能需求描述

- 登录
- 密码重置
- 用户管理
- 预约管理
- 实验室管理
- 退出登录 

### 2、学生功能需求描述

- 登录
- 密码重置
- 查看个人信息
- 查看实验室列表
- 预约
- 管理预约信息
- 退出登录

## 二、数据库设计

### 1、用户表 （sys_user）

| 字段名         | 类型     | 注释                           |
| -------------- | -------- | ------------------------------ |
| id             | bigint   |                                |
| password       | varchar  | 密码                           |
| student_number | int      | 学号                           |
| real_name      | varchar  | 真实姓名                       |
| gender         | tinyint  | 性别<br/>0：男<br/>1：女       |
| state          | tinyint  | 状态<br/>0：正常<br/>1：禁用   |
| remark         | tinyint  | 权限<br/>0：管理员<br/>1：学生 |
| create_time    | datetime | 创建时间                       |
| update_time    | datetime | 更新时间                       |



### 2、预约表（sys_appointment）

| 字段名             | 类型     | 注释                                                       |
| ------------------ | -------- | ---------------------------------------------------------- |
| id                 | bigint   |                                                            |
| uid                | int      | 用户id                                                     |
| lid                | int      | 实验室id                                                   |
| date               | datetime | 预约时间                                                   |
| state              | tinyint  | 预约状态<br>0：通过<br>1：不通过<br>2：审核中<br>3：已取消 |
| appointment_number | int      | 预约人数                                                   |
| activity_name      | varchar  | 活动名称                                                   |
| principal          | varchar  | 负责人                                                     |
| contact            | varchar  | 负责人联系方式                                             |
| speaker            | varchar  | 主讲人                                                     |
| description        | varchar  | 活动描述                                                   |
| device_demand      | varchar  | 设备需求                                                   |
| consumer_demand    | varchar  | 消费需求                                                   |
| other_demand       | varchar  | 其他需求                                                   |
| staff              | varchar  | 工作人员                                                   |
| staff_contact      | varchar  | 工作人员联系方式                                           |
| teacher            | varchar  | 指导老师                                                   |
| activity_time      | datetime | 活动时间                                                   |
| set_time           | datetime | 布场时间                                                   |
| reason             | varchar  | 不通过原因                                                 |


### 3、实验室表（sys_lab）

| 字段名     | 类型    | 注释         |
| ---------- | ------- | ------------ |
| id         | bigint  |              |
| name       | varchar | 实验室教室号 |
| galleryful | int     | 容纳人数     |




## 三、说明

- 作者：韦祖杰

- 环境：

    - JDK        1.8.0_211
    - Maven      3.6.3
    - Mysql      8.0.19
    - Pagehelper 1.2.13
    - Thymeleaf  2.2.6
    - IntelliJ IDEA 2017
      

## 四、日志

- 2020年5月22日
    - 完成"认证/授权"功能

- 2020年5月9日
    - 完成"预约通过"功能
    - 完成"预约不通过"功能
    - 完成"预约修改"功能

- 2020年5月5日
    - 完成"预约删除"功能
    - 完成"预约查看"功能
    - 完成"预约取消"功能
    - 完成"预约新增"功能

- 2020年4月29日
    - 添加"预约添加"页面
    - 完成"密码修改"功能

- 2020年4月26日
    - 增加了一些细节
    - 实现"我的预约"功能

- 2020年4月22日
    - 实现"个人信息"功能
    - 实现"用户新增"功能
    - 实现"用户注册"功能
    - 美化前端页面

- 2020年4月21日
    - 实现"用户更新"功能
    - 实现"用户删除"功能

- 2020年4月14日：
    - 实现"用户登录"功能
    - 查询"用户列表"功能
    - 使用 Pagehelper 实现分页查询
    
## 五、联系

- [Github@weizujie](https://github.com/weizujie)
  

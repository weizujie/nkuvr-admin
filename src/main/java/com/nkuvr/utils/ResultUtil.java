package com.nkuvr.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果的类
 */
@Data
public class ResultUtil {

    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<>();

    // 把构造方法私有
    private ResultUtil() {
    }

    // 成功静态方法
    public static ResultUtil success() {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setSuccess(true);
        resultUtil.setCode(20000);
        resultUtil.setMessage("操作成功");
        return resultUtil;
    }

    // 失败静态方法
    public static ResultUtil error() {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setSuccess(true);
        resultUtil.setCode(20001);
        resultUtil.setMessage("操作失败");
        return resultUtil;
    }

    public ResultUtil success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResultUtil message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultUtil code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultUtil data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResultUtil data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
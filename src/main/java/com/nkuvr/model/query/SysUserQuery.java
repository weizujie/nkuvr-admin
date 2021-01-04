package com.nkuvr.model.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserQuery {

    @ApiModelProperty("用户名称，模糊查询")
    private String name;

    @ApiModelProperty(value = "查询开始时间", example = "2020-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2020-04-01 10:10:10")
    private String end;

}

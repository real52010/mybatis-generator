package com.real.demo.common.base;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "BasePagingResponse", description = "分页返回")
@JsonIgnoreProperties(value={"pageRecordSize"})
public class BasePagingResponse<T> extends BaseResponse<T> {
    /**
     * 查询总记录数记录数
     */
    @ApiModelProperty(value = "查询总记录数据量")
    private Integer totalRecordSize;
    /**
     * 返回总数
     */
    @ApiModelProperty(value = "查询到的数据总页数")
    private Integer totalPageSize;
    
	@ApiModelProperty(value = "当每页显示数据量 默认值：10")
	private Integer pageRecordSize=10;
	
    

}

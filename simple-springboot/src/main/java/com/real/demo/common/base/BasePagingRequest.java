package com.real.demo.common.base;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "BasePagingRequest", description = "分页请求")
public class BasePagingRequest extends BaseRequest {

	/**
	 * 查询类型，0.全部 1只查询总部 2，只查询数据
	 */
	@Range(min = 0, max = 3, message = "查询类型只能取[0,1,2]")
	@ApiModelProperty(value = "查询类型，0.全部 1只查询总数 2，只查询数据,默认值：0")
	private Integer queryType = 0;
	/**
	 * 当前请求第几页 前请求第几页,从1开始
	 */
	@ApiModelProperty(value = "当前请求第几页,从1开始，默认值：1")
	@Range(min = 1, max = 99999, message = "请求页数只能为1-99999之间的数字")
	private Integer pageNum = 1;
	/**
	 * 每页显示数据量
	 */
	@Range(min = 1, max = 100, message = "每页显示数量只能为1-100之前的数字")
	@ApiModelProperty(value = "当每页显示数据量 默认值：10")
	private Integer pageSize = 10;
	
	@ApiModelProperty(value = "排序字字段")
	private String orderByColumn;
	
	 /**
	  * 排序的方向 "desc" 或者 "asc".
	  */
	public  String isAsc = "isAsc";

}

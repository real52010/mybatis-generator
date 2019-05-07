package com.real.demo.common.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.real.demo.common.ReturnCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "返回说明")
//@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class BaseResponse<T> {
    @ApiModelProperty(value = "返回码：000000为成功")
    private String retCode= ReturnCode.SUCCESS.getRetCode();
    @ApiModelProperty(value = "返回码描述信息")
    private String retMsg=ReturnCode.SUCCESS.getRetMsg();
    @ApiModelProperty(value = "通用返回结果，如果返回结果为Object或List时将会通过该属性返回")
    /**
     * 不建议使用这种不明确的返回定义，尽可能只在service内部用
     */
    private T data;
    public BaseResponse(){
    }
    public BaseResponse(ReturnCode returnCode){
        this.retCode=returnCode.getRetCode();
        this.retMsg=returnCode.getRetMsg();
    }
    
    public BaseResponse(String retCode,String retMsg){
        this.retCode=retCode;
        this.retMsg=retMsg;
    }

    @JsonIgnoreProperties()
    public boolean isSuccess(){
        return ReturnCode.SUCCESS.getRetCode().equals(retCode);
    }
    public static BaseResponse success(){
        return new BaseResponse(ReturnCode.SUCCESS);
    }
    public static BaseResponse success(String retMsg){
        BaseResponse response= new BaseResponse(ReturnCode.SUCCESS);
        response.setRetMsg(retMsg);
        return response;
    }
    /**
     * 实际上这个方法和 BaseResponse 重复了
     * @param returnCode
     * @return
     */
    public static BaseResponse retResponse(ReturnCode returnCode){
        BaseResponse response= new BaseResponse(returnCode);
        return response;
    }
}

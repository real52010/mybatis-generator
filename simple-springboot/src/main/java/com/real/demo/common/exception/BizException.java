package com.real.demo.common.exception;

import com.real.demo.common.ReturnCode;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class BizException  extends  BaseException{

    public  BizException(ReturnCode returnCode){
      super(returnCode);
    }
    public  BizException(String errCode,String errMsg){
        super(errCode,errMsg);
    }
}

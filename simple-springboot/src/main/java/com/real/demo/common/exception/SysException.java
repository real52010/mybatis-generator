package com.real.demo.common.exception;

import com.real.demo.common.ReturnCode;

import lombok.Data;
@Data
public class SysException extends  BaseException{

    public  SysException(ReturnCode returnCode){
        super(returnCode);
    }
    public  SysException(String errCode,String errMsg){
        super(errCode,errMsg);
    }
}


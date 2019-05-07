package com.real.demo.common.exception;

import com.real.demo.common.ReturnCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseException extends RuntimeException {
	private String errCode;
	private String errMsg;

	public BaseException(ReturnCode returnCode) {
		this.errCode = returnCode.getRetCode();
		this.errMsg = returnCode.getRetMsg();
	}

	@Override
	public String getMessage() {
		StringBuffer msg = new StringBuffer();
		msg.append("{");
		msg.append("errCode:" + errCode + ",");
		msg.append("errMsg:" + errMsg + "");
		msg.append("}");
		return msg.toString();
	}

	@Override
	public String toString() {
		return this.getClass() + getMessage();
	}
}

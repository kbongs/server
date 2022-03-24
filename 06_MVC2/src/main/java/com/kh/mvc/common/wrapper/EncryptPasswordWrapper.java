package com.kh.mvc.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.kh.mvc.common.util.EncryptUtil;

public class EncryptPasswordWrapper extends HttpServletRequestWrapper {

	public EncryptPasswordWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = "";
		
		if(name.equals("userPwd")) {
			value = EncryptUtil.oneWayEnc(super.getParameter(name), "SHA-256");
		} else {
			value = super.getParameter(name);
		}
		
		return value;
	}
	
}

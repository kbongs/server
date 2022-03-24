package com.kh.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.kh.util.EncryptUtil;

public class EncryptPasswordWrapper extends HttpServletRequestWrapper {

	public EncryptPasswordWrapper(HttpServletRequest request) {
		super(request);
	}

	// 클라이언트가 전달하는 값 중에 password name 값만 암호화 처리하고 나머지는 정상적으로 리턴되도록 한다.
	@Override
	public String getParameter(String name) {
		String value = "";
		
		if(name.equals("password")) {
			value = EncryptUtil.oneWayEnc(super.getParameter(name), "SHA-256");
		} else {
			value = super.getParameter(name);
		}
		
		return value;
	}
	
}

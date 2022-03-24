package com.kh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.wrapper.EncryptPasswordWrapper;


@WebFilter(filterName="encryptFilter", urlPatterns = "/views/member/enrollResult.jsp")
public class EncryptFilter implements Filter {

    public EncryptFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// request의 파라미터 값을 직접 변경할 수 없기 때문에 RequestWrapper를 생성한다.
		EncryptPasswordWrapper wrapper = new EncryptPasswordWrapper((HttpServletRequest) request);
		
		// request 대신에 생성한 wrapper 객체를 넘겨준다.
		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

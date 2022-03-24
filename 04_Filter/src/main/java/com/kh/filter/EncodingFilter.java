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

// 서블릿 필터는 request, response가 서블릿이나 JSP 등 리소스에 도달하기 전에 필요한 전/후 처리 작업을 처리한다.
// 서블릿 필터는 FilterChain을 통해서 여러 개의 필터를 연속적으로 사용 가능하다.
@WebFilter(filterName="encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }
    
    // 컨테이너가 필터를 생성할 때 초기화를 위해서 호출한다.
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println(fConfig.getFilterName() + " 필터가 생성되어 초기화가 진행");
	}

	// 컨테이너가 현재 요청에 필터를 적용하겠다고 판단하면 호출한다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("서블릿 동작 전 코드 실행");
		HttpServletRequest hr = (HttpServletRequest) request;
		String requestMethod = hr.getMethod();
		
		System.out.println("요청 방식 : " + requestMethod);
		
		if (requestMethod.equals("POST")) {
			hr.setCharacterEncoding("UTF-8");
			
			System.out.println(request.getCharacterEncoding() + " 인코딩 완료");
		}
		
		chain.doFilter(hr, response); // 다음 필터를 호출하거나, 마지막이면 servlet, JSP를 호출한다.
		
		System.out.println("서블릿 동작 후 코드 실행");
	}

	// 컨테이너가 필터를 제거할 때 호출한다.
	public void destroy() {
		System.out.println("필터가 소멸되어 destroy() 호출");
	}
}

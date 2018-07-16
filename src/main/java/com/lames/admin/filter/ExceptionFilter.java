package com.lames.admin.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lames.admin.model.TAdmin;

/**
 * Servlet Filter implementation class Exception
 */
public class ExceptionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ExceptionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		// pass the request along the filter chain
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		System.out.println("ServletPath :" + req.getServletPath());

		TAdmin admin = (TAdmin) session.getAttribute("admin");
		System.out.println(admin);
		if (admin == null) {
			resp.sendRedirect("/admin/Login.jsp");
		} else {
			System.out.println("admin:" + admin.getLoginName());
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package com.lames.admin.servlet.tadmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.admin.service.impl.TAdminServiceimpl;
import com.lames.admin.validator.LoginNameValidator;
import com.lames.admin.validator.LoginPasswordValidator;

/**
 * Servlet implementation class TAdminLogin
 */
public class TAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TAdminServiceimpl tadminService = new TAdminServiceimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TAdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		System.out.println("name: " + loginName);
		System.out.println("psw: " + loginPassword);
		LoginNameValidator lnv = new LoginNameValidator();
		LoginPasswordValidator lpv = new LoginPasswordValidator();
		List<String> err1 = lnv.validate(loginName);
		err1.addAll(lpv.validate(loginPassword));
		if (err1.size() > 0) {
			;
		} else {
			tadminService.login(loginName, loginPassword);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

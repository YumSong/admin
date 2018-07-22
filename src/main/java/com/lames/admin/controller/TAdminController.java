package com.lames.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.orm.TAdmin;
import com.lames.admin.service.orm.impl.TAdminServiceORMimpl;
import com.lames.admin.util.JsonUtil;
import com.lames.admin.validator.LoginNameValidator;
import com.lames.admin.validator.LoginPasswordValidator;

@Controller

public class TAdminController {

	private TAdminServiceORMimpl tadminService = new TAdminServiceORMimpl();
	
	@Mapping("/Login.do")
	public void loginTAdmin(HttpServletRequest request, HttpServletResponse response)
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
			request.setAttribute("errMsg", err1);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			JsonResult jsonResult = tadminService.login(loginName, loginPassword);
			String jstr=JsonUtil.objectToJson(jsonResult);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().write(jstr);
		}
	}

}

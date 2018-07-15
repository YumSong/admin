package com.lames.admin.servlet.merchant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lames.admin.model.JsonResult;
import com.lames.admin.service.impl.MerchantServiceimpl;
import com.lames.admin.validator.LoginNameValidator;
import com.lames.admin.validator.LoginPasswordValidator;

/**
 * Servlet implementation class Register
 */
public class MerchantRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MerchantServiceimpl merchantService = new MerchantServiceimpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchantRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginName = request.getParameter("loginName"); 
		String loginPassword = request.getParameter("loginPassword");
		LoginNameValidator lnv = new LoginNameValidator();
		LoginPasswordValidator lpv = new LoginPasswordValidator();
		List<String> err1 = lnv.validate(loginName);
		err1.addAll(lpv.validate(loginPassword));
		JsonResult jsonResult=null;
		if(err1.size()>0) {	
			jsonResult = new JsonResult();
			jsonResult.setStatus(false);
			jsonResult.setMessage(err1.toString());;
		}else {
			jsonResult = merchantService.registerMerchant(loginName, loginPassword);
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr =null;
		try {
			jsonStr = mapper.writeValueAsString(jsonResult);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(jsonStr);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.lames.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.admin.model.JsonResult;
import com.lames.admin.service.orm.IMerchantDetailService;
import com.lames.admin.service.orm.impl.MerchantDetailServiceORMimpl;
import com.lames.admin.service.orm.impl.MerchantServiceORMimpl;
import com.lames.admin.validator.LoginNameValidator;
import com.lames.admin.validator.LoginPasswordValidator;

@Controller
public class MerchantController {

	private IMerchantDetailService merchantDetailService = new MerchantDetailServiceORMimpl();
	private MerchantServiceORMimpl merchantService = new MerchantServiceORMimpl();

	@Mapping("/merchantdetail.do")
	public void getMerchantdetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String merchantID = request.getParameter("merchantID");
		if (merchantID != null) {
			Integer MerchantID = Integer.valueOf(merchantID);
			String jsonResult = merchantDetailService.findMerchantDetailByMerchantID(MerchantID);
			response.getWriter().write(jsonResult);
		}
	}
	
	@Mapping("/GetPassedShopID.do")
	public void getPassedShopId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String shopID=merchantDetailService.getPassedShopID();
		response.getWriter().write(shopID);
	}
	
	@Mapping("/merchant/login.do")
	public void loginMerchant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginName = request.getParameter("loginName"); 
		String loginPassword = request.getParameter("loginPassword");
		System.out.println("name: "+loginName);
		System.out.println("psw: "+loginPassword);
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
			jsonResult = merchantService.loginMerchant(loginName, loginPassword);
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
	
	@Mapping("/merchant/register.do")
	public void registerMerchant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}

package com.lames.admin.controller;

import java.io.Console;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.admin.service.impl.MerchantDetailServiceimpl;

@Controller
public class MerchantDetailController {

	private MerchantDetailServiceimpl merchantDetailService = new  MerchantDetailServiceimpl();    
	
	@Mapping("/merchantdetail.do")
	public void findMerchantDetail(Integer merchantID,HttpServletResponse response) throws IOException {
		System.out.println(merchantID);
		if(merchantID!=null) {
			String jsonResult = merchantDetailService.findMerchantDetailByMerchantID(merchantID);
			response.getWriter().write(jsonResult);
		}
	}
}

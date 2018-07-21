package com.jake.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;

@Controller
@Mapping("/my")
public class TestController {

	@Mapping("/test")
	public void test(HttpServletResponse repsonse) throws IOException {
		repsonse.getWriter().write("helolo");
		
	}
}

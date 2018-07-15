package com.lames.admin.servlet.merchantdetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.admin.service.impl.MerchantDetailServiceimpl;

/**
 * Servlet implementation class GetPassedShopID
 */
public class GetPassedShopID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantDetailServiceimpl merchantDetailService = new  MerchantDetailServiceimpl();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPassedShopID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String shopID=merchantDetailService.getPassedShopID();
		response.getWriter().write(shopID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

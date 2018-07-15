package com.lames.admin.servlet.merchantdetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.admin.service.impl.MerchantDetailServiceimpl;

/**
 * Servlet implementation class FindMerchantDetail
 */
public class FindMerchantDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantDetailServiceimpl merchantDetailService = new  MerchantDetailServiceimpl();        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMerchantDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String merchantID = request.getParameter("merchantID");
		if(merchantID!=null) {
		Integer MerchantID = Integer.valueOf(merchantID);
		String jsonResult = merchantDetailService.findMerchantDetailByMerchantID(MerchantID);
		response.getWriter().write(jsonResult);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

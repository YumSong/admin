package com.lames.admin.servlet.merchantdetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.admin.model.MerchantDetail;
import com.lames.admin.service.impl.MerchantDetailServiceimpl;

/**
 * Servlet implementation class VerifyStatus
 */
public class VerifyStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MerchantDetailServiceimpl merchantDetailService = new  MerchantDetailServiceimpl();  
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Status = request.getParameter("status");
		String MerchantDetailID = request.getParameter("merchantDetailID");

		if (Status != null && MerchantDetailID != null) {
			Integer merchantDetailID = Integer.valueOf(MerchantDetailID);
			Integer status = Integer.valueOf(Status);
			MerchantDetail merchantDetail =new MerchantDetail();
			merchantDetail.setMerchantID(merchantDetailID);
			merchantDetail.setStatus(status);
			String pageNum = request.getParameter("pageNum");
			merchantDetailService.verifyMerchantDetailStatus(merchantDetail);
			response.sendRedirect("/admin/MerchantDetail/ListVerify.do?pageNum="+pageNum);
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

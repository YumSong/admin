package com.lames.admin.servlet.merchantdetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.admin.service.impl.MerchantDetailServiceimpl;

/**
 * Servlet implementation class UpdateStatus
 */
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantDetailServiceimpl merchantDetailService = new MerchantDetailServiceimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStatus() {
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

		String Status = request.getParameter("status");
		String MerchantDetailID = request.getParameter("merchantDetailID");

		if (Status != null && MerchantDetailID != null) {
			Integer merchantDetailID = Integer.valueOf(MerchantDetailID);
			Integer status = Integer.valueOf(Status);
			String pageNum = request.getParameter("pageNum");
			merchantDetailService.updateMerchantDetailStatus(merchantDetailID, status);
			response.sendRedirect("/admin/MerchantDetail/ListToUpdate.do?pageNum=" + pageNum);
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

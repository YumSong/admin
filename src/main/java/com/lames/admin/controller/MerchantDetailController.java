package com.lames.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.admin.model.orm.MerchantDetail;
import com.lames.admin.service.orm.impl.MerchantDetailServiceORMimpl;
import com.lames.admin.util.PageUtil;

@Controller
@Mapping("/MerchantDetail")
public class MerchantDetailController {

	private MerchantDetailServiceORMimpl merchantDetailService = new MerchantDetailServiceORMimpl();

	@Mapping("/ListToUpdate.do")
	public void getListToUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNum = null;
		PageUtil pUtil = new PageUtil();
		pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			System.out.println(pageNum);
			pUtil.setPageNum(1);
		} else {
			System.out.println(pageNum);
			pUtil.setPageNum(Integer.valueOf(pageNum));
		}
		String jsonStr= merchantDetailService.listToUpdateStatus(pUtil);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(jsonStr);

	}

	@Mapping("/ListVerify.do")
	public void getListVerify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNum = null;
		PageUtil pUtil = new PageUtil();
		pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pUtil.setPageNum(1);
		} else {
			pUtil.setPageNum(Integer.valueOf(pageNum));
		}
		String jsonStr = merchantDetailService.listToVerify(pUtil);;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(jsonStr);
	}

	@Mapping("/UpdateStatus.do")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String status1 = request.getParameter("status");
		String merchantDetailID1 = request.getParameter("merchantDetailID");
		String lastUpdateTime1 = request.getParameter("lastUpdateTime");
		System.out.println(status1);
		System.out.println(merchantDetailID1);
		System.out.println(lastUpdateTime1);
		if (status1 != null && merchantDetailID1 != null) {
			Integer merchantDetailID = Integer.valueOf(merchantDetailID1);
			Integer status = Integer.valueOf(status1);
			Long  lastUpdateTime = Long.valueOf(lastUpdateTime1);
			MerchantDetail merchantDetail = new MerchantDetail();
			merchantDetail.setMerchantDetailID(merchantDetailID);
			merchantDetail.setLastUpdateTime(lastUpdateTime);
			String jsonStr=merchantDetailService.updateMerchantDetailStatus(merchantDetail, status);
			response.getWriter().write(jsonStr);
		}
	}
	
//	@Mapping("/VerifyStatus.do")
//	public void verifyStatus(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String Status = request.getParameter("status");
//		String MerchantDetailID = request.getParameter("merchantDetailID");
//		String lastUpdateTime1 = request.getParameter("lastUpdateTime");
//
//		if (Status != null && MerchantDetailID != null) {
//			Integer merchantDetailID = Integer.valueOf(MerchantDetailID);
//			Integer status = Integer.valueOf(Status);
//			Long  lastUpdateTime = Long.valueOf(lastUpdateTime1);
//			MerchantDetail merchantDetail =new MerchantDetail();
//			merchantDetail.setMerchantDetailID(merchantDetailID);
//			merchantDetail.setStatus(status);
//			merchantDetail.setLastUpdateTime(lastUpdateTime);
//			String pageNum = request.getParameter("pageNum");
//			merchantDetailService.verifyMerchantDetailStatus(merchantDetail);
//			response.sendRedirect("/admin/MerchantDetail/ListVerify.do?pageNum="+pageNum);
//		}	
//	}
	
	
}

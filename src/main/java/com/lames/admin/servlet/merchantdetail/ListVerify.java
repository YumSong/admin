package com.lames.admin.servlet.merchantdetail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.admin.model.MerchantDetail;
import com.lames.admin.model.MerchantDetailPic;
import com.lames.admin.service.impl.MerchantDetailServiceimpl;
import com.lames.admin.util.PageUtil;

/**
 * Servlet implementation class ListVerify
 */
public class ListVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MerchantDetailServiceimpl merchantDetailService = new  MerchantDetailServiceimpl();  
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNum = null;
		PageUtil pUtil = new PageUtil();
		pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pUtil.setPageNum(1);
		}else {
			pUtil.setPageNum(Integer.valueOf(pageNum));
		}	
		List<MerchantDetail> list=merchantDetailService.listToVerify(pUtil);	
		request.setAttribute("merchantDetails", list);
		request.setAttribute("pUtil",pUtil);
		request.getRequestDispatcher("/MerchantDetail/ListVerify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

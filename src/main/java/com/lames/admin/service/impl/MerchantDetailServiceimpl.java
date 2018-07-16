package com.lames.admin.service.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lames.admin.dao.impl.MerchantDetailDAOimpl;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.MerchantDetail;
import com.lames.admin.service.IMerchantDetailService;
import com.lames.admin.util.PageUtil;

public class MerchantDetailServiceimpl implements IMerchantDetailService {

	private MerchantDetailDAOimpl merchantDetailDAO = new MerchantDetailDAOimpl();

	public String getPassedShopID() {
		// TODO Auto-generated method stub
		List<Integer> list = merchantDetailDAO.queryPassedShopID();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonStr = mapper.writeValueAsString(list);
			return jsonStr;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil) {
		// TODO Auto-generated method stub
		List<MerchantDetail> list = merchantDetailDAO.listToUpdateStatus(pUtil);
		return list;
	}

	public List<MerchantDetail> listToVerify(PageUtil pUtil) {
		// TODO Auto-generated method stub
		List<MerchantDetail> list = merchantDetailDAO.listToVerify(pUtil);
		return list;
	}

	public int updateMerchantDetailStatus(Integer merchantDetailID, Integer status) {
		// TODO Auto-generated method stub
		if (status == 3) {
			merchantDetailDAO.updateStatusByID(merchantDetailID, 1);
			return 1;
		} else if (status == 1) {
			merchantDetailDAO.updateStatusByID(merchantDetailID, 3);
			return 1;
		}
		return 0;
	}

	public int verifyMerchantDetailStatus(Integer merchantDetailID, Integer status) {
		// TODO Auto-generated method stub
		return merchantDetailDAO.updateStatusByID(merchantDetailID, status);
	}

	public String findMerchantDetailByMerchantID(Integer merchantID) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		MerchantDetail m = merchantDetailDAO.findByMerchantID(merchantID);
		JsonResult jsonResult = new JsonResult();
		if (merchantID == null) {
			jsonResult.setStatus(false);
			jsonResult.setMessage("id  is  null");
		} else if (m != null) {
			jsonResult.setStatus(true);
			jsonResult.setMessage("got  a  merchantDetail");
			jsonResult.setData("merchantDetail", m);
		} else {
			jsonResult.setStatus(false);
			jsonResult.setMessage(" none ");
		}
		try {
			String jsonStr = mapper.writeValueAsString(jsonResult);
			return jsonStr;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MerchantDetail insert(MerchantDetail merchantDetail) {
		System.out.println("detail:"+merchantDetail);
		MerchantDetail detail = merchantDetailDAO.findByMerchantID(merchantDetail.getMerchantID());
		System.out.println("detail2:"+detail);
		if(detail != null) {
			if(detail.getStatus() == 2) {
				merchantDetailDAO.updateByID(merchantDetail);
			}
		}else {
			merchantDetailDAO.insert(merchantDetail);
		}
		return merchantDetail;
	}

}

package com.lames.admin.service.impl;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lames.admin.constant.MerchantDetailStatus;
import com.lames.admin.dao.impl.MerchantDetailDAOimpl;
import com.lames.admin.dao.orm.IMerchantDetailDAOorm;
import com.lames.admin.dao.orm.impl.MerchantDetailDAOorm;
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

	public int updateMerchantDetailStatus(MerchantDetail merchantDetail, Integer status) {
		// TODO Auto-generated method stub
		if (merchantDetail != null) {
			if (status != merchantDetail.getStatus()) {
				merchantDetail.setStatus(status);
				if(isUpdateable(merchantDetail).isStatus())
					return 1;
			}
		} else {
			return 0;
		}
		return 0;
	}

	public int verifyMerchantDetailStatus(MerchantDetail merchantDetail) {
		// TODO Auto-generated method stub
		if (merchantDetail != null) {
			if(isUpdateable(merchantDetail).isStatus()) {
				//set jsonResult  message
				return 1;
			}
		}
		//set jsonResult  message
		return 0;
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
		System.out.println("detail:" + merchantDetail);
		MerchantDetail detail = merchantDetailDAO.findByMerchantID(merchantDetail.getMerchantID());
		System.out.println("detail2:" + detail);
		if (detail != null) {
			if (detail.getStatus() == MerchantDetailStatus.REJECTED) {
				merchantDetail.setStatus(MerchantDetailStatus.UNTREATED);
				merchantDetailDAO.updateByID(merchantDetail);
			}
		} else {
			merchantDetailDAO.insert(merchantDetail);
		}
		return merchantDetail;
	}

	public JsonResult isUpdateable(MerchantDetail merchantDetail) {
		// TODO Auto-generated method stub
		JsonResult jsonResult = new JsonResult();
		MerchantDetail oldMerchantDetail = merchantDetailDAO.fingByID(merchantDetail.getMerchantDetailID());
		if (oldMerchantDetail.getLastUpdateTime().equals(merchantDetail.getLastUpdateTime())) {
			java.util.Date curDate = new java.util.Date();
			Long lastUpdateTime=curDate.getTime();
			merchantDetail.setLastUpdateTime(lastUpdateTime);
			if (merchantDetailDAO.updateByID(merchantDetail) > 0) {
				jsonResult.setStatus(true);
				jsonResult.setMessage("Update successfully!");
				return jsonResult;
			} else {
				jsonResult.setStatus(false);
				return jsonResult;
			}

		} else {
			jsonResult.setStatus(false);
			jsonResult.setMessage("Error:This MerchantDetail has been modified!");
			return jsonResult;
		}

	}

}

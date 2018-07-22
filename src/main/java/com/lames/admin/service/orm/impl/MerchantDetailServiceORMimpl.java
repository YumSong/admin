package com.lames.admin.service.orm.impl;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lames.admin.constant.MerchantDetailStatus;
import com.lames.admin.dao.orm.IMerchantDetailDAOorm;
import com.lames.admin.dao.orm.impl.MerchantDetailDAOorm;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.orm.MerchantDetail;
import com.lames.admin.service.orm.IMerchantDetailService;
import com.lames.admin.util.JsonUtil;
import com.lames.admin.util.PageUtil;

public class MerchantDetailServiceORMimpl implements IMerchantDetailService {

	private IMerchantDetailDAOorm merchantDetailDAOorm = new MerchantDetailDAOorm();

	public String getPassedShopID() {
		// TODO Auto-generated method stub
		List<Integer> list = null;
		try {
			list = merchantDetailDAOorm.queryPassedShopID();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	public String listToUpdateStatus(PageUtil pUtil) {
		// TODO Auto-generated method stub
		List<MerchantDetail> list = null;
		JsonResult jsonResult = new JsonResult();
		String jsonStr = null;
		try {
			list = merchantDetailDAOorm.listToUpdateStatus(pUtil);
			if(list!=null) {
				jsonResult.setStatus(true);
				jsonResult.setMessage("got list");
				jsonResult.setData("list", list);
				jsonResult.setData("pUtil",pUtil);
				jsonStr = JsonUtil.objectToJson(jsonResult);
				return jsonStr;
			}else {
				jsonResult.setStatus(false);
				jsonResult.setMessage("Other error");
				jsonStr = JsonUtil.objectToJson(jsonResult);
				return jsonStr;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}

	public List<MerchantDetail> listToVerify(PageUtil pUtil) {
		// TODO Auto-generated method stub
		List<MerchantDetail> list = null;
		try {
			list = merchantDetailDAOorm.listToVerify(pUtil);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public JsonResult updateMerchantDetailStatus(MerchantDetail merchantDetail, Integer status) {
		// TODO Auto-generated method stub
		JsonResult jsonResult=null;
		if (merchantDetail != null) {
			merchantDetail.setStatus(status);
			jsonResult =isUpdateable(merchantDetail);
			if (jsonResult.isStatus())
				jsonResult.setMessage("Update status successfully ");
				return jsonResult;

		}
		return jsonResult;
	}

	public JsonResult verifyMerchantDetailStatus(MerchantDetail merchantDetail) {
		// TODO Auto-generated method stub
		JsonResult jsonResult=null;
		if (merchantDetail != null) {
			jsonResult=isUpdateable(merchantDetail);
			if (jsonResult.isStatus()) {
				// set jsonResult message
				jsonResult.setMessage("Verify MerchantDetail successfully");
				return jsonResult;
			}
		}
		// set jsonResult message
		return jsonResult;
	}

	public String findMerchantDetailByMerchantID(Integer merchantID) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		MerchantDetail m = null;
		try {
			m = merchantDetailDAOorm.findByMerchantID(merchantID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		MerchantDetail detail = null;
		try {
			detail = merchantDetailDAOorm.findByMerchantID(merchantDetail.getMerchantID());
			System.out.println("detail2:" + detail);
			if (detail != null) {
				if (detail.getStatus() == MerchantDetailStatus.REJECTED) {
					merchantDetail.setStatus(MerchantDetailStatus.UNTREATED);
					merchantDetailDAOorm.updateByID(merchantDetail);
				}
			} else {
				merchantDetailDAOorm.insert(merchantDetail);
			}
			return merchantDetail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail;
	}

	public JsonResult isUpdateable(MerchantDetail merchantDetail) {
		// TODO Auto-generated method stub
		JsonResult jsonResult = new JsonResult();
		MerchantDetail newMerchantDetail;
		try {
			newMerchantDetail = merchantDetailDAOorm.fingByID(merchantDetail.getMerchantDetailID());
			System.out.println("latest:"+newMerchantDetail.getLastUpdateTime());
			System.out.println("old   :"+merchantDetail.getLastUpdateTime());
			if (newMerchantDetail.getLastUpdateTime().equals(merchantDetail.getLastUpdateTime())) {
				java.util.Date curDate = new java.util.Date();
				Long lastUpdateTime = curDate.getTime();
				merchantDetail.setLastUpdateTime(lastUpdateTime);
				if (merchantDetailDAOorm.updateByID(merchantDetail) > 0) {
					jsonResult.setStatus(true);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonResult;
	}

}

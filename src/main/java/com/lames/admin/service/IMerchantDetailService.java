package com.lames.admin.service;

import java.util.List;

import com.lames.admin.model.JsonResult;
import com.lames.admin.model.MerchantDetail;
import com.lames.admin.util.PageUtil;

public interface IMerchantDetailService {

	public String getPassedShopID();
	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil);
	public List<MerchantDetail> listToVerify(PageUtil pUtil);
	public String findMerchantDetailByMerchantID(Integer merchantDetailID);
	public int updateMerchantDetailStatus(MerchantDetail merchantDetail, Integer Status);
	public int verifyMerchantDetailStatus(MerchantDetail merchantDetail);
	public MerchantDetail insert(MerchantDetail merchantDetail);
	public JsonResult isUpdateable(MerchantDetail merchantDetail);
}

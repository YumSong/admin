package com.lames.admin.service.orm;

import java.util.List;

import com.lames.admin.model.JsonResult;
import com.lames.admin.model.orm.MerchantDetail;
import com.lames.admin.util.PageUtil;

public interface IMerchantDetailService {

	public String getPassedShopID();
	public String listToUpdateStatus(PageUtil pUtil);
	public String listToVerify(PageUtil pUtil);
	public String findMerchantDetailByMerchantID(Integer merchantDetailID);
	public String updateMerchantDetailStatus(MerchantDetail merchantDetail, Integer Status);
	public JsonResult verifyMerchantDetailStatus(MerchantDetail merchantDetail);
	public MerchantDetail insert(MerchantDetail merchantDetail);
	public JsonResult isUpdateable(MerchantDetail merchantDetail);
}

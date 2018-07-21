package com.lames.admin.service.orm;

import java.util.List;

import com.lames.admin.model.JsonResult;
import com.lames.admin.model.orm.MerchantDetail;
import com.lames.admin.util.PageUtil;

public interface IMerchantDetailService {

	public String getPassedShopID();
	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil);
	public List<MerchantDetail> listToVerify(PageUtil pUtil);
	public String findMerchantDetailByMerchantID(Integer merchantDetailID);
	public JsonResult updateMerchantDetailStatus(MerchantDetail merchantDetail, Integer Status);
	public JsonResult verifyMerchantDetailStatus(MerchantDetail merchantDetail);
	public MerchantDetail insert(MerchantDetail merchantDetail);
	public JsonResult isUpdateable(MerchantDetail merchantDetail);
}

package com.lames.admin.service;

import java.util.List;

import com.lames.admin.model.MerchantDetail;
import com.lames.admin.util.PageUtil;

public interface IMerchantDetailService {

	public String getPassedShopID();
	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil);
	public List<MerchantDetail> listToVerify(PageUtil pUtil);
	public String findMerchantDetailByMerchantID(Integer merchantDetailID);
	public int updateMerchantDetailStatus(Integer merchantDetailID, Integer Status);
	public int verifyMerchantDetailStatus(Integer merchantDetailID,Integer Status);
}

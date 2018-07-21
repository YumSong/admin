package com.lames.admin.dao;

import java.util.List;

import com.lames.admin.model.MerchantDetail;
import com.lames.admin.util.PageUtil;

public interface IMerchantDetailDAO {

	public MerchantDetail findByMerchantID(Integer merchantID);
	public int insert(MerchantDetail m);
	public MerchantDetail fingByID(Integer merchantDetailID);
	public List<Integer> queryPassedShopID();
	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil);
	public List<MerchantDetail> listToVerify(PageUtil pUtil);
	public int updateStatusByID(Integer merchantDetailID,Integer Status);
	int updateByID(MerchantDetail detail);
}

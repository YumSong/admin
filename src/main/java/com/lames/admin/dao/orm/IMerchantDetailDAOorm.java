package com.lames.admin.dao.orm;

import java.sql.SQLException;
import java.util.List;

import com.lames.admin.model.orm.MerchantDetail;
import com.lames.admin.util.PageUtil;

public interface IMerchantDetailDAOorm {

	public MerchantDetail findByMerchantID(Integer merchantID)throws SQLException ;
	public int insert(MerchantDetail m)throws SQLException ;
	public MerchantDetail fingByID(Integer merchantDetailID)throws SQLException ;
	public List<Integer> queryPassedShopID()throws SQLException ;
	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil)throws SQLException ;
	public List<MerchantDetail> listToVerify(PageUtil pUtil)throws SQLException ;
	public int updateStatusByID(Integer merchantDetailID,Integer Status)throws SQLException ;
	int updateByID(MerchantDetail detail)throws SQLException ;
}

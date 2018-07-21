package com.lames.admin.dao.orm.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jake.core.Criteria;
import com.jake.core.PageInfo;
import com.jake.core.SqlSession;
import com.jake.core.SqlSessionFactory;
import com.lames.admin.constant.MerchantDetailStatus;
import com.lames.admin.dao.orm.IMerchantDetailDAOorm;
import com.lames.admin.model.orm.MerchantDetail;
import com.lames.admin.util.DBormUtil;
import com.lames.admin.util.PageUtil;

public class MerchantDetailDAOorm implements IMerchantDetailDAOorm {
	
	private SqlSessionFactory factory = new SqlSessionFactory("com.lames.admin.model.orm");
	
	public MerchantDetail findByMerchantID(Integer merchantID) throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		MerchantDetail merchantDetail = new MerchantDetail();
		Criteria criteria = new Criteria();
		criteria.put("MERCHANT_ID=",merchantID);
		merchantDetail=sqlSession.find(merchantDetail,criteria);
		sqlSession.close();
		return merchantDetail;

	}

	public int insert(MerchantDetail m) throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		String[] str = m.getShopPic();
		String pics ="";
		if(str!=null) {
			for(String s:str) {
				pics=pics+s+";;";
			}
		}
		m.setShopPics(pics);
		int i = sqlSession.save(m);
		sqlSession.close();
		return i;
	}

	public MerchantDetail fingByID(Integer merchantDetailID) throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();
		MerchantDetail merchantDetail = new MerchantDetail();
		merchantDetail.setMerchantDetailID(merchantDetailID);
		MerchantDetail merchantDetail2=(MerchantDetail)sqlSession.find(merchantDetail);
		String pics =merchantDetail2.getShopPics();
		if(!"".equals(pics)) {
			merchantDetail2.setShopPic(pics.split(";;"));
		}
		sqlSession.close();
		return merchantDetail2;
	}

	public List<Integer> queryPassedShopID() throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();
		MerchantDetail merchantDetail = new MerchantDetail();
		merchantDetail.setStatus(MerchantDetailStatus.PASSED);
		List<MerchantDetail> listM=sqlSession.findAll(MerchantDetail.class);
		List<Integer> list = new ArrayList<Integer>();
		for(MerchantDetail  m: listM) {
			list.add(m.getShopID());
		}
		sqlSession.close();
		return list;
	}

	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil)throws SQLException  {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();
		Criteria criteria = new Criteria();
		criteria.put("status<>",MerchantDetailStatus.UNTREATED);
		List<MerchantDetail> listM=sqlSession.findAll(MerchantDetail.class, criteria,pUtil.getBeginNum(),pUtil.getEndNum());
		PageInfo info = new PageInfo(listM);
		pUtil.setTotal(info.getTotal());
		for(MerchantDetail m :listM) {
			String str = m.getShopPics();
			if(!"".equals(str)&& str!=null) {
				m.setShopPic(str.split(";;"));
			}
		}
		sqlSession.close();
		return listM;
	}

	public List<MerchantDetail> listToVerify(PageUtil pUtil)throws SQLException  {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();
		Criteria criteria = new Criteria();
		criteria.put("status=",MerchantDetailStatus.UNTREATED);
		List<MerchantDetail> listM=sqlSession.findAll(MerchantDetail.class, criteria,pUtil.getBeginNum(),pUtil.getEndNum());
		PageInfo info = new PageInfo(listM);
		pUtil.setTotal(info.getTotal());
		for(MerchantDetail m :listM) {
			if(!"".equals(m.getShopPics())) {
				m.setShopPic(m.getShopPics().split(";;"));
			}
		}
		sqlSession.close();
		return listM;
	}

	public int updateStatusByID(Integer merchantDetailID, Integer Status)throws SQLException  {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		MerchantDetail merchantDetail = new MerchantDetail();
		merchantDetail.setMerchantDetailID(merchantDetailID);
		merchantDetail.setStatus(Status);
		int i = sqlSession.update(merchantDetail);
		sqlSession.close();
		return i;

	}

	public int updateByID(MerchantDetail detail) throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		String[] str = detail.getShopPic();
		String pics ="";
		if(str!=null) {
			for(String s:str) {
				pics=pics+s+";;";
			}
		}
		detail.setShopPics(pics);
		System.out.println(pics);
		detail.setShopPic(null);
		int i = sqlSession.update(detail);
		sqlSession.close();
		return i;
	}

}

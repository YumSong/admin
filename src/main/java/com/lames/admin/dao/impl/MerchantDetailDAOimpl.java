package com.lames.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lames.admin.dao.IMerchantDetailDAO;
import com.lames.admin.model.MerchantDetail;
import com.lames.admin.util.DBUtil;
import com.lames.admin.util.Dbutil2;
import com.lames.admin.util.PageUtil;

public class MerchantDetailDAOimpl implements IMerchantDetailDAO {

	public MerchantDetailDAOimpl() {
		// TODO Auto-generated constructor stub
	}

	public MerchantDetail findByMerchantID(Integer merchantID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "SELECT MERCHANTDETAIL_ID," + "MERCHANT_ID," + "IDCARD_NUM," + "IDCARD_PIC," + "MERCHANT_NAME,"
					+ "SHOP_ID," + "STATUS," + "SHOP_PIC," + "BUSINESS_PIC," + "ADDRESS," + "INTRODUCTION "
					+ "From MERCHANTDETAIL where MERCHANT_ID=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, merchantID);
			rs = ps.executeQuery();
			while (rs.next()) {
				MerchantDetail m = new MerchantDetail();
				m.setMerchantDetailID(rs.getInt(1));
				m.setMerchantID(rs.getInt(2));
				m.setIdcardNum(rs.getInt(3));
				m.setIdcardPic(rs.getString(4));
				m.setMerchantName(rs.getString(5));
				m.setShopID(rs.getInt(6));
				m.setStatus(rs.getInt(7));
				if (rs.getString(8) != null) {
					m.setShopPic(rs.getString(8).split(";;"));
				} else {
					m.setShopPic(null);
				}
				m.setBusinessPic(rs.getString(9));
				m.setAddress(rs.getString(10));
				m.setIntroduction(rs.getString(11));
				return m;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps, rs);
		}	

		return null;
	}

	public List<Integer> queryPassedShopID() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Integer> list = new ArrayList<Integer>();
		try {
			String sql = "SELECT SHOP_ID From MERCHANTDETAIL where STATUS=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);// 审核通过的
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			if (list.size() != 0)
				return list;
			return null;
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps, rs);
		}	
		return null;
	}

	public List<MerchantDetail> listToUpdateStatus(PageUtil pUtil) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs1 = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<MerchantDetail> list = new ArrayList<MerchantDetail>();
		try {
			String totalSQL = "SELECT Count(*) FROM MERCHANTDETAIL where STATUS not in(?,?)";
			ps = conn.prepareStatement(totalSQL);
			ps.setInt(1, 0);// 未审核；不查询未审核
			ps.setInt(2, 2);// 驳回；不查询驳回
			rs1 = ps.executeQuery();
			while (rs1.next()) {
				pUtil.setTotal(rs1.getInt(1));
				System.out.println(pUtil.getTotal());
			}
			String sql = "SELECT MERCHANTDETAIL_ID," + "MERCHANT_ID," + "IDCARD_NUM," + "IDCARD_PIC," + "MERCHANT_NAME,"
					+ "SHOP_ID," + "STATUS," + "SHOP_PIC," + "BUSINESS_PIC," + "ADDRESS," + "INTRODUCTION "
					+ "From (SELECT A.* ,ROWNUM RN FROM MERCHANTDETAIL A where STATUS not in(?,?))"
					+ " WHERE RN between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);// 未审核；不查询未审核
			ps.setInt(2, 2);// 驳回；不查询驳回
			ps.setInt(3, pUtil.getBeginNum());
			ps.setInt(4, pUtil.getEndNum());
			rs = ps.executeQuery();
			while (rs.next()) {
				MerchantDetail m = new MerchantDetail();
				m.setMerchantDetailID(rs.getInt(1));
				m.setMerchantID(rs.getInt(2));
				m.setIdcardNum(rs.getInt(3));
				m.setIdcardPic(rs.getString(4));
				m.setMerchantName(rs.getString(5));
				m.setShopID(rs.getInt(6));
				m.setStatus(rs.getInt(7));
				if (rs.getString(8) != null) {
					m.setShopPic(rs.getString(8).split(";;"));
				} else {
					m.setShopPic(null);
				}
				m.setBusinessPic(rs.getString(9));
				m.setAddress(rs.getString(10));
				m.setIntroduction(rs.getString(11));
				list.add(m);
			}
			if (list.size() != 0)
				return list;
			return null;
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps, rs);
		}	
		return null;
	}

	public List<MerchantDetail> listToVerify(PageUtil pUtil) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<MerchantDetail> list = new ArrayList<MerchantDetail>();
		try {
			String sql = "SELECT MERCHANTDETAIL_ID," + "MERCHANT_ID," + "IDCARD_NUM," + "IDCARD_PIC," + "MERCHANT_NAME,"
					+ "SHOP_ID," + "STATUS," + "SHOP_PIC," + "BUSINESS_PIC," + "ADDRESS," + "INTRODUCTION "
					+ "From (SELECT A.* ,ROWNUM RN FROM MERCHANTDETAIL A where STATUS=? )"
					+ " WHERE RN between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);// 只查未审核外的都需要查出来
			ps.setInt(2, pUtil.getBeginNum());
			ps.setInt(3, pUtil.getEndNum());
			rs = ps.executeQuery();
			while (rs.next()) {
				MerchantDetail m = new MerchantDetail();
				m.setMerchantDetailID(rs.getInt(1));
				m.setMerchantID(rs.getInt(2));
				m.setIdcardNum(rs.getInt(3));
				m.setIdcardPic(rs.getString(4));
				m.setMerchantName(rs.getString(5));
				m.setShopID(rs.getInt(6));
				m.setStatus(rs.getInt(7));
				if (rs.getString(8) != null) {
					m.setShopPic(rs.getString(8).split(";;"));
				} else {
					m.setShopPic(null);
				}
				m.setBusinessPic(rs.getString(9));
				m.setAddress(rs.getString(10));
				m.setIntroduction(rs.getString(11));
				list.add(m);
			}
			if (list.size() != 0)
				return list;
			return null;
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps, rs);
		}	
		return null;
	}

	public MerchantDetail fingByID(Integer merchantDetailID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "SELECT MERCHANTDETAIL_ID," + "MERCHANT_ID," + "IDCARD_NUM," + "IDCARD_PIC," + "MERCHANT_NAME,"
					+ "SHOP_ID," + "STATUS," + "SHOP_PIC," + "BUSINESS_PIC," + "ADDRESS," + "INTRODUCTION "
					+ "From MERCHANTDETAIL where MERCHANTDETAIL_ID=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, merchantDetailID);
			rs = ps.executeQuery();
			while (rs.next()) {
				MerchantDetail m = new MerchantDetail();
				m.setMerchantDetailID(rs.getInt(1));
				m.setMerchantID(rs.getInt(2));
				m.setIdcardNum(rs.getInt(3));
				m.setIdcardPic(rs.getString(4));
				m.setMerchantName(rs.getString(5));
				m.setShopID(rs.getInt(6));
				m.setStatus(rs.getInt(7));
				if (rs.getString(8) != null) {
					m.setShopPic(rs.getString(8).split(";;"));
				} else {
					m.setShopPic(null);
				}
				m.setBusinessPic(rs.getString(9));
				m.setAddress(rs.getString(10));
				m.setIntroduction(rs.getString(11));
				return m;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps, rs);
		}	
		return null;
	}

	public int updateStatusByID(Integer merchantDetailID, Integer Status) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE MERCHANTDETAIL SET STATUS = ? WHERE MERCHANTDETAIL_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Status);
			ps.setInt(2, merchantDetailID);
			return ps.executeUpdate();
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps);
		}	
		return 0;
	}
	
	public int updateByID(MerchantDetail detail) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE MERCHANTDETAIL SET IDCARD_NUM = ?,IDCARD_PIC=?,"
					+ "MERCHANT_NAME=?,STATUS=0,SHOP_PIC=?,BUSINESS_PIC=?,ADDRESS=?,INTRODUCTION=? WHERE MERCHANTDETAIL_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, detail.getIdcardNum());
			ps.setString(2, detail.getIdcardPic());
			ps.setString(3, detail.getMerchantName());
			if (detail.getShopPic() == null) {
				ps.setString(4, null);
			} else {
				String str ="";
				for(int i = 0 ;i<detail.getShopPic().length;i++)
					str =str+ detail.getShopPic()[i]+";;";
				ps.setString(4, str);
			}
			ps.setString(5, detail.getBusinessPic());
			ps.setString(6, detail.getAddress());
			ps.setString(7, detail.getIntroduction());
			ps.setInt(8, detail.getMerchantDetailID());
			return ps.executeUpdate();
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps);
		}	
		return 0;
	}

	public int insert(MerchantDetail m) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO MERCHANTDETAIL ( MERCHANTDETAIL_ID," + "MERCHANT_ID," + "IDCARD_NUM,"
					+ "IDCARD_PIC," + "MERCHANT_NAME," + "SHOP_ID," + "STATUS," + "SHOP_PIC," + "BUSINESS_PIC,"
					+ "ADDRESS,INTRODUCTION)" + "values(S_merchantDetail.nextval,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getMerchantID());
			ps.setInt(2, m.getIdcardNum());
			ps.setString(3, m.getIdcardPic());
			ps.setString(4, m.getMerchantName());
			ps.setInt(5, m.getShopID());
			ps.setInt(6, 0);
			if (m.getShopPic() == null) {
				ps.setString(7, null);
			} else {
				String str ="";
				for(int i = 0 ;i<m.getShopPic().length;i++)
					str =str+ m.getShopPic()[i]+";;";
				ps.setString(7, str);
			}
			ps.setString(8, m.getBusinessPic());
			ps.setString(9, m.getAddress());
			ps.setString(10, m.getIntroduction());
			return ps.executeUpdate();

		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.free(conn, ps);
		}	
		return 0;
	}

}

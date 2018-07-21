package com.lames.admin.util;

import java.io.BufferedInputStream;

public class PageUtil {

	private Integer beginNum;
	private Integer endNum;
	private Integer length;
	private Integer pageNum;
	private Integer total;
	
	private void setParameter() {
		this.beginNum = 1 + this.length * (this.pageNum - 1);
		this.endNum = this.length * this.pageNum;
		
	}
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
		this.length = 3;
		this.pageNum = 1;
		this.total = this.length * this.pageNum;
	}

	public Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;

	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
		setParameter();
	}

	public Integer getPageNum() {
		return pageNum;
	}

	// 设置查看第几页
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
		setParameter();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public boolean hasNextPage() {
		if(this.total>this.beginNum) {
			return true;
		}
			return false;
	}
	
	public boolean hasPreviousPage() {
		if(this.pageNum>0) {
			return true;
		}
			return false;
	}
	
	
	

}

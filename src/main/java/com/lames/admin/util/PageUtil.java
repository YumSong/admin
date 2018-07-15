package com.lames.admin.util;

public class PageUtil {

	private Integer beginNum;
	private Integer endNum;
	private Integer length;
	private Integer pageNum;
	private Integer total; 
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub	
		this.length = 10;
		this.pageNum = 1;
		this.beginNum = 1+this.length*(this.pageNum-1);
		this.endNum = 10+this.length*(this.pageNum-1);
		this.total=10;
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
	}

	public Integer getPageNum() {
		return pageNum;
	}

	//设置查看第几页
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
		this.beginNum = 1+this.length*(this.pageNum-1);
		this.endNum = this.length*(this.pageNum);
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}

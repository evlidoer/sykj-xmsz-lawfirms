package com.jt.lawfirm.bean;

import java.util.List;

public class PageBean {
	//数据偏移量，offset/limit +1 我们要得到当前第几页<=> pageNum
	private int offset;
	private int limit;//每页多少条
	private long total;//总行数，不能写错
	private List<?> rows;//分页数据,不能写错，bt只认rows
	
	
	public PageBean(int offset, int limit, long total, List<?> rows) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.total = total;
		this.rows = rows;
	}
	
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "PageBean [offset=" + offset + ", limit=" + limit + ", total=" + total + ", rows=" + rows + "]";
	}


	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset/limit+1;	
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}

package com.util.page;

import java.util.List;

/**
 * 分页实体模型
 * @version 1.0,2013-9-3
 * @author Wymann
 */
public class Pager {
	
	//某一页的记录列表
	private List list;
	//总记录数
	private int allRow;
	//总页数
	private int totalPage;
	//当前页
	private int currentPage=1;
	//每页记录数
	private int pageSize=5;
	//翻页访问地址
	private String pageUrl;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
}

package com.eras.erasweb.model;

import java.util.List;


import com.eras.erasweb.dto.UserTypeDTO;

public class UserTypeResponse {
	private List<UserTypeDTO> content;
	private int pageNO;
	private int pageSize;
	private long totalElement;
	private int totalPages;
	private Boolean last;
	public List<UserTypeDTO> getContent() {
		return content;
	}
	public void setContent(List<UserTypeDTO> content) {
		this.content = content;
	}
	public int getPageNO() {
		return pageNO;
	}
	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}

}

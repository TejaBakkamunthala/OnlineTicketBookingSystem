package com.ticket.app.common;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Pagination {
	
	
	private int pageNo;
    private int recordPerPage;
    private String sortDir;
    private String sortKey;
    
    
	public Pagination(int pageNo, int recordPerPage, String sortDir, String sortKey) {
		super();
		this.pageNo = pageNo;
		this.recordPerPage = recordPerPage;
		this.sortDir = sortDir;
		this.sortKey = sortKey;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getRecordPerPage() {
		return recordPerPage;
	}


	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}


	public String getSortDir() {
		return sortDir;
	}


	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}


	public String getSortKey() {
		return sortKey;
	}


	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}


	@Override
	public String toString() {
		return "Pagination [pageNo=" + pageNo + ", recordPerPage=" + recordPerPage + ", sortDir=" + sortDir
				+ ", sortKey=" + sortKey + "]";
	}


	public Pageable getPageableInstance() {
		org.springframework.data.domain.Sort sort = Sort.by(sortDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortKey);
		       return PageRequest.of(pageNo, recordPerPage, sort);
		 
		}
    
	 
	    
	    
	}




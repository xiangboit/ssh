package com.ssh.bean;

import java.util.List;

@SuppressWarnings("rawtypes")
public class QueryResult {
	private int rowCount;
	
	private List list;
	
	public QueryResult(int rowCount, List list) {
		
		this.rowCount = rowCount;
		this.list = list;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}

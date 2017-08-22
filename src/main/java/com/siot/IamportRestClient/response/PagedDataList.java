package com.siot.IamportRestClient.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PagedDataList<T> {

	@SerializedName("total")
	int total;
	
	@SerializedName("previous")
	int previous;
	
	@SerializedName("next")
	int next;
	
	@SerializedName("list")
	List<T> list;
	
	public int getTotal() {
		return total;
	}
	
	public int getPrevious() {
		return previous;
	}
	
	public int getNext() {
		return next;
	}
	
	public List<T> getList() {
		return list;
	}
	
}

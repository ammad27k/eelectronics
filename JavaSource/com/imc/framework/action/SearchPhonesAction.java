package com.imc.framework.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SearchPhonesAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2824692280181175547L;
	private String filterName;
	private String catId;

	public void prepareSearchPhonesByAjax(){
		System.out.println(filterName);
	}
	
	public String searchPhonesByAjax(){
		return SUCCESS;
	}
	
	
	@Override
	public void prepare() throws Exception {
	}
	
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

}

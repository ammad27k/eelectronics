package com.imc.framework.action;


import com.imc.framework.bean.MobilePhoneReviews;
import com.imc.framework.bean.MobilePhones;
import com.imc.service.MobileService;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7094066676316497645L;

	private String name;
	private long id;
	private String comments;
	
	public void validateAddReviews(){
		
	}
	public String addReviews(){
		try{
			
			MobilePhoneReviews reviews = new MobilePhoneReviews();
			MobilePhones phone = new MobilePhones();
			phone.setId(id);
			reviews.setMobilePhones(phone);
			reviews.setName(name);
			reviews.setReviewsDesc(comments);
			
			MobileService.persistObject( reviews);
			
			
			
		}catch(Exception e){
			
		}
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
}

package com.imc.framework.action;

import java.util.List;

import com.imc.framework.bean.MobileAlertTypes;
import com.imc.framework.bean.MobileNetworks;
import com.imc.framework.bean.MobilePhoneReviews;
import com.imc.framework.bean.MobilePhones;
import com.imc.service.MobileService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author ammad
 *
 */
public class PhoneDetailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8496025642369802740L;
	
	private String fancyurl;
	
	private List<MobilePhoneReviews> phoneReviews;
	private List<MobileNetworks> mobileNetworks;
	private List<MobileAlertTypes> mobileAlertsType;
	
	private long id;
	
	private void prepareFetchPhoneDetail(String fancyUrl){
		try {
			String arg[] = fancyUrl.split("-");
			MobilePhones phones = (MobilePhones) MobileService.getMobilePhoneId(MobilePhones.class, "gsmarenaId", Long.parseLong(arg[arg.length-1]), false);
			
			mobileNetworks = MobileService.getMobileNetworks(null, phones.getId());
			setMobileAlertsType(MobileService.getMobileAlertType(null, phones.getId()));
			setPhoneReviews(MobileService.getMobilePhoneReviews(null, phones.getId()));
			setId(phones.getId());
			
		} catch (Exception e) {
			System.out.println("System malFunction" +e);
		}
	}
	
	public String fetchPhoneDetail(){
		prepareFetchPhoneDetail(getFancyurl());
		return SUCCESS;
	}
	
	

	public String getFancyurl() {
		return fancyurl;
	}

	public void setFancyurl(String fancyurl) {
		this.fancyurl = fancyurl;
	}

	public List<MobilePhoneReviews> getPhoneReviews() {
		return phoneReviews;
	}

	public void setPhoneReviews(List<MobilePhoneReviews> phoneReviews) {
		this.phoneReviews = phoneReviews;
	}

	public List<MobileNetworks> getMobileNetworks() {
		return mobileNetworks;
	}

	public void setMobileNetworks(List<MobileNetworks> mobileNetworks) {
		this.mobileNetworks = mobileNetworks;
	}

	public List<MobileAlertTypes> getMobileAlertsType() {
		return mobileAlertsType;
	}

	public void setMobileAlertsType(List<MobileAlertTypes> mobileAlertsType) {
		this.mobileAlertsType = mobileAlertsType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	
}

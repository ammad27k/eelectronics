package com.imc.framework.bean;
// Generated Mar 6, 2013 10:49:21 PM by Hibernate Tools 3.4.0.CR1

/**
 * MobilePhoneToMessaging generated by hbm2java
 */
public class MobilePhoneToMessaging implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4604685035730589210L;
	private Long id;
	private MobilePhones mobilePhones;
	private MobileMessaging mobileMessaging;

	public MobilePhoneToMessaging() {
	}

	public MobilePhoneToMessaging(MobilePhones mobilePhones,
			MobileMessaging mobileMessaging) {
		this.mobilePhones = mobilePhones;
		this.mobileMessaging = mobileMessaging;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MobilePhones getMobilePhones() {
		return this.mobilePhones;
	}

	public void setMobilePhones(MobilePhones mobilePhones) {
		this.mobilePhones = mobilePhones;
	}

	public MobileMessaging getMobileMessaging() {
		return this.mobileMessaging;
	}

	public void setMobileMessaging(MobileMessaging mobileMessaging) {
		this.mobileMessaging = mobileMessaging;
	}

}

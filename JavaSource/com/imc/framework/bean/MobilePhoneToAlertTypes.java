package com.imc.framework.bean;
// Generated Mar 6, 2013 10:49:21 PM by Hibernate Tools 3.4.0.CR1

/**
 * MobilePhoneToAlertTypes generated by hbm2java
 */
public class MobilePhoneToAlertTypes implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4420852350534790340L;
	private Long id;
	private MobilePhones mobilePhones;
	private MobileAlertTypes mobileAlertTypes;

	public MobilePhoneToAlertTypes() {
	}

	public MobilePhoneToAlertTypes(MobilePhones mobilePhones,
			MobileAlertTypes mobileAlertTypes) {
		this.mobilePhones = mobilePhones;
		this.mobileAlertTypes = mobileAlertTypes;
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

	public MobileAlertTypes getMobileAlertTypes() {
		return this.mobileAlertTypes;
	}

	public void setMobileAlertTypes(MobileAlertTypes mobileAlertTypes) {
		this.mobileAlertTypes = mobileAlertTypes;
	}

}

package com.imc.framework.bean;
// Generated Mar 6, 2013 10:49:21 PM by Hibernate Tools 3.4.0.CR1

/**
 * MobilePhoneToMemoryCardslots generated by hbm2java
 */
public class MobilePhoneToMemoryCardslots implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3870749755737829643L;
	private Long id;
	private MobilePhones mobilePhones;
	private MobileMemoryCardslots mobileMemoryCardslots;

	public MobilePhoneToMemoryCardslots() {
	}

	public MobilePhoneToMemoryCardslots(MobilePhones mobilePhones,
			MobileMemoryCardslots mobileMemoryCardslots) {
		this.mobilePhones = mobilePhones;
		this.mobileMemoryCardslots = mobileMemoryCardslots;
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

	public MobileMemoryCardslots getMobileMemoryCardslots() {
		return this.mobileMemoryCardslots;
	}

	public void setMobileMemoryCardslots(
			MobileMemoryCardslots mobileMemoryCardslots) {
		this.mobileMemoryCardslots = mobileMemoryCardslots;
	}

}

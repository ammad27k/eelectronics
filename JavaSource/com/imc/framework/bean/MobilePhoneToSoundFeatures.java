package com.imc.framework.bean;
// Generated Mar 6, 2013 10:49:21 PM by Hibernate Tools 3.4.0.CR1

/**
 * MobilePhoneToSoundFeatures generated by hbm2java
 */
public class MobilePhoneToSoundFeatures implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4230719618603171034L;
	private Long id;
	private MobilePhones mobilePhones;
	private MobileSoundFeatures mobileSoundFeatures;

	public MobilePhoneToSoundFeatures() {
	}

	public MobilePhoneToSoundFeatures(MobilePhones mobilePhones,
			MobileSoundFeatures mobileSoundFeatures) {
		this.mobilePhones = mobilePhones;
		this.mobileSoundFeatures = mobileSoundFeatures;
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

	public MobileSoundFeatures getMobileSoundFeatures() {
		return this.mobileSoundFeatures;
	}

	public void setMobileSoundFeatures(MobileSoundFeatures mobileSoundFeatures) {
		this.mobileSoundFeatures = mobileSoundFeatures;
	}

}

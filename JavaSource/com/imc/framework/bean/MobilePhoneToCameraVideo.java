package com.imc.framework.bean;
// Generated Mar 6, 2013 10:49:21 PM by Hibernate Tools 3.4.0.CR1

/**
 * MobilePhoneToCameraVideo generated by hbm2java
 */
public class MobilePhoneToCameraVideo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -642256342454371274L;
	private Long id;
	private MobileCameraVideo mobileCameraVideo;
	private MobilePhones mobilePhones;

	public MobilePhoneToCameraVideo() {
	}

	public MobilePhoneToCameraVideo(MobileCameraVideo mobileCameraVideo,
			MobilePhones mobilePhones) {
		this.mobileCameraVideo = mobileCameraVideo;
		this.mobilePhones = mobilePhones;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MobileCameraVideo getMobileCameraVideo() {
		return this.mobileCameraVideo;
	}

	public void setMobileCameraVideo(MobileCameraVideo mobileCameraVideo) {
		this.mobileCameraVideo = mobileCameraVideo;
	}

	public MobilePhones getMobilePhones() {
		return this.mobilePhones;
	}

	public void setMobilePhones(MobilePhones mobilePhones) {
		this.mobilePhones = mobilePhones;
	}

}

package com.imc.framework.bean;
// Generated Mar 6, 2013 10:49:21 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * MobileEdge generated by hbm2java
 */
public class MobileEdge implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8125502162383011861L;
	private Long id;
	private String title;
	private Character isActive;
	private Character isDeleted;
	private Set<?> mobilePhoneses = new HashSet<Object>(0);

	public MobileEdge() {
	}

	public MobileEdge(String title, Character isActive, Character isDeleted,
			Set<?> mobilePhoneses) {
		this.title = title;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.mobilePhoneses = mobilePhoneses;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Character getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public Character getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Character isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<?> getMobilePhoneses() {
		return this.mobilePhoneses;
	}

	public void setMobilePhoneses(Set<?> mobilePhoneses) {
		this.mobilePhoneses = mobilePhoneses;
	}

}

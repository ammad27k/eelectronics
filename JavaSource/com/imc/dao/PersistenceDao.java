package com.imc.dao;

import org.hibernate.Session;

import com.imc.framework.bean.MobilePhoneReviews;
import com.imc.framework.bean.MobilePhones;

public interface PersistenceDao {
	public int persistMobilePhone(MobilePhones phones,Session session) throws Exception;
	public Object getId(Class<?> cls,Session session,String value) throws Exception;
	public int persistObject(String tablename,Object obj,Session session) throws Exception;
	public Object getIdByNameValue(Class<?> cls ,Session session, String name, Object value,boolean id) throws Exception;
	public void deleteObject(Session session , String tableName,String name,String value)throws Exception;
	public int persistReviews(MobilePhoneReviews  obj,Session session) throws Exception ;
}

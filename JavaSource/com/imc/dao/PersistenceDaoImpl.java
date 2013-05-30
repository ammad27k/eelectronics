package com.imc.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.imc.framework.bean.MobilePhoneReviews;
import com.imc.framework.bean.MobilePhones;

public class PersistenceDaoImpl implements PersistenceDao{
	Logger LGR = Logger.getLogger(PersistenceDaoImpl.class);
	
	@Override
	public int persistMobilePhone(MobilePhones phones, Session session) throws Exception {
		try{
			session.saveOrUpdate(phones);
			return 1;
		}catch(Exception e){
			throw new Exception(e);
		}
		
	}
	
	public Object getId(Class<?> cls,Session session,String value) throws Exception{
		try{
			return session.createCriteria(cls).add(Restrictions.eq("title", value)).uniqueResult();
		}catch(Exception e){
			throw new Exception(e);
		}
	}
	
	public Object getIdByNameValue(Class<?> cls ,Session session, String name, Object value,boolean id) throws Exception{
		try {
			if(id){
				return session.createCriteria(cls).add(Restrictions.eq(name, Long.parseLong((String) value))).uniqueResult();
			}else{
				return session.createCriteria(cls).add(Restrictions.eq(name, value)).uniqueResult();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public int persistObject(String tablename,Object obj,Session session) throws Exception {
		try{
			session.saveOrUpdate(tablename, obj);
			return 1;
		}catch(Exception e){
			throw new Exception(e);
		}
	}
	
	@Override
	public int persistReviews(MobilePhoneReviews  obj,Session session) throws Exception {
		try{
			int i = session.createSQLQuery("insert into mobile_phones_reviews (phone_id,name,reviews_desc) values ('" + obj.getMobilePhones().getId()+"',"+
					"'"+obj.getName()+"','"+obj.getReviewsDesc() + "')" ).addEntity(MobilePhoneReviews.class).executeUpdate();
			return i;
			
		}catch(Exception e){
			throw new Exception(e);
		}
	}
	
	@Override
	public void deleteObject(Session session , String tableName,String name,String value)throws Exception{
		try{
			session.createSQLQuery("delete from " + tableName + " where " + name +" = " + value).executeUpdate();
		}catch(Exception e){
			throw new Exception(e);
		}
	}

}

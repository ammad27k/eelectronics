package com.imc.framework.factory;

import com.imc.dao.MobilePhoneMultipleFeatureDao;
import com.imc.dao.MobilePhoneMultipleFeatureDaoImpl;
import com.imc.dao.PersistenceDao;
import com.imc.dao.PersistenceDaoImpl;

public class DAOFactory {

	public static DAOFactory daoFactory = null;
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		if(daoFactory == null){
			daoFactory = new DAOFactory();
		}
		return daoFactory;
	}
	
	public MobilePhoneMultipleFeatureDao getMultipleFeatureDao(){
		return new MobilePhoneMultipleFeatureDaoImpl();
	}
	
	public PersistenceDao getPersistenceDao(){
		return new PersistenceDaoImpl();
	}
}

package com.imc.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.imc.framework.bean.MobileAlertTypes;
import com.imc.framework.bean.MobileBrowsers;
import com.imc.framework.bean.MobilePhoneToAlertTypes;
import com.imc.framework.bean.MobilePhones;
import com.imc.framework.bean.MobileSimTypes;
import com.imc.framework.bean.MobileWlan;
import com.imc.service.MobileService;
import com.imc.utils.HibernateUtil;


public class Main {

	public static void main(String[] args) {
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction transaction = null;
		try {
		//	transaction = session.beginTransaction();
			/*Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");
			Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
			Student student1 = new Student("Eswar", address1);
			Student student2 = new Student("Joe", address2);
			session.save(student1);
			session.save(student2);
			
			MobileAlertTypesHome alertsTypeHome = new MobileAlertTypesHome();
			MobileAlertTypes mobileAlertType = alertsTypeHome.findById(new Long(1));
			MobileAlertTypes mb = new MobileAlertTypes();
			List<?> list = alertsTypeHome.findByExample(mb);
			System.out.println(mobileAlertType.getTitle() + list.size());
			
			for(int i = 0; i<list.size(); i++){
				System.out.println(((MobileAlertTypes)list.get(i)).getTitle());
			}
			mb.setTitle("ammad");
			alertsTypeHome.persist(mb);
			
			MobilePhoneToAlertTypes alp = new MobilePhoneToAlertTypes();
			MobileAlertTypes mobileAlertTypes = new MobileAlertTypes();
			mobileAlertTypes.setTitle("ammad");
			alp.setMobileAlertTypes(mobileAlertTypes);
			MobileAlertTypesHome h = new MobileAlertTypesHome();
			h.persist(mobileAlertTypes);
			MobilePhones phones = new MobilePhones();
			MobilePhonesHome hm = new MobilePhonesHome();
			
			phones.setPhotoUrl("sdfd");
			phones.setCallRecords("Jdfsd");
			phones.setPhonebook("fsdfsd");
			hm.persist(phones);
			alp.setMobilePhones(phones);
			
			MobilePhoneToAlertTypesHome home = new MobilePhoneToAlertTypesHome();
			home.persist(alp);*/
			
			/*MobilePhoneToAlertTypes alp = new MobilePhoneToAlertTypes();
			MobileAlertTypes mobileAlertTypes = new MobileAlertTypes();
			mobileAlertTypes.setTitle("ammad");
			alp.setMobileAlertTypes(mobileAlertTypes);
			MobileAlertTypesHome h = new MobileAlertTypesHome();
			h.persist(mobileAlertTypes);
			MobilePhones phones = new MobilePhones();
			MobilePhonesHome hm = new MobilePhonesHome();
			
			phones.setPhotoUrl("asdfsd");
			phones.setCallRecords("Jdfsd");
			phones.setPhonebook("fsdfsd");
			hm.persist(phones);
			alp.setMobilePhones(phones);
			
			MobilePhoneToAlertTypesHome home = new MobilePhoneToAlertTypesHome();
			home.persist(alp);*/
			
			/*MobileAlertTypesHome alertHomes = new MobileAlertTypesHome();
			MobileAlertTypes aa = alertHomes.findById(new Long(14));
			Set<MobilePhoneToAlertTypes> set = (Set<MobilePhoneToAlertTypes>) aa.getMobilePhoneToAlertTypeses();
			Iterator<MobilePhoneToAlertTypes> iterator  = set.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next().getId());
			}
			System.out.println(aa.getTitle());*/
			
			/*MobilePhonesHome home = new MobilePhonesHome();
			MobilePhones phone = new MobilePhones();
			phone.setId(new Long(5));
			List size = home.findByExample(phone);
			System.out.println(((MobilePhones)size.get(0)).getBattery());*/
			
			
			/*MobilePhones mobilePhone = new MobilePhones(new Long(434),"43sdfd" , "4sfdds" ,"gammad");
			Set<MobileAlertTypes> alertType = new HashSet<MobileAlertTypes>();
			MobileAlertTypes aTypes = new MobileAlertTypes();
			aTypes.setTitle("arshadd");
			alertType.add(aTypes);
			mobilePhone.setMobilePhoneToAlertTypeses(alertType);
			MobilePhonesHome home = new MobilePhonesHome();
			home.persist(mobilePhone);*/
			
			/*Session sesion = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = sesion.beginTransaction();
			MobilePhones phones = new MobilePhones(234, "dfsd","dsfdfs", "dfsd");
			MobileOs os = new MobileOs();
			os.setTitle("amamd");
			phones.setMobileOs(os );
			sesion.save(phones);
			transaction.commit();
			sesion.close();*/
			
			Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = sesion.beginTransaction();
			/*MobileAlertTypes atye = new MobileAlertTypes();
			atye.setTitle("asdsfm");
			Set<MobilePhoneToAlertTypes> se  = new HashSet<MobilePhoneToAlertTypes>();
			MobilePhones phones = new MobilePhones(234, "dfsd","dsfdfs", "dfsd");
			phones.setId(new Long(21));
			se.add(new MobilePhoneToAlertTypes(phones, atye));
			atye.setMobilePhoneToAlertTypeses(se);*/
			
			
			/*
			MobilePhones phone = ((MobilePhones)sesion.get(MobilePhones.class, new Long(21)));
			Set<MobilePhoneToAlertTypes> a =  (Set<MobilePhoneToAlertTypes>) phone.getMobilePhoneToAlertTypeses();
			
			Iterator<MobilePhoneToAlertTypes> iter = a.iterator();
			while(iter.hasNext()){
				System.out.println(((MobilePhoneToAlertTypes)iter.next()).getMobileAlertTypes().getTitle());
			}*/
			
			/*try {
				System.out.println("sfdfs");
				List<MobileAlertTypes> type = MobileService.getMobileAlertType(null,6);
				for(int i = 0 ; i<type.size(); i++){
					System.out.println(type.get(i).getTitle());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			}*/
			
			/*MobilePhones phones = new MobilePhones(21, "234234", "sdfsdf", "sdfdfs");
			
			MobileWlan wlan = new MobileWlan();
			wlan.setTitle("nowifi");
			phones.setMobileWlan(wlan);
			MobileAlertTypes atypes = new MobileAlertTypes();
			atypes.setTitle("setViraton");
			MobilePhoneToAlertTypes toAlert = new MobilePhoneToAlertTypes();
			toAlert.setMobileAlertTypes(atypes);
			toAlert.setMobilePhones(phones);
			
			sesion.saveOrUpdate(toAlert);*/
	/*		Main m = new Main();
			Object list = m.getId(MobileSimTypes.class, sesion,"ammasd");
			if(list != null){
				System.out.println(((MobileSimTypes)list).getId());
			}else{
				MobilePhones phone = new MobilePhones(343,"", "","");
				MobileAlertTypes t = new MobileAlertTypes();
				t.setTitle("fsdf");
				MobilePhoneToAlertTypes toAlert = new MobilePhoneToAlertTypes();
				toAlert.setMobileAlertTypes(t);
				toAlert.setMobilePhones(phone);
				Set<MobilePhoneToAlertTypes> set = new HashSet<>();
				set.add(toAlert);
				phone.setMobilePhoneToAlertTypeses(set);
				sesion.saveOrUpdate(phone);
				System.out.println("ammad");
			}
	*/		
			Main m = new Main();
			m.delte(sesion);
		
		
		transaction.commit();
			
		} catch (HibernateException e) {
			//transaction.rollback();
		//	e.printStackTrace();
		} finally {
		
		}

	}
	public Object getId(Class<?> cls,Session session,String value) {
			return session.createCriteria(cls).add(Restrictions.eq("title", value)).uniqueResult();
	}
	
	public void delte(Session sesion ){
		sesion.createSQLQuery("delete from mobile_phone_to_browsers where phone_id = 3").executeUpdate();
	}

	/*public boolean checkTableIfExist(String tableName, Session session){
		Connection connection = session.
		return;
	}*/
}

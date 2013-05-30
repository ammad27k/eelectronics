package com.imc.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.imc.framework.bean.MobileAlertTypes;
import com.imc.framework.bean.MobileBrands;
import com.imc.framework.bean.MobileBrowsers;
import com.imc.framework.bean.MobileCameraFeatures;
import com.imc.framework.bean.MobileCameraPrimary;
import com.imc.framework.bean.MobileCameraSecondary;
import com.imc.framework.bean.MobileCameraVideo;
import com.imc.framework.bean.MobileColors;
import com.imc.framework.bean.MobileDataSpeeds;
import com.imc.framework.bean.MobileDisplayProtection;
import com.imc.framework.bean.MobileDisplayTypes;
import com.imc.framework.bean.MobileFeatures;
import com.imc.framework.bean.MobileGames;
import com.imc.framework.bean.MobileJava;
import com.imc.framework.bean.MobileMemory;
import com.imc.framework.bean.MobileMemoryCardslots;
import com.imc.framework.bean.MobileMessaging;
import com.imc.framework.bean.MobileNetworks;
import com.imc.framework.bean.MobileNfc;
import com.imc.framework.bean.MobilePhoneReviews;
import com.imc.framework.bean.MobilePhoneToAlertTypes;
import com.imc.framework.bean.MobilePhoneToBrowsers;
import com.imc.framework.bean.MobilePhoneToCameraFeatures;
import com.imc.framework.bean.MobilePhoneToCameraPrimary;
import com.imc.framework.bean.MobilePhoneToCameraSecondary;
import com.imc.framework.bean.MobilePhoneToCameraVideo;
import com.imc.framework.bean.MobilePhoneToColors;
import com.imc.framework.bean.MobilePhoneToDataSpeeds;
import com.imc.framework.bean.MobilePhoneToDisplayTypes;
import com.imc.framework.bean.MobilePhoneToFeatures;
import com.imc.framework.bean.MobilePhoneToGames;
import com.imc.framework.bean.MobilePhoneToJava;
import com.imc.framework.bean.MobilePhoneToMemory;
import com.imc.framework.bean.MobilePhoneToMemoryCardslots;
import com.imc.framework.bean.MobilePhoneToMessaging;
import com.imc.framework.bean.MobilePhoneToNetworks;
import com.imc.framework.bean.MobilePhoneToNfc;
import com.imc.framework.bean.MobilePhoneToProtections;
import com.imc.framework.bean.MobilePhoneToRadio;
import com.imc.framework.bean.MobilePhoneToSensors;
import com.imc.framework.bean.MobilePhoneToSoundFeatures;
import com.imc.framework.bean.MobilePhones;
import com.imc.framework.bean.MobileRadio;
import com.imc.framework.bean.MobileSensors;
import com.imc.framework.bean.MobileSoundFeatures;

public class MobilePhoneMultipleFeatureDaoImpl implements MobilePhoneMultipleFeatureDao
{
	Logger LGR = Logger.getLogger(MobilePhoneMultipleFeatureDaoImpl.class);
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MobileAlertTypes> getMobileAlertTypes(MobilePhones phone,Session session,long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToAlertTypes> set =  (Set<MobilePhoneToAlertTypes>) phone.getMobilePhoneToAlertTypeses();
			Iterator<MobilePhoneToAlertTypes> iterator = set.iterator();
			List<MobileAlertTypes> mobileAlertsType = new ArrayList<>();
			while(iterator.hasNext()){
				mobileAlertsType.add(((MobilePhoneToAlertTypes)iterator.next()).getMobileAlertTypes());
			}
			return mobileAlertsType;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Alerts type");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileBrowsers> getMobileBrowsers(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToBrowsers> set =  (Set<MobilePhoneToBrowsers>) phone.getMobilePhoneToBrowserses();
			Iterator<MobilePhoneToBrowsers> iterator = set.iterator();
			List<MobileBrowsers> mobileBrowsers = new ArrayList<>();
			while(iterator.hasNext()){
				mobileBrowsers.add(((MobilePhoneToBrowsers)iterator.next()).getMobileBrowsers());
			}
			return mobileBrowsers;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileCameraFeatures> getCameraFeatures(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToCameraFeatures> set =  (Set<MobilePhoneToCameraFeatures>) phone.getMobilePhoneToCameraFeatureses();
			Iterator<MobilePhoneToCameraFeatures> iterator = set.iterator();
			List<MobileCameraFeatures> mobileCameraFeatures = new ArrayList<>();
			while(iterator.hasNext()){
				mobileCameraFeatures.add(((MobilePhoneToCameraFeatures)iterator.next()).getMobileCameraFeatures());
			}
			return mobileCameraFeatures;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MobileCameraPrimary> getCameraPrimaries(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToCameraPrimary> set =  (Set<MobilePhoneToCameraPrimary>) phone.getMobilePhoneToCameraFeatureses();
			Iterator<MobilePhoneToCameraPrimary> iterator = set.iterator();
			List<MobileCameraPrimary> mobileCameraPrimaries = new ArrayList<>();
			while(iterator.hasNext()){
				mobileCameraPrimaries.add(((MobilePhoneToCameraPrimary)iterator.next()).getMobileCameraPrimary());
			}
			return mobileCameraPrimaries;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MobileCameraSecondary> getCameraSecondaries(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToCameraSecondary> set =  (Set<MobilePhoneToCameraSecondary>) phone.getMobilePhoneToCameraFeatureses();
			Iterator<MobilePhoneToCameraSecondary> iterator = set.iterator();
			List<MobileCameraSecondary> mobileCameraSecondaries = new ArrayList<>();
			while(iterator.hasNext()){
				mobileCameraSecondaries.add(((MobilePhoneToCameraSecondary)iterator.next()).getMobileCameraSecondary());
			}
			return mobileCameraSecondaries;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileCameraVideo> getCameraVideos(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToCameraVideo> set =  (Set<MobilePhoneToCameraVideo>) phone.getMobilePhoneToCameraVideos();
			Iterator<MobilePhoneToCameraVideo> iterator = set.iterator();
			List<MobileCameraVideo> mobileCameraVideos = new ArrayList<>();
			while(iterator.hasNext()){
				mobileCameraVideos.add(((MobilePhoneToCameraVideo)iterator.next()).getMobileCameraVideo());
			}
			return mobileCameraVideos;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileColors> getMobileColors(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToColors> set =  (Set<MobilePhoneToColors>) phone.getMobilePhoneToColorses();
			Iterator<MobilePhoneToColors> iterator = set.iterator();
			List<MobileColors> mobileColors = new ArrayList<>();
			while(iterator.hasNext()){
				mobileColors.add(((MobilePhoneToColors)iterator.next()).getMobileColors());
			}
			return mobileColors;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileDataSpeeds> getMobileDataSpeeds(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToDataSpeeds> set =  (Set<MobilePhoneToDataSpeeds>) phone.getMobilePhoneToColorses();
			Iterator<MobilePhoneToDataSpeeds> iterator = set.iterator();
			List<MobileDataSpeeds> mobileColors = new ArrayList<>();
			while(iterator.hasNext()){
				mobileColors.add(((MobilePhoneToDataSpeeds)iterator.next()).getMobileDataSpeeds());
			}
			return mobileColors;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileDisplayTypes> getDisplayTypes(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToDisplayTypes> set =  (Set<MobilePhoneToDisplayTypes>) phone.getMobilePhoneToColorses();
			Iterator<MobilePhoneToDisplayTypes> iterator = set.iterator();
			List<MobileDisplayTypes> mobileDisplayTypes = new ArrayList<>();
			while(iterator.hasNext()){
				mobileDisplayTypes.add(((MobilePhoneToDisplayTypes)iterator.next()).getMobileDisplayTypes());
			}
			return mobileDisplayTypes;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileFeatures> getMobileFeatures(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToFeatures> set =  (Set<MobilePhoneToFeatures>) phone.getMobilePhoneToColorses();
			Iterator<MobilePhoneToFeatures> iterator = set.iterator();
			List<MobileFeatures> mobileFeatures = new ArrayList<>();
			while(iterator.hasNext()){
				mobileFeatures.add(((MobilePhoneToFeatures)iterator.next()).getMobileFeatures());
			}
			return mobileFeatures;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile Browser");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileGames> getMobileGames(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToGames> set =  (Set<MobilePhoneToGames>) phone.getMobilePhoneToGameses();
			Iterator<MobilePhoneToGames> iterator = set.iterator();
			List<MobileGames> mobileGames = new ArrayList<>();
			while(iterator.hasNext()){
				mobileGames.add(((MobilePhoneToGames)iterator.next()).getMobileGames());
			}
			return mobileGames;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile games");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileJava> getMobileJavas(MobilePhones phone, Session session,long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToJava> set =  (Set<MobilePhoneToJava>) phone.getMobilePhoneToGameses();
			Iterator<MobilePhoneToJava> iterator = set.iterator();
			List<MobileJava> mobileGames = new ArrayList<>();
			while(iterator.hasNext()){
				mobileGames.add(((MobilePhoneToJava)iterator.next()).getMobileJava());
			}
			return mobileGames;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile games");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileMemory> getMobileMemories(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToMemory> set =  (Set<MobilePhoneToMemory>) phone.getMobilePhoneToMemories();
			Iterator<MobilePhoneToMemory> iterator = set.iterator();
			List<MobileMemory> mobileMemories = new ArrayList<>();
			while(iterator.hasNext()){
				mobileMemories.add(((MobilePhoneToMemory)iterator.next()).getMobileMemory());
			}
			return mobileMemories;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile games");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileMemoryCardslots> getMobileMemoryCardslots(MobilePhones phone, Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToMemoryCardslots> set =  (Set<MobilePhoneToMemoryCardslots>) phone.getMobilePhoneToMemoryCardslotses();
			Iterator<MobilePhoneToMemoryCardslots> iterator = set.iterator();
			List<MobileMemoryCardslots> mobileMemoryCardslots = new ArrayList<>();
			while(iterator.hasNext()){
				mobileMemoryCardslots.add(((MobilePhoneToMemoryCardslots)iterator.next()).getMobileMemoryCardslots());
			}
			return mobileMemoryCardslots;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile games");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileMessaging> getMobileMessagings(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToMessaging> set =  (Set<MobilePhoneToMessaging>) phone.getMobilePhoneToMessagings();
			Iterator<MobilePhoneToMessaging> iterator = set.iterator();
			List<MobileMessaging> mobileMessagings = new ArrayList<>();
			while(iterator.hasNext()){
				mobileMessagings.add(((MobilePhoneToMessaging)iterator.next()).getMobileMessaging());
			}
			return mobileMessagings;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile games");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileNetworks> getMobileNetworks(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToNetworks> set =  (Set<MobilePhoneToNetworks>) phone.getMobilePhoneToNetworkses();
			Iterator<MobilePhoneToNetworks> iterator = set.iterator();
			List<MobileNetworks> mobileNetworks = new ArrayList<>();
			while(iterator.hasNext()){
				mobileNetworks.add(((MobilePhoneToNetworks)iterator.next()).getMobileNetworks());
			}
			return mobileNetworks;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileNfc> getMobileNfcs(MobilePhones phone, Session session,long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToNfc> set =  (Set<MobilePhoneToNfc>) phone.getMobilePhoneToNfcs();
			Iterator<MobilePhoneToNfc> iterator = set.iterator();
			List<MobileNfc> mobileNfcs= new ArrayList<>();
			while(iterator.hasNext()){
				mobileNfcs.add(((MobilePhoneToNfc)iterator.next()).getMobileNfc());
			}
			return mobileNfcs;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileDisplayProtection> getDisplayProtections(MobilePhones phone, Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToProtections> set =  (Set<MobilePhoneToProtections>) phone.getMobilePhoneToProtectionses();
			Iterator<MobilePhoneToProtections> iterator = set.iterator();
			List<MobileDisplayProtection> mobileDisplayProtections= new ArrayList<>();
			while(iterator.hasNext()){
				mobileDisplayProtections.add(((MobilePhoneToProtections)iterator.next()).getMobileDisplayProtection());
			}
			return mobileDisplayProtections;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileRadio> getMobileRadios(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToRadio> set =  (Set<MobilePhoneToRadio>) phone.getMobilePhoneToRadios();
			Iterator<MobilePhoneToRadio> iterator = set.iterator();
			List<MobileRadio> mobileRadios= new ArrayList<>();
			while(iterator.hasNext()){
				mobileRadios.add(((MobilePhoneToRadio)iterator.next()).getMobileRadio());
			}
			return mobileRadios;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileSensors> getMobileSensors(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToSensors> set =  (Set<MobilePhoneToSensors>) phone.getMobilePhoneToSensorses();
			Iterator<MobilePhoneToSensors> iterator = set.iterator();
			List<MobileSensors> mobileSensors = new ArrayList<>();
			while(iterator.hasNext()){
				mobileSensors.add(((MobilePhoneToSensors)iterator.next()).getMobileSensors());
			}
			return mobileSensors;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobileSoundFeatures> getMobileSoundFeatures(MobilePhones phone,Session session, long phoneId) throws Exception {
		try{
			phone = ((MobilePhones)session.get(MobilePhones.class, new Long(phoneId)));
			Set<MobilePhoneToSoundFeatures> set =  (Set<MobilePhoneToSoundFeatures>) phone.getMobilePhoneToSoundFeatureses();
			Iterator<MobilePhoneToSoundFeatures> iterator = set.iterator();
			List<MobileSoundFeatures> mobileSoundFeatures = new ArrayList<>();
			while(iterator.hasNext()){
				mobileSoundFeatures.add(((MobilePhoneToSoundFeatures)iterator.next()).getMobileSoundFeatures());
			}
			return mobileSoundFeatures;
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public List<MobileBrands> getMobileAllBrands(MobileBrands brands,Session session) throws Exception {
		try{
			return session.createCriteria(MobileBrands.class).list();
			
		}catch(Exception ex){
			LGR.info("#DAOException# some error occured while getting mobile networks");
			throw new Exception(ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MobilePhones> getAllMobilePhoneByBrands(MobilePhones phones ,Session session, long brandId,int limit) throws Exception{
		try{
			Criteria criteria = session.createCriteria(MobilePhones.class).setMaxResults(limit);
			List<MobilePhones> moiblePhones = criteria.add(Restrictions.eq("brandId", brandId)).list();
			return moiblePhones;
		}catch(Exception e){
			LGR.info("#DAOException# some error occured while getting all mobile phone by brandId");
			throw new Exception(e);
		}
	}
	
	
	public  BigInteger getMobilePhonesCount(MobilePhones phones ,Session session ,long brandId,int limit) throws Exception{
		try{
			BigInteger count = (BigInteger) session.createSQLQuery("select count(*) as count from mobile_phones where brand_id = "+brandId).list().get(0);
			return count;
		}catch(Exception e){
			LGR.info("#DAOException# some error occured while getting all mobile phone count");
			throw new Exception(e);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MobilePhoneReviews> getMobilePhoneReviews(MobilePhones phones,Session session, long id)throws Exception {
		try{
			List<MobilePhoneReviews> mobilePhoneReviews = session.createSQLQuery("select * from mobile_phones_reviews " +
					"where phone_id = "+id +" order by created_at desc").addEntity(MobilePhoneReviews.class).list();
			return mobilePhoneReviews;
		}catch(Exception e){
			LGR.info("#DAOException# some error occured while getting mobile phone reviews");
			throw new Exception(e);
		}
	}
	

}

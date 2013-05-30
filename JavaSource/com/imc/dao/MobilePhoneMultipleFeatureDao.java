package com.imc.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;

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
import com.imc.framework.bean.MobilePhones;
import com.imc.framework.bean.MobileRadio;
import com.imc.framework.bean.MobileSensors;
import com.imc.framework.bean.MobileSoundFeatures;

public interface MobilePhoneMultipleFeatureDao{
	public List<MobileAlertTypes> getMobileAlertTypes(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public List<MobileBrowsers> getMobileBrowsers(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public List<MobileCameraFeatures> getCameraFeatures(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public List<MobileCameraPrimary> getCameraPrimaries(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileCameraSecondary> getCameraSecondaries(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileCameraVideo> getCameraVideos(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileColors> getMobileColors(MobilePhones phone,Session session,long phoneId) throws Exception;
		
	public  List<MobileDataSpeeds> getMobileDataSpeeds(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileDisplayTypes> getDisplayTypes(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileFeatures> getMobileFeatures(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileGames> getMobileGames(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileJava> getMobileJavas(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileMemory> getMobileMemories(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileMemoryCardslots> getMobileMemoryCardslots(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileMessaging> getMobileMessagings(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileNetworks> getMobileNetworks(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileNfc> getMobileNfcs(MobilePhones phone,Session session,long phoneIds) throws Exception;
	
	public  List<MobileDisplayProtection> getDisplayProtections(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileRadio> getMobileRadios(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileSensors> getMobileSensors(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public  List<MobileSoundFeatures> getMobileSoundFeatures(MobilePhones phone,Session session,long phoneId) throws Exception;
	
	public List<MobileBrands> getMobileAllBrands(MobileBrands brands,Session session) throws Exception;
	
	public List<MobilePhones> getAllMobilePhoneByBrands(MobilePhones phones ,Session session, long brandId,int limit) throws Exception;
	
	public  BigInteger getMobilePhonesCount(MobilePhones phones ,Session session ,long brandId,int limit) throws Exception;
	
	public List<MobilePhoneReviews> getMobilePhoneReviews(MobilePhones phones,Session session,long id) throws Exception;
}

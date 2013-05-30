package com.imc.cron;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.imc.framework.bean.MobileAlertTypes;
import com.imc.framework.bean.MobileBluetooth;
import com.imc.framework.bean.MobileBrands;
import com.imc.framework.bean.MobileBrowsers;
import com.imc.framework.bean.MobileCameraFeatures;
import com.imc.framework.bean.MobileCameraPrimary;
import com.imc.framework.bean.MobileCameraSecondary;
import com.imc.framework.bean.MobileCameraVideo;
import com.imc.framework.bean.MobileChipsets;
import com.imc.framework.bean.MobileColors;
import com.imc.framework.bean.MobileCpu;
import com.imc.framework.bean.MobileDataSpeeds;
import com.imc.framework.bean.MobileDisplayProtection;
import com.imc.framework.bean.MobileDisplayTypes;
import com.imc.framework.bean.MobileEdge;
import com.imc.framework.bean.MobileFeatures;
import com.imc.framework.bean.MobileGames;
import com.imc.framework.bean.MobileGprs;
import com.imc.framework.bean.MobileGpu;
import com.imc.framework.bean.MobileJava;
import com.imc.framework.bean.MobileMemory;
import com.imc.framework.bean.MobileMemoryCardslots;
import com.imc.framework.bean.MobileMessaging;
import com.imc.framework.bean.MobileNetworks;
import com.imc.framework.bean.MobileNfc;
import com.imc.framework.bean.MobileOs;
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
import com.imc.framework.bean.MobilePhones;
import com.imc.framework.bean.MobileRadio;
import com.imc.framework.bean.MobileSensors;
import com.imc.framework.bean.MobileSimTypes;
import com.imc.framework.bean.MobileUsb;
import com.imc.framework.bean.MobileWlan;
import com.imc.framework.helper.Constants;
import com.imc.service.MobileService;
import com.imc.utils.DateUtils;

public class Scrap {
	private String pageHtml = "";
	private Document pageSoup;
	private String heading;
	private MobilePhones phones;
	private String gsmernaId; 
	private String brand = "";
	
	public Scrap(){
	}
	public void fetchPageHtml(String url) throws Exception{
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet  = new HttpGet(url);
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity httpEntity  = response.getEntity();
		if(httpClient != null){
			InputStream iStream = httpEntity.getContent();
			String encoding = "UTF-8";
			StringWriter stringWriter = new StringWriter();
			IOUtils.copy(iStream, stringWriter, encoding);
			pageHtml = stringWriter.toString();
		}
		if(!pageHtml.equalsIgnoreCase("")){
			fetchPageSoup(pageHtml);
		}
		String number = url.split("-")[1];
		gsmernaId = number.substring(0, number.length()-4);
		
		phones =  (MobilePhones) MobileService.getIdByNameValue(MobilePhones.class, "gsmarenaId", Long.parseLong(gsmernaId),false);
		if(phones == null){
			phones = new MobilePhones();
			phones.setGsmarenaId(Long.parseLong(gsmernaId));
			
		}
		
		
	}
	
	 public void fetchPageSoup(String pageHtml) throws Exception{
         pageSoup = Jsoup.parse(pageHtml);
     }
	 
	 public void getHeading() throws Exception{
		 try{
			 Elements elements = pageSoup.getElementsByTag("h1");
			 heading = elements.toString().replaceAll("\\<.*?>","");
			 phones.setTitle(heading);
			 
			 if(heading.contains("Sony Ericsson")){
				 brand = "sony_ericsson";
			 }
			 else if(heading.contains("T-Mobile")){
				 brand = "t_mobile";
			 }
			 else{
				 brand = heading.split(" ")[0];
			 }
			  
			 MobileBrands mobileBrands = (MobileBrands) MobileService.getId(MobileBrands.class,brand.toLowerCase());
			 if(mobileBrands != null){
				 phones.setBrandId(mobileBrands.getId());
				 phones.setSlug(heading.replace(" " ,"-").toLowerCase() +"-"+ phones.getGsmarenaId());
			 }
		 }catch(Exception e){
			 System.out.println("get heading");
		 }
		 
	 }
	 
	
	public void getBrands() throws Exception{
		try{
		 Elements elements = pageSoup.getElementById("brandmenu").children();
		 ListIterator<Element> listBrands = elements.iterator().next().getElementsByTag("a").listIterator();
		 while(listBrands.hasNext()){
			 String[] brands = listBrands.next().attr("href").split("-");
			 MobileBrands mobileBrands = (MobileBrands) MobileService.getId(MobileBrands.class,brands[0]);
			 if(mobileBrands == null){
				 mobileBrands = new MobileBrands();
				 mobileBrands.setTitle(brands[0]);
				 mobileBrands.setSlug(brands[0] + "-" + brands[1] + "-");
				 mobileBrands.setIsActive('Y');
				 mobileBrands.setIsDeleted('N');
			 }
			 MobileService.persistObject("MobileBrands", mobileBrands);
		 }
		}catch(Exception e){
			System.out.println("get brands");
		}
		 		 
	 }
	
	 public void downloadImage() throws Exception{
		 try{
		 Elements elements = pageSoup.getElementById("specs-cp-pic").children();
		 String imageUrl = elements.iterator().next().getElementsByTag("img").attr("src");
		 saveImages(new URL(imageUrl),imageUrl);
		 }catch(Exception e){
			 System.out.println("download images");
		 }
		 
	 }
	 
	 public int saveImages(URL url,String imageUrl) throws Exception{
		 try{
			 File file  = new File(Constants.CONTEXT_PATH + "images" + File.separator + brand);
			 if(!file.exists()){
				 file.mkdirs();
			 }
			 String[] endUrl = imageUrl.split("/"); 
			 imageUrl = endUrl[endUrl.length - 1];
			 String photoUrl = File.separator + brand + File.separator + imageUrl;
			 phones.setPhotoUrl(photoUrl);
			
			 System.out.println("Absolute path  :" + file.getAbsolutePath());
			 File image  = new File(Constants.CONTEXT_PATH + "images" + File.separator + brand + File.separator + imageUrl); if (image.exists()) return 0;
			 InputStream inputStream = url.openStream();
			 OutputStream outputStream = new FileOutputStream(image);
			 
			 byte buffer[] = new byte[2048];
			 int length = 0;
			 while((length = inputStream.read(buffer)) != -1){
				 outputStream.write(buffer, 0, length);
			 } 
			 inputStream.close();
			 outputStream.close();
		 }catch(Exception e){
			
			 return -1;
		 }
		 return 1;
	 }
	 
	 public void parseData() throws Exception{
		 try{
		 Set<MobilePhoneToNetworks> setMobileToNetwork = new HashSet<>();
		 Set<MobilePhoneToAlertTypes> setMobileToAlertTypes = new HashSet<>();
		 Set<MobilePhoneToDisplayTypes> setMobileToDisplay = new HashSet<>();
		 Set<MobilePhoneToProtections> setMobileToProtection = new HashSet<>();
		 Set<MobilePhoneToMemoryCardslots> setMobileToMemoryCardSlots = new HashSet<>();
		 Set<MobilePhoneToMemory> setMobileToMemory = new HashSet<>();
		 Set<MobilePhoneToDataSpeeds> setMobileToDataSpeed = new HashSet<>();
		 Set<MobilePhoneToNfc> setMobileToNfc = new HashSet<>();
		 Set<MobilePhoneToCameraPrimary> setMobileToCameraPrimaries = new HashSet<>();
		 Set<MobilePhoneToFeatures> setMobileToFeatures = new HashSet<>();
		 Set<MobilePhoneToCameraVideo> setMobileToCameraVideos = new HashSet<>();
		 Set<MobilePhoneToCameraSecondary> setMobileToCameraSecondaries = new HashSet<>();
		 Set<MobilePhoneToSensors> setMobileToSensors = new HashSet<>();
		 Set<MobilePhoneToMessaging> setMobileToMessagings = new HashSet<>();
		 Set<MobilePhoneToBrowsers> setMobilePhoneToBrowsers = new HashSet<>();
		 Set<MobilePhoneToRadio> setMobilePhoneToRadios = new HashSet<>();
		 Set<MobilePhoneToGames> setMobilePhoneToGames = new HashSet<>();
		 Set<MobilePhoneToJava> setMobilePhoneToJavas = new HashSet<>();
		 Set<MobilePhoneToColors> setMobilePhoneToColors = new HashSet<>();
		 Set<MobilePhoneToCameraFeatures> setMobilePhoneToCameraFeatures = new HashSet<>();
		 
		 Elements elements = pageSoup.getElementById("specs-list").children();//tables
			ListIterator<Element> tableIterator = elements.listIterator();
			while(tableIterator.hasNext()){
					Elements childElements = tableIterator.next().children();
					ListIterator<Element> tbodayIterator = childElements.listIterator();
					while(tbodayIterator.hasNext()){
						Elements trElements = tbodayIterator.next().children();
						Iterator<Element> innerTr = trElements.iterator();
						while(innerTr.hasNext()){
							Element element = innerTr.next();
							
							
							List<Node> nodes = element.childNodes();
							String ttl = null,nfo = null;
							for(Node node : nodes){
								if(!node.nodeName().equalsIgnoreCase("#text")){
										
											if(node.nodeName().equalsIgnoreCase("th")){
												String value = node.toString().replaceAll("\\<.*?>","");
												System.out.println("------------------");
												System.out.println(value);
												System.out.println("------------------");
											}
											if(node.nodeName().equalsIgnoreCase("td")){
												StringTokenizer tokenizer = new StringTokenizer(node.toString(), "\"");
												tokenizer.nextToken();
												String ttlStr = tokenizer.nextToken();
												
												if(ttlStr.equalsIgnoreCase("ttl")){
													ttl = node.toString().replaceAll("\\<.*?>","");
													System.out.print(ttl);
												}
												if(ttlStr.equalsIgnoreCase("nfo")){
													nfo = node.toString().replaceAll("\\<.*?>","");
													System.out.println(":" + nfo);
												}
												
												if(((ttl.equalsIgnoreCase("2G Network")) || (ttl.equalsIgnoreCase("3G Network")
														) || (ttl.equalsIgnoreCase("4G Network"))) && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_networks", "phone_id", String.valueOf(phones.getId()));
															MobileNetworks mobileNetworks =  (MobileNetworks) MobileService.getId(MobileNetworks.class, nfo);
															if(mobileNetworks == null){
																mobileNetworks = new MobileNetworks();
																mobileNetworks.setTitle(nfo);
																mobileNetworks.setType(ttl.split(" ")[0]);
																mobileNetworks.setIsActive('Y');
																mobileNetworks.setIsDeleted('N');
															}
															
															MobilePhoneToNetworks phoneToNetworks = new MobilePhoneToNetworks();
															phoneToNetworks.setMobileNetworks(mobileNetworks);
															phoneToNetworks.setMobilePhones(phones);
															setMobileToNetwork.add(phoneToNetworks);
														}
													}catch(Exception e){
														System.out.println("network error");
													}
												}
												
												if(ttl.equalsIgnoreCase("Alert types") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_alert_types", "phone_id", String.valueOf(phones.getId()));
															String[] alerts = nfo.split(",");
															for(String alert : alerts){
																MobilePhoneToAlertTypes phoneToAlertType = new MobilePhoneToAlertTypes();
																MobileAlertTypes alertTypes =  (MobileAlertTypes) MobileService.getId(MobileAlertTypes.class, alert);
																if(alertTypes == null){
																	alertTypes = new MobileAlertTypes();
																	alertTypes.setTitle(alert);
																	alertTypes.setIsActive('Y');
																	alertTypes.setIsDeleted('N');
																	
																	
																}
																phoneToAlertType.setMobileAlertTypes(alertTypes);
																phoneToAlertType.setMobilePhones(phones);
																setMobileToAlertTypes.add(phoneToAlertType);
															
															}
														}
													}catch(Exception e){
														System.out.println("Alerts Type error");
													}
												}
												
												if(ttl.equalsIgnoreCase("Phonebook") && ttl != null){
													if(nfo != null){
														phones.setPhonebook(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("Call records") && ttl != null){
													if(nfo != null){
														phones.setCallRecords(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("SIM") && ttl != null){
													try{
														if(nfo != null){
															MobileSimTypes simTypes = (MobileSimTypes) MobileService.getId(MobileSimTypes.class, nfo);
															if(simTypes == null){
																simTypes = new MobileSimTypes();
																simTypes.setTitle(nfo);
																simTypes.setIsActive('Y');
																simTypes.setIsDeleted('N');
															}
															
															phones.setSimTypeId(simTypes.getId());
															MobileService.persistObject("MobileSimTypes", simTypes);
														}
													}catch(Exception e){
														System.out.println("Sim error");
													}
												}
												if(ttl.equalsIgnoreCase("Announced") && ttl!= null){
													if(nfo != null){
														phones.setAnnouncementDate(DateUtils.parseDateFromSTring(nfo));
														System.out.println(nfo);
														
													}
												}
												if(ttl.equalsIgnoreCase("Status") && ttl!= null){
													if(nfo != null){
														//phones.setReleaseDate(DateUtils.parseDateFromSTring(nfo));
														System.out.println(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("Dimensions") && ttl!= null){
													if(nfo != null){
														phones.setDimensions(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("Weight") && ttl!= null){
													if(nfo != null){
														phones.setWeight(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("Type") && ttl!= null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_display_types", "phone_id", String.valueOf(phones.getId()));
															String[] types = nfo.split(",");
															for(String type : types){
																MobileDisplayTypes displayType =  (MobileDisplayTypes) MobileService.getId(MobileDisplayTypes.class, type);
																if(displayType == null){
																	displayType = new MobileDisplayTypes();
																	displayType.setTitle(type);
																	displayType.setIsActive('Y');
																	displayType.setIsDeleted('N');
																}
																
																MobilePhoneToDisplayTypes phoneToDisplayType = new MobilePhoneToDisplayTypes();
																phoneToDisplayType.setMobileDisplayTypes(displayType);
																phoneToDisplayType.setMobilePhones(phones);
																setMobileToDisplay.add(phoneToDisplayType);
															}
															
														}
													}catch(Exception e){
														System.out.println("Type error");
													}
												}
												
												if(ttl.equalsIgnoreCase("Protection") && ttl!= null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_protections", "phone_id", String.valueOf(phones.getId()));
															String[] protections = nfo.split(",");
															for(String protection : protections){
																MobileDisplayProtection displayProtection =  (MobileDisplayProtection) MobileService.getId(MobileDisplayProtection.class, protection);
																if(displayProtection == null){
																	displayProtection = new MobileDisplayProtection();
																	displayProtection.setTitle(protection);
																	displayProtection.setIsActive('Y');
																	displayProtection.setIsDeleted('N');
																}
																MobilePhoneToProtections phoneToProtections = new MobilePhoneToProtections();
																phoneToProtections.setMobileDisplayProtection(displayProtection);
																phoneToProtections.setMobilePhones(phones);
																setMobileToProtection.add(phoneToProtections);
															}
														}
													}catch(Exception e){
														System.out.println("Protection error");
													}
													
												}
												if(ttl.equalsIgnoreCase("Size") && ttl != null){
													if(nfo != null){
														phones.setDisplaySize(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("Multitouch") && ttl != null){
													if(nfo != null){
														phones.setDisplayMultitouch(nfo.equalsIgnoreCase("Yes") ? 'Y' :'N');
													}
												}
												if(ttl.equalsIgnoreCase("Loudspeaker") && ttl != null){
													if(nfo != null){
														phones.setSoundLoudspeaker(nfo.equalsIgnoreCase("Yes") ? 'Y' :'N');
													}
												}
												if(ttl.equalsIgnoreCase("3.5mm jack") && ttl != null){
													if(nfo != null){
														phones.setSound35mmjack(nfo.equalsIgnoreCase("Yes") ? 'Y' :'N');
													}
												}
												
												if(ttl.equalsIgnoreCase("Card slot") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_memory_cardslots", "phone_id", String.valueOf(phones.getId()));
															String[] cardslots = nfo.split(",");
															for(String cardslot : cardslots){
																MobileMemoryCardslots cardSlots = (MobileMemoryCardslots) MobileService.getId(MobileMemoryCardslots.class, cardslot);
																if(cardSlots == null){
																	cardSlots = new MobileMemoryCardslots();
																	cardSlots.setTitle(cardslot);
																	cardSlots.setIsActive('Y');
																	cardSlots.setIsDeleted('N');
																}
																
																MobilePhoneToMemoryCardslots phoneToMemoryCardSlots = new MobilePhoneToMemoryCardslots();
																phoneToMemoryCardSlots.setMobileMemoryCardslots(cardSlots);
																phoneToMemoryCardSlots.setMobilePhones(phones);
																setMobileToMemoryCardSlots.add(phoneToMemoryCardSlots);
															}
															
															
														}
													}catch(Exception e){
														System.out.println("Card slot error");
													}
												}
												
												if(ttl.equalsIgnoreCase("Internal") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_memory", "phone_id", String.valueOf(phones.getId()));
															String[] internalMemory = nfo.split(",");
															for(String iMemory : internalMemory){
																MobileMemory mobileMemory = (MobileMemory) MobileService.getId(MobileMemory.class, iMemory);
																if(mobileMemory == null){
																	mobileMemory = new MobileMemory();
																	mobileMemory.setTitle(iMemory);
																	mobileMemory = new MobileMemory();
																}
																mobileMemory.setIsActive('Y');
																mobileMemory.setIsDeleted('N');
																MobilePhoneToMemory phoneToMemory = new MobilePhoneToMemory();
																phoneToMemory.setMobileMemory(mobileMemory);
																phoneToMemory.setMobilePhones(phones);
																setMobileToMemory.add(phoneToMemory);
															}
															
															
														}
													}catch(Exception e){
														System.out.println("Internal error");
													}
												}
												if(ttl.equalsIgnoreCase("GPRS") && ttl != null){
													if(nfo != null){
														MobileGprs mobileGprs=  (MobileGprs) MobileService.getId(MobileGprs.class, nfo);
														if(mobileGprs == null){
															mobileGprs = new MobileGprs();
															mobileGprs.setTitle(nfo);
															mobileGprs.setIsActive('Y');
															mobileGprs.setIsDeleted('N');
														}
														phones.setMobileGprs(mobileGprs);
													}
												}
												if(ttl.equalsIgnoreCase("EDGE") && ttl != null){
													if(nfo != null){
														MobileEdge mobileEdge=  (MobileEdge) MobileService.getId(MobileEdge.class, nfo);
														if(mobileEdge == null){
															mobileEdge = new MobileEdge();
															mobileEdge.setTitle(nfo);
															mobileEdge.setIsActive('Y');
															mobileEdge.setIsDeleted('N');
														}
														phones.setMobileEdge(mobileEdge);
													}
												}
												if(ttl.equalsIgnoreCase("Speed") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_data_speeds", "phone_id", String.valueOf(phones.getId()));
															String[] speeds = nfo.split(";");
															for(String speed : speeds){
																MobileDataSpeeds mobileDataSpeeds =  (MobileDataSpeeds) MobileService.getId(MobileDataSpeeds.class, speed);
																if(mobileDataSpeeds == null){
																	mobileDataSpeeds = new MobileDataSpeeds();
																	mobileDataSpeeds.setTitle(speed);
																	mobileDataSpeeds.setIsActive('Y');
																	mobileDataSpeeds.setIsDeleted('N');
																}
																MobilePhoneToDataSpeeds phoneToMemoryDataSpeeds = new MobilePhoneToDataSpeeds();
																phoneToMemoryDataSpeeds.setMobileDataSpeeds(mobileDataSpeeds);
																phoneToMemoryDataSpeeds.setMobilePhones(phones);
																setMobileToDataSpeed.add(phoneToMemoryDataSpeeds);
															}
															
														
														}
													}catch(Exception e){
														System.out.println("Speed error");
													}
												}
												
												if(ttl.equalsIgnoreCase("WLAN") && ttl != null){
													if(nfo != null){
														MobileWlan mobileWlan =  (MobileWlan) MobileService.getId(MobileWlan.class, nfo);
														if(mobileWlan == null){
															mobileWlan = new MobileWlan();
															mobileWlan.setTitle(nfo);
															mobileWlan.setIsActive('Y');
															mobileWlan.setIsDeleted('N');
														}
														phones.setMobileWlan(mobileWlan);
													}
												}
												if(ttl.equalsIgnoreCase("Bluetooth") && ttl != null){
													if(nfo != null){
														MobileBluetooth mobileBluetooth =  (MobileBluetooth) MobileService.getId(MobileBluetooth.class, nfo);
														if(mobileBluetooth == null){
															mobileBluetooth = new MobileBluetooth();
															mobileBluetooth.setTitle(nfo);
															mobileBluetooth.setIsActive('Y');
															mobileBluetooth.setIsDeleted('N');
														}
														phones.setMobileBluetooth(mobileBluetooth);
													}
												}
												if(ttl.equalsIgnoreCase("NFC") && ttl != null){
													if(nfo != null){
														MobileService.deleteObject("mobile_phone_to_nfc", "phone_id", String.valueOf(phones.getId()));
														MobileNfc mobileNfc =  (MobileNfc) MobileService.getId(MobileNfc.class, nfo);
														if(mobileNfc == null){
															mobileNfc = new MobileNfc();
															mobileNfc.setTitle(nfo);
															mobileNfc.setIsActive('Y');
															mobileNfc.setIsDeleted('N');
														}
														MobilePhoneToNfc phoneToNfc = new MobilePhoneToNfc();
														phoneToNfc.setMobileNfc(mobileNfc);
														phoneToNfc.setMobilePhones(phones);
														setMobileToNfc.add(phoneToNfc);
													}
												}
												if(ttl.equalsIgnoreCase("USB") && ttl != null){
													if(nfo != null){
														MobileUsb mobileUsb =  (MobileUsb) MobileService.getId(MobileUsb.class, nfo);
														if(mobileUsb == null){
															mobileUsb = new MobileUsb();
															mobileUsb.setTitle(nfo);
															mobileUsb.setIsActive('Y');
															mobileUsb.setIsDeleted('N');
														}
														phones.setMobileUsb(mobileUsb);
													}
												}
												
												if(ttl.equalsIgnoreCase("Primary") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_camera_primary", "phone_id", String.valueOf(phones.getId()));
															String[] primaries = nfo.split(",");
															for(String primary : primaries){
																MobileCameraPrimary mobileCameraPrimary =  (MobileCameraPrimary) MobileService.getId(MobileCameraPrimary.class, primary);
																if(mobileCameraPrimary == null){
																	mobileCameraPrimary = new MobileCameraPrimary();
																	mobileCameraPrimary.setTitle(primary);
																	mobileCameraPrimary.setIsActive('Y');
																	mobileCameraPrimary.setIsDeleted('N');
																}
																MobilePhoneToCameraPrimary phoneToCameraPrimary = new MobilePhoneToCameraPrimary();
																phoneToCameraPrimary.setMobileCameraPrimary(mobileCameraPrimary);
																phoneToCameraPrimary.setMobilePhones(phones);
																setMobileToCameraPrimaries.add(phoneToCameraPrimary);
															}
															
														}
													}catch(Exception e){
														System.out.println("Primary error");
													}
												}
												if(ttl.equalsIgnoreCase("Features") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_camera_features", "phone_id", String.valueOf(phones.getId()));
															String[] features = nfo.split(",");
															for(String feature : features){
																MobileCameraFeatures mobileCameraFeatures =  (MobileCameraFeatures) MobileService.getId(MobileCameraFeatures.class, feature);
																if(mobileCameraFeatures == null){
																	mobileCameraFeatures = new MobileCameraFeatures();
																	mobileCameraFeatures.setTitle(feature);
																	mobileCameraFeatures.setIsActive('Y');
																	mobileCameraFeatures.setIsDeleted('N');
																}
																MobilePhoneToCameraFeatures phoneToCameraFeatures = new MobilePhoneToCameraFeatures();
																phoneToCameraFeatures.setMobileCameraFeatures(mobileCameraFeatures);
																phoneToCameraFeatures.setMobilePhones(phones);
																setMobilePhoneToCameraFeatures.add(phoneToCameraFeatures);
															}
															
														}
													}catch(Exception e){
														System.out.println("Features error");
													}
												}
												if(ttl.equalsIgnoreCase("Video") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_camera_video", "phone_id", String.valueOf(phones.getId()));
															String[] videos = nfo.split(",");
															for(String video : videos){
																MobileCameraVideo mobileCameraVideo =  (MobileCameraVideo) MobileService.getId(MobileCameraVideo.class, video);
																if(mobileCameraVideo == null){
																	mobileCameraVideo = new MobileCameraVideo();
																	mobileCameraVideo.setTitle(video);
																	mobileCameraVideo.setIsActive('Y');
																	mobileCameraVideo.setIsDeleted('N');
																}
																MobilePhoneToCameraVideo phoneToCameraVideo = new MobilePhoneToCameraVideo();
																phoneToCameraVideo.setMobileCameraVideo(mobileCameraVideo);
																phoneToCameraVideo.setMobilePhones(phones);
																setMobileToCameraVideos.add(phoneToCameraVideo);
															}
															
														}
													}catch(Exception e){
														System.out.println("Video error");
													}
												}
												if(ttl.equalsIgnoreCase("Secondary") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_camera_secondary", "phone_id", String.valueOf(phones.getId()));
															String[] secondories = nfo.split(",");
															for(String secondory : secondories){
																MobileCameraSecondary mobileCameraSecondary =  (MobileCameraSecondary) MobileService.getId(MobileCameraSecondary.class, secondory);
																if(mobileCameraSecondary == null){
																	mobileCameraSecondary = new MobileCameraSecondary();
																	mobileCameraSecondary.setTitle(secondory);
																	mobileCameraSecondary.setIsActive('Y');
																	mobileCameraSecondary.setIsDeleted('N');
																}
																MobilePhoneToCameraSecondary phoneToCameraSecondary = new MobilePhoneToCameraSecondary();
																phoneToCameraSecondary.setMobileCameraSecondary(mobileCameraSecondary);
																phoneToCameraSecondary.setMobilePhones(phones);
																setMobileToCameraSecondaries.add(phoneToCameraSecondary);
															}
															
														}
													}catch(Exception e){
														System.out.println("Secondry error");
													}
												}
												if(ttl.equalsIgnoreCase("OS") && ttl != null){
													if(nfo != null){
														MobileOs mobileOs =  (MobileOs) MobileService.getId(MobileOs.class, nfo);
														if(mobileOs == null){
															mobileOs = new MobileOs();
															mobileOs.setTitle(nfo);
															mobileOs.setIsActive('Y');
															mobileOs.setIsDeleted('N');
														}
														phones.setMobileOs(mobileOs);
													}
												}
												if(ttl.equalsIgnoreCase("Chipset") && ttl != null){
													if(nfo != null){
														MobileChipsets mobileChipsets =  (MobileChipsets) MobileService.getId(MobileChipsets.class, nfo);
														if(mobileChipsets == null){
															mobileChipsets = new MobileChipsets();
															mobileChipsets.setTitle(nfo);
															mobileChipsets.setIsActive('Y');
															mobileChipsets.setIsDeleted('N');
														}
														phones.setMobileChipsets(mobileChipsets);
													}
												}
												if(ttl.equalsIgnoreCase("CPU") && ttl != null){
													if(nfo != null){
														MobileCpu mobileCpu =  (MobileCpu) MobileService.getId(MobileCpu.class, nfo);
														if(mobileCpu == null){
															mobileCpu = new MobileCpu();
															mobileCpu.setTitle(nfo);
															mobileCpu.setIsActive('Y');
															mobileCpu.setIsDeleted('N');
														}
														phones.setMobileCpu(mobileCpu);
													}
												}
												if(ttl.equalsIgnoreCase("GPU") && ttl != null){
													if(nfo != null){
														MobileGpu mobileGpu =  (MobileGpu) MobileService.getId(MobileGpu.class, nfo);
														if(mobileGpu == null){
															mobileGpu = new MobileGpu();
															mobileGpu.setTitle(nfo);
															mobileGpu.setIsActive('Y');
															mobileGpu.setIsDeleted('N');
														}
														phones.setMobileGpu(mobileGpu);
													}
												}
												if(ttl.equalsIgnoreCase("Sensors") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_sensors", "phone_id", String.valueOf(phones.getId()));
															String[] sensors = nfo.split(",");
															for(String sensor : sensors){
																MobileSensors mobileSensors =  (MobileSensors) MobileService.getId(MobileSensors.class, sensor);
																if(mobileSensors == null){
																	mobileSensors = new MobileSensors();
																	mobileSensors.setTitle(sensor);
																	mobileSensors.setIsActive('Y');
																	mobileSensors.setIsDeleted('N');
																}
																MobilePhoneToSensors phoneToSensors = new MobilePhoneToSensors();
																phoneToSensors.setMobileSensors(mobileSensors);
																phoneToSensors.setMobilePhones(phones);
																setMobileToSensors.add(phoneToSensors);
															}
															
														}
													}catch(Exception e){
														System.out.println("Sendor error");
													}
												}
												if(ttl.equalsIgnoreCase("Messaging") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_messaging", "phone_id", String.valueOf(phones.getId()));
															String[] messages = nfo.split(",");
															for(String message :messages ){
																MobileMessaging mobileMessaging =  (MobileMessaging) MobileService.getId(MobileMessaging.class, message);
																if(mobileMessaging == null){
																	mobileMessaging = new MobileMessaging();
																	mobileMessaging.setTitle(message);
																	mobileMessaging.setIsActive('Y');
																	mobileMessaging.setIsDeleted('N');
																}
																MobilePhoneToMessaging phoneToMessaging = new MobilePhoneToMessaging();
																phoneToMessaging.setMobileMessaging(mobileMessaging);
																phoneToMessaging.setMobilePhones(phones);
																setMobileToMessagings.add(phoneToMessaging);
															}
														}
													}catch(Exception e){
														System.out.println("Messaging error");
													}
												}
												
												if(ttl.equalsIgnoreCase("Browser") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_browsers", "phone_id", String.valueOf(phones.getId()));
															String[] browsers = nfo.split(",");
															for(String browser :browsers ){
																MobileBrowsers mobileBrowsers =  (MobileBrowsers) MobileService.getId(MobileBrowsers.class, browser);
																if(mobileBrowsers == null){
																	mobileBrowsers = new MobileBrowsers();
																	mobileBrowsers.setTitle(browser);
																	mobileBrowsers.setIsActive('Y');
																	mobileBrowsers.setIsDeleted('N');
																}
																MobilePhoneToBrowsers phoneToBrowsers = new MobilePhoneToBrowsers();
																phoneToBrowsers.setMobileBrowsers(mobileBrowsers);
																phoneToBrowsers.setMobilePhones(phones);
																setMobilePhoneToBrowsers.add(phoneToBrowsers);	
															}
															
														}
													}catch(Exception e){
														System.out.println("Browser error");
													}
												}
												if(ttl.equalsIgnoreCase("Radio") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_radio", "phone_id", String.valueOf(phones.getId()));
															String[] radios = nfo.split(",");
															for(String radio :radios ){
																MobileRadio mobileRadio =  (MobileRadio) MobileService.getId(MobileRadio.class, radio);
																if(mobileRadio == null){
																	mobileRadio = new MobileRadio();
																	mobileRadio.setTitle(radio);
																	mobileRadio.setIsActive('Y');
																	mobileRadio.setIsDeleted('N');
																}
																MobilePhoneToRadio phoneToRadio = new MobilePhoneToRadio();
																phoneToRadio.setMobileRadio(mobileRadio);
																phoneToRadio.setMobilePhones(phones);
																setMobilePhoneToRadios.add(phoneToRadio);	
															}
															
														}
													}catch(Exception e){
														System.out.println("Radio error");
													}
												}
												if(ttl.equalsIgnoreCase("Games") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_games", "phone_id", String.valueOf(phones.getId()));
															String[] games = nfo.split(",");
															for(String game :games ){
																MobileGames mobileGames =  (MobileGames) MobileService.getId(MobileGames.class, game);
																if(mobileGames == null){
																	mobileGames = new MobileGames();
																	mobileGames.setTitle(game);
																	mobileGames.setIsActive('Y');
																	mobileGames.setIsDeleted('N');
																}
																MobilePhoneToGames phoneToGames = new MobilePhoneToGames();
																phoneToGames.setMobileGames(mobileGames);
																phoneToGames.setMobilePhones(phones);
																setMobilePhoneToGames.add(phoneToGames);	
															}
															
														}
													}catch(Exception e){
														System.out.println("Games error");
													}
												}
												
												if(ttl.equalsIgnoreCase("Java") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_java", "phone_id", String.valueOf(phones.getId()));
															String[] javas = nfo.split(",");
															for(String java : javas){
																MobileJava mobileJava =  (MobileJava) MobileService.getId(MobileJava.class, java);
																if(mobileJava == null){
																	mobileJava = new MobileJava();
																	mobileJava.setTitle(java);
																	mobileJava.setIsActive('Y');
																	mobileJava.setIsDeleted('N');
																}
																MobilePhoneToJava phoneToJava = new MobilePhoneToJava();
																phoneToJava.setMobileJava(mobileJava);
																phoneToJava.setMobilePhones(phones);
																setMobilePhoneToJavas.add(phoneToJava);
															}
														}
													}catch(Exception e){
														System.out.println("Java");
													}
												}
												
												if(ttl.equalsIgnoreCase("Colors") && ttl != null){
													try{
													if(nfo != null){
														MobileService.deleteObject("mobile_phone_to_colors", "phone_id", String.valueOf(phones.getId()));
														String[] colors = nfo.split(",");
														for(String color : colors){
															MobileColors mobileColors =  (MobileColors) MobileService.getId(MobileColors.class, color);
															if(mobileColors == null){
																mobileColors = new MobileColors();
																mobileColors.setTitle(color);
																mobileColors.setIsActive('Y');
																mobileColors.setIsDeleted('N');
															}
															MobilePhoneToColors phoneToColors = new MobilePhoneToColors();
															phoneToColors.setMobileColors(mobileColors);
															phoneToColors.setMobilePhones(phones);
															setMobilePhoneToColors.add(phoneToColors);
														}
													}
													}catch(Exception e){
														System.out.println("Colors error");
													}
												}
												if(ttl.equalsIgnoreCase("Phone Features") && ttl != null){
													try{
														if(nfo != null){
															MobileService.deleteObject("mobile_phone_to_features", "phone_id", String.valueOf(phones.getId()));
															String[] phoneFeatures = nfo.split("-");
															for(String phoneFeature : phoneFeatures){
																MobileFeatures mobileFeatures =  (MobileFeatures) MobileService.getId(MobileFeatures.class, phoneFeature);
																if(mobileFeatures == null){
																	mobileFeatures = new MobileFeatures();
																	mobileFeatures.setTitle(phoneFeature);
																	mobileFeatures.setIsActive('Y');
																	mobileFeatures.setIsDeleted('N');
																}
																MobilePhoneToFeatures phoneToFeatures = new MobilePhoneToFeatures();
																phoneToFeatures.setMobileFeatures(mobileFeatures);
																phoneToFeatures.setMobilePhones(phones);
																setMobileToFeatures.add(phoneToFeatures);
															}
														}
													}catch(Exception e){
														System.out.println("Phone Features error");
													}
												}
												if(ttl.equalsIgnoreCase("Battery Type") && ttl != null){
													if(nfo != null){
														phones.setBattery(nfo);
													}
												}
												if(ttl.equalsIgnoreCase("Stand-by") && ttl != null){
													if(nfo != null){
														phones.setStandbyTime(nfo);
													}
												}
												
												if(ttl.equalsIgnoreCase("Music play") && ttl != null){
													if(nfo != null){
														phones.setMusicPlay(nfo);
													}
												}
												
											}
											
								}
							}
							
						}
						
					}
			}
			
			if(phones.getPhonebook() == null) phones.setPhonebook("null");
			if(phones.getCallRecords() == null) phones.setCallRecords("null");
			
			phones.setMobilePhoneToAlertTypeses(setMobileToAlertTypes);
			phones.setMobilePhoneToNetworkses(setMobileToNetwork);
			phones.setMobilePhoneToProtectionses(setMobileToProtection);
			phones.setMobilePhoneToDisplayTypeses(setMobileToDisplay);
			phones.setMobilePhoneToMemoryCardslotses(setMobileToMemoryCardSlots);
			phones.setMobilePhoneToMemories(setMobileToMemory);
			phones.setMobilePhoneToDataSpeedses(setMobileToDataSpeed);
			phones.setMobilePhoneToNfcs(setMobileToNfc);
			phones.setMobilePhoneToCameraPrimaries(setMobileToCameraPrimaries);
			phones.setMobilePhoneToFeatureses(setMobileToFeatures);
			phones.setMobilePhoneToCameraVideos(setMobileToCameraVideos);
			phones.setMobilePhoneToCameraSecondaries(setMobileToCameraSecondaries);
			phones.setMobilePhoneToSensorses(setMobileToSensors);
			phones.setMobilePhoneToMessagings(setMobileToMessagings);
			phones.setMobilePhoneToBrowserses(setMobilePhoneToBrowsers);
			phones.setMobilePhoneToRadios(setMobilePhoneToRadios);
			phones.setMobilePhoneToGameses(setMobilePhoneToGames);
			phones.setMobilePhoneToJavas(setMobilePhoneToJavas); 
			phones.setMobilePhoneToColorses(setMobilePhoneToColors); 
			phones.setMobilePhoneToCameraFeatureses(setMobilePhoneToCameraFeatures); 
				
			MobileService.persisteMobilePhones(phones);
		 }catch(Exception e){
			 System.out.println("parse data");
		 }
	 }
	 
	 
}

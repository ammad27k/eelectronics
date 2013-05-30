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
import com.imc.framework.bean.MobilePhoneToAlertTypes;
import com.imc.framework.bean.MobilePhones;
import com.imc.service.MobileService;

public class Scrap1 {
	private String pageHtml = "";
	private Document pageSoup;
	private String heading;
	public Scrap1(){
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
		String gsmernaId = number.substring(0, number.length()-4);
		
	}
	
	 public void fetchPageSoup(String pageHtml) throws Exception{
         pageSoup = Jsoup.parse(pageHtml);
     }
	 
	 public void getHeading() throws Exception{
		 Elements elements = pageSoup.getElementsByTag("h1");
		 heading = elements.toString().replaceAll("\\<.*?>","");
		 System.out.println(heading);
	 }
	 public void downloadImage() throws Exception{
		 Elements elements = pageSoup.getElementById("specs-cp-pic").children();
		 String imageUrl = elements.iterator().next().getElementsByTag("img").attr("src");
		 saveImages(new URL(imageUrl)); 
	 }
	 public void saveImages(URL url) throws Exception{
		 File file  = new File("images" + File.separator + heading.split(" ")[0]);
		 if(!file.exists()){
			 file.mkdirs();
		 }
		 File image  = new File("images" + File.separator + heading.split(" ")[0] +"" + File.separator + heading); if (image.exists()) return;
		 InputStream inputStream = url.openStream();
		 OutputStream outputStream = new FileOutputStream(file.getAbsolutePath() + File.separator + heading);
		 
		 byte buffer[] = new byte[2048];
		 int length = 0;
		 while((length = inputStream.read(buffer)) != -1){
			 outputStream.write(buffer, 0, length);
		 }
		 inputStream.close();
		 outputStream.close();
	 }
	 
	 public void parseData() throws Exception{
		 
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
												if(ttl.equalsIgnoreCase("Alert types") && ttl != null){
													if(nfo != null){
													}
												}
												
												if(ttl.equalsIgnoreCase("Phonebook") && ttl != null){
													if(nfo != null){
													}
												}
												if(ttl.equalsIgnoreCase("Call records") && ttl != null){
													if(nfo != null){
													}
												}
											}
								}
							}
							
						}
						
					}
			}
			
	 }
	 
	 
}

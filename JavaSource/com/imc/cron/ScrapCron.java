package com.imc.cron;

public class ScrapCron {

	public static void main(String[] args){
		Scrap1 scrap = new Scrap1();
		try{
			scrap.fetchPageHtml("http://www.gsmarena.com/apple_iphone_5-4910.php");
			scrap.getHeading();
			scrap.downloadImage();
			scrap.parseData();
			
		}catch (Exception e) {
			System.out.print(e);
		}
}
}

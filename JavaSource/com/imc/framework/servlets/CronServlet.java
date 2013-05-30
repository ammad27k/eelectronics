package com.imc.framework.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imc.cron.Scrap;

/**
 * Servlet implementation class TestServalet
 */
public class CronServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CronServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Scrap scrap = new Scrap();
		try{
			String url = "http://www.gsmarena.com/sony_ericsson_xperia_neo_v-";
			int start = 2020;
			
			int limit = 50;
			for(int i = start ;i< start + limit ; i++) {
					scrap.fetchPageHtml(url + i + ".php");
					scrap.getBrands();
					scrap.getHeading();
					scrap.downloadImage();
					scrap.parseData();
				
			}
			
			
		}catch (Exception e) {
			System.out.print(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}

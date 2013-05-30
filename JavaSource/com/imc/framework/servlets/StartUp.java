package com.imc.framework.servlets;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.imc.framework.helper.Constants;

/**
 * Servlet implementation class StartUp
 */
public class StartUp extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public StartUp() {
        super();
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {}
	
	@Override
	public void init() throws ServletException {
		Constants.BASE_PATH = "";
		Constants.CONTEXT_PATH = this.getInitParameter("contextPath");
		System.out.println(Constants.CONTEXT_PATH);
	}

}

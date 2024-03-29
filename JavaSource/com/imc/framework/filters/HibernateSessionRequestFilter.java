package com.imc.framework.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;

import com.imc.utils.HibernateUtil;

public class HibernateSessionRequestFilter implements Filter {

	 private SessionFactory sf;
	 private static Logger log = Logger.getLogger(HibernateSessionRequestFilter.class);
	 
	    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)throws IOException, ServletException {
	        try {
	            log.debug("Starting a database transaction");
	            sf.getCurrentSession().beginTransaction();
	 
	            // Call the next filter (continue request processing)
	            chain.doFilter(request, response);
	 
	            // Commit and cleanup
	            log.debug("Committing the database transaction");
	            sf.getCurrentSession().getTransaction().commit();
	 
	        } catch (StaleObjectStateException staleEx) {
	            log.error("This interceptor does not implement optimistic concurrency control!");
	            log.error("Your application will not work until you add compensation actions!");
	            // Rollback, close everything, possibly compensate for any permanent changes
	            // during the conversation, and finally restart business conversation. Maybe
	            // give the user of the application a chance to merge some of his work with
	            // fresh data... what you do here depends on your applications design.
	            throw staleEx;
	        } catch (Throwable ex) {
	            // Rollback only
	            ex.printStackTrace();
	            try {
	                if (sf.getCurrentSession().getTransaction().isActive()) {
	                    log.debug("Trying to rollback database transaction after exception");
	                    sf.getCurrentSession().getTransaction().rollback();
	                }
	            } catch (Throwable rbEx) {
	                log.error("Could not rollback transaction after exception!", rbEx);
	            }
	 
	            // Let others handle it... maybe another interceptor for exceptions?
	            throw new ServletException(ex);
	        }
	    }
	 
	    public void init(FilterConfig filterConfig) throws ServletException {
	        log.debug("Initializing filter...");
	        log.debug("Obtaining SessionFactory from static HibernateUtil singleton");
	        sf = HibernateUtil.getSessionFactory();
	    }
	@Override
	public void destroy() {}

}

package com.imc.tileshelper;

import com.opensymphony.xwork2.ActionInvocation;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

public class TilesResult extends ServletDispatcherResult {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6463528891933223750L;

	public TilesResult() {
        super();
    }

    public TilesResult(String location) {
        super(location);
    }

    @Override
    public void doExecute(String location, ActionInvocation invocation) throws Exception {
        setLocation(location);
        ServletContext context = ServletActionContext.getServletContext();
        ApplicationContext applicationContext = ServletUtil.getApplicationContext(context);
        TilesContainer container = TilesAccess.getContainer(applicationContext);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
        container.render(location, servletRequest);
    }
}
package com.sttl.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
 * App Intializer class is the replacement of the web.xml
 * it will handle request and response from the mvc model 
 * throgh dispatcher servlet
 */

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));
		
		//here you can add property of serlvet like load on startup and mapping url usinh
		//the servlet objet 
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}

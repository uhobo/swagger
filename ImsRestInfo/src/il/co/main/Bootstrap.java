package il.co.main;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class Bootstrap extends HttpServlet {
	
	@Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
	
	    BeanConfig beanConfig = new BeanConfig();
	    beanConfig.setVersion("1.0.3");
	    beanConfig.setSchemes(new String[]{"http", "https"});
	    beanConfig.setHost("localhost:8080");
	    
	    beanConfig.setBasePath("/ImsRestInfo/rest");
	    beanConfig.setResourcePackage("il.co.main");
	    beanConfig.setScan(true);
	} 
}

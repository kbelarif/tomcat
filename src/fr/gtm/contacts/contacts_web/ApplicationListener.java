package fr.gtm.contacts.contacts_web;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private static Logger LOG =Logger.getLogger(ApplicationListener.class.getName()); 

    public ApplicationListener() {
        
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }


    public void contextInitialized(ServletContextEvent sce)  { 
         LOG.info(">>>>> démarrage de l'application");
    }
	
}

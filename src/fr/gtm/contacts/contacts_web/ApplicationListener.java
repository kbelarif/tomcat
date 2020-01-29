package fr.gtm.contacts.contacts_web;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.gtm.contacts.dao.ContactDao;
import fr.gtm.contacts.service.ContactService;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private static Logger LOG =Logger.getLogger(ApplicationListener.class.getName()); 

    public ApplicationListener(){}

    public void contextDestroyed(ServletContextEvent sce)  { 
    	LOG.info(">>>>> arrêt de l'application");
        ServletContext application =sce.getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) application.getAttribute("EMF");
        emf.close();

    }

    public void contextInitialized(ServletContextEvent sce)  { 
         LOG.info(">>>>> démarrage de l'application");
         //contexte applicatif
         ServletContext application =sce.getServletContext();
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
         application.setAttribute("EMF", emf);
         ContactDao contactDao = new ContactDao(emf);
         //application.setAttribute("contactDao", contactDao);
         ContactService contactservice =new ContactService(contactDao);
         application.setAttribute("contactservice", contactservice);
    }	
}

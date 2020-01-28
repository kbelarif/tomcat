package fr.gtm.contacts.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Civilite;
import fr.gtm.contacts.entities.Contact;

public class ContactDao extends AbstractDao<Contact,Long>{
	

	public ContactDao(EntityManagerFactory emf) {
		super(Contact.class);
		this.emf = emf;
	}
	
	public List<Contact> getContactsByCivilite(Civilite civilite){
		String sql = "SELECT c FROM Contact c WHERE c.civilite= :foo";
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createQuery(sql, Contact.class)
										.setParameter("foo", civilite)
										.getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getContactsByNom(String nom){
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class)
										.setParameter("nom", nom+"%")
										.getResultList();
		em.close();
		return contacts;
	}

	public List<Contact> getAllContact() {
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getAll", Contact.class)
										.getResultList();
		em.close();
		return contacts;
	}
	
	public List<Adresse> getAdresses(long idContact){
		EntityManager em = emf.createEntityManager();
		Contact contact = em.find(Contact.class, idContact);
		contact.getAdresses().size(); // Permet de charger les éléments de contact.getAdresse en mémoire
		em.close();
		return contact.getAdresses();
	}

}

package fr.gtm.contacts.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

//import fr.gtm.entities.Contact;

public abstract class AbstractDao<E,ID> {
	
	protected EntityManagerFactory emf;
	private Class<E> entityClass;

	public AbstractDao(Class<E> clazz) {
		entityClass = clazz;
	}

	public E findById(ID id) {
		EntityManager em = emf.createEntityManager();
		E c = em.find(entityClass, id);
		em.close();
		return c;
	}
	
	public void save(E e) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(E e) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public E remove(ID id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		E e = em.find(entityClass, id);
		em.remove(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}
}

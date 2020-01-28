package fr.gtm.contacts.service;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.contacts.dao.ContactDao;
import fr.gtm.contacts.dto.ContactDto;
import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;

public class ContactService {
	private ContactDao contactDao;

	public ContactService(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	public ContactDto findByContactId(long idContact) {
		Contact contact =contactDao.findById(idContact);
		return new ContactDto(contact);		
	}
	
	public List<Adresse> getAdressesByContactId(long idContact){
		
		return contactDao.getAdresses(idContact);
	}

	public List<ContactDto> getAllContactsDto() {
		List<Contact> contacts = contactDao.getAllContact();
		List<ContactDto>  dtos = new ArrayList<ContactDto>();
		for(Contact c : contacts) {
			dtos.add(new ContactDto(c));
		}
		return dtos;
	}
	
}

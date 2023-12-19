package com.contact.dao;

import org.assertj.core.api.Assertions;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.contact.modal.Contact;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContactRepositoryTests {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Test
	public void test_saveContact() {
		Contact contact = new Contact(1,"Raghav","Gandhinagar DMM","9090898978","raghav@gmail.com");
		
		Contact savedContact = contactRepository.save(contact);
		
		// checking whether the contact is saved to database or not.
		Assertions.assertThat(savedContact).isNotNull();
		Assertions.assertThat(savedContact.getName()).isEqualTo("Raghav");
	}
	
	@Test
	public void test_getAllContacts() {
		Contact contact1 = new Contact(1,"Raghav","Gandhinagar DMM","9090898978","raghav@gmail.com");
		Contact contact2 = new Contact(2,"Afred","Sainagar ATP","9097898978","afred@gmail.com");
		
		contactRepository.save(contact1);
		contactRepository.save(contact2);
		
		List<Contact> contacts = contactRepository.findAll();
		
		// checking to retrieve all the contacts from database.
		Assertions.assertThat(contacts).isNotNull();
		Assertions.assertThat(contacts.size()).isEqualTo(2);
	}
	
	@Test
	public void test_deleteContact() {
		Contact contact1 = new Contact(1,"Raghav","Gandhinagar DMM","9090898978","raghav@gmail.com");
		Contact contact2 = new Contact(2,"Afred","Sainagar ATP","9097898978","afred@gmail.com");
		
		contactRepository.save(contact1);
		contactRepository.save(contact2);
		
		contactRepository.deleteById(1);
		
		List<Contact> contacts = contactRepository.findAll();
		
		// checking to delete the contact in the database.
		Assertions.assertThat(contacts.size()).isEqualTo(1);
		Assertions.assertThat(contacts.get(0).getId()).isEqualTo(2);
	}

}

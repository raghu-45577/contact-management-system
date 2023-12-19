package com.contact.service;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.contact.dao.ContactRepository;
import com.contact.modal.Contact;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTests {
	
	// creating the mock
	@Mock
	private ContactRepository contactRepository;
	
	// injecting the created mocks
	@InjectMocks
	private ContactService contactService;
	
	private Contact contact1;
	private Contact contact2;
	
	@BeforeEach
	public void init() {
		contact1 = new Contact(1,"Raghav","Gandhinagar DMM","9090898978","raghav@gmail.com");
		contact2 = new Contact(2,"Afred","Sainagar ATP","9097898978","afred@gmail.com");
	}
	
	@Test
	public void test_createContact() {
		when(contactRepository.save(contact1)).thenReturn(contact1);
		
		ResponseEntity<Contact> contact = contactService.createContact(contact1);
		
		// checking whether the contact is created or not and with the id 1.
		Assertions.assertThat(contact.getBody()).isNotNull();
		Assertions.assertThat(contact.getBody().getId()).isEqualTo(1);
	}
	
	
	@Test
	public void test_getAllContacts() {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(contact1);
		contacts.add(contact2);
		
		when(contactRepository.findAll()).thenReturn(contacts);
		
		ResponseEntity<List<Contact>> savedContacts = contactService.getAllContacts();
		
		// checking whether all the contacts are retrieved or not.
		Assertions.assertThat(savedContacts).isNotNull();
		Assertions.assertThat(savedContacts.getBody().size()).isEqualTo(2);
	}
	
	@Test
	public void test_deleteContact() {
		
		contactRepository.deleteById(1);
		
		//verifying whether the delete method is called or not.
		verify(contactRepository,times(1)).deleteById(1);
	}
	

}

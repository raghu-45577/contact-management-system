package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.modal.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	// making call to create method in service class to create the contact.
	@PostMapping("/contact")
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
			return contactService.createContact(contact);
	}
	
	// making call to getAllContacts in service class to retrieve all the contacts.
	@GetMapping("/all")
	public ResponseEntity<List<Contact>> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	// making call to deleteContact method in service class to delete the contact by using its id.
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContactById(@PathVariable int id){
		return contactService.deleteContact(id);
	}

}

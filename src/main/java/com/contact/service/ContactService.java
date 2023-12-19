package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.contact.dao.ContactRepository;
import com.contact.modal.Contact;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	// creating the contact and saving to database.
	public ResponseEntity<Contact> createContact(Contact contact){
		try {
			Contact savedContact = contactRepository.save(contact);
			return new ResponseEntity<>(savedContact,HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
	}
	
	// getting all the saved contacts from database.
	public ResponseEntity<List<Contact>> getAllContacts(){
		try {
			List<Contact> contacts = contactRepository.findAll();
			return new ResponseEntity<>(contacts,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
	// deleting the saved contact using its id in the database.
	public ResponseEntity<String> deleteContact(int id){
		try {
			Contact contact = contactRepository.findById(id).get();
			contactRepository.deleteById(id);
			return new ResponseEntity<>("Contact with name "+contact.getName()+" is deleted",HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>("Contact not found",HttpStatus.BAD_REQUEST);
	}
	

}

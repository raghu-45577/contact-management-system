package com.contact.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.contact.modal.Contact;
import com.contact.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class ContactControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactService contactService;
	
	private Contact contact1;
	
	@BeforeEach
	public void init() {
		contact1 = new Contact(1,"Raghav","Gandhinagar DMM","9090898978","raghav@gmail.com");
	}

	
	@Test
	public void test_addContact() throws Exception {
		
		// checking the post operation is performed and got the required result.
		mockMvc.perform(post("/api/contacts/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(contact1))).andExpect(status().isOk());
	}
	
	@Test
	public void test_getAllContacts() throws Exception {
		
		// checking whether the get operation is performed and got the required response.
		mockMvc.perform(get("/api/contacts/all")).andExpect(status().isOk());
	}
	
	@Test
	public void test_deleteContactById() throws Exception {
		// checking the delete operation is performed.
		mockMvc.perform(delete("/api/contacts/1")).andExpect(status().isOk());
	}

}

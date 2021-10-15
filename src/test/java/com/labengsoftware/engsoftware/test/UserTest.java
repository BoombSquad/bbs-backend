package com.labengsoftware.engsoftware.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.labengsoftware.engsoftware.controller.UserController;
import com.labengsoftware.engsoftware.model.Users;
import com.labengsoftware.engsoftware.model.dto.CreateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateUserRequestDTO;
import com.labengsoftware.engsoftware.repository.UserRepository;
import com.labengsoftware.engsoftware.service.UserService;
import com.labengsoftware.engsoftware.service.impl.UserServiceImpl;

public class UserTest {

	private static final String USER_ID = "d158473a-411a-4bf5-873c-db0988079ccd";
	private static final String PHONE = "119942080022";
	private static final String STORE_NAME = "Loja do pedrinho";
	private static final String DOCUMENT_NUMBER = "12345678910";
	private static final String NAME = "pedrinho";
	private static final String SURNAME = "maluquinho";
	private static final String ADDRESS = "pedrinholandia123";
	private static final String EMAIL = "pedro@email.com";

	@InjectMocks
	UserServiceImpl service;
	@Mock
	UserRepository repo;
	@Mock
	Users user;

	@InjectMocks
	UserController controller;
	@Mock
	UserService services;

	@BeforeEach
	void openMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void userCreate() {

		CreateUserRequestDTO request = new CreateUserRequestDTO();

		request.setAddress(ADDRESS);
		request.setDocumentNumber(DOCUMENT_NUMBER);
		request.setEmail(EMAIL);
		request.setName(NAME);
		request.setPhone(PHONE);
		request.setStoreName(STORE_NAME);
		request.setSurname(SURNAME);

		when(repo.saveAndFlush(Mockito.any())).thenReturn(user);
		when(user.getId()).thenReturn(USER_ID);

		assertNotNull(service.create(request));

	}

	@Test
	void userUpdate() {

		UpdateUserRequestDTO request = new UpdateUserRequestDTO();
		UpdateUserRequestDTO urequest = new UpdateUserRequestDTO();
		
		request.setAddress(ADDRESS);
		request.setDocumentNumber(DOCUMENT_NUMBER);
		request.setEmail(EMAIL);
		request.setName(NAME);
		request.setPhone(PHONE);
		request.setStoreName(STORE_NAME);
		request.setSurname(SURNAME);

		when(repo.getById(USER_ID)).thenReturn(user);
		when(repo.saveAndFlush(Mockito.any())).thenReturn(user);
		when(user.getId()).thenReturn(USER_ID);

		service.update(request, USER_ID);
		service.update(urequest, USER_ID);


	}
	
	@Test
	void userDelete() {

		when(repo.saveAndFlush(Mockito.any())).thenReturn(user);
		when(repo.getById(USER_ID)).thenReturn(user);

		service.delete(USER_ID);

	}

	@Test
	void userController(){
		
		CreateUserRequestDTO request = new CreateUserRequestDTO();
		
		request.setAddress(ADDRESS);
		request.setDocumentNumber(DOCUMENT_NUMBER);
		request.setEmail(EMAIL);
		request.setName(NAME);
		request.setPhone(PHONE);
		request.setStoreName(STORE_NAME);
		request.setSurname(SURNAME);
		
		UpdateUserRequestDTO urequest = new UpdateUserRequestDTO();
		
		request.setAddress(ADDRESS);
		request.setDocumentNumber(DOCUMENT_NUMBER);
		request.setEmail(EMAIL);
		request.setName(NAME);
		request.setPhone(PHONE);
		request.setStoreName(STORE_NAME);
		request.setSurname(SURNAME);
		
		
		controller.createUser(request);
		controller.updateUser(urequest, USER_ID);
		controller.deleteUser(USER_ID);
		controller.getUser(USER_ID);
		
	}

}

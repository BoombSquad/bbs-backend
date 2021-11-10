package com.labengsoftware.engsoftware.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import com.labengsoftware.engsoftware.controller.SneakerController;
import com.labengsoftware.engsoftware.model.Sneakers;
import com.labengsoftware.engsoftware.model.dto.CreateSneakerRequestDTO;
import com.labengsoftware.engsoftware.model.dto.SneakerResponseDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateSneakerRequestDTO;
import com.labengsoftware.engsoftware.repository.SneakerRepository;
import com.labengsoftware.engsoftware.service.SneakerService;
import com.labengsoftware.engsoftware.service.impl.SneakerServiceImpl;

public class SneakerTest {

	private static final String PRICE = "799.99";

	private static final String USER_UUID = "ff8878f8-12f8-46af-be7a-e058224f3189";

	private static final String SNEAKER_ID = "5";

	private static final String SIZE = "11.1";

	private static final String NAME = "pedrinho";

	private static final String MODEL = "dunk";

	private static final String CONDITION = "9.7";

	private static final String COLOUR = "black";

	@InjectMocks
	SneakerServiceImpl service;
	@Mock
	SneakerRepository repo;
	@Mock
	Sneakers snkr;

	@InjectMocks
	SneakerController controller;
	@Mock
	SneakerService services;
	

	@BeforeEach
	void openMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void sneakerCreate() {
		
		CreateSneakerRequestDTO request = new CreateSneakerRequestDTO();
		request.setColour(COLOUR);
		request.setCondition(CONDITION);
		request.setModel(MODEL);
		request.setName(NAME);
		request.setSize(SIZE);
		request.setUid(USER_UUID);

		when(snkr.getId()).thenReturn(SNEAKER_ID);
		when(repo.saveAndFlush(Mockito.any())).thenReturn(snkr);
		SneakerResponseDTO response = service.create(request);

	}

	@Test
	void sneakerUpdate() {
		
		UpdateSneakerRequestDTO request = new UpdateSneakerRequestDTO();
		UpdateSneakerRequestDTO urequest = new UpdateSneakerRequestDTO();
		
		request.setColour(COLOUR);
		request.setCondition(CONDITION);
		request.setModel(MODEL);
		request.setName(NAME);
		request.setSize(SIZE);
		request.setUid(USER_UUID);
		request.setPrice(PRICE);

		when(repo.getById(SNEAKER_ID)).thenReturn(snkr);
		when(repo.saveAndFlush(Mockito.any())).thenReturn(snkr);
		when(snkr.getId()).thenReturn(SNEAKER_ID);

		service.update(SNEAKER_ID, request);
		service.update(SNEAKER_ID, urequest);

	}
	
	@Test
	void sneakerDelete() {

		when(repo.saveAndFlush(Mockito.any())).thenReturn(snkr);
		when(repo.getById(SNEAKER_ID)).thenReturn(snkr);

		service.delete(SNEAKER_ID);

	}

	@Test
	void sneakerGet() {

		Page<Sneakers> page = null;

		when(repo.findAllSneakersByUser(Mockito.any(), Mockito.any())).thenReturn(page);

		service.getSneakersByUser(USER_UUID);
		service.getSneakersByBrand(MODEL);
		service.getSneakersByColour(COLOUR);
		service.getSneakersByModel(MODEL);
		service.getSneakersBySize(SIZE);

	}

	@Test
	void sneakerController(){
		
		CreateSneakerRequestDTO request = new CreateSneakerRequestDTO();
		
		request.setColour(COLOUR);
		request.setCondition(CONDITION);
		request.setModel(MODEL);
		request.setName(NAME);
		request.setSize(SIZE);
		request.setUid(USER_UUID);
		
		UpdateSneakerRequestDTO urequest = new UpdateSneakerRequestDTO();
		
		request.setColour(COLOUR);
		request.setCondition(CONDITION);
		request.setModel(MODEL);
		request.setName(NAME);
		request.setSize(SIZE);
		request.setUid(USER_UUID);
		
		
		controller.createSneaker(request, USER_UUID);
		controller.getAllByUser(USER_UUID);
		controller.deleteSneaker(SNEAKER_ID);
		controller.updateSneaker(SNEAKER_ID, urequest);
		controller.getAllByBrand(MODEL);
		controller.getAllByColour(COLOUR);
		controller.getAllByModel(MODEL);
		controller.getAllBySize("11");
		controller.getAllByUser(USER_UUID);
		
	}

}

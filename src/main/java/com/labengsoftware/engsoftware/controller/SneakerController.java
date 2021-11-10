package com.labengsoftware.engsoftware.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labengsoftware.engsoftware.model.Sneakers;
import com.labengsoftware.engsoftware.model.dto.CreateSneakerRequestDTO;
import com.labengsoftware.engsoftware.model.dto.SneakerResponseDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateSneakerRequestDTO;
import com.labengsoftware.engsoftware.service.SneakerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/snkr")
public class SneakerController {


	@Autowired
	SneakerService service;

	@PostMapping("/create/{user_id}")
	public SneakerResponseDTO createSneaker(@RequestBody CreateSneakerRequestDTO request,
			@PathVariable String user_id) {

		log.info("Criando tenis");
		request.setUid(user_id);

		SneakerResponseDTO response = service.create(request);

		return response;
	}
	
	@GetMapping
	public List<Sneakers> getAll() {

		log.info("Pegando todos os tenis");

		List<Sneakers> page = service.findAll();

		return page;
	}

	@GetMapping("/{user_id}")
	public Page<Sneakers> getAllByUser(@PathVariable String user_id) {

		log.info("Pegando todos os tenis do usuario");

		Page<Sneakers> page = service.getSneakersByUser(user_id);

		return page;
	}
	
	@GetMapping("/size/{size}")
	public Page<Sneakers> getAllBySize(@PathVariable String size) {

		log.info("Pegando todos os tenis do usuario");
		
		Page<Sneakers> page = service.getSneakersBySize(size);

		return page;
	}
	
	@GetMapping("/brand/{brand}")
	public Page<Sneakers> getAllByBrand(@PathVariable String brand) {

		log.info("Pegando todos os tenis do usuario");

		Page<Sneakers> page = service.getSneakersByBrand(brand);

		return page;
	}
	
	@GetMapping("/model/{model}")
	public Page<Sneakers> getAllByModel(@PathVariable String model) {

		log.info("Pegando todos os tenis do usuario");

		Page<Sneakers> page = service.getSneakersByModel(model);

		return page;
	}
	
	@GetMapping("/colour/{colour}")
	public Page<Sneakers> getAllByColour(@PathVariable String colour) {

		log.info("Pegando todos os tenis do usuario");

		Page<Sneakers> page = service.getSneakersByColour(colour);

		return page;
	}
	
	@PatchMapping("/{sneaker_id}")
	public SneakerResponseDTO updateSneaker(@PathVariable String sneaker_id, UpdateSneakerRequestDTO request) {

		log.info("Atualizando tenis do usuario");

		SneakerResponseDTO res = service.update(sneaker_id, request);

		return res;
	}
	
	@DeleteMapping("/{sneaker_id}")
	public SneakerResponseDTO deleteSneaker(@PathVariable String sneaker_id) {

		log.info("Deletando tenis");

		SneakerResponseDTO res = service.delete(sneaker_id);

		return res;
	}
}

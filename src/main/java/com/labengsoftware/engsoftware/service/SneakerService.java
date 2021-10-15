package com.labengsoftware.engsoftware.service;


import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;

import com.labengsoftware.engsoftware.model.Sneakers;
import com.labengsoftware.engsoftware.model.dto.CreateSneakerRequestDTO;
import com.labengsoftware.engsoftware.model.dto.SneakerResponseDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateSneakerRequestDTO;

public interface SneakerService {
	
	SneakerResponseDTO create(CreateSneakerRequestDTO request);
	
	SneakerResponseDTO update(BigInteger sneaker_id, UpdateSneakerRequestDTO urequest);
	
	SneakerResponseDTO delete(BigInteger sneaker_id);

	SneakerResponseDTO sell(BigInteger sneaker_id);
	
	Page<Sneakers> getSneakersByUser(String user_id);

	Page<Sneakers> getSneakersByModel(String Model);

	Page<Sneakers> getSneakersByColour(String colour);

	Page<Sneakers> getSneakersBySize(String Size);

	Page<Sneakers> getSneakersByBrand(String brand);

	List<Sneakers> findAll();

	

}

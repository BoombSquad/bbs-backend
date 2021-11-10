package com.labengsoftware.engsoftware.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.labengsoftware.engsoftware.model.Sneakers;
import com.labengsoftware.engsoftware.model.dto.CreateSneakerRequestDTO;
import com.labengsoftware.engsoftware.model.dto.SneakerResponseDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateSneakerRequestDTO;
import com.labengsoftware.engsoftware.model.type.SneakerStatus;
import com.labengsoftware.engsoftware.repository.SneakerRepository;
import com.labengsoftware.engsoftware.service.SneakerService;

@Service
public class SneakerServiceImpl implements SneakerService {

	@Autowired
	SneakerRepository repo;

	@Override
	public SneakerResponseDTO create(CreateSneakerRequestDTO request) {

		SneakerResponseDTO response = new SneakerResponseDTO();
		Sneakers snkrs = new Sneakers();

		snkrs.setUid(request.getUid());
		snkrs.setName(request.getName());
		snkrs.setPrice(request.getPrice());
		snkrs.setModel(request.getModel());
		snkrs.setColour(request.getColour());
		snkrs.setBrand(request.getBrand());
		snkrs.setStatus(SneakerStatus.ENABLE.keyValue());
		snkrs.setSize(request.getSize());
		snkrs.setCondition(request.getCondition());
		snkrs.setCreatedAt(LocalDateTime.now().toString());
		
		try {

			snkrs = repo.saveAndFlush(snkrs);

		} catch (Exception e) {

			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "could not create sneaker " + e);
		}

		response.setId(snkrs.getId().toString());
		response.setValid(Boolean.TRUE.toString());
		response.setTime(LocalDateTime.now().toString());

		return response;
	}

	@Override
	public Page<Sneakers> getSneakersByUser(String user_id) {

		Pageable pageable = null;
		Page<Sneakers> page = null;
		try {
			
			page = repo.findAllSneakersByUser(pageable, user_id);
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not retrieve all sneaker" + e);
		}

		return page;

	}
	
	@Override
	public Page<Sneakers> getSneakersByBrand(String brand) {

		Pageable pageable = null;
		Page<Sneakers> page = null;
		try {
			
			page = repo.findAllSneakersByBrand(pageable, brand);
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not retrieve all sneaker" + e);
		}

		return page;

	}
	
	@Override
	public Page<Sneakers> getSneakersBySize(String Size) {

		Pageable pageable = null;
		Page<Sneakers> page = null;
		try {
			
			page = repo.findAllSneakersBySize(pageable, Size);
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not retrieve all sneaker" + e);
		}

		return page;

	}
	
	@Override
	public Page<Sneakers> getSneakersByColour(String colour) {

		Pageable pageable = null;
		Page<Sneakers> page = null;
		try {
			
			page = repo.findAllSneakersByColour(pageable, colour);
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not retrieve all sneaker" + e);
		}

		return page;

	}
	
	@Override
	public Page<Sneakers> getSneakersByModel(String Model) {

		Pageable pageable = null;
		Page<Sneakers> page = null;
		try {
			
			page = repo.findAllSneakersByModel(pageable, Model);
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not retrieve all sneaker" + e);
		}

		return page;

	}

	@Override
	public SneakerResponseDTO update(String sneaker_id, UpdateSneakerRequestDTO urequest) {

		SneakerResponseDTO res = new SneakerResponseDTO();
		Sneakers snkr = repo.getById(sneaker_id);
		try {
			
			if (urequest.getColour() != null) {

				snkr.setColour(urequest.getColour());

			}if (urequest.getCondition() != null) {

				snkr.setCondition(urequest.getCondition());

			}if (urequest.getModel() != null) {

				snkr.setModel(urequest.getModel());

			}if (urequest.getName() != null) {

				snkr.setName(urequest.getName());

			}if (urequest.getPrice() != null) {

				snkr.setPrice(urequest.getPrice());

			}if (urequest.getSize() != null) {

				snkr.setSize(urequest.getSize());
			}
			snkr.setUpdatedAt(LocalDateTime.now().toString());
			snkr = repo.saveAndFlush(snkr);
			
			res.setTime(LocalDateTime.now().toString());
			res.setValid(Boolean.TRUE.toString());
			res.setId(snkr.getId().toString());
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not update sneaker" + e);
		}

		
		return res;
	}

	@Override
	public SneakerResponseDTO delete(String sneaker_id) {

		SneakerResponseDTO res = new SneakerResponseDTO();  
		Sneakers snkr = repo.getById(sneaker_id);
		try {
			
			snkr.setStatus(SneakerStatus.DELETED.keyValue());
			snkr.setDeletedAt(LocalDateTime.now().toString());
			snkr = repo.saveAndFlush(snkr);
			
			res.setValid(Boolean.TRUE.toString());
			res.setTime(LocalDateTime.now().toString());
			
		} catch (Exception e) {
			
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not delete sneaker" + e);

			
		}
		
		
		return res;
	}

	@Override
	public List<Sneakers> findAll() {
		
		List<Sneakers> snkrs = repo.findAll();
		
		return snkrs;
	}

	@Override
	public SneakerResponseDTO sell(String sneaker_id) {
		// TODO Auto-generated method stub
		return null;
	}

}

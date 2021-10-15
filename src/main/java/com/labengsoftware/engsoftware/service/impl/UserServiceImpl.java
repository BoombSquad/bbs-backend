package com.labengsoftware.engsoftware.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.labengsoftware.engsoftware.model.Users;
import com.labengsoftware.engsoftware.model.dto.CreateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UserResponseDTO;
import com.labengsoftware.engsoftware.model.type.UserStatus;
import com.labengsoftware.engsoftware.repository.UserRepository;
import com.labengsoftware.engsoftware.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserResponseDTO create(CreateUserRequestDTO request) {
		
		Users user = new Users();
		UserResponseDTO res = new UserResponseDTO();
		
		user.setAddress(request.getAddress());
		user.setDocumentNumber(request.getDocumentNumber());
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPhone(request.getPhone());
		user.setStoreName(request.getStoreName());
		user.setSurname(request.getSurname());
		user.setPassword(request.getPassword());
		user.setCreatedAt(LocalDateTime.now().toString());
		
		try {
		
			
			user.setStatus(UserStatus.ENABLE.keyValue());
			user = repo.saveAndFlush(user);
			
			res.setUid(user.getId());
			res.setTime(LocalDateTime.now().toString());
			res.setValid(Boolean.TRUE.toString());
			
		} catch (Exception e) {
			
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not create user" + e);
			
		}
		return res;
	}

	@Override
	public UserResponseDTO delete(String user_id) {
		UserResponseDTO res = new UserResponseDTO();  
		Users user = repo.getById(user_id);
		try {
			
			user.setStatus(UserStatus.DELETED.keyValue());
			user.setDeletedAt(LocalDateTime.now().toString());
			user = repo.saveAndFlush(user);
			
			res.setValid(Boolean.TRUE.toString());
			res.setTime(LocalDateTime.now().toString());
			
		} catch (Exception e) {
			
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not delete user" + e);
			
		}
		
		return res;
	}

	@Override
	public Optional<Users> getUser(String user_id) {
		
		Optional<Users> user = repo.findById(user_id);
		
		return user;
	}

	@Override
	public UserResponseDTO update(UpdateUserRequestDTO urequest, String user_id) {
		UserResponseDTO res = new UserResponseDTO();
		Users user = repo.getById(user_id);
		try {
			
			if (urequest.getName() != null) {

				user.setName(urequest.getName());

			}if (urequest.getSurname() != null) {

				user.setSurname(urequest.getSurname());

			}if (urequest.getAddress() != null) {

				user.setAddress(urequest.getAddress());

			}if (urequest.getEmail() != null) {

				user.setEmail(urequest.getEmail());

			}if (urequest.getStoreName() != null) {

				user.setStoreName(urequest.getStoreName());

			}if (urequest.getPhone() != null) {

				user.setPhone(urequest.getPhone());
			}
			user.setUpdatedAt(LocalDateTime.now().toString());
			user = repo.saveAndFlush(user);
			
			res.setTime(LocalDateTime.now().toString());
			res.setValid(Boolean.TRUE.toString());
			res.setUid(user.getId());
			
		} catch (Exception e) {
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "could not update user" + e);
		}

		
		return res;
	}

}

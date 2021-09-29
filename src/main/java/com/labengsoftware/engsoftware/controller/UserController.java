package com.labengsoftware.engsoftware.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labengsoftware.engsoftware.model.Users;
import com.labengsoftware.engsoftware.model.dto.CreateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UserResponseDTO;
import com.labengsoftware.engsoftware.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		UserService service;
		
		@PostMapping("/create")
		public UserResponseDTO createUser(@RequestBody CreateUserRequestDTO request){
			
			
			log.info("Criando usuario");

			UserResponseDTO response = service.create(request);

			
			return response;
		}
		
		@GetMapping("/{user_id)")
		public Optional<Users> getUser(@PathVariable String user_id){
			
			
			log.info("Recuperando usuario");

			Optional<Users> response = service.getUser(user_id);


			return response;
		}
		
		@DeleteMapping("/{user_id)")
		public UserResponseDTO deleteUser(@PathVariable String user_id){
			
			
			log.info("Deletando usuario");

			UserResponseDTO response = service.delete(user_id);


			return response;
		}
		
		@PatchMapping
		public UserResponseDTO updateUser(@RequestBody UpdateUserRequestDTO request, @PathVariable String user_id){
			
			
			log.info("Atualizando usuario");

			UserResponseDTO response = service.update(request, user_id);


			return response;
		}

}

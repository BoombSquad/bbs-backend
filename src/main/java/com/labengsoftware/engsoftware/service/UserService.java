package com.labengsoftware.engsoftware.service;

import com.labengsoftware.engsoftware.model.dto.CreateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UpdateUserRequestDTO;
import com.labengsoftware.engsoftware.model.dto.UserResponseDTO;

public interface UserService {
	
	UserResponseDTO create(CreateUserRequestDTO request);

	UserResponseDTO delete(String user_id);

	UserResponseDTO getUser(String user_id);

	UserResponseDTO update(UpdateUserRequestDTO request, String user_id);
	

}

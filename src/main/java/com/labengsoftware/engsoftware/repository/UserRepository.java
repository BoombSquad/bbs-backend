package com.labengsoftware.engsoftware.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labengsoftware.engsoftware.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {

	Users findById(UUID user_id);

}

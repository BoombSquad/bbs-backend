package com.labengsoftware.engsoftware.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.labengsoftware.engsoftware.model.Sneakers;

public interface SneakerRepository extends JpaRepository<Sneakers, String> {

	@Query(value = "SELECT * FROM sneakers WHERE sneakers.user_id = :uid", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Page<Sneakers> findAllSneakersByUser(Pageable pageable, @Param("uid") String user_id);

	@Query(value = "SELECT * FROM sneakers WHERE sneakers.sneakers_size = :ssize", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Page<Sneakers> findAllSneakersBySize(Pageable pageable, @Param("ssize") String size);
	
	@Query(value = "SELECT * FROM sneakers WHERE sneakers.sneakers_brand = :sbrand", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Page<Sneakers> findAllSneakersByBrand(Pageable pageable, @Param("sbrand") String brand);
	
	@Query(value = "SELECT * FROM sneakers WHERE sneakers.sneakers_colour = :scolour", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Page<Sneakers> findAllSneakersByColour(Pageable pageable, @Param("scolour") String colour);
	
	@Query(value = "SELECT * FROM sneakers WHERE sneakers.sneakers_model = :smodel", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Page<Sneakers> findAllSneakersByModel(Pageable pageable, @Param("smodel") String model);
	
	@Query(value = "SELECT * FROM sneakers WHERE sneakers.sneakers_code = :sid", countQuery = "SELECT count(*) FROM Users", nativeQuery = true)
	Sneakers getById(@Param("sid") String sneaker_id);

}

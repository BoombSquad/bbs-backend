DROP TABLE IF EXISTS SNEAKERS;  
CREATE TABLE SNEAKERS (  
sneakers_code INT PRIMARY KEY,  
user_id VARCHAR(50) NOT NULL,
sneakers_name VARCHAR(50) NOT NULL,  
sneakers_price VARCHAR(50) NOT NULL,
sneakers_model VARCHAR(50) NOT NULL,
sneakers_colour VARCHAR(50) NOT NULL,
sneakers_brand VARCHAR(50) NOT NULL,
sneakers_status VARCHAR(50) NOT NULL,
sneakers_size VARCHAR(50) NOT NULL,
sneakers_cond VARCHAR(50) NOT NULL,
created_at VARCHAR(50) NOT NULL,
updated_at VARCHAR(50),
selled_at VARCHAR(50),
deleted_at VARCHAR(50)
);

DROP TABLE IF EXISTS Users;  
CREATE TABLE Users (  
user_id VARCHAR(36) PRIMARY KEY,
user_name VARCHAR(50) NOT NULL,  
user_pass VARCHAR(50) NOT NULL,
user_surname VARCHAR(50) NOT NULL,
user_phone VARCHAR(50) NOT NULL,
user_email VARCHAR(50) NOT NULL,
user_address VARCHAR(50) NOT NULL,
user_storeName VARCHAR(50),
user_documentNumber VARCHAR(50) NOT NULL,
user_status VARCHAR(50) NOT NULL,
created_at VARCHAR(50),
updated_at VARCHAR(50),
deleted_at VARCHAR(50)
);  
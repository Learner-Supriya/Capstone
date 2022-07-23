package com.wipro.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {

}

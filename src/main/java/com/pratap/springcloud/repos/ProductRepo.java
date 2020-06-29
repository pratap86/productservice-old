package com.pratap.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratap.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}

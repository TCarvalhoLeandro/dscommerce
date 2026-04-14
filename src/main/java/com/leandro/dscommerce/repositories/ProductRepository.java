package com.leandro.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

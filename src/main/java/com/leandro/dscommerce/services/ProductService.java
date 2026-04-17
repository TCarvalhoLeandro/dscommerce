package com.leandro.dscommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandro.dscommerce.dto.ProductDTO;
import com.leandro.dscommerce.entities.Product;
import com.leandro.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired // injecao de dependencia automatica
	private ProductRepository productRepository;
	
	// service retorna DTO
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> result = productRepository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable){
		Page<Product> result = productRepository.findAll(pageable);
		// lambda para converter p/ DTO e retornar uma lista
		return result.map(x -> new ProductDTO(x));
	}
	
	
	public void insert(ProductDTO entity) {
		Product product = new Product(entity);
		productRepository.save(product);
	}
}


// http://localhost:8080/products?size=10&page=0&sort=name,desc

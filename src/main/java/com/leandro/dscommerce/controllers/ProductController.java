package com.leandro.dscommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.dscommerce.dto.ProductDTO;
import com.leandro.dscommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		ProductDTO dto = productService.findById(id);
		return dto;
	}
	
	@GetMapping
	public Page<ProductDTO> findAll(Pageable pageable){
		return productService.findAll(pageable);
	}
	
	@PostMapping
	public void insert(ProductDTO entity) {
		productService.insert(entity);
	}
}


//Controller -> DTO -> Service -> Repository -> Banco de Dados
//Controller <- DTO <- Service <- Repository <- Banco de Dados
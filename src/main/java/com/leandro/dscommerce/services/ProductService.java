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
	// readOnly = true sinaliza que esse endpoint so faz consulta no banco para economizar memoria
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> result = productRepository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable){
		// Page no lugar de List para salvar os metadados da paginacao
		Page<Product> result = productRepository.findAll(pageable);
		// lambda para converter p/ DTO e retornar uma lista
		return result.map(x -> new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		// converte o dto em Product
		Product product = new Product(dto);
		// chama o metodo inderir do JPA
		product = productRepository.save(product);
		// converte Product em dto e retorna dto
		return new ProductDTO(product);
	}
	
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		// pega a referencia do Product pelo id passado
		Product product = productRepository.getReferenceById(id);
		// atualiza o product com os dados do dto
		copyDtoToEntity(dto, product);
		// salva no banco o novo product
		product = productRepository.save(product);
		// retorna o dto
		return new ProductDTO(product);
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product product) {
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setImgUrl(dto.getImgUrl());

	}
	
}


// http://localhost:8080/products?size=10&page=0&sort=name,desc

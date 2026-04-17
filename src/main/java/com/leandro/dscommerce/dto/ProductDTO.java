package com.leandro.dscommerce.dto;

import com.leandro.dscommerce.entities.Product;

// DTO - Data Tranfer Object (Objeto de Transferencia de Dados)

// Nao e necessario set no DTO porque a finalidade é recuperar os dados e não modificar

public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	public ProductDTO() {
	}

	// para facilitar a criacao do DTO instancia direto recebendo um Product
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
	}
	

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}

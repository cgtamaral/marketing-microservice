package br.pucminas.marketingmicroservice.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.pucminas.marketingmicroservice.api.dtos.ProductDTO;
import br.pucminas.marketingmicroservice.api.enums.ProductTypeEnum;

@Entity
public class Product 
{
	private Long id;
	private String title;
	private ProductTypeEnum productTypeEnum;
	
	public Product() {	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "title", length = 4000, nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "productType", nullable = false)
	public ProductTypeEnum getProductTypeEnum() {
		return productTypeEnum;
	}
	public void setProductTypeEnum(ProductTypeEnum productTypeEnum) {
		this.productTypeEnum = productTypeEnum;
	}
	
	@Transient
	public static List<ProductDTO> convertToDTO(List<Product> products) 
	{
		List<ProductDTO> retorno = new ArrayList<ProductDTO>();
		for (Product product : products) {
			retorno.add(convertToDTO(product));
		}
		return retorno;
	}
	
	@Transient
	public static ProductDTO convertToDTO(Product product) 
	{
		ProductDTO retorno = new ProductDTO();
		
		retorno.setId(product.getId());
		retorno.setTitle(product.getTitle());
		retorno.setProductType(product.getProductTypeEnum().toString());

		return retorno;
	}
}

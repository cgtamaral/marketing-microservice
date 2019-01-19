package br.pucminas.marketingmicroservice.api.dtos;

import java.util.Calendar;

public class MarketingDTO {
	
	private Long id;
	private String title;
	private String description;
	private ProductDTO product;
	private Calendar registerDate;
	private Calendar beginDate;
	private Calendar finishDate;
	private Integer quantityProduct;
	private Double oldValue;
	private Double promotionValue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public Calendar getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}
	public Calendar getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}
	public Calendar getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}
	public Integer getQuantityProduct() {
		return quantityProduct;
	}
	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}
	public Double getOldValue() {
		return oldValue;
	}
	public void setOldValue(Double oldValue) {
		this.oldValue = oldValue;
	}
	public Double getPromotionValue() {
		return promotionValue;
	}
	public void setPromotionValue(Double promotionValue) {
		this.promotionValue = promotionValue;
	}
	
}

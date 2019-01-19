package br.pucminas.marketingmicroservice.api.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.pucminas.marketingmicroservice.api.dtos.MarketingDTO;

@Entity
public class Marketing 
{
	private Long id;
	private String title;
	private String description;
	private Product product;
	private Calendar registerDate;
	private Calendar beginDate;
	private Calendar finishDate;
	private Integer quantityProduct;
	private Double oldValue;
	private Double promotionValue;
	
	public Marketing() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "title", length = 250, nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 4000, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "registerDate", nullable = false)
	public Calendar getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}


	@Column(name = "beginDate", nullable = false)
	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	@Column(name = "finishDate", nullable = false)
	public Calendar getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}

	@Column(name = "quantityProduct", nullable = false)
	public Integer getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}
	
	@Column(name = "oldValue", nullable = false)
	public Double getOldValue() {
		return oldValue;
	}

	public void setOldValue(Double oldValue) {
		this.oldValue = oldValue;
	}
	
	@Column(name = "promotionValue", nullable = false)
	public Double getPromotionValue() {
		return promotionValue;
	}

	public void setPromotionValue(Double promotionValue) {
		this.promotionValue = promotionValue;
	}

	@Transient
	public static List<MarketingDTO> convertToDTO(List<Marketing> marketings) {
		List<MarketingDTO> retorno = new ArrayList<MarketingDTO>();
		for (Marketing item : marketings) 
		{
			MarketingDTO marketingDTO = convertToDTO(item);
			
			retorno.add(marketingDTO);
		}
		
		return retorno;
	}

	@Transient
	public static MarketingDTO convertToDTO(Marketing marketing) {
		
		MarketingDTO marketingDTO = new MarketingDTO();
		marketingDTO.setId(marketing.getId());
		marketingDTO.setTitle(marketing.getTitle());
		marketingDTO.setDescription(marketing.getDescription());
		marketingDTO.setProduct(Product.convertToDTO(marketing.getProduct()));
		marketingDTO.setRegisterDate(marketing.getRegisterDate());
		marketingDTO.setBeginDate(marketing.getBeginDate());
		marketingDTO.setFinishDate(marketing.getFinishDate());
		marketingDTO.setQuantityProduct(marketing.getQuantityProduct());
		marketingDTO.setOldValue(marketing.getOldValue());
		marketingDTO.setPromotionValue(marketing.getPromotionValue());
		
		return marketingDTO;
	}
}

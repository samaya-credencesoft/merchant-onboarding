package com.csoft.payone.service.seller;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String referenceNumber;
	private String item;
	private String itemDescription;
	private String merchantWebsite;
	private BigDecimal TotalAmount;
	private String buyerEmail;
	private String buyerMobile;
	private Date lastDate;
	
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getMerchantWebsite() {
		return merchantWebsite;
	}
	public void setMerchantWebsite(String merchantWebsite) {
		this.merchantWebsite = merchantWebsite;
	}
	public BigDecimal getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerMobile() {
		return buyerMobile;
	}
	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}

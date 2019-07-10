package com.item.order.processing.model;

import java.io.Serializable;

public class SearchItemResponse implements Serializable,CalculationResponse {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String shortDescription;
	private String title;
	private String uom;
	private double unitPrice;
	private String unitPriceUom;
	private String extnTransportMethodType;
	private String organizationCode;
	private String itemPicture;
	private double unitSalePrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitPriceUom() {
		return unitPriceUom;
	}

	public void setUnitPriceUom(String unitPriceUom) {
		this.unitPriceUom = unitPriceUom;
	}

	public String getExtnTransportMethodType() {
		return extnTransportMethodType;
	}

	public void setExtnTransportMethodType(String extnTransportMethodType) {
		this.extnTransportMethodType = extnTransportMethodType;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getItemPicture() {
		return itemPicture;
	}

	public void setItemPicture(String itemPicture) {
		this.itemPicture = itemPicture;
	}

	public double getUnitSalePrice() {
		return unitSalePrice;
	}

	public void setUnitSalePrice(double unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}

}

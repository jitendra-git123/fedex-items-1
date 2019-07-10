package com.item.order.processing.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author semwaln
 * 
 *         Entity class for Item_Data TABLE.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VIEW_ITEM_LIST")
public class ViewItemList implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;

	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "UNIT_PRICE")
	private double unitPrice;

	@Column(name = "UNIT_PRICE_UOM")
	private String unitPriceUom;

	@Column(name = "EXTN_TRANSPORT_METHOD_TYPE")
	private String extnTransportMethodType;

	@Column(name = "ORGANIZATION_CODE")
	private String organizationCode;

	@Column(name = "ITEM_PICTURE")
	private String itemPicture;

	@Column(name = "UNIT_SALE_PRICE")
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
package com.item.order.processing.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ItemAvailabilityResponse
 */

public class ItemAvailabilityResponse implements Serializable, CalculationResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets or Sets stockAvailability
	 */
	public enum StockAvailabilityEnum {
		INSTOCK("In Stock"),

		OUTOFSTOCK("Out of Stock"),
		
		ZIPCODENOTMATCH("Item cannot be delivered to the selected location/zone");

		private String value;

		StockAvailabilityEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StockAvailabilityEnum fromValue(String text) {
			for (StockAvailabilityEnum b : StockAvailabilityEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("stockAvailability")
	private StockAvailabilityEnum stockAvailability = null;

	@JsonProperty("quantity")
	private double quantity ;

	@JsonProperty("timeSlot")
	private String timeSlot = null;

	public ItemAvailabilityResponse stockAvailability(StockAvailabilityEnum stockAvailability) {
		this.stockAvailability = stockAvailability;
		return this;
	}

	/**
	 * Get stockAvailability
	 * 
	 * @return stockAvailability
	 **/
	public StockAvailabilityEnum getStockAvailability() {
		return stockAvailability;
	}

	public void setStockAvailability(StockAvailabilityEnum stockAvailability) {
		this.stockAvailability = stockAvailability;
	}

	public ItemAvailabilityResponse quantity(Long quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Get quantity
	 * 
	 * @return quantity
	 **/
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public ItemAvailabilityResponse timeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ItemAvailabilityResponse itemAvailabilityResponse = (ItemAvailabilityResponse) o;
		return Objects.equals(this.stockAvailability, itemAvailabilityResponse.stockAvailability)
				&& Objects.equals(this.quantity, itemAvailabilityResponse.quantity)
				&& Objects.equals(this.timeSlot, itemAvailabilityResponse.timeSlot);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockAvailability, quantity, timeSlot);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ItemAvailabilityResponse {\n");

		sb.append("    stockAvailability: ").append(toIndentedString(stockAvailability)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    timeSlot: ").append(toIndentedString(timeSlot)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

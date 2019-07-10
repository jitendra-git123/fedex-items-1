package com.item.order.processing.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.item.order.processing.model.ApiResponseMessage;
import com.item.order.processing.model.ItemAvailabilityResponse;
import com.item.order.processing.model.SearchItemResponse;
import com.item.order.processing.service.ItemService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemApiController {

	@Autowired
	private ItemService itemServiceImpl;

	@GetMapping(value = "/itemavailability/{itemId}/{zipCode}/{quantity}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseMessage getItemAvailability(@PathVariable("itemId") String itemId,
			@PathVariable("zipCode") String zipCode, @PathVariable("quantity") int quantity) {

		ItemAvailabilityResponse response = itemServiceImpl.getItemAvailability(itemId, zipCode, quantity);

		if (response != null) {
			return new ApiResponseMessage(ApiResponseMessage.OK, "SUCCESS", response);
		} else {
			return new ApiResponseMessage(ApiResponseMessage.NO_RECORD_FOUND, "No Record Found", response);
		}
	}

	@GetMapping(value = "/getallproducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseMessage getAllProduct() {

		// ItemAvailabilityResponse response = itemServiceImpl.getItemAvailability();

		List<SearchItemResponse> response = itemServiceImpl.getAllProductList();
		if (response != null && !response.isEmpty()) {
			return new ApiResponseMessage(ApiResponseMessage.OK, "SUCCESS", response);
		} else {
			return new ApiResponseMessage(ApiResponseMessage.NO_RECORD_FOUND, "No Record Found", response);
		}
	}

}

package com.item.order.processing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.item.order.processing.model.ItemAvailabilityResponse;
import com.item.order.processing.model.SearchItemResponse;



/**
 * 
 * @author semwaln
 * 
 *         <pre>
 *  Interface providing business logic implementation for Item details
 *         </pre>
 *
 */
@Service
public interface ItemService {

	ItemAvailabilityResponse getItemAvailability(String itemId, String zipCode, int quantity);

	List<SearchItemResponse> getAllProductList();

}
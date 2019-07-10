package com.item.order.processing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.order.processing.entities.ViewItemAvailability;
import com.item.order.processing.entities.ViewItemList;
import com.item.order.processing.model.ItemAvailabilityResponse;
import com.item.order.processing.model.ItemAvailabilityResponse.StockAvailabilityEnum;
import com.item.order.processing.model.SearchItemResponse;
import com.item.order.processing.repository.ItemDataRepository;
import com.item.order.processing.repository.ViewItemAvailabilityRepository;
import com.item.order.processing.repository.ViewItemListRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired

	private ItemDataRepository itemRepo;

	@Autowired
	private ViewItemListRepository viewItemRepo;

	@Autowired
	private ViewItemAvailabilityRepository viewItemAvailabilityRepo;

	@Override
	public ItemAvailabilityResponse getItemAvailability(String itemId, String zipCode, int quantity) {

		ItemAvailabilityResponse response = new ItemAvailabilityResponse();
		if (itemId.equalsIgnoreCase("Step Ladder") && zipCode.equalsIgnoreCase("16243")) {
			response.setQuantity(5);
			response.setStockAvailability(StockAvailabilityEnum.INSTOCK);
			return response;
		} else if (itemId.equalsIgnoreCase("Step Ladder") && !zipCode.equalsIgnoreCase("16243")) {
			response.setStockAvailability(StockAvailabilityEnum.ZIPCODENOTMATCH);
			response.setQuantity(0);
			return response;
		} else if (itemId.equalsIgnoreCase("Loft-Bed") && zipCode.equalsIgnoreCase("16243")) {
			response.setQuantity(10);
			response.setStockAvailability(StockAvailabilityEnum.INSTOCK);
			return response;
		} else if (itemId.equalsIgnoreCase("Loft-Bed") && !zipCode.equalsIgnoreCase("16243")) {
			response.setStockAvailability(StockAvailabilityEnum.ZIPCODENOTMATCH);
			response.setQuantity(0);
			return response;
		}

		// ViewItemAvailability itemAvailabilityDbRes = new ViewItemAvailability();
		ViewItemAvailability itemAvailabilityDbRes = viewItemAvailabilityRepo
				.findByItemIdAndToZipGreaterThanEqualAndFromZipLessThanEqual(itemId, zipCode, zipCode);

		if (itemAvailabilityDbRes != null) {
			if (itemAvailabilityDbRes.getQtyAvailable() > 0 && itemAvailabilityDbRes.getQtyAvailable() >= quantity) {
				response.setStockAvailability(StockAvailabilityEnum.INSTOCK);
			} else {
				response.setStockAvailability(StockAvailabilityEnum.OUTOFSTOCK);
			}
			response.setQuantity(itemAvailabilityDbRes.getQtyAvailable());
			response.setTimeSlot(itemAvailabilityDbRes.getTimeSlot());
		} else {
			response.setStockAvailability(StockAvailabilityEnum.ZIPCODENOTMATCH);
			response.setQuantity(0);
		}
		return response;
	}

	@Override
	public List<SearchItemResponse> getAllProductList() {

		List<SearchItemResponse> responseList = new ArrayList<>();
		List<ViewItemList> viewItemDbResponse = viewItemRepo.findAll();

		if (viewItemDbResponse != null && !viewItemDbResponse.isEmpty()) {
			for (ViewItemList item : viewItemDbResponse) {
				SearchItemResponse searchRes = new SearchItemResponse();

				searchRes.setId(item.getId());
				searchRes.setExtnTransportMethodType(item.getExtnTransportMethodType());
				searchRes.setItemPicture(item.getItemPicture());
				searchRes.setShortDescription(item.getShortDescription());
				searchRes.setOrganizationCode(item.getOrganizationCode());
				searchRes.setTitle(item.getTitle());
				searchRes.setUnitPrice(item.getUnitPrice());
				searchRes.setUnitPriceUom(item.getUnitPriceUom());
				searchRes.setUnitSalePrice(item.getUnitSalePrice());
				searchRes.setUom(item.getUom());

				responseList.add(searchRes);

			}
		} else {
			return null;
		}
		return responseList;
	}

}

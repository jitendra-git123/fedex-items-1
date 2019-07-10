package com.item.order.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.item.order.processing.entities.ViewItemAvailability;


/**
 * Spring Data JPA repository for the ProjectMetricsActiveSprint entity.
 */
@Repository
public interface ViewItemAvailabilityRepository extends JpaRepository<ViewItemAvailability,String> {

	ViewItemAvailability findByItemIdAndToZipGreaterThanEqualAndFromZipLessThanEqual(String itemId, String zipCode,
			String zipCode2);

}

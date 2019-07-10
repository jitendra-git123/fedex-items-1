package com.item.order.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.item.order.processing.entities.ViewItemList;


/**
 * Spring Data JPA repository for the ProjectMetricsActiveSprint entity.
 */
@Repository
public interface ViewItemListRepository extends JpaRepository<ViewItemList,Integer> {

}

package com.infinite.orders_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.orders_details.model.Order_Details;

@Repository
public interface Order_DetailsRepositoty extends JpaRepository<Order_Details, Long> {

}

package com.infinite.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.orders.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

}

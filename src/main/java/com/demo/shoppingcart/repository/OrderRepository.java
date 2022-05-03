package com.demo.shoppingcart.repository;

import com.demo.shoppingcart.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
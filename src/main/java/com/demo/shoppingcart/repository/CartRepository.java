package com.demo.shoppingcart.repository;

import com.demo.shoppingcart.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Query(value = "select * from dbo.CART where USER_ID= ?1 and PRDT_ID= ?2", nativeQuery = true)
    Cart findByUserIdAndPrdtId(String userId, String productId);
}

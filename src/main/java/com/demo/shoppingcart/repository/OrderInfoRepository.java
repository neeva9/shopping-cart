package com.demo.shoppingcart.repository;

import com.demo.shoppingcart.entity.OrderInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoRepository extends CrudRepository<OrderInfo, Integer> {

    @Query(value = "SELECT cart.CART_ID,user.FIRST_NAME, user.LAST_NAME, user.PHONE, user.EMAIL, " +
            "prod.NAME, prod.RATE, cart.QUANTITY, cart.TOTAL \n" +
            "FROM (DBO.CART cart\n" +
            "INNER JOIN DBO.PROFILE  user on user.profile_id = cart.profile_id and  user.profile_id= ?1)\n" +
            "INNER JOIN DBO.PRODUCT prod on prod.prdt_id = cart.prdt_id", nativeQuery = true)
    List<OrderInfo> findByProfileId(String userId);
}

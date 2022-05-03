package com.demo.shoppingcart.repository;

import com.demo.shoppingcart.entity.OrderInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoRepository extends CrudRepository<OrderInfo, Integer> {

    @Query(value = "SELECT\n" +
            "  cart.CART_ID,\n" +
            "  user.FIRST_NAME,\n" +
            "  user.LAST_NAME,\n" +
            "  user.PHONE,\n" +
            "  user.EMAIL,\n" +
            "  prod.NAME,\n" +
            "  prod.RATE,\n" +
            "  cart.QUANTITY,\n" +
            "  cart.TOTAL\n" +
            "FROM\n" +
            "  (\n" +
            "    DBO.CART cart\n" +
            "    INNER JOIN DBO.USER user on user.user_id = cart.user_id\n" +
            "    and user.user_id = ?) \n" +
            "  INNER JOIN DBO.PRODUCT prod on prod.prdt_id = cart.prdt_id", nativeQuery = true)
    List<OrderInfo> saveOrdersByUserId(String userId);

    @Query(value = "SELECT\n" +
            "  cart.CART_ID,\n" +
            "  user.FIRST_NAME,\n" +
            "  user.LAST_NAME,\n" +
            "  user.PHONE,\n" +
            "  user.EMAIL,\n" +
            "  prod.NAME,\n" +
            "  prod.RATE,\n" +
            "  cart.QUANTITY,\n" +
            "  cart.TOTAL\n" +
            "FROM\n" +
            "  (\n" +
            "    DBO.CART cart\n" +
            "    INNER JOIN DBO.USER user on user.user_id = cart.user_id\n" +
            "    and user.user_id = ?\n" +
            "  )\n" +
            "  INNER JOIN DBO.ORDERS orders on orders.cart_id = cart.cart_id\n" +
            "  INNER JOIN DBO.PRODUCT prod on prod.prdt_id = cart.prdt_id\n" +
            "\n", nativeQuery = true)
    List<OrderInfo> findOrdersByUserId(String userId);
}

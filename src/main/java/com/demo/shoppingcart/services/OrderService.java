package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.OrderDetail;
import com.demo.shoppingcart.entity.OrderInfo;
import com.demo.shoppingcart.entity.Orders;
import com.demo.shoppingcart.repository.OrderInfoRepository;
import com.demo.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private OrderRepository orderRepository;


    public List<OrderDetail> checkoutOrder(int userId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        List<OrderInfo> byProfileId = orderInfoRepository.findByProfileId(String.valueOf(userId));

        byProfileId.forEach(item -> {
            Orders orders = new Orders();
            orders.setCartId(item.getCartId());
            orders.setCreatedDate(ZonedDateTime.now());
            orderRepository.save(orders);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setName(item.getFirstName() + item.getLastName());
            orderDetail.setPhoneNo(item.getPhone());
            orderDetail.setEmail(item.getEmail());
            orderDetail.setProductName(item.getProdName());
            orderDetail.setProductRate(String.valueOf(item.getRate()));
            orderDetail.setProductQuantity(String.valueOf(item.getQuantity()));
            orderDetail.setCartTotal(String.valueOf(item.getTotal()));
            orderDetail.setCreatedDate(String.valueOf(ZonedDateTime.now()));
            orderDetails.add(orderDetail);
        });

        return orderDetails;
    }
}

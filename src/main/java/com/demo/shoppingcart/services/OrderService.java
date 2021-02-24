package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.OrderDetail;
import com.demo.shoppingcart.entity.OrderInfo;
import com.demo.shoppingcart.entity.Orders;
import com.demo.shoppingcart.exception.CartEmptyException;
import com.demo.shoppingcart.exception.OrderNotFoundException;
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

    public List<OrderDetail> checkoutOrder(String userId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            List<OrderInfo> byProfileId = orderInfoRepository.findByProfileId(String.valueOf(userId));

            byProfileId.forEach(item -> {
                Orders orders = new Orders();
                orders.setCartId(String.valueOf(item.getCartId()));
                orders.setCreatedDate(ZonedDateTime.now());
                orderRepository.save(orders);

                populateOrderDetails(orderDetails, item);
            });
        } catch (Exception e) {
            throw new OrderNotFoundException("Order Not Found");
        }
        if (orderDetails.isEmpty())
            throw new CartEmptyException("Cart is empty !!");
        return orderDetails;
    }

    private void populateOrderDetails(List<OrderDetail> orderDetails, OrderInfo item) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCartId(item.getCartId() != null ? String.valueOf(item.getCartId()) : null);
        orderDetail.setName(item.getFirstName() != null && item.getLastName() != null ? item.getFirstName() + ", " + item.getLastName() : null);
        orderDetail.setPhoneNo(item.getPhone() != null ? item.getPhone() : null);
        orderDetail.setEmail(item.getEmail() != null ? item.getEmail() : null);
        orderDetail.setProductName(item.getProdName() != null ? item.getProdName() : null);
        orderDetail.setProductRate(item.getRate() != null ? String.valueOf(item.getRate()) : null);
        orderDetail.setProductQuantity(item.getQuantity() != null ? String.valueOf(item.getQuantity()) : null);
        orderDetail.setCartTotal(item.getTotal() != null ? String.valueOf(item.getTotal()) : null);
        orderDetail.setCreatedDate(String.valueOf(ZonedDateTime.now()));
        orderDetails.add(orderDetail);
    }

}

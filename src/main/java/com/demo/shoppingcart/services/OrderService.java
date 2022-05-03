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
        return getOrderDetails(userId, "save");
    }

    private List<OrderDetail> getOrderDetails(String userId, String action) {
        List<OrderDetail> orderDetails = new ArrayList<>();
//        try {
        List<OrderInfo> byUserId = new ArrayList<>();
        if (action.equalsIgnoreCase("save"))
            byUserId = orderInfoRepository.saveOrdersByUserId(String.valueOf(userId));
        else if (action.equalsIgnoreCase("list"))
            byUserId = orderInfoRepository.findOrdersByUserId(String.valueOf(userId));

        if (byUserId.isEmpty())
            throw new OrderNotFoundException("Order Not Found for the User");
        byUserId.forEach(item -> {
            Orders orders = getOrders(item);
            if (action.equalsIgnoreCase("save"))
                orderRepository.save(orders);

            populateOrderDetails(orderDetails, item, action);
        });
//        } catch (Exception e) {
//            throw new OrderNotFoundException("Order Not Found");
//        }
        if (orderDetails.isEmpty() && action.equalsIgnoreCase("save"))
            throw new CartEmptyException("Cart is empty !!");
        if (orderDetails.isEmpty() && action.equalsIgnoreCase("list"))
            throw new OrderNotFoundException("Order Not Found for the User");
        return orderDetails;
    }

    private Orders getOrders(OrderInfo item) {
        Orders orders = new Orders();
        orders.setCartId(String.valueOf(item.getCartId()));
        orders.setCreatedDate(ZonedDateTime.now());
        return orders;
    }

    private void populateOrderDetails(List<OrderDetail> orderDetails, OrderInfo item, String action) {
        OrderDetail orderDetail = new OrderDetail();
        if (action.equalsIgnoreCase("save"))
            extracted(item, orderDetail);
        orderDetail.setUserName(item.getFirstName() != null && item.getLastName() != null ? item.getFirstName() + ", " + item.getLastName() : null);
        orderDetail.setProductName(item.getProdName() != null ? item.getProdName() : null);
        orderDetail.setProductRate(item.getRate() != null ? String.valueOf(item.getRate()) : null);
        orderDetail.setProductQuantity(item.getQuantity() != null ? String.valueOf(item.getQuantity()) : null);
        orderDetail.setCartTotal(item.getTotal() != null ? String.valueOf(item.getTotal()) : null);
        orderDetails.add(orderDetail);
    }

    private void extracted(OrderInfo item, OrderDetail orderDetail) {
        orderDetail.setCartId(item.getCartId() != null ? String.valueOf(item.getCartId()) : null);
        orderDetail.setPhoneNo(item.getPhone() != null ? item.getPhone() : null);
        orderDetail.setEmail(item.getEmail() != null ? item.getEmail() : null);
        orderDetail.setCreatedDate(String.valueOf(ZonedDateTime.now()));
    }

    public List<OrderDetail> listOfOrders(String userId) {
        return getOrderDetails(userId, "list");
    }
}

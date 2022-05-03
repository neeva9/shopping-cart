package com.demo.shoppingcart.controllers;

import com.demo.shoppingcart.controllers.data.OrderDetail;
import com.demo.shoppingcart.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/v1", tags = "Order Details")
@RestController
@RequestMapping(value = "/v1/order", produces = "application/json")
public class OrderDetailsController {

    private final OrderService orderService;


    public OrderDetailsController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Place order for user",
            response = OrderDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("{userId}")
    public ResponseEntity<List<OrderDetail>> checkoutOrder(@PathVariable String userId) {

        List<OrderDetail> orderDetails = orderService.checkoutOrder(userId);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @ApiOperation(value = "Orders placed by user in descending order",
            response = OrderDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("{userId}")
    public ResponseEntity<List<OrderDetail>> orderDetail(@PathVariable String userId) {

        List<OrderDetail> orderDetails = orderService.listOfOrders(userId);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

}

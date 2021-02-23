package com.demo.shoppingcart.controllers;

import com.demo.shoppingcart.controllers.data.CartDetail;
import com.demo.shoppingcart.controllers.data.CartRequest;
import com.demo.shoppingcart.controllers.data.OrderDetail;
import com.demo.shoppingcart.services.CartService;
import com.demo.shoppingcart.services.OrderService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/v1", tags = "Product Details")
@RestController
@RequestMapping(value = "/v1/order", produces = "application/json")
public class OrderController {

    private OrderService orderService;


    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Obtain list of Product details",
            response = OrderDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("{userId}")
    public ResponseEntity<List<OrderDetail>> checkoutOrder(@PathVariable int userId) {

        List<OrderDetail> orderDetails = orderService.checkoutOrder(userId);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

}

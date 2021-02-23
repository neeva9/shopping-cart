package com.demo.shoppingcart.controllers;

import com.demo.shoppingcart.controllers.data.CartDetail;
import com.demo.shoppingcart.controllers.data.CartRequest;
import com.demo.shoppingcart.controllers.data.UserDetail;
import com.demo.shoppingcart.services.CartService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/v1", tags = "Product Details")
@RestController
@RequestMapping(value = "/v1/cart", produces = "application/json")
public class CartController {

    private CartService cartService;


    public CartController(final CartService cartService) {
        this.cartService = cartService;
    }

    @ApiOperation(value = "Obtain list of Product details",
            response = CartDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(value = "/upsert")
    public ResponseEntity<List<CartDetail>> addProduct(
            @ApiParam(value = "User Id", required = true)
            @RequestHeader(value = "userId", required = true) String userId,
            @RequestBody @Validated List<CartRequest> cartRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors() || userId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<CartDetail> cartDetails = cartService.addProductToCart(userId, cartRequest);
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }

    @DeleteMapping("/cart/{id}")
    void deleteEmployee(@PathVariable int id) {
        cartService.removeProductFromCart(id);
    }
}

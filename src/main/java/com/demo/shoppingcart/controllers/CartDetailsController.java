package com.demo.shoppingcart.controllers;

import com.demo.shoppingcart.controllers.data.CartDetail;
import com.demo.shoppingcart.controllers.data.CartRequest;
import com.demo.shoppingcart.exception.InvalidRequestException;
import com.demo.shoppingcart.services.CartService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/v1", tags = "Cart Details")
@RestController
@RequestMapping(value = "/v1/cart", produces = "application/json")
public class CartDetailsController {

    private final CartService cartService;


    public CartDetailsController(final CartService cartService) {
        this.cartService = cartService;
    }

    @ApiOperation(value = "Add or update product to cart",
            response = CartDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(value = "/upsert")
    public ResponseEntity<List<CartDetail>> addProduct(
            @ApiParam(value = "User Id", required = true)
            @RequestHeader(value = "userId") String userId,
            @RequestBody @Validated List<CartRequest> cartRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors() || userId.isEmpty() || userId == null || cartRequest.isEmpty()) {
            throw new InvalidRequestException("Invalid Request");
        }
        validateListRequest(cartRequest);
        List<CartDetail> cartDetails = cartService.addProductToCart(userId, cartRequest);
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }

    private void validateListRequest(List<CartRequest> cartRequest) {
        boolean distinctProdId = cartRequest.size() > 1 && cartRequest.stream().map(CartRequest::getProductId).distinct().count() == 1;
        if (distinctProdId) {
            throw new InvalidRequestException("Product Id should be unique for each item to be added or updated to cart");
        }
        cartRequest.forEach(item -> {
            if ((item.getProductId() == null || item.getQuantity() == null)) {
                throw new InvalidRequestException("Invalid Request");
            }
            if (item.getQuantity() != null && item.getQuantity() == 0)
                throw new InvalidRequestException("Invalid Request");
        });

    }

    @ApiOperation(value = "Delete cart details")
    @DeleteMapping("/{cartId}")
    void deleteCrt(@PathVariable int cartId) {
        cartService.removeProductFromCart(cartId);
    }
}

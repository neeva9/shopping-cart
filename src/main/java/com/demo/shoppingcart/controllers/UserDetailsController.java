package com.demo.shoppingcart.controllers;

import com.demo.shoppingcart.controllers.data.UserDetail;
import com.demo.shoppingcart.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/v1", tags = "Product Details")
@RestController
@RequestMapping(value = "/v1/user", produces = "application/json")
public class UserDetailsController {

    private UserService userService;


    public UserDetailsController(final UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Obtain list of Product details",
            response = UserDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping()
    public ResponseEntity<List<UserDetail>> getProducts() {
        List<UserDetail> productDetails = userService.getUserDetails();
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

}

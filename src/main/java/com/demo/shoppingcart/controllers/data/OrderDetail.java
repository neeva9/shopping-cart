package com.demo.shoppingcart.controllers.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Order Details
 */
@Data
@Getter
public class OrderDetail {

    @ApiModelProperty(notes = "Cart Id", example = "123")
    private String cartId;

    @ApiModelProperty(notes = "User Name", example = "123")
    private String name;

    @ApiModelProperty(notes = "User PhoneNo", example = "123")
    private String phoneNo;

    @ApiModelProperty(notes = "User Email", example = "123")
    private String email;

    @ApiModelProperty(notes = "Product Name in Order", example = "ABC, BCD")
    private String productName;

    @ApiModelProperty(notes = "Product Quantity", example = "ABC Description")
    private String productQuantity;

    @ApiModelProperty(notes = "Product Rate", example = "ABC Description")
    private String productRate;

    @ApiModelProperty(notes = "Order Total", example = "500")
    private String cartTotal;

    @ApiModelProperty(notes = "Order Created Date")
    private String createdDate;

}

package com.demo.shoppingcart.controllers.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class OrderDetail {

    @ApiModelProperty(notes = "Cart Id", example = "1")
    private String name;

    @ApiModelProperty(notes = "User Id", example = "ABC Item")
    private String phoneNo;

    @ApiModelProperty(notes = "Product Id", example = "ABC Item")
    private String email;

    @ApiModelProperty(notes = "Cart Total", example = "ABC Description")
    private String productName;

    @ApiModelProperty(notes = "Cart Total", example = "ABC Description")
    private String productQuantity;

    @ApiModelProperty(notes = "Cart Total", example = "ABC Description")
    private String productRate;

    @ApiModelProperty(notes = "Cart Total", example = "ABC Description")
    private String cartTotal;

    @ApiModelProperty(notes = "Product Rate", example = "10.65")
    private String createdDate;

}

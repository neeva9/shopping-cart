package com.demo.shoppingcart.controllers.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CartDetail {

    @ApiModelProperty(notes = "Cart Id", example = "1")
    private String cartId;

    @ApiModelProperty(notes = "User Id", example = "ABC Item")
    private String userId;

    @ApiModelProperty(notes = "Product Id", example = "ABC Item")
    private String productId;

    @ApiModelProperty(notes = "Cart Total", example = "ABC Description")
    private String total;

    @ApiModelProperty(notes = "Product Rate", example = "10.65")
    private String createdDate;

    @ApiModelProperty(notes = "Product Rate", example = "10.65")
    private String updatedDate;

}

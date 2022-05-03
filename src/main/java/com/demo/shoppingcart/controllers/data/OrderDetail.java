package com.demo.shoppingcart.controllers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Order Details
 */
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetail {

    @ApiModelProperty(notes = "Cart Id", example = "123")
    private String cartId;

    @ApiModelProperty(notes = "User Name", example = "123")
    private String userName;

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

package com.demo.shoppingcart.controllers.data;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Cart Request
 */
@Data
@Getter
public class CartRequest {

    @ApiModelProperty(notes = "Product Id", example = "123")
    @NotNull
    private String productId;

    @ApiModelProperty(notes = "Quantity of Product", example = "5")
    @NotNull
    private Integer quantity;

}

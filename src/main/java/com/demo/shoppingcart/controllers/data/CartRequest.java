package com.demo.shoppingcart.controllers.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CartRequest {

    @ApiModelProperty(notes = "Product Id", example = "1")
    private String productId;

    @ApiModelProperty(notes = "Quantity of Product", example = "5")
    private String quantity;

}

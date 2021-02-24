package com.demo.shoppingcart.controllers.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Order Request
 */
@Data
@Getter
public class OrderRequest {

    @ApiModelProperty(notes = "Product Id", example = "123")
    private String cartId;

    @ApiModelProperty(notes = "Quantity of Product", example = "5")
    private String quantity;

}

package com.demo.shoppingcart.controllers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Order Request
 */
@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest {

    @ApiModelProperty(notes = "Product Id", example = "123")
    private String cartId;

    @ApiModelProperty(notes = "Quantity of Product", example = "5")
    private String quantity;

}

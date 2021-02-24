package com.demo.shoppingcart.controllers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Product Details
 */
@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDetail {

    @ApiModelProperty(notes = "Product Id", example = "123")
    private String productId;

    @ApiModelProperty(notes = "Product Name", example = "ABC Item")
    private String productName;

    @ApiModelProperty(notes = "Product Description", example = "ABC Description")
    private String productDescrpt;

    @ApiModelProperty(notes = "Product Rate", example = "10.65")
    private Double productRate;

}

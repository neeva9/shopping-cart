package com.demo.shoppingcart.controllers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * Cart Details
 */
@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDetail {

    @ApiModelProperty(notes = "Cart Id", example = "123")
    private String cartId;

    @ApiModelProperty(notes = "User Id", example = "123")
    private String userId;

    @ApiModelProperty(notes = "Product Id", example = "123")
    private String productId;

    @ApiModelProperty(notes = "Cart Total", example = "100")
    private String total;

    @ApiModelProperty(notes = "Cart Created Date")
    private String createdDate;

    @ApiModelProperty(notes = "Cart Updated Date")
    private String updatedDate;

}

package com.demo.shoppingcart.controllers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDetail {

    @ApiModelProperty(notes = "Profile Id", example = "1")
    private String profileId;

    @ApiModelProperty(notes = "First Name", example = "ABC")
    private String firstName;

    @ApiModelProperty(notes = "Product Description", example = "ABC Description")
    private String lastName;

    @ApiModelProperty(notes = "Phone Number", example = "1234567890")
    private String phoneNo;

    @ApiModelProperty(notes = "Email Addres", example = "abc.email@test.com")
    private String email;

}

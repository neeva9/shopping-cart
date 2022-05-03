package com.demo.shoppingcart.controllers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User Details
 */
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDetail {

    @ApiModelProperty(notes = "User Id", example = "1")
    private String userId;

    @ApiModelProperty(notes = "First Name", example = "ABC")
    private String firstName;

    @ApiModelProperty(notes = "Last Name", example = "XYZ")
    private String lastName;

    @ApiModelProperty(notes = "Phone Number", example = "1234567890")
    private String phoneNo;

    @ApiModelProperty(notes = "Email Address", example = "abc.email@test.com")
    private String email;

}

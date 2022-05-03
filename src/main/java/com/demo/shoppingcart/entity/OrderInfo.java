package com.demo.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity object for Order details.
 */
@Entity
@Table(name = "ORDER_INFO", schema = "dbo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {


    @Id
    @Column(name = "CART_ID")
    private Integer cartId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String prodName;

    @Column(name = "RATE")
    private Double rate;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "TOTAL")
    private Double total;

}
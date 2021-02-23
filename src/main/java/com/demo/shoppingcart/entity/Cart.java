package com.demo.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Entity object for Cart details.
 */
@Entity
@Table(name = "CART", schema = "dbo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @PrePersist
    public void prePersist() {
        createdDate = ZonedDateTime.now();
    }

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column(name = "PROFILE_ID")
    private Integer profileId;

    @Column(name = "PRDT_ID")
    private Integer productId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    private ZonedDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    private ZonedDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "PROFILE_ID", insertable = false, updatable = false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRDT_ID", referencedColumnName = "PRDT_ID", insertable = false, updatable = false)
    private Product product;

}

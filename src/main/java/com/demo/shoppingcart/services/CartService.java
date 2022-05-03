package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.CartDetail;
import com.demo.shoppingcart.controllers.data.CartRequest;
import com.demo.shoppingcart.entity.Cart;
import com.demo.shoppingcart.entity.Product;
import com.demo.shoppingcart.entity.User;
import com.demo.shoppingcart.exception.CartNotFoundException;
import com.demo.shoppingcart.exception.ProductNotFoundException;
import com.demo.shoppingcart.exception.UserNotFoundException;
import com.demo.shoppingcart.repository.CartRepository;
import com.demo.shoppingcart.repository.ProductRepository;
import com.demo.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    public List<CartDetail> addProductToCart(String userId, List<CartRequest> cartRequestList) {
        Optional<User> user = validateUserDetails(userId);
        List<Cart> cartList = new ArrayList<>();
        List<CartDetail> cartDetails = new ArrayList<>();
        for (CartRequest cartRequest : cartRequestList) {
            populateCart(user, cartRequest, cartList);
        }

        cartList.forEach(cart -> {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartId(String.valueOf(cart.getCartId()));
            cartDetail.setUserId(cart.getUserId().toString());
            cartDetail.setProductId(cart.getProductId().toString());
            cartDetail.setTotal(String.valueOf(cart.getTotal()));
            cartDetail.setCreatedDate(String.valueOf(cart.getCreatedDate()));
            cartDetail.setUpdatedDate(cart.getUpdatedDate() != null ? String.valueOf(cart.getUpdatedDate()) : null);
            cartDetails.add(cartDetail);
        });
        return cartDetails;
    }

    private List<Cart> populateCart(Optional<User> userId, CartRequest cartRequest, List<Cart> cartList) {
        Optional<Product> productRepositoryById = productRepository.findById(Integer.parseInt(cartRequest.getProductId()));
        if (productRepositoryById.isPresent()) {
            Cart existingCart = cartRepository.findByUserIdAndPrdtId(userId.get().getUserId().toString(), productRepositoryById.get().getProductId().toString());

            if (existingCart == null) {

                Cart cart = new Cart();
                cart.setProductId(productRepositoryById.get().getProductId());
                cart.setUserId(userId.get().getUserId());
                cart.setQuantity(Integer.valueOf(cartRequest.getQuantity()));
                cart.setTotal(Double.valueOf(Math.round(Integer.valueOf(cartRequest.getQuantity()) * productRepositoryById.get().getRate())));
                cartList.add(cartRepository.save(cart));

            } else {
                existingCart.setQuantity(Integer.valueOf(cartRequest.getQuantity()));
                existingCart.setTotal(Double.valueOf(Math.round(Integer.valueOf(cartRequest.getQuantity()) * productRepositoryById.get().getRate())));
                existingCart.setUpdatedDate(ZonedDateTime.now());
                cartList.add(cartRepository.save(existingCart));
            }


        } else {
            throw new ProductNotFoundException("Product Not Found");
        }
        return cartList;
    }

    private Optional<User> validateUserDetails(String userId) {
        Optional<User> userRepositoryById = userRepository.findById(Integer.valueOf(userId));
        if (userRepositoryById.isPresent()) {
            return userRepositoryById;
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }

    public void removeProductFromCart(int cartId) {
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception e) {
            throw new CartNotFoundException("Cart Not Found");
        }
    }
}

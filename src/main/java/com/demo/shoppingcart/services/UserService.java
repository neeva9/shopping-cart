package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.ProductDetail;
import com.demo.shoppingcart.controllers.data.UserDetail;
import com.demo.shoppingcart.entity.Product;
import com.demo.shoppingcart.entity.Profile;
import com.demo.shoppingcart.repository.ProductRepository;
import com.demo.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository  userRepository;


    public List<UserDetail> getUserDetails() {
        List<UserDetail> userDetails = new ArrayList<>();
        Iterable<Profile> products = userRepository.findAll();
        products.forEach(profile -> {
            UserDetail userDetail = new UserDetail();
            userDetail.setProfileId(String.valueOf(profile.getProfileId()));
            userDetail.setFirstName(profile.getFirstName());
            userDetail.setLastName(profile.getLastName());
            userDetail.setPhoneNo(profile.getPhone());
            userDetail.setEmail(profile.getEmail());
            userDetails.add(userDetail);
        });
        return userDetails;
    }
}

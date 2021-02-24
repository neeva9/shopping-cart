package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.UserDetail;
import com.demo.shoppingcart.entity.Profile;
import com.demo.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserDetail> getUserDetails() {
        List<UserDetail> userDetails = new ArrayList<>();
        Iterable<Profile> products = userRepository.findAll();
        products.forEach(profile -> {
            UserDetail userDetail = new UserDetail();
            userDetail.setProfileId(profile.getProfileId() != null ? String.valueOf(profile.getProfileId()) : null);
            userDetail.setFirstName(profile.getFirstName() != null ? profile.getFirstName() : null);
            userDetail.setLastName(profile.getLastName() != null ? profile.getLastName() : null);
            userDetail.setPhoneNo(profile.getPhone() != null ? profile.getPhone() : null);
            userDetail.setEmail(profile.getEmail() != null ? profile.getEmail() : null);
            userDetails.add(userDetail);
        });
        return userDetails;
    }
}

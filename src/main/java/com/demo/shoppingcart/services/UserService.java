package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.UserDetail;
import com.demo.shoppingcart.entity.User;
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
        Iterable<User> users = userRepository.findAll();
        users.forEach(user -> {
            UserDetail userDetail = new UserDetail();
            userDetail.setUserId(user.getUserId() != null ? String.valueOf(user.getUserId()) : null);
            userDetail.setFirstName(user.getFirstName() != null ? user.getFirstName() : null);
            userDetail.setLastName(user.getLastName() != null ? user.getLastName() : null);
            userDetail.setPhoneNo(user.getPhone() != null ? user.getPhone() : null);
            userDetail.setEmail(user.getEmail() != null ? user.getEmail() : null);
            userDetails.add(userDetail);
        });
        return userDetails;
    }
}

package com.demo.shoppingcart.repository;

import com.demo.shoppingcart.entity.Product;
import com.demo.shoppingcart.entity.Profile;
import org.h2.engine.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Profile, Integer> {

}

package com.demo.shoppingcart.services;

import com.demo.shoppingcart.controllers.data.ProductDetail;
import com.demo.shoppingcart.entity.Product;
import com.demo.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<ProductDetail> getProductDetails() {
        List<ProductDetail> productDetails = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(product -> {
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProductId(product.getProductId() != null ? String.valueOf(product.getProductId()) : null);
            productDetail.setProductName(product.getName() != null ? product.getName() : null);
            productDetail.setProductDescrpt(product.getDescription()!=null?product.getDescription():null);
            productDetail.setProductRate(product.getRate()!=null?product.getRate():null);

            productDetails.add(productDetail);
        });
        return productDetails;
    }
}

package com.pratap.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pratap.springcloud.dto.Coupon;
import com.pratap.springcloud.model.Product;
import com.pratap.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/prodcutapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceURL;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {

		Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(),
				Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repository.save(product);
	}
}

package com.dodunghoctap.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodunghoctap.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

}

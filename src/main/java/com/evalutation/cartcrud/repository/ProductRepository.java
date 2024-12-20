package com.evalutation.cartcrud.repository;

import com.evalutation.cartcrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

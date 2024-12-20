package com.evalutation.cartcrud.services;

import com.evalutation.cartcrud.model.Product;
import com.evalutation.cartcrud.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();

    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));

    }

    public void deleteProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("product not found");
        }
    }

    public Product updateProduct(Long id, Product product){

        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        return productRepository.save(existingProduct);
    }



}

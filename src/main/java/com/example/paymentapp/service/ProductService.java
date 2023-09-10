package com.example.paymentapp.service;

import com.example.paymentapp.dto.ProductDto;
import com.example.paymentapp.dto.request.ProductRequest;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long id);

    void saveProduct(ProductRequest productRequest);

    void updateProduct(ProductRequest productRequest);

    List<ProductDto> getAll();

    void deleteProductById(Long id);




}

package com.example.paymentapp.service.impl;

import com.example.paymentapp.dto.ProductDto;
import com.example.paymentapp.dto.request.ProductRequest;
import com.example.paymentapp.model.Product;
import com.example.paymentapp.repository.ProductRepository;
import com.example.paymentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    @Override
    public ProductDto getProductById(Long id) {

        Product product = productRepository.getProductById(id);
        return ProductDto.builder()
                .name(product.getName())
                .desc(product.getDesc())
                .SKU(product.getSKU())
                .category(product.getCategory())
                .modifiedAt(product.getModifiedAt())
                .createdAt(product.getCreatedAt())
                .build();
    }

    @Override
    public void saveProduct(ProductRequest productRequest) {

        productRepository.save(
                Product.builder()
                        .name(productRequest.getName())
                        .desc(productRequest.getDesc())
                        .SKU(productRequest.getSKU())
                        .category(productRequest.getCategory())
                        .modifiedAt(productRequest.getModifiedAt())
                        .createdAt(productRequest.getModifiedAt())
                        .build()
        );

    }

    @Override
    public void updateProduct(ProductRequest productRequest) {

        Product product =  Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .desc(productRequest.getDesc())
                .SKU(productRequest.getSKU())
                .category(productRequest.getCategory())
                .modifiedAt(productRequest.getModifiedAt())
                .createdAt(productRequest.getCreatedAt())
                .build();

        productRepository.save(product);

    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product : products){

            ProductDto productDto = ProductDto.builder()
                    .name(product.getName())
                    .desc(product.getDesc())
                    .SKU(product.getSKU())
                    .category(product.getCategory())
                    .modifiedAt(product.getModifiedAt())
                    .createdAt(product.getCreatedAt())

                    .build();

        }
        return productDtos;
    }

    @Override
    public void deleteProductById(Long id) {

        Product product = productRepository.getProductById(id);

        productRepository.deleteById(id);

    }
}

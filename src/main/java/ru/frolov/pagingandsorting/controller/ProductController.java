package ru.frolov.pagingandsorting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.frolov.pagingandsorting.dto.APIResponse;
import ru.frolov.pagingandsorting.entity.Product;
import ru.frolov.pagingandsorting.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = this.service.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }
}

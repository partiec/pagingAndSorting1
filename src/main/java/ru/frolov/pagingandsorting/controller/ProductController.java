package ru.frolov.pagingandsorting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable("field") String field) {
        List<Product> allProducts = this.service.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithPagination(
            @PathVariable int offset,
            @PathVariable int pageSize) {

        Page<Product> productsWithPagination = this.service.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(
            @PathVariable int offset,
            @PathVariable int pageSize,
            @PathVariable String field) {

        Page<Product> productsWithPagination = this.service.findProductsWithPaginationAndSorting(offset,pageSize,field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}

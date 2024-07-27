package ru.frolov.pagingandsorting.service;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.frolov.pagingandsorting.entity.Product;
import ru.frolov.pagingandsorting.repository.ProductRepository;

import java.util.List;

@Service
@Data
public class ProductService {

    private final ProductRepository repository;

//    @PostConstruct
//    public void initDB() {
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new BigDecimal(new Random().nextDouble(100))))
//                .collect(Collectors.toList());
//        repository.saveAll(products);
//    }

    public List<Product> findAllProducts() {
        return this.repository.findAll();
    }

    public List<Product> findProductsWithSorting(String field) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Product> findProductsWithPagination(int offset, int pageSize) {
        Page<Product> products = this.repository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Product> products = this.repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }
}

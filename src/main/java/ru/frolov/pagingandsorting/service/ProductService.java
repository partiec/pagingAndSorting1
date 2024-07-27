package ru.frolov.pagingandsorting.service;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.frolov.pagingandsorting.entity.Product;
import ru.frolov.pagingandsorting.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Data
public class ProductService {

    private final ProductRepository repository;

    @PostConstruct
    public void initDB() {
        List<Product> products = IntStream.rangeClosed(1, 200)
                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new BigDecimal(new Random().nextDouble(100))))
                .collect(Collectors.toList());
        repository.saveAll(products);
    }

    public List<Product> findAllProducts() {
        return this.repository.findAll();
    }
}

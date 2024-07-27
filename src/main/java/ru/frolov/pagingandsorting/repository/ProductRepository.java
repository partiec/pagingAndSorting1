package ru.frolov.pagingandsorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.frolov.pagingandsorting.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

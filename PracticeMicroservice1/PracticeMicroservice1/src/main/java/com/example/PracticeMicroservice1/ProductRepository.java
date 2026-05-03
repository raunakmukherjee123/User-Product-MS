package com.example.PracticeMicroservice1;

import com.example.PracticeMicroservice1.projections.ProductProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query()
    ProductProjections findProduct();
}

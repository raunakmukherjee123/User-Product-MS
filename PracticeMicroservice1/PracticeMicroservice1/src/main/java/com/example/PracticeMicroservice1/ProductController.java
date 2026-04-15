package com.example.PracticeMicroservice1;

import com.example.PracticeMicroservice1.OpenFeignClient.ProviderFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProviderFeignClient providerFeignClient;

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        productService.add(productRequestDto);
        return "Product added";
    }

    @GetMapping("/all/user")
    public PageResponse<?> getAllUser(){
        return providerFeignClient.getAllUser(0,4,"id");
    }
}

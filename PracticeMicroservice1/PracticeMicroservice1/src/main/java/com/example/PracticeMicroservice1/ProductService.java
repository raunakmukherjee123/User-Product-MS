package com.example.PracticeMicroservice1;

import com.example.PracticeMicroservice1.RestTemplate.RestTemplateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final RestTemplateClient restTemplateClient;


    public void add(ProductRequestDto productRequestDto) {
//     User user= restTemplate.getForObject("http://localhost:8080/api/user/name/"+productRequestDto.getUserName(), User.class);
        User user=restTemplateClient.getUser(productRequestDto.getUserName());
     Product product=new Product();
     product.setName(productRequestDto.getProductName());
        product.setUserId(user.getId());
        productRepository.save(product);
    }
}

package com.example.PracticeMicroservice1;

import com.example.PracticeMicroservice1.RestTemplate.RestTemplateClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final RestTemplateClient restTemplateClient;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

//@CircuitBreaker(name = "userService",fallbackMethod = "addProductFallback")
//@Retry(name = "retryBreaker",fallbackMethod = "addProductFallback")
@RateLimiter(name = "rateBreaker",fallbackMethod = "addProductFallback")
    public void add(ProductRequestDto productRequestDto) {
//     User user= restTemplate.getForObject("http://localhost:8080/api/user/name/"+productRequestDto.getUserName(), User.class);
        User user=restTemplateClient.getUser(productRequestDto.getUserName());
     Product product=new Product();
     product.setName(productRequestDto.getProductName());
        product.setUserId(user.getId());
        Product savedProduct=productRepository.save(product);
//        rabbitTemplate
//                .convertAndSend(exchangeName,routingKey, Map.of("productId",savedProduct.getId()));

    rabbitTemplate.convertAndSend(exchangeName, routingKey, "test message");
    }

    // parameters of fallback method should be same as the method in which we implement it + Exception
    public void addProductFallback(ProductRequestDto productRequestDto,Exception e)
    {
        System.out.println("FALLBACK CALLED");

       // return "User service not working";
    }
}

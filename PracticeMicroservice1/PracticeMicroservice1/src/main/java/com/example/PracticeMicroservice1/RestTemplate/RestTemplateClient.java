package com.example.PracticeMicroservice1.RestTemplate;

import com.example.PracticeMicroservice1.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {
    private final RestTemplate restTemplate;
    private static final String baseurl="http://PracticeMicroservice";

    public User getUser(String name)
    {
        User user= restTemplate
                .getForObject(baseurl+"/api/user/name/"+name, User.class);

        return user;
    }
}

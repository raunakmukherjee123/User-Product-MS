package com.example.PracticeMicroservice1.OpenFeignClient;

import com.example.PracticeMicroservice1.PageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PracticeMicroservice")
public interface ProviderFeignClient {

    @GetMapping("/api/user/all")
    public PageResponse<?> getAllUser(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy
    );
}

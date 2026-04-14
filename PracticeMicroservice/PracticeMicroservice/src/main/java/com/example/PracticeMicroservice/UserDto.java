package com.example.PracticeMicroservice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {
    private String name;
    private Integer age;
}

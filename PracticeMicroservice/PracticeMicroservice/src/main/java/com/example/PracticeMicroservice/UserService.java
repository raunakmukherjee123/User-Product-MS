package com.example.PracticeMicroservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
    }

    public UserDto getUserById(Integer id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No user found with this id"));

        return UserDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    public User findByName(String name) {
        User user= userRepository.findByName(name);
        if(user==null)
        {
            throw new RuntimeException("no user found");
        }
        return user;
    }

    public PageResponse<?> getAllUser(int pageNo,int pageSize,String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<User> userPage=userRepository.findAll(pageable);
        List<User> users=userPage.getContent();

        return PageResponse.<List<User>>builder()
                .totalPages(userPage.getTotalPages())
                .content(users)
                .isLastPage(userPage.isLast())
                .pageNumber(userPage.getNumber())
                .pageSize(userPage.getSize())
                .totalElements(userPage.getTotalElements())
                .build();
    }

    public void updateName(Integer id,UserName userName) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No user found"));

        user.setName(userName.getName());

        userRepository.save(user);
    }
}

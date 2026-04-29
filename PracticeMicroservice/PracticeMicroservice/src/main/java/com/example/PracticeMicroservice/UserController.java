package com.example.PracticeMicroservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {
        userService.add(user);
        return "User added";
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public User findUserByName(@PathVariable("name") String name)
    {
        return userService.findByName(name);
    }
    @GetMapping("/all")
    public PageResponse<?> getAllUser(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy
    )
    {
        return userService.getAllUser(pageNo,pageSize,sortBy);
    }

    @PatchMapping("/update/{id}")
    public void updateName(@PathVariable("id") Integer id,@RequestBody UserName userName)
    {
        userService.updateName(id,userName);
    }
}

package com.burakyildiz.springboot.controllers;

import com.burakyildiz.springboot.dto.UserDto;
import com.burakyildiz.springboot.entities.User;
import com.burakyildiz.springboot.exceptions.ProductNotFoundException;
import com.burakyildiz.springboot.exceptions.UserNotFoundException;
import com.burakyildiz.springboot.mapper.UserMapper;
import com.burakyildiz.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    //[GET] https://localhost:8080/api/users/
    @GetMapping("")
    public List<UserDto>findAll() {
        List<User> userList = userService.findAll();

        //Sistemde hiç kullanıcı yoksa
        if (userList.size() == 0) {
            throw new UserNotFoundException("There are no user!");
        }

        List<UserDto> userDtoList = UserMapper.INSTANCE.convertAllUserListToUserDtoList(userList);

        return userDtoList;

    }

    //[GET] https://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    //[POST] https://localhost:8080/api/users/
    @PostMapping("")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {

        User user = UserMapper.INSTANCE.convertUserDtoToUser(userDto);

        user = userService.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}

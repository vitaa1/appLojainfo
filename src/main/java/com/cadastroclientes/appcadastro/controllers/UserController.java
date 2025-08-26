package com.cadastroclientes.appcadastro.controllers;

import com.cadastroclientes.appcadastro.dto.UserDto;
import com.cadastroclientes.appcadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private  UserService service;

    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody UserDto userDto) {
        UserDto savedUser = service.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userdto = service.getUserId(userId);
        return ResponseEntity.ok(userdto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDto updateUser) {
        UserDto userDto = service.updateUser(userId, updateUser);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        service.deleteUser(userId);
        return ResponseEntity.ok("Usuario deletado com sucesso");
    }
}

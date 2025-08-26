package com.cadastroclientes.appcadastro.service;

import com.cadastroclientes.appcadastro.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserId(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updateUser);

    void  deleteUser(Long userId);
}

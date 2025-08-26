package com.cadastroclientes.appcadastro.mapper;

import com.cadastroclientes.appcadastro.dto.UserDto;
import com.cadastroclientes.appcadastro.domain.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getNome(),
                user.getSobrenome()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getNome(),
                userDto.getSobrenome()
        );
    }
}

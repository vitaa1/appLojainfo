package com.cadastroclientes.appcadastro.service.impl;

import com.cadastroclientes.appcadastro.dto.UserDto;
import com.cadastroclientes.appcadastro.domain.User;
import com.cadastroclientes.appcadastro.exception.ResourceNotFoundException;
import com.cadastroclientes.appcadastro.mapper.UserMapper;
import com.cadastroclientes.appcadastro.repository.UserRepository;
import com.cadastroclientes.appcadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = repository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserId(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("usuario com esse id nao foi encontrado " + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updateUser) {
        User user = repository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("usuario com esse id nao existe " + userId)
        );
        user.setNome(updateUser.getNome());
        user.setSobrenome(updateUser.getSobrenome());

        User updateUserObj = repository.save(user);
        return UserMapper.mapToUserDto(updateUserObj);
    }

    @Override
    public void  deleteUser(Long userId) {
        User user = repository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("usuario com esse id nao existe " + userId)
        );
        repository.deleteById(userId);;
    }
}

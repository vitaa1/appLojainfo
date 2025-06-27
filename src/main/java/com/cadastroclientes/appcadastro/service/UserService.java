package com.cadastroclientes.appcadastro.service;

import com.cadastroclientes.appcadastro.domain.User;
import com.cadastroclientes.appcadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User insert (User obj) {
        return repository.save(obj);
    }

    public void deleteById (Long id) {
         repository.deleteById(id);
    }

    public User update (User obj, Long id) {
       User entity = repository.getReferenceById(id);
       updateUser(entity, obj);
       return repository.save(entity);
    }

    private void updateUser (User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setSobrenome(obj.getSobrenome());
    }
}

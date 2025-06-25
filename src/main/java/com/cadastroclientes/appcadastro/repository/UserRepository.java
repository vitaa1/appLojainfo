package com.cadastroclientes.appcadastro.repository;

import com.cadastroclientes.appcadastro.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

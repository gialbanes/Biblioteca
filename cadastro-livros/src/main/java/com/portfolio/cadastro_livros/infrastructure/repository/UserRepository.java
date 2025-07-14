package com.portfolio.cadastro_livros.infrastructure.repository;

import com.portfolio.cadastro_livros.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

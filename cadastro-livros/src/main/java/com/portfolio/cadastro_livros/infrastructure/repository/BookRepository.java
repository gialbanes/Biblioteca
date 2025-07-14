package com.portfolio.cadastro_livros.infrastructure.repository;

import com.portfolio.cadastro_livros.infrastructure.entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> { // o JPA já possui métodos prontos para o CRUD

}

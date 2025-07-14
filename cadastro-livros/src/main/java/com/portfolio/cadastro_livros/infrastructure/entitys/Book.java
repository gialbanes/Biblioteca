package com.portfolio.cadastro_livros.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o ID automaticamente
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private int year;
    private String genre;
}


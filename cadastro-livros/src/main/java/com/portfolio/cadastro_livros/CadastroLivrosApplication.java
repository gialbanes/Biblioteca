package com.portfolio.cadastro_livros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.portfolio.cadastro_livros.infrastructure.entitys")
public class CadastroLivrosApplication {
	public static void main(String[] args) {
		SpringApplication.run(CadastroLivrosApplication.class, args);
	}
}


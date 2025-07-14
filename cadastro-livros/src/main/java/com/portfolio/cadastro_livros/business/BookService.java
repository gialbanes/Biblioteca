package com.portfolio.cadastro_livros.business;

import com.portfolio.cadastro_livros.infrastructure.entitys.Book;
import com.portfolio.cadastro_livros.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    // injetar a dependência do repository dentro da classe service, pois irei utilizar para criar os métodos CRUD
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void saveBook(Book book){
        repository.saveAndFlush(book); //salva e fecha a conexão com o BD
    }

    public Book findBookById(Long id){
        return repository.findById(id).orElseThrow( //tratamento se não existir o livro
                () -> new RuntimeException("Livro não encontrado")
        );
    }

    public void deleteBookById(Long id){
        repository.deleteById(id);
    }

    public void updateBookById(Long id, Book book){
        Book bookEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado"));
        Book bookUpdated = Book.builder()
                //evita que eu tenha que passar todos os dados novamente
                .title(book.getTitle() != null ? book.getTitle() : bookEntity.getTitle())
                .author(book.getAuthor() != null ? book.getAuthor() : bookEntity.getAuthor())
                .publicationYear(book.getPublicationYear() != 0 ? book.getPublicationYear() : bookEntity.getPublicationYear())
                .genre(book.getGenre() != null ? book.getGenre() : bookEntity.getGenre())
                .build();

        repository.saveAndFlush(bookUpdated);
    }
}

package com.portfolio.cadastro_livros.controller;

import com.portfolio.cadastro_livros.business.BookService;
import com.portfolio.cadastro_livros.infrastructure.entitys.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping //para gravar
    public ResponseEntity<Void> saveBook(@RequestBody Book book){
        bookService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Book> findBookById(@RequestParam Long id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBookById(@RequestParam Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateBookById(@RequestParam Long id, @RequestBody Book book){
        bookService.updateBookById(id, book);
        return ResponseEntity.ok().build();
    }
}

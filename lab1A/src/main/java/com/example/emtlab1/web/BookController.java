package com.example.emtlab1.web;
import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.dto.BookDto;
import com.example.emtlab1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/library")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto book) {
        return bookService.save(book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto product) {
        return bookService.update(id, product)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

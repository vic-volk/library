package ru.bmstu.rk.rest;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.bmstu.rk.model.Book;
import ru.bmstu.rk.repositories.elastic.BookDocumentRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/books")
class BookController {

    private List<String> names = Lists.newArrayList(
            "Isaac Newton",
            "Louis Pasteur",
            "Galileo",
            "Marie Curie",
            "Albert Einstein",
            "Charles Darwin",
            "Otto Hahn",
            "Nikola Tesla",
            "James Clerk Maxwell",
            "Aristotle aristotle"
    );

    @Autowired
    private BookDocumentRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<BookResource> showAll() {
        BookResource book = new BookResource();
        book.setName("Name");
        book.setAuthor("Author");
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public HttpEntity<BookResource> show(@PathVariable Long bookId) {
        BookResource book = new BookResource();
        book.setName("Name");
        book.setAuthor("Author");
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public HttpEntity<String> init() {
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setAuthor(names.get(new Random().nextInt(names.size())));
            book.setName("Sample book");
            repository.save(book);
        }
        return new HttpEntity<>("Success: " + new Date());
    }
}
package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookRepositories repositories;

    public BooksController(BookRepositories repositories) {
        this.repositories = repositories;
    }

    @GetMapping
    public String getBooks(Model model){
        model.addAttribute("books", repositories.findAll());
        return "books/list";
    }
}

package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorsRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorsRepositories repositories;

    public AuthorController(AuthorsRepositories repositories) {
        this.repositories = repositories;
    }

    @GetMapping
    public String getBooks(Model model){
        model.addAttribute("authors", repositories.findAll());
        return "authors/list";
    }
}

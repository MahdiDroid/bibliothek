package com.mahdidroid.bibliothek.controllers;


import com.mahdidroid.bibliothek.repositories.IBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final IBookRepository bookRepository;

    public BookController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getbooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

}

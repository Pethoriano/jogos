package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private GamesRepository repository;



    @GetMapping
    public String getAll(Model model, Pageable pageable) {
        /*List <GamesResponseDTO> games = repository.findAll().stream().map(GamesResponseDTO::new).toList();*/
        Page<GamesResponseDTO> games = repository.findAll(pageable).map(GamesResponseDTO::new);
        model.addAttribute("games", games);
        return "home";
    }



    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/";
    }
}

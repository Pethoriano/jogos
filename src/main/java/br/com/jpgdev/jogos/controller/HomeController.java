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
    public String getAll(Model model, @PageableDefault (page = 0, size = 4) Pageable pageable, @RequestParam(required = false) String sort) {
        Page <GamesResponseDTO> games = repository.findAll( pageable).map(GamesResponseDTO::new);
        model.addAttribute("games", games);
        model.addAttribute("sort", sort);
        return "home";
    }

    @GetMapping ("/{status}")
    public String GetStatus(@PathVariable ("status") String status, Model model, @PageableDefault (page = 0, size = 4) Pageable pageable){
        Page<GamesResponseDTO> games = repository.findByStatus(GamesStatus.valueOf(status.toUpperCase()), pageable);
        model.addAttribute("games", games);
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/";
    }
}

package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getAll(Model model){
        List<GamesResponseDTO> games = repository.findAll().stream().map(GamesResponseDTO::new).toList();
        model.addAttribute("games", games);
        return "home";
    }

    @GetMapping ("/{status}")
    public String GetStatus(@PathVariable ("status") String status, Model model){
        List<GamesResponseDTO> listaDeGames = repository.findByStatus(GamesStatus.valueOf(status.toUpperCase()));
        model.addAttribute("games", listaDeGames);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/";
    }
}

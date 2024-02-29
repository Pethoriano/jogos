package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.GamesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deletagame")
public class DeletaGameController {

    @Autowired
    private GamesRepository repository;

    @DeleteMapping
    @Transactional
    public String deletaGame(Long id) {
        repository.deleteById(id);
        return "redirect:/home";
    }

}

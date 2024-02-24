package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.*;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/home")
public class GamesController {

    @Autowired
    private GamesRepository repository;

    /*@GetMapping
    public List<GamesResponseDTO> getAll(Model model){
        List<GamesResponseDTO> listaDeGames = repository.findAll().stream().map(GamesResponseDTO::new).toList();
        return listaDeGames;
    }*/

    @GetMapping
    public String getAll(Model model){
        List<GamesResponseDTO> listaDeGames = repository.findAll().stream().map(GamesResponseDTO::new).toList();
        model.addAttribute("lista", listaDeGames);
        return "home";
    }

    @GetMapping ("/{status}")
    public String GetStatus(@PathVariable ("status") String status, Model model){
        List<GamesResponseDTO> listaDeGames = repository.findByStatus(GamesStatus.valueOf(status.toUpperCase()));
        model.addAttribute("lista", listaDeGames);
        return "home";
    }



    /*@PostMapping
    public void saveGames(@RequestBody GamesRequestDTO data){
        Games gamesdata = new Games(data);
        repository.save(gamesdata);
        return;
    }*/

    @PostMapping
    public String saveGames(@RequestBody GamesRequestDTO data) {
        Games gamesdata = new Games(data);
        repository.save(gamesdata);
        return "redirect:/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}

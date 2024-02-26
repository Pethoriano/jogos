package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.*;
import jakarta.transaction.Transactional;
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

    @PostMapping
    public String saveGames(@RequestBody GamesRequestDTO data) {
        Games gamesdata = new Games(data);
        repository.save(gamesdata);
        return "redirect:/home";
    }

    /*@DeleteMapping ()
    public String deletaGame(Long id) {
        repository.deleteById(id);
        return "redirect:/home";
    }*/
    //Foi opção minha não usar o DeleteMapping, li um pouco e teria que fazer um form (o que achei uma "gambiarra")
    //por o thymeleaf/html nn suportar o method, ou usar outras ferramentas como o JS que nn é o meu foco atual.
    //Aparentemente pelo o que li não se trata de um problema optar por essa escolha.
    //Devido ao escopo do projeto, acredito nn ter problema optar pelo get.

    @GetMapping("/deletagame")
    @Transactional
    public String deletaGame(Long id) {
        repository.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/alteragame")
    public String getAlteraGame(Long id, Model model) {
        List<GamesResponseDTO> game = repository.findById(id).stream().map(GamesResponseDTO::new).toList();
        model.addAttribute("game", game);
        return "alteragame";
    }

    @PutMapping("/alteragame")
    @Transactional
    public String alteraGame(@RequestBody GamesRequestDTO dados, Long id){
        Games game = repository.getReferenceById(id);
        game.atualizaJogo(dados);
        return "home";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}

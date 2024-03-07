package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cadastragame")
public class CadastraGameController {

    @Autowired
    private GamesRepository repository;

    @GetMapping
    public String getCadastraGame(Long id, Model model) {
        if (id!=null){
            var games = repository.getReferenceById(id);
            model.addAttribute("games", games);
        }
        return "alteragame";
    }

    @PostMapping
    @Transactional
    public String saveGame(@Valid GamesRequestDTO dados, BindingResult result) {
        if(result.hasErrors()){
            return "alteragame";
        }
        Games gamesdata = new Games(dados);
        repository.save(gamesdata);
        return "redirect:/";
    }

    @PutMapping
    @Transactional
    public String alteraGame(Long id, GamesRequestDTO dados){
        Games game = repository.getReferenceById(id);
        game.atualizaJogo(dados);
        return "redirect:/";
    }
}

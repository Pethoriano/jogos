package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.Games;
import br.com.jpgdev.jogos.games.GamesRepository;
import br.com.jpgdev.jogos.games.GamesRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastragame")
public class CadastraGameController {

    @Autowired
    private GamesRepository repository;

    @GetMapping
    public String getCadastraGame(Long id, Model model) {
        if (id!=null){
            var game = repository.findById(id);
            model.addAttribute("games", game);
        }
        return "alteragame";
    }

    @PostMapping
    @Transactional
    public String saveGame(GamesRequestDTO dados) {
        Games gamesdata = new Games(dados);
        repository.save(gamesdata);
        return "redirect:/home";
    }

    @PutMapping
    @Transactional
    public String alteraGame(Long id, GamesRequestDTO dados){
        Games game = repository.getReferenceById(id);
        game.atualizaJogo(dados);
        return "redirect:/home";
    }
}

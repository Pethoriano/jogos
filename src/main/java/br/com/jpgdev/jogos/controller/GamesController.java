package br.com.jpgdev.jogos.controller;

import br.com.jpgdev.jogos.games.Games;
import br.com.jpgdev.jogos.games.GamesRepository;
import br.com.jpgdev.jogos.games.GamesRequestDTO;
import br.com.jpgdev.jogos.games.GamesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class GamesController {

    @Autowired
    private GamesRepository repository;

    @GetMapping
    public List<GamesResponseDTO> getAll(){
        List<GamesResponseDTO> listaDeGames = repository.findAll().stream().map(GamesResponseDTO::new).toList();
        return listaDeGames;
    }

    @PostMapping
    public void saveGames(@RequestBody GamesRequestDTO data){
        Games gamesdata = new Games(data);
        repository.save(gamesdata);
        return;
    }

    }

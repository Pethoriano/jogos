package br.com.jpgdev.jogos.games;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamesRepository extends JpaRepository <Games, Long> {

    List<GamesResponseDTO> findByStatus(GamesStatus gamesStatus);
}

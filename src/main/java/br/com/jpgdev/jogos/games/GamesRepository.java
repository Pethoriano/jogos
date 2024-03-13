package br.com.jpgdev.jogos.games;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GamesRepository extends JpaRepository <Games, Long> {

    Page<GamesResponseDTO> findByStatus(GamesStatus gamesStatus, Pageable pageable);
}

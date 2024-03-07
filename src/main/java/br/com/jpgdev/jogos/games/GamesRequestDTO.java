package br.com.jpgdev.jogos.games;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record GamesRequestDTO(@NotBlank (message = "User's name cannot be empty.") String nome, Integer nota, String imagem, String avaliacao, GamesStatus status) {


}

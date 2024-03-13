package br.com.jpgdev.jogos.games;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GamesRequestDTO(@NotBlank(message = "Nome não pode ser vazio") String nome,
                              @Min(value = 1, message = "Digite um valor maior que 1")
                              @Max(value = 10, message = "Digite um valor menor que 10") Integer nota,
                              @NotBlank(message = "Por favor, cole aqui o endereço da imagem") String imagem,
                              String avaliacao,
                              @NotNull (message = "Selecione um status para o jogo") GamesStatus status) {


}

package br.com.jpgdev.jogos.games;

public record GamesResponseDTO(Long id, String nome, Integer nota, String imagem, String avaliacao, GamesStatus status) {

    public GamesResponseDTO(Games games){
        this(games.getId(), games.getNome(), games.getNota(), games.getImagem(), games.getAvaliacao(), games.getStatus());
    }


}

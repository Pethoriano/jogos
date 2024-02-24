package br.com.jpgdev.jogos.games;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "games")
@Entity(name = "games")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Games {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer nota;
    private String imagem;
    private String avaliacao;
    @Enumerated(EnumType.STRING)
    private GamesStatus status;

    public Games(GamesRequestDTO data){
        this.nome = data.nome();
        this.nota = data.nota();
        this.imagem = data.imagem();
        this.avaliacao = data.avaliacao();
        this.status=data.status();
    }

}

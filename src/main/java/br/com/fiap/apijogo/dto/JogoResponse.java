package br.com.fiap.apijogo.dto;

import br.com.fiap.apijogo.entity.Jogo;
import org.springframework.hateoas.Link;

import java.time.LocalDate;

public record JogoResponse(
        Long id,
        String titulo,
        String descricao,
        Double preco,
        LocalDate dataLancamento, Link link) {

    public static JogoResponse fromEntity(Jogo jogo, Link link) {
        return new JogoResponse(
                jogo.getId(),
                jogo.getTitulo(),
                jogo.getDescricao(),
                jogo.getPreco(),
                jogo.getDataLancamento(),
                link
        );
    }

}

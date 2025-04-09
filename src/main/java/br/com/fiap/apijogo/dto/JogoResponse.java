package br.com.fiap.apijogo.dto;

import org.springframework.hateoas.Link;

import java.time.LocalDate;

public record JogoResponse(
        Long id,
        String titulo,
        String descricao,
        Double preco,
        LocalDate dataLancamento, Link link) {


}

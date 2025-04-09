package br.com.fiap.apijogo.dto;

import org.springframework.hateoas.Link;

public record PlataformaResponse(
        String nome,
        String empresa,
        Double precoPlataforma
) {
}

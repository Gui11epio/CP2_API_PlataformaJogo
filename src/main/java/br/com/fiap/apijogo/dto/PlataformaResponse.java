package br.com.fiap.apijogo.dto;

import br.com.fiap.apijogo.entity.Plataforma;
import org.springframework.hateoas.Link;

public record PlataformaResponse(
        String nome,
        String empresa,
        Double precoPlataforma) {

    public static PlataformaResponse fromEntity(Plataforma plataforma) {
        return new PlataformaResponse(
                plataforma.getNome(),
                plataforma.getEmpresa(),
                plataforma.getPrecoPlataforma()
        );
    }
}

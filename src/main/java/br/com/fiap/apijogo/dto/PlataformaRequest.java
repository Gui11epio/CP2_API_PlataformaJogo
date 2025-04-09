package br.com.fiap.apijogo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlataformaRequest {

    @NotNull(message = "O nome da Plataforma é obrigatório")
    @Size(min = 1 , max = 1000)
    private String nome;

    @NotNull(message = "A empresa é obrigatória")
    @Size(min = 1 , max = 1000)
    private String empresa;
}

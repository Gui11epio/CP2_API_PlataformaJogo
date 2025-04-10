package br.com.fiap.apijogo.dto;

import br.com.fiap.apijogo.entity.Plataforma;
import jakarta.validation.constraints.*;
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

    @NotBlank
    @DecimalMin(value = "1.000", message = "O valor mínimo é de 1000 reais")
    @DecimalMax(value = "5.000", message = "O valor máximo é de 5000 reais")
    private Double precoPlataforma;

    public Plataforma toEntity() {
        return new Plataforma(null, nome, empresa, precoPlataforma);
    }
}

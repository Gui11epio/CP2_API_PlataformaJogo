package br.com.fiap.apijogo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JogoRequest {
    @NotBlank(message = "O Título do jogo é obrigatório")
    @Size(min = 1, max = 50, message = "O título do jogo deve ter entre 1 e 50 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 1 , max = 1000, message = "A descrição deve ter entre 1 e 1000 caracteres")
    private String descricao;

    @NotNull(message = "O Preço é obrigatório")
    @DecimalMin(value = "1.0", message = "O valor mínimo é de 1 real")
    @DecimalMax(value = "600.0", message = "O valor máximo é de 600 reais")
    private Double preco;

    @NotNull(message = "A data de lançamento é necessária")
    private LocalDate dataLancamento;

    private Long plataformaId;

}

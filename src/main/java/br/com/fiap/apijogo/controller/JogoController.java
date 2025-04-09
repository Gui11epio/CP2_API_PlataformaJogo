package br.com.fiap.apijogo.controller;

import br.com.fiap.apijogo.dto.JogoResponse;
import br.com.fiap.apijogo.entity.Jogo;
import br.com.fiap.apijogo.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
@Tag(name = "COMANDOS JOGO")
public class JogoController {
    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    @Operation(summary = "Cadastrar jogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogo cadastrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Jogo.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo criar(@RequestBody Jogo jogo) {
        return service.criar(jogo);
    }

    @Operation(summary = "Retorna um jogo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogo encontrado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JogoResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhum jogo encontrado",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public Jogo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Listar jogos por meio de páginas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Nenhum jogo encontrado",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Jogo encontrado com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping
    public ResponseEntity<Page<Jogo>> listarJ(Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @Operation(summary = "Atualiza um jogo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogo encontrado e atualizado com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Jogo.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhum jogo encontrado para atualizar",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo jogo) {
        return service.atualizar(id, jogo);
    }

    @Operation(summary = "Exclui um jogo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhum jogo encontrado para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Jogo excluido com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

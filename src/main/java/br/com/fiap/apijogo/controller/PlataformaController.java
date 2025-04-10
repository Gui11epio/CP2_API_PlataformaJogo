package br.com.fiap.apijogo.controller;

import br.com.fiap.apijogo.dto.JogoResponse;
import br.com.fiap.apijogo.entity.Jogo;
import br.com.fiap.apijogo.entity.Plataforma;
import br.com.fiap.apijogo.service.PlataformaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/plataformas")
@Tag(name = "COMANDOS PLATAFORMA")
public class PlataformaController {
    private final PlataformaService service;

    public PlataformaController(PlataformaService service) {
        this.service = service;
    }

    @Operation(summary = "Cadastrar plataforma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plataforma cadastrada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Jogo.class))}),
            @ApiResponse(responseCode = "400", description = "Atributos informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plataforma criar(@RequestBody Plataforma plataforma) {
        return service.criar(plataforma);
    }

    @Operation(summary = "Retorna uma plataforma por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plataforma encontrada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JogoResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Nenhuma plataforma encontrada",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public Plataforma buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Listar as plataformas e seus jogos por meio de páginas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Nenhuma plataforma encontrada",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "200", description = "Plataforma encontrada com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Plataforma>>> listarP(Pageable pageable) {
        Page<Plataforma> page = service.listar(pageable);

        List<Plataforma> plataformas = page.getContent();

        List<EntityModel<Plataforma>> plataformasComLinks = new ArrayList<>();

        for (int i = 0; i < plataformas.size(); i++) {
            Plataforma atual = plataformas.get(i);

            EntityModel<Plataforma> model = EntityModel.of(atual,
                    linkTo(methodOn(PlataformaController.class).buscarPorId(atual.getId())).withSelfRel()
            );

            // Se houver próxima plataforma na mesma página
            if (i + 1 < plataformas.size()) {
                Plataforma proxima = plataformas.get(i + 1);
                model.add(linkTo(methodOn(PlataformaController.class)
                        .buscarPorId(proxima.getId())).withRel("next"));
            }

            plataformasComLinks.add(model);
        }

        CollectionModel<EntityModel<Plataforma>> collectionModel =
                CollectionModel.of(plataformasComLinks);

        return ResponseEntity.ok(collectionModel);
    }

    @Operation(summary = "Atualiza uma plataforma pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plataforma encontrada e atualizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Jogo.class))}),
            @ApiResponse(responseCode = "400", description = "Nenhuma plataforma encontrada para atualizar",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public Plataforma atualizar(@PathVariable Long id, @RequestBody Plataforma plataforma) {
        return service.atualizar(id, plataforma);
    }

    @Operation(summary = "Exclui uma plataforma pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Nenhuma plataforma encontrada para excluir",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "204", description = "Plataforma excluida com sucesso",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

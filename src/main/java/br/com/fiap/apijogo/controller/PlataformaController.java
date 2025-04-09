package br.com.fiap.apijogo.controller;

import br.com.fiap.apijogo.entity.Plataforma;
import br.com.fiap.apijogo.service.PlataformaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {
    private final PlataformaService service;

    public PlataformaController(PlataformaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plataforma criar(@RequestBody Plataforma plataforma) {
        return service.criar(plataforma);
    }

    @GetMapping("/{id}")
    public Plataforma buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<Plataforma> listarTodos() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public Plataforma atualizar(@PathVariable Long id, @RequestBody Plataforma plataforma) {
        return service.atualizar(id, plataforma);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

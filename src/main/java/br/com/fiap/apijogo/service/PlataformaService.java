package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Plataforma;

import java.util.List;

public interface PlataformaService {
    Plataforma criar(Plataforma plataforma);
    Plataforma buscarPorId(Long id);
    List<Plataforma> listarTodos();
    Plataforma atualizar(Long id, Plataforma plataforma);
    void deletar(Long id);
}

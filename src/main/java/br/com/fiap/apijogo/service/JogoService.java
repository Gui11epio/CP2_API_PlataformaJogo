package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Jogo;

import java.util.List;

public interface JogoService {
    Jogo criar(Jogo jogo);
    Jogo buscarPorId(Long id);
    List<Jogo> listarTodos();
    List<Jogo> buscarPorPlataforma(Long plataformaId);
    Jogo atualizar(Long id, Jogo jogo);
    void deletar(Long id);
}

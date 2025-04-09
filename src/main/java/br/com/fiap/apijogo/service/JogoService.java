package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Jogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JogoService {
    Jogo criar(Jogo jogo);
    Jogo buscarPorId(Long id);
    Page<Jogo> listar(Pageable pageable);
    Jogo atualizar(Long id, Jogo jogo);
    void deletar(Long id);
}

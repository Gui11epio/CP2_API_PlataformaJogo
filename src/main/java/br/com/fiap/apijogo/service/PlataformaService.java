package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Plataforma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlataformaService {
    Plataforma criar(Plataforma plataforma);
    Plataforma buscarPorId(Long id);
    Page<Plataforma> listar(Pageable pageable);
    Plataforma atualizar(Long id, Plataforma plataforma);
    void deletar(Long id);
}

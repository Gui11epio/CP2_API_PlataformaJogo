package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Jogo;
import br.com.fiap.apijogo.repository.JogoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoServiceImpl implements JogoService {
    private final JogoRepository repository;
    private final JogoRepository jogoRepository;

    public JogoServiceImpl(JogoRepository repository, JogoRepository jogoRepository) {
        this.repository = repository;
        this.jogoRepository = jogoRepository;
    }

    @Override
    public Jogo criar(Jogo jogo) {
        return repository.save(jogo);
    }

    @Override
    public Jogo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }


    @Override
    public Page<Jogo> listar(Pageable pageable) {
        return jogoRepository.findAll(pageable);
    }


    @Override
    public Jogo atualizar(Long id, Jogo jogo) {
        return repository.findById(id)
                .map(existente -> {
                    jogo.setId(id);
                    return repository.save(jogo);
                })
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    @Override
    public void deletar(Long id) {
        Jogo jogo = buscarPorId(id);
        repository.delete(jogo);
    }
}

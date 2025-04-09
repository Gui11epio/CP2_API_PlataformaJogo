package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Jogo;
import br.com.fiap.apijogo.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoServiceImpl implements JogoService {
    private final JogoRepository repository;

    public JogoServiceImpl(JogoRepository repository) {
        this.repository = repository;
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
    public List<Jogo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Jogo> buscarPorPlataforma(Long plataformaId) {
        return repository.findByPlataformaId(plataformaId);
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

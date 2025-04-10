package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Jogo;
import br.com.fiap.apijogo.repository.JogoRepository;
import br.com.fiap.apijogo.repository.PlataformaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoServiceImpl implements JogoService {

    private final JogoRepository jogoRepository;

    public JogoServiceImpl(JogoRepository repository, JogoRepository jogoRepository) {

        this.jogoRepository = jogoRepository;
    }

    @Override
    public Jogo criar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @Override
    public Jogo buscarPorId(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }


    @Override
    public Page<Jogo> listar(Pageable pageable) {
        return jogoRepository.findAll(pageable);
    }


    @Override
    public Jogo atualizar(Long id, Jogo jogo) {
        return jogoRepository.findById(id)
                .map(existente -> {
                    jogo.setId(id);
                    return jogoRepository.save(jogo);
                })
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    @Override
    public void deletar(Long id) {
        Jogo jogo = buscarPorId(id);
        jogoRepository.delete(jogo);
    }

}

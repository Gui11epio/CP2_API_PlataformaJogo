package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Plataforma;
import br.com.fiap.apijogo.repository.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaServiceImpl implements PlataformaService {

    private final PlataformaRepository repository;

    public PlataformaServiceImpl(PlataformaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Plataforma criar(Plataforma plataforma) {
        return repository.save(plataforma);
    }

    @Override
    public Plataforma buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plataforma não encontrada"));
    }

    @Override
    public List<Plataforma> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Plataforma atualizar(Long id, Plataforma plataforma) {
        return repository.findById(id)
                .map(existente -> {
                    plataforma.setId(id);
                    return repository.save(plataforma);
                })
                .orElseThrow(() -> new RuntimeException("Plataforma não encontrada"));
    }

    @Override
    public void deletar(Long id) {
        Plataforma plataforma = buscarPorId(id);
        repository.delete(plataforma);
    }
}

package br.com.fiap.apijogo.service;

import br.com.fiap.apijogo.entity.Plataforma;
import br.com.fiap.apijogo.repository.PlataformaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaServiceImpl implements PlataformaService {


    private final PlataformaRepository plataformaRepository;

    public PlataformaServiceImpl(PlataformaRepository repository, PlataformaRepository plataformaRepository) {

        this.plataformaRepository = plataformaRepository;
    }

    @Override
    public Plataforma criar(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    @Override
    public Plataforma buscarPorId(Long id) {
        return plataformaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plataforma não encontrada"));
    }

    @Override
    public Page<Plataforma> listar(Pageable pageable) {
        return plataformaRepository.findAll(pageable);
    }


    @Override
    public Plataforma atualizar(Long id, Plataforma plataforma) {
        return plataformaRepository.findById(id)
                .map(existente -> {
                    plataforma.setId(id);
                    return plataformaRepository.save(plataforma);
                })
                .orElseThrow(() -> new RuntimeException("Plataforma não encontrada"));
    }

    @Override
    public void deletar(Long id) {
        Plataforma plataforma = buscarPorId(id);
        plataformaRepository.delete(plataforma);
    }
}

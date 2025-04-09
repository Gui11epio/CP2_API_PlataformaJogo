package br.com.fiap.apijogo.repository;

import br.com.fiap.apijogo.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByPlataformaId(Long plataformaId);
}

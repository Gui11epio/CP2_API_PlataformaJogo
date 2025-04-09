package br.com.fiap.apijogo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String empresa;
    private Double precoPlataforma;
    @OneToMany(mappedBy = "plataforma")
    @JsonManagedReference
    private List<Jogo> jogos;

    public Plataforma() {
    }

    public Plataforma(Long id, String nome, String empresa, List<Jogo> jogos) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.precoPlataforma = precoPlataforma;
        this.jogos = jogos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getPrecoPlataforma() {
        return precoPlataforma;
    }

    public void setPrecoPlataforma(Double precoPlataforma) {
        this.precoPlataforma = precoPlataforma;
    }
}

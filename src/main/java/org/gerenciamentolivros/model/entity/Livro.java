package org.gerenciamentolivros.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String titulo;
    @Setter
    private String autor;
    @Setter
    private Double anopublicacao;
    @Setter
    private String genero;

    // CONSTRUTOR
    public Livro() {
    }

    public Livro( String titulo, String autor, Double anopublicacao, String genero) {

        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacao = anopublicacao;
        this.genero = genero;
    }
    // GET E SET

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getAnopublicacao() {
        return anopublicacao;
    }

    public String getGenero() {
        return genero;
    }

}

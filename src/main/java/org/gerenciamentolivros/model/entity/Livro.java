package org.gerenciamentolivros.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

import java.util.Date;

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
    private Date anopublicacao;
    @Setter
    private String genero;

    // CONSTRUTOR
    public Livro() {
    }

    public Livro( Long id, String titulo, String autor, Date anopublicacao, String genero) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacao = anopublicacao;
        this.genero = genero;
    }
    // GET E SET

    public Long getId() {return id;
    }

    public String getTitulo() {return titulo;
    }

    public String getAutor() {return autor;
    }

    public Date getAnopublicacao() {return anopublicacao;
    }

    public String getGenero() {return genero;
    }

}

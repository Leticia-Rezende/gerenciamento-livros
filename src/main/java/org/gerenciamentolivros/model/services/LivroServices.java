package org.gerenciamentolivros.model.services;

import org.gerenciamentolivros.model.entity.Livro;
import org.gerenciamentolivros.persistence.LivroDAO;

import java.util.List;

public class LivroServices {
    private LivroDAO livroDAO = new LivroDAO();

    public void addLivro(Livro livro) {livroDAO.save(livro);
    }

    public List<Livro> getAllLivros() {return livroDAO.findAll();
    }

    public Livro getLivroById(Long id) {return livroDAO.findById(id);
    }

    public void updateLivro(Livro livro ) {livroDAO.update(livro);
    }

    public void removeLivro(Long id) {livroDAO.delete(id);
    }
}

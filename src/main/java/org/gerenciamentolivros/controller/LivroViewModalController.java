package org.gerenciamentolivros.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Setter;
import org.gerenciamentolivros.model.entity.Livro;
import org.gerenciamentolivros.model.services.LivroServices;

import java.net.URL;
import java.util.ResourceBundle;

public class LivroViewModalController extends  LivroController{


    @FXML
    TextField txtId;
    @FXML
    TextField txtTitulo;
    @FXML
    TextField txtAutor;
    @FXML
    TextField txtAnoPublicacao;
    @FXML
    TextField txtGenero;
    @FXML
    Button btnSalvar;
    @FXML
    Button btnExcluir;
    @FXML
    Button btnCancelar;

    @Setter
    private LivroServices livroServices;

    private Livro livro;
    //*****************************************************************************************************************
    // INICIALIZAÇÃO
    @Override
    public void initialize(URL location, ResourceBundle resources) {}


    //*****************************************************************************************************************
    // TRATAMENTO DE EVENTOS
    @FXML
    public void btnSalvarOnAction() {
        try {
            if (livro == null) {
                this.livro = new Livro();
                lerCampos();
                livroServices.addLivro(livro);
                fecharModal();
            } else {
                lerCampos();
                livroServices.updateLivro(livro);
                fecharModal();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void btnExcluirOnAction() {
        lerCampos();
        livroServices.removeLivro(Long.valueOf(livro.getId()));
        fecharModal();
    }

    @FXML
    public void btnCancelarOnAction() {

        fecharModal();
    }

    //*****************************************************************************************************************
    // METODOS COMPLEMENTARES
    public void fecharModal() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
        if (livro != null) {
            preencherCampos();
        }
    }

    private void preencherCampos() {
        if (livro != null) {
            txtId.setText(String.valueOf(livro.getId()));
            txtTitulo.setText(livro.getTitulo());
            txtAutor.setText(livro.getAutor());
            txtAnoPublicacao.setText(livro.getAnopublicacao().toString());
            txtGenero.setText(livro.getGenero());
        }
    }

    private void lerCampos() {

        this.livro.setTitulo(txtTitulo.getText());
        this.livro.setAutor(txtAutor.getText());
        this.livro.setAnopublicacao(Double.valueOf(txtAnoPublicacao.getText()));
        this.livro.setGenero(txtGenero.getText());
    }

}

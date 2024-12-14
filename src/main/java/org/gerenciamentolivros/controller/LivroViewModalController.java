package org.gerenciamentolivros.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Setter;
import org.gerenciamentolivros.model.entity.Livro;
import org.gerenciamentolivros.model.services.LivroServices;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class LivroViewModalController extends  LivroController{


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
            txtTitulo.setText(livro.getTitulo());

            // Formatar a data para exibir apenas o ano
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            if (livro.getAnopublicacao() != null) {
                txtAnoPublicacao.setText(sdf.format(livro.getAnopublicacao()));
            } else {
                txtAnoPublicacao.setText(""); // Limpar o campo se a data for nula
            }

            txtAutor.setText(livro.getAutor());
            txtGenero.setText(livro.getGenero());
        }
    }

    private void lerCampos() {
        this.livro.setTitulo(txtTitulo.getText());

        // Lógica para ler o ano de lançamento
        String anoText = txtAnoPublicacao.getText();
        if (anoText.length() != 4 || !anoText.matches("\\d{4}")) {
            throw new IllegalArgumentException("Por favor, insira um ano válido com 4 dígitos.");
        }

        int ano = Integer.parseInt(anoText);
        String dataString = ano + "-01-01"; // Definindo 1º de janeiro como data padrão
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date anoDeLancamento = sdf.parse(dataString);
            this.livro.setAnopublicacao(anoDeLancamento);
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao converter a data: " + e.getMessage());
        }

        this.livro.setAutor(txtAutor.getText());
        this.livro.setGenero(txtGenero.getText());
    }

}

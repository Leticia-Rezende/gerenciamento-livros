package org.gerenciamentolivros.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.gerenciamentolivros.model.entity.Livro;
import org.gerenciamentolivros.model.services.LivroServices;
import org.gerenciamentolivros.utils.Alerta;
import org.gerenciamentolivros.utils.PathFXML;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    ScrollPane scrollPaneMain;
    @FXML
    VBox vBoxMain;
    @FXML
    MenuBar menuBarMain;
    @FXML
    Menu menuHelp;
    @FXML
    Menu menuCadastro;
    @FXML
    MenuItem menuItemLivros;


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onCadastroLivroAction() {
        loadView("\\LivroView.fxml");
    }

    @FXML
    public void onHelpAboutAction() {
        Alerta.exibirAlerta("gerenciamento-livros", "About", "gerenciamento-livros V 1.0", Alert.AlertType.INFORMATION);

    }
    //******************************************************************************************************************
    // CARREGAMENTO DA VIEW
    public void loadView(String arquivoFXML){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            VBox vBox = fxmlLoader.load(new FileInputStream(PathFXML.pathBase() + arquivoFXML));

            vBoxMain.getChildren().clear();
            vBoxMain.getChildren().add(menuBarMain);
            vBoxMain.getChildren().addAll(vBox.getChildren());

            LivroController controller = fxmlLoader.getController();
            controller.setLivroServices(new LivroServices());
            controller.updateTableView();
            controller.tblivro.prefHeightProperty().bind(vBoxMain.heightProperty());

        } catch (RuntimeException | IOException e) {
            Alerta.exibirAlerta("Error","Erro ao carregar a view",e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}

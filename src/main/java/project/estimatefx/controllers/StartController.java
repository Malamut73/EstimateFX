package project.estimatefx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.estimatefx.HelloApplication;

import java.io.IOException;

public class StartController {

    @FXML
    private TextField loginField;

    @FXML
    private Button loginInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize(){

        loginInButton.setOnAction(actionEvent -> {
            String loginText = loginField.getText().trim();
            String passwordText = passwordField.getText().trim();
            if(!(loginText.equals("")) || !(passwordText.equals("")))
                loginUser(loginText, passwordText);
            else
                System.out.println("Login or password are empty");
        });
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("singUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }

    private void loginUser(String loginText, String passwordText) {
    }
}
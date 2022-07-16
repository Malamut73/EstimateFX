package project.estimatefx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import project.estimatefx.config.DatabaseHandler;

public class SignUpController {

    @FXML
    private PasswordField signUpCountry;

    @FXML
    private Button signUpEntreButton;

    @FXML
    private CheckBox signUpFemale;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpLogin;

    @FXML
    private CheckBox signUpMale;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpPassword;

    @FXML
    void initialize(){

        DatabaseHandler dbHandler = new DatabaseHandler();
        signUpEntreButton.setOnAction(event -> {
            dbHandler.signUpUser(signUpName.getText(), signUpLastName.getText(), signUpLogin.getText(),
                    signUpPassword.getText(), signUpCountry.getText(), "Male");
        });
    }


}

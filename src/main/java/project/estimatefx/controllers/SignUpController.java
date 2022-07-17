package project.estimatefx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import project.estimatefx.config.DatabaseHandler;
import project.estimatefx.user.User;

public class SignUpController {


    @FXML
    private TextField signUpCountry;

    @FXML
    private Button signUpEntreButton;

    @FXML
    private CheckBox signUpFamale;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpLogin;

    @FXML
    private CheckBox signUpMale;

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    void initialize(){

        signUpNewUser();

    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        signUpEntreButton.setOnAction(event -> {

            String firstName = signUpName.getText();
            String lastName = signUpLastName.getText();
            String login = signUpLogin.getText();
            String password = signUpPassword.getText();
            String country = signUpCountry.getText();
            String gender = "";

            if(signUpMale.isSelected()){
                gender = "Мужской";
            }else{
                gender = "Женский";
            }

            User user = new User(firstName, lastName, login,
                    password, country, gender);

            dbHandler.signUpUser(user);
        });
    }


}

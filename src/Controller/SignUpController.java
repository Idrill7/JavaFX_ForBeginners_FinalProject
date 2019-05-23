package Controller;
import AlertMessage.Message;
import DBConnection.Conexion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable{

    private Connection conn;
    @FXML
    private AnchorPane ASuPane;

    @FXML
    private JFXTextField fullName;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXCheckBox checkTerms;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnLogin;

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void login(ActionEvent event) throws Exception{
        btnLogin.getScene().getWindow().hide();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/Login.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.setResizable(false);
        login.initStyle(StageStyle.UNDECORATED);
        login.show();
    }

    @FXML
    public void signUp(ActionEvent event) throws Exception{



        if (checkTerms.isSelected()) {
            conn = Conexion.getConnection();
            System.out.println("conexion realizada");
            String sqlInsert = "INSERT INTO user (fullname,email,password) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sqlInsert);
            ps.setString(1,fullName.getText());
            ps.setString(2,email.getText());
            ps.setString(3,password.getText());
            ps.executeUpdate();

            Message.setMessageInformation("Registro realizado ¡ Gracias !");

        } else
        {
            Message.setMessageWarning("Falta confirmación de los términos","Por favor, si usted desea registarse, acepte nuestros términos        ¡ Gracias !");
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}

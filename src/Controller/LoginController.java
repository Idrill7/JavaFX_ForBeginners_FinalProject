package Controller;

import AlertMessage.Message;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import DBConnection.Conexion;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {


    Connection conn;


    @FXML
    private AnchorPane anPane;

    @FXML
    private Pane loginPane;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton btnForgot;

    @FXML
    private JFXButton btnReg;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnExit;

    @FXML
    void createLogin(ActionEvent event) throws Exception{

        try {
            conn = Conexion.getConnection();
            String sqlSelect ="SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?";
            PreparedStatement ps = conn.prepareStatement(sqlSelect);
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());

            ResultSet rs = ps.executeQuery();
            int count = 0;

            while (rs.next())
            {
                count = count+1;
            }
            if (count==1)
            {
                btnLogin.getScene().getWindow().hide();
                Stage signUp = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../FXML/HomePage.fxml"));
                Scene scene = new Scene(root);
                signUp.setScene(scene);
                signUp.setResizable(false);
                signUp.initStyle(StageStyle.UNDECORATED);
                signUp.show();

            } else {
                Message.setMessageError("Error al introducir los datos");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void createRegister(ActionEvent event) throws Exception {

        btnReg.getScene().getWindow().hide();
        Stage signUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/SignUp.fxml"));
        Scene scene = new Scene(root);
        signUp.setScene(scene);
        signUp.setResizable(false);
        signUp.initStyle(StageStyle.UNDECORATED);
        signUp.show();

    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

}

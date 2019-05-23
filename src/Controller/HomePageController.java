package Controller;

import DBConnection.Conexion;
import Model.User;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{

    @FXML
    private TableColumn<User, String> fullnameRow;

    @FXML
    private TableColumn<User, String> emailRow;

    @FXML
    private TableColumn<User, String> passwordRow;

    @FXML
    private JFXButton btnShow;

    @FXML
    private TableView<User> dataTable;

    @FXML
    private JFXButton btnExit;

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }


    @FXML
    void showData(ActionEvent event) throws SQLException, ClassNotFoundException {

        Connection conn = Conexion.getConnection();

        ObservableList<User> data = FXCollections.observableArrayList();

        String sqlSelect = "SELECT * FROM USER";
        PreparedStatement ps = conn.prepareStatement(sqlSelect);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            User u = new User(
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("password"));

            //aniadimos los datos
            data.add(u);
        }
        dataTable.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fullnameRow.setCellValueFactory(new PropertyValueFactory<User, String>("fullName"));
        emailRow.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        passwordRow.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
    }
}


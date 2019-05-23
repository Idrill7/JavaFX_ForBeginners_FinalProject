package AlertMessage;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class Message {
    private static Alert alert;

    public static void setMessageError(String str)
    {
         alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }
    public static void setMessageWarning(String titulo, String str)
    {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText(titulo);
        alert.setContentText(str);
        alert.showAndWait();
    }

    public static void setMessageInformation(String str)
    {alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.showAndWait();
    }

}

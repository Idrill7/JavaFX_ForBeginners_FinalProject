package Model;

import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty fullName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty password;

    public User(String fullName, String email, String password) {
        this.fullName = new SimpleStringProperty(fullName);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getEmail() {
        return email.get();
    }


    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}

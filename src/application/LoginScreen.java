package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private Stage loginStage;

    @Override
    public void start(Stage primaryStage) {
        try {
        	loginStage = primaryStage;
            primaryStage.setTitle("Login Screen");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 20, 20, 20));

            Label usernameLabel = new Label("Username:");
            grid.add(usernameLabel, 0, 0);
            TextField usernameTextField = new TextField();
            grid.add(usernameTextField, 1, 0);

            Label passwordLabel = new Label("Password:");
            grid.add(passwordLabel, 0, 1);
            PasswordField passwordField = new PasswordField();
            grid.add(passwordField, 1, 1);

            Button loginButton = new Button("Login");
            grid.add(loginButton, 0, 2, 2, 1);

            Label messageLabel = new Label();
            grid.add(messageLabel, 0, 3, 2, 1);

            loginButton.setOnAction(event -> {
                String enteredUsername = usernameTextField.getText();
                String enteredPassword = passwordField.getText();
                
                User authenticatedUser = UserDAO.authenticateUser(enteredUsername, enteredPassword);

                if ( authenticatedUser != null ) {
                    // Authentication successful
                    openMainApplication();
                } else {
                    // Authentication failed
                    messageLabel.setText("Invalid username or password");
                }
            });

            Scene scene = new Scene(grid, 500, 250);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String username, String password) {
        // For simplicity, hardcoding a single set of admin credentials
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private void openMainApplication() {
    	loginStage.close();
        
    	CarRentalUI carRentalUI = new CarRentalUI();
        carRentalUI.start(new Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }
}


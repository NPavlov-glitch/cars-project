package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
        	if (DatabaseConnector.testConnection()) {
                // Create an instance of LoginScreen
                LoginScreen loginScreen = new LoginScreen();

                // Pass the stage to the LoginScreen instance
                loginScreen.start(primaryStage);
            } else {
                // Handle the case where the connection test fails
                System.err.println("Unable to establish a database connection. Exiting...");
            }
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

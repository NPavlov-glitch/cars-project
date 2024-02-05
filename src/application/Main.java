package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
        	if (DatabaseConnector.testConnection()) {
                LoginScreen loginScreen = new LoginScreen();

                loginScreen.start(primaryStage);
            } else {
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

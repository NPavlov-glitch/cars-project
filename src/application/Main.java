package application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
        try {
            // Create an instance of CarRentalUI
        	CarRentalUI carRentalUI = new CarRentalUI();
            
            // Pass the stage to the CarRentalUI instance
            carRentalUI.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

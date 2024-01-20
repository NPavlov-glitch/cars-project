package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CarRentalUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Car Rental System");

            // Create a grid pane for the UI components
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 20, 20, 20));

            // Car details UI components
            Label carLabel = new Label("Car Details");
            grid.add(carLabel, 0, 0, 2, 1);

            Label makeLabel = new Label("Make:");
            grid.add(makeLabel, 0, 1);
            TextField makeTextField = new TextField();
            grid.add(makeTextField, 1, 1);

            Label modelLabel = new Label("Model:");
            grid.add(modelLabel, 0, 2);
            TextField modelTextField = new TextField();
            grid.add(modelTextField, 1, 2);

            // Add Car button
            Button addCarButton = new Button("Add Car");
            grid.add(addCarButton, 0, 3, 2, 1);

            // Client details UI components
            Label clientLabel = new Label("Client Details");
            grid.add(clientLabel, 0, 4, 2, 1);

            Label nameLabel = new Label("Name:");
            grid.add(nameLabel, 0, 5);
            TextField nameTextField = new TextField();
            grid.add(nameTextField, 1, 5);

            Label phoneLabel = new Label("Phone:");
            grid.add(phoneLabel, 0, 6);
            TextField phoneTextField = new TextField();
            grid.add(phoneTextField, 1, 6);

            // Add Client button
            Button addClientButton = new Button("Add Client");
            grid.add(addClientButton, 0, 7, 2, 1);

            // Rent out a car UI components
            Label rentLabel = new Label("Rent Out a Car");
            grid.add(rentLabel, 0, 8, 2, 1);

            // Car selection (for renting out)
            Label carSelectionLabel = new Label("Select Car:");
            grid.add(carSelectionLabel, 0, 9);
            TextField carSelectionTextField = new TextField();
            grid.add(carSelectionTextField, 1, 9);

            // Client selection (for renting out)
            Label clientSelectionLabel = new Label("Select Client:");
            grid.add(clientSelectionLabel, 0, 10);
            TextField clientSelectionTextField = new TextField();
            grid.add(clientSelectionTextField, 1, 10);

            // Rent Out button
            Button rentOutButton = new Button("Rent Out");
            grid.add(rentOutButton, 0, 11, 2, 1);

            // Set the scene
            Scene scene = new Scene(grid, 400, 500);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

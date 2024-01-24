package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CarRentalUI extends Application {
	
	private List<Car> cars = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private Operator operator;
    private User loggedInUser;
    private Button createOperatorButton;
    
    private void loginUser(User user) {
        loggedInUser = user;
        updateUIBasedOnUserRole(loggedInUser);
    }

    private void updateUIBasedOnUserRole(User loggedInUser) {
        if (loggedInUser != null && "Administrator".equals(loggedInUser.getRole())) {
            createOperatorButton.setVisible(true);
        } else {
            createOperatorButton.setVisible(false);
        }
    }
    
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

            Label yearLabel = new Label("Year:");
            grid.add(yearLabel, 0, 3);
            TextField yearTextField = new TextField();
            grid.add(yearTextField, 1, 3);

            Label carClassLabel = new Label("Car Class:");
            grid.add(carClassLabel, 0, 4);
            TextField carClassTextField = new TextField();
            grid.add(carClassTextField, 1, 4);

            Label categoryLabel = new Label("Category:");
            grid.add(categoryLabel, 0, 5);
            TextField categoryTextField = new TextField();
            grid.add(categoryTextField, 1, 5);

            Label featuresLabel = new Label("Features:");
            grid.add(featuresLabel, 0, 6);
            TextField featuresTextField = new TextField();
            grid.add(featuresTextField, 1, 6);

            Label photosLabel = new Label("Photos:");
            grid.add(photosLabel, 0, 7);
            TextField photosTextField = new TextField();
            grid.add(photosTextField, 1, 7);

            Label smokerLabel = new Label("Smoker:");
            grid.add(smokerLabel, 0, 8);
            CheckBox smokerCheckBox = new CheckBox();
            grid.add(smokerCheckBox, 1, 8);

            // Add Car button
            Button addCarButton = new Button("Add Car");
            grid.add(addCarButton, 0, 9, 2, 1);

            // Client details UI components
            Label clientLabel = new Label("Client Details");
            grid.add(clientLabel, 0, 10, 2, 1);

            Label nameLabel = new Label("Name:");
            grid.add(nameLabel, 0, 11);
            TextField nameTextField = new TextField();
            grid.add(nameTextField, 1, 11);

            Label phoneLabel = new Label("Phone:");
            grid.add(phoneLabel, 0, 12);
            TextField phoneTextField = new TextField();
            grid.add(phoneTextField, 1, 12);

            // Add Client button
            Button addClientButton = new Button("Add Client");
            grid.add(addClientButton, 0, 13, 2, 1);

            // Rent out a car UI components
            Label rentLabel = new Label("Rent Out a Car");
            grid.add(rentLabel, 0, 14, 2, 1);

            // Car selection (for renting out)
            Label carSelectionLabel = new Label("Select Car:");
            grid.add(carSelectionLabel, 0, 15);
            TextField carSelectionTextField = new TextField();
            grid.add(carSelectionTextField, 1, 15);

            // Client selection (for renting out)
            Label clientSelectionLabel = new Label("Select Client:");
            grid.add(clientSelectionLabel, 0, 16);
            TextField clientSelectionTextField = new TextField();
            grid.add(clientSelectionTextField, 1, 16);

            // Rent Out button
            Button rentOutButton = new Button("Rent Out");
            grid.add(rentOutButton, 0, 17, 2, 1);

            
            // Event handling for adding a car
            addCarButton.setOnAction(event -> {
                String make = makeTextField.getText();
                String model = modelTextField.getText();

                // Retrieve values for additional attributes
                String yearText = yearTextField.getText();
                if (!yearText.isEmpty()) {
                    try {
                        int year = Integer.parseInt(yearText);
                        String carClass = carClassTextField.getText();
                        String category = categoryTextField.getText();
                        String features = featuresTextField.getText();
                        String photos = photosTextField.getText();
                        boolean smoker = smokerCheckBox.isSelected();

                        // Create a new Car object using the provided details
                        Car car = new Car(make, model, year, carClass, category, features, photos, smoker);

                        // Add the created car to the list or perform any other logic
                        cars.add(car);

                        System.out.println("Added Car: " + car);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid year format: " + yearText);
                        // Handle the error (e.g., display an error message to the user)
                    }
                } else {
                    System.err.println("Year field is empty");
                    // Handle the error (e.g., display an error message to the user)
                }
           
            });


            addClientButton.setOnAction(event -> {
                String clientName = nameTextField.getText();
                String clientPhone = phoneTextField.getText();

                // Create a new Client object using the provided details
                Client client = new Client(clients.size() + 1, clientName, clientPhone);

                // Add the created client to the list or perform any other logic
                clients.add(client);

                System.out.println("Added Client: " + client);
            });

            // Event handling for renting out a car
            rentOutButton.setOnAction(event -> {
                // Retrieve values for car selection and client selection
                int carIndex = Integer.parseInt(carSelectionTextField.getText()) - 1;
                int clientIndex = Integer.parseInt(clientSelectionTextField.getText()) - 1;

                // Check if the indices are valid
                if (carIndex >= 0 && carIndex < cars.size() && clientIndex >= 0 && clientIndex < clients.size()) {
                    // Retrieve the selected car and client
                    Car selectedCar = cars.get(carIndex);
                    Client selectedClient = clients.get(clientIndex);

                    // Perform the logic to rent out the car using the Operator class
                    operator.rentOutCar(selectedCar, selectedClient, LocalDateTime.now(), LocalDateTime.now().plusDays(7), "smooth", "No issues reported.");

                    System.out.println("Rented out Car: " + selectedCar + " to Client: " + selectedClient);
                } else {
                    System.out.println("Invalid car or client selection");
                }
            });
            
            createOperatorButton = new Button("Create Operator");
            grid.add(createOperatorButton, 0, 18, 2, 1);
            createOperatorButton.setVisible(false);

            Scene scene = new Scene(grid, 500, 600);
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

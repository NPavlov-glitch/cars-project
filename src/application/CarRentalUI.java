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
    private Button createOperatorButton;
    private User loggedInUser;
    
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
            
            Label companyLabel = new Label("Create Rental Company");
            grid.add(companyLabel, 0, 19, 2, 1);

	         // Create Rental Company UI components
	         Label createCompanyLabel = new Label("Create Rental Company");
	         grid.add(createCompanyLabel, 0, 19, 2, 1);
	
	         Label companyNameLabel = new Label("Company Name:");
	         grid.add(companyNameLabel, 0, 20);
	         TextField companyNameTextField = new TextField();
	         grid.add(companyNameTextField, 1, 20);
	
	         Label companyLocationLabel = new Label("Company Location:");
	         grid.add(companyLocationLabel, 0, 21);
	         TextField companyLocationTextField = new TextField();
	         grid.add(companyLocationTextField, 1, 21);
	
	         // Add Rental Company button
	         Button createCompanyButton = new Button("Create Rental Company");
	         grid.add(createCompanyButton, 0, 22, 2, 1);
	
	         // Create Operator UI components
	         Label createOperatorLabel = new Label("Create Operator");
	         grid.add(createOperatorLabel, 0, 23, 2, 1);
	
	         Label usernameLabel = new Label("Username:");
	         grid.add(usernameLabel, 0, 24);
	         TextField usernameTextField = new TextField();
	         grid.add(usernameTextField, 1, 24);
	
	         Label passwordLabel = new Label("Password:");
	         grid.add(passwordLabel, 0, 25);
	         TextField passwordTextField = new TextField();
	         grid.add(passwordTextField, 1, 25);
	
	         // Add Operator button
	         Button createOperatorButton = new Button("Create Operator");
	         grid.add(createOperatorButton, 0, 26, 2, 1);

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
            
         // Event handling for creating a rental company
            createCompanyButton.setOnAction(event -> {
                String companyName = companyNameTextField.getText();
                String companyLocation = companyLocationTextField.getText();

                // Create a new CarRentalCompany
                CarRentalCompany newCompany = new CarRentalCompany(companyName, companyLocation);

                // Insert the company information into the database
                boolean success = UserDAO.createCompany(newCompany);

                if (success) {
                    // Associate the company with the logged-in administrator
//                    loggedInUser.setCarRentalCompany(newCompany);

                    System.out.println("Created CarRentalCompany: " + newCompany.getName());
                } else {
                    System.out.println("Failed to create CarRentalCompany.");
                    // Handle the error (e.g., display an error message to the user)
                }
            });
            
         // Event handling for creating an operator
            createOperatorButton.setOnAction(event -> {
                String newOperatorUsername = usernameTextField.getText();
                String newOperatorPassword = passwordTextField.getText();

                // Validate the input (you may want to add more validation)
                if (!newOperatorUsername.isEmpty() && !newOperatorPassword.isEmpty()) {
                    // Create a new Operator object or use your existing logic to create an operator

                    // Perform any additional logic (e.g., store the operator in the database)
                     UserDAO.createUser(newOperatorUsername, newOperatorPassword, "Operator");

                    System.out.println("Operator created: " + newOperatorUsername);
                } else {
                    System.out.println("Please enter a valid username and password for the new operator.");
                }
            });

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

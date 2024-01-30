package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class CarRentalUI extends Application {
	
	private List<Car> cars = new ArrayList<>();
    private User loggedInUser;
    
    public CarRentalUI(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Car Rental System");

            // Create a grid pane for the UI components
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(40, 40, 40, 40));

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
            
            Label addressLabel = new Label("Address:");
            grid.add(addressLabel, 0, 13);
            TextField addressTextField = new TextField();
            grid.add(addressTextField, 1, 13);

            // Add Client button
            Button addClientButton = new Button("Add Client");
            grid.add(addClientButton, 0, 14, 2, 1);

            // Rent out a car UI components
            Label rentLabel = new Label("Rent Out a Car");
            grid.add(rentLabel, 0, 15, 2, 1);

            // Car selection (for renting out)
            Label carSelectionLabel = new Label("Select Car:");
            grid.add(carSelectionLabel, 0, 16);
            TextField carSelectionTextField = new TextField();
            grid.add(carSelectionTextField, 1, 16);

            // Client selection (for renting out)
            Label clientSelectionLabel = new Label("Select Client:");
            grid.add(clientSelectionLabel, 0, 17);
            TextField clientSelectionTextField = new TextField();
            grid.add(clientSelectionTextField, 1, 17);

            // Rent Out button
            Button rentOutButton = new Button("Rent Out");
            grid.add(rentOutButton, 0, 18, 2, 1);
            
            Label companyLabel = new Label("Create Rental Company");
            grid.add(companyLabel, 0, 20, 2, 1);

	         // Create Rental Company UI components
	         Label createCompanyLabel = new Label("Create Rental Company");
	         grid.add(createCompanyLabel, 0, 20, 2, 1);
	
	         Label companyNameLabel = new Label("Company Name:");
	         grid.add(companyNameLabel, 0, 21);
	         TextField companyNameTextField = new TextField();
	         grid.add(companyNameTextField, 1, 21);
	
	         Label companyLocationLabel = new Label("Company Location:");
	         grid.add(companyLocationLabel, 0, 22);
	         TextField companyLocationTextField = new TextField();
	         grid.add(companyLocationTextField, 1, 22);
	
	         // Add Rental Company button
	         Button createCompanyButton = new Button("Create Rental Company");
	         grid.add(createCompanyButton, 0, 23, 2, 1);
	
	         // Create Operator UI components
	         Label createOperatorLabel = new Label("Create Operator");
	         grid.add(createOperatorLabel, 0, 24, 2, 1);
	
	         Label usernameLabel = new Label("Username:");
	         grid.add(usernameLabel, 0, 25);
	         TextField usernameTextField = new TextField();
	         grid.add(usernameTextField, 1, 25);
	
	         Label passwordLabel = new Label("Password:");
	         grid.add(passwordLabel, 0, 26);
	         TextField passwordTextField = new TextField();
	         grid.add(passwordTextField, 1, 26);
	
	         // Add Operator button
	         Button createOperatorButton = new Button("Create Operator");
	         grid.add(createOperatorButton, 0, 27, 2, 1);
	         
	         VBox rentalProtocolUI = createRentalProtocolUI();
	         grid.add(rentalProtocolUI, 0, 19, 2, 1);

	         if (loggedInUser != null && "Operator".equals(loggedInUser.getRole())) {
	        	    nameLabel.setVisible(true);
	        	    nameTextField.setVisible(true);
	        	    phoneLabel.setVisible(true);
	        	    phoneTextField.setVisible(true);
	        	    addressLabel.setVisible(true);
	        	    addressTextField.setVisible(true);
	        	    addClientButton.setVisible(true);
	        	} else {
	        	    nameLabel.setVisible(false);
	        	    nameTextField.setVisible(false);
	        	    phoneLabel.setVisible(false);
	        	    phoneTextField.setVisible(false);
	        	    addressLabel.setVisible(false);
	        	    addressTextField.setVisible(false);
	        	    addClientButton.setVisible(false);
	        	}

            // Event handling for adding a car
            addCarButton.setOnAction(event -> {
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
                        Car car = new Car(model, year, carClass, category, features, photos, smoker);
                        
                        boolean success = UserDAO.createCar(car);
                        
                        if (success == true) {
                        	System.out.println("Car added: " + car.getModel() + " " + car.getYear());
                        } else {
                        	System.err.println("Failed to create a car!");
                        }

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
                String clientAddress = addressTextField.getText();

                if ( !clientName.isEmpty() && isValidPhoneNumber(clientPhone) && !clientAddress.isEmpty() ) {
                    
                    Client authenticatedClient = UserDAO.authenticateClient(clientPhone);

                    if ( authenticatedClient == null ) {
                    	Client client = new Client(clientName, clientPhone, clientAddress);
                    	
                    	boolean success = UserDAO.createClient(client);

                        if ( success == true ) {
                        	System.out.println("Added Client: " + client.getName());
                        } else {
                        	System.err.println("Failed to create client!");
                        }
                    } else {
                        // Authentication failed
                    	System.err.println("Clien with this phone already exists");
                    }

                    
                } else {
                	System.err.println("Please add correct client data!");
                }

            });

            // Event handling for renting out a car
            rentOutButton.setOnAction(event -> {
               
            });
            
         // Event handling for creating a rental company
            createCompanyButton.setOnAction(event -> {
                String companyName = companyNameTextField.getText();
                String companyLocation = companyLocationTextField.getText();

                CarRentalCompany newCompany = new CarRentalCompany(companyName, companyLocation);

                boolean success = UserDAO.createCompany(newCompany);

                if (success) {
//                    loggedInUser.setCarRentalCompany(newCompany);

                    System.out.println("Created CarRentalCompany: " + newCompany.getName());
                } else {
                    System.out.println("Failed to create CarRentalCompany.");
                }
            });
            
         // Event handling for creating an operator
            createOperatorButton.setOnAction(event -> {
                String newOperatorUsername = usernameTextField.getText();
                String newOperatorPassword = passwordTextField.getText();

                if (!newOperatorUsername.isEmpty() && !newOperatorPassword.isEmpty()) {
                     UserDAO.createUser(newOperatorUsername, newOperatorPassword, "Operator");

                    System.out.println("Operator created: " + newOperatorUsername);
                } else {
                    System.out.println("Please enter a valid username and password for the new operator.");
                }
            });

            Scene scene = new Scene(grid, 600, 800);
            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public VBox createRentalProtocolUI() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        GridPane carGrid = new GridPane();
        GridPane clientGrid = new GridPane();
        Label carSelectionLabel = new Label("Select Car:");
        carGrid.add(carSelectionLabel, 0, 0);

        ComboBox<SelectOptions> carSelectionComboBox = new ComboBox<>();
        ObservableList<SelectOptions> carOptions = FXCollections.observableArrayList();

        ComboBox<SelectOptions> clientSelectionComboBox = new ComboBox<>();
        ObservableList<SelectOptions> clientOptions = FXCollections.observableArrayList();

        List<Car> allCars = UserDAO.getAllCars();
        for (Car car : allCars) {
            SelectOptions carOption = new SelectOptions(car.getId(), car.getModel() + " " + car.getYear());
            carOptions.add(carOption);
        }

        List<Client> allClients = UserDAO.getAllClients();
        for (Client client : allClients) {
            SelectOptions clientOption = new SelectOptions(client.getId(), client.getName());
            clientOptions.add(clientOption);
        }

        carSelectionComboBox.setItems(carOptions);
        carSelectionComboBox.setConverter(new StringConverter<SelectOptions>() {
            @Override
            public String toString(SelectOptions carOption) {
                return carOption.getDisplayText();
            }

            @Override
            public SelectOptions fromString(String string) {
                // Not needed for this example
                return null;
            }
        });
        carGrid.add(carSelectionComboBox, 1, 0);

        clientSelectionComboBox.setItems(clientOptions);
        clientSelectionComboBox.setConverter(new StringConverter<SelectOptions>() {
            @Override
            public String toString(SelectOptions clientOption) {
                return clientOption.getDisplayText();
            }

            @Override
            public SelectOptions fromString(String string) {
                // Not needed for this example
                return null;
            }
        });
        clientGrid.add(clientSelectionComboBox, 1, 0);

        Label rentalStartDateLabel = new Label("Rental Start Date:");
        DatePicker rentalStartDatePicker = new DatePicker();
        carGrid.add(rentalStartDateLabel, 0, 1);
        carGrid.add(rentalStartDatePicker, 1, 1);

        Label rentalEndDateLabel = new Label("Rental End Date:");
        DatePicker rentalEndDatePicker = new DatePicker();
        carGrid.add(rentalEndDateLabel, 0, 2);
        carGrid.add(rentalEndDatePicker, 1, 2);

        Label rentalNotesLabel = new Label("Rental Notes:");
        TextField rentalNotesTextField = new TextField();
        carGrid.add(rentalNotesLabel, 0, 3);
        carGrid.add(rentalNotesTextField, 1, 3);

        Button rentOutButton = new Button("Rent Out");

        rentOutButton.setOnAction(event -> {
            SelectOptions selectedCarOption    = carSelectionComboBox.getValue();
            SelectOptions selectedClientOption = clientSelectionComboBox.getValue();
            LocalDate 	  startDatePicker 	   = rentalStartDatePicker.getValue();
            LocalDate 	  endDatePicker 	   = rentalEndDatePicker.getValue();
            String 		  rentalNotes 		   = rentalNotesTextField.getText();
            	
            System.out.println("Car ID: " + selectedCarOption.getId() + " Client ID: " + selectedClientOption.getId() );
            boolean success = UserDAO.createRentalProtocol(selectedClientOption, selectedCarOption,
            		startDatePicker, endDatePicker,
                    rentalNotes);
            
            if ( success ) {
            	System.out.println("Rental Protocol Created: " + selectedClientOption.getDisplayText() + " : " + selectedCarOption.getDisplayText());
            } else {
            	System.err.println("Error in creating a rental protocol!");
            }
        });

        vbox.getChildren().addAll(carGrid, clientGrid, rentOutButton);

        return vbox;
    }



    
    private boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^[\\d\\-\\+\\s]+$";
        return phone.matches(phoneRegex);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

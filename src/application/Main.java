package application;
	
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Car testCar = new Car("Toyota", "Camry", 2022, "family", "sedan", "GPS, Air Conditioning", "car.jpg", false);
	        Client testClient = new Client(1, "John Doe", "123-456-7890");
	        LocalDateTime rentalStartDateTime = LocalDateTime.now();
	        LocalDateTime rentalEndDateTime = rentalStartDateTime.plusDays(7); // 7 days rental period

	        RentalProtocol testRentalProtocol = new RentalProtocol(testCar, testClient, rentalStartDateTime, rentalEndDateTime, "smooth", "No issues reported.");

	        // Print rental protocol details to the console
	        System.out.println("Rented Car: " + testRentalProtocol.getRentedCar().getMake() + " " + testRentalProtocol.getRentedCar().getModel());
	        System.out.println("Client: " + testRentalProtocol.getClient().getName());
	        System.out.println("Rental Start Date: " + testRentalProtocol.getRentalStartDateTime());
	        System.out.println("Rental End Date: " + testRentalProtocol.getRentalEndDateTime());
	        System.out.println("Status: " + testRentalProtocol.getStatus());
	        System.out.println("Protocol Description: " + testRentalProtocol.getProtocolDescription());
		        
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

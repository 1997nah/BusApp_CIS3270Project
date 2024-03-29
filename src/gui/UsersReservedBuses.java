package gui;

import businessLogic.ValueObject;
import database.MySQLqueries;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.image.*;

//Scene that shows the buses that the user has already reserved
public class UsersReservedBuses extends Application {
	Stage window;
	Scene scene1;
	//gets userdata
	static ValueObject user = new ValueObject(MySQLqueries.getUser());

	
	public static void main(String[] args) {
		//Generate the PNR
		String PNR = user.generatePNR();
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) {
		 window = primaryStage;
		 
		//Create reservation button and action so that the reservation information is saved into the database
		Button button = new Button("Click to make Reservation");
		button.setOnAction(e -> {
			int busNum = 1234;
			String userName = user.getUsername();
			//calls reserveBus method which will INSERT TO the busRider and reservation data tables
			MySQLqueries.reserveBus(userName, busNum);
		});
		
		//Layout
		VBox menuLayout = new VBox(20);
		menuLayout.getChildren().addAll(button);
		menuLayout.setAlignment(Pos.CENTER);
		scene1 = new Scene(menuLayout, 1024, 683);
				
				
				
		//Set the scene
		window.setScene(scene1);
		window.setTitle("User's Reserved Buses");
		window.show();
			
	}

}

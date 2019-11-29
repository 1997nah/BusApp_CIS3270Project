package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.image.*;


public class Main extends Application {
	Stage window;
	Scene scene1, scene2, scene3;
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		//created two objects, a label and a button
		window.setOnCloseRequest(e -> {
			e.consume();//tells the program to use the answer from the method closeProgram()
			closeProgram();
		});
		
		Label label1 = new Label("Login to the application");
		Button button1 = new Button("Register");
		Button button2 = new Button("book");
		Button button3 = new Button("login");
		Button button4 = new Button("Close");
		button1.setOnAction(e -> window.setScene(scene2)); //added action for the button
		button3.setOnAction(e -> window.setScene(scene3));
		button2.setOnAction(e -> {
			boolean confirm = ConfirmBox.display("New reservation", "Confirm selection");
			System.out.println(confirm);
		});
		button4.setOnAction(e -> closeProgram());
		
		
		//layout 1 = children are laid out in vertical column
		//this is how we want the window arranged
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button3, button1, button2, button4);
		scene1 = new Scene(layout1, 200, 200);
		
		//created two objects, a label and a button
		Label label2 = new Label("Go back, i remembered my password");
		button2 = new Button("return to login screen");
		button2.setOnAction(e -> window.setScene(scene1)); //added action for the button
		
		
		VBox layout2 = new VBox(50);
		layout2.getChildren().addAll(label2, button2);
		scene2 = new Scene(layout2, 600, 300);
		
		
		Label label3 = new Label("Enter username and password");
		button3 = new Button("login");
		button2 = new Button("return to login screen");
		button2.setOnAction(e -> window.setScene(scene1));
		button3.setOnAction(e -> AlertBox.display("Error", "Invalid username and/or password \nPlease try again"));
		
		VBox layout3 = new VBox(30);
		layout3.getChildren().addAll(label3, button3, button2);
		scene3 = new Scene(layout3, 600, 300);
		
		
		window.setScene(scene1);
		window.setTitle("Login Screen");
		window.show();
	}
	
	private void closeProgram() {
		boolean confirm = ConfirmBox.display("Close Program?", "Are you sure you want to close?");
		
		if (confirm) {
			System.out.println("File is saved!");
			window.close();
		} else {
			window.setScene(scene1);
		}
	}
	

}
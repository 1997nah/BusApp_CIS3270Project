package gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	
	public static void display(String title, String message) {
		
		Stage window = new Stage();
		
		//this forces the user to take care of this window before going back to the main window
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(350);
		
		Label label = new Label();
		label.setText(message);
		
		Button closeButton =  new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait(); //this blocks user interaction until the aler box is closed
	}

}

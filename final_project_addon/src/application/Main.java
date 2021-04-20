package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Button extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			String linkURL = "https://www.twitch.tv/caldraeus";											//Link button leads to
			String linkImageURL = "https://i.imgur.com/hKWnpw5.png"; 									//Link image URL
			String backroundURL = "https://i.imgur.com/OljjBeF.png"; 									//Background image URL
			
			Image i = new Image(backroundURL);															//Generate background image
			ImageView imageView = new ImageView(i);
			root.getChildren().add(imageView);
			
			Image linkImage = new Image(linkImageURL);													//Prepare link image
			ImageView linkImageView = new ImageView(linkImage);
				
			Hyperlink link = new Hyperlink();															//Generate hyperlink
			link.setLayoutX(150);
			link.setLayoutY(175);
			link.setGraphic(linkImageView);
			link.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			        //System.out.println("This link is clicked");
			        getHostServices().showDocument(linkURL);											//Load link
			        ((Stage)root.getScene().getWindow()).close();										//Close image
			    }
			});
			root.getChildren().add(link);
			
			primaryStage.setResizable(false);															//Disable Resizing
			primaryStage.setTitle("Twitch Link Button");												//Title Application
			primaryStage.setScene(scene);
			primaryStage.show();																		//Display Window
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
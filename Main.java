package application;
import java.util.Base64;
import java.util.Base64.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.BASELINE_LEFT);
			grid.setHgap(10); //Horizontal
			grid.setVgap(10); //Vertical
			grid.setPadding(new Insets(25,25,25,25));
			Scene scene = new Scene(grid,400,400);
			
			Label etiqueta =new Label("Palabra");
			grid.add(etiqueta, 0, 1);
			
			TextField palabraCaja =new TextField();
			grid.add(palabraCaja,1,1);
			
			Button botonEncriptar = new Button("Encriptar");
			grid.add(botonEncriptar,1,2);
			botonEncriptar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					byte [] palabra = palabraCaja.getText().getBytes();
					String resultado= Base64.getEncoder().encodeToString(palabra);
					palabraCaja.setText(String.valueOf(resultado));
				}	
			});
			
			Button botonDesencriptar = new Button("Desencriptar");
			grid.add(botonDesencriptar,2,2);
			botonDesencriptar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String a=palabraCaja.getText();
					Base64.Decoder palabra = Base64.getDecoder();
					byte[] resultado = palabra.decode(a);
					String desencriptado = new String(resultado);
					palabraCaja.setText(desencriptado);
					
				}	
			});
			
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

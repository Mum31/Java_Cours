package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importer le Button
import javafx.scene.control.Label;
import javafx.scene.layout.VBox; // Utiliser VBox pour organiser les éléments
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer un label
        Label label = new Label("Bonjour, JavaFX !");
        
        // Créer un bouton
        Button button = new Button("Cliquez ici");

        // Ajouter une action au bouton
        button.setOnAction(event -> {
            System.out.println("Button clicked");
        });

        // Utiliser un VBox pour organiser le label et le bouton
        VBox vbox = new VBox(label, button); // Créer un VBox avec le label et le bouton

        // Créer une scène avec le VBox
        Scene scene = new Scene(vbox, 300, 250);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        
        // Configurer la fenêtre principale
        primaryStage.setTitle("Ma Première Application JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
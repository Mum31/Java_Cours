package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App extends Application {

    private TableView<User> tableView;
    private ObservableList<User> userList;
    private Connexion connexion;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialiser la connexion à la base de données
        connexion = new Connexion("jdbc:mysql://localhost:3306/mabase", "root", "");
        userList = FXCollections.observableArrayList();

        // Charger les utilisateurs depuis la base de données
        loadUsersFromDatabase();

        // Création de la TableView
        tableView = new TableView<>();
        TableColumn<User, String> nameColumn = new TableColumn<>("Nom");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<User, String> surnameColumn = new TableColumn<>("Prénom");
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());

        TableColumn<User, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        tableView.getColumns().addAll(nameColumn, surnameColumn, emailColumn);

        // Créer un bouton "Ajouter"
        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> showAddUserDialog());

        // Créer un layout principal
        VBox vbox = new VBox();
        vbox.getChildren().addAll(tableView, addButton);

        // Configurer la scène
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Gestion des Utilisateurs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadUsersFromDatabase() {
        try (Connection connection = connexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                userList.add(new User(name, surname, email));
            }
            tableView.setItems(userList);

        } catch (SQLException e) {
            System.out.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }

    private void showAddUserDialog() {
        // Créer une nouvelle fenêtre pour ajouter un utilisateur
        Stage dialog = new Stage();
        dialog.setTitle("Ajouter un Utilisateur");
        dialog.initModality(Modality.APPLICATION_MODAL);

        // Champs de saisie
        TextField nameField = new TextField();
        nameField.setPromptText("Nom");
        TextField surnameField = new TextField();
        surnameField.setPromptText("Prénom");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        // Bouton pour valider l'ajout
        Button addButton = new Button("Ajouter");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String email = emailField.getText();

            if (!name.isEmpty() && !surname.isEmpty() && !email.isEmpty()) {
                User newUser = new User(name, surname, email);
                userList.add(newUser);
                tableView.setItems(userList);
                // Insérer l'utilisateur dans la base de données
                insertUserIntoDatabase(newUser);
                dialog.close();
            } else {
                // Alerte si les champs sont vides
                Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez remplir tous les champs.", ButtonType.OK);
                alert.showAndWait();
            }
        });

        // Layout pour le dialogue
        VBox dialogLayout = new VBox(10);
        dialogLayout.getChildren().addAll(nameField, surnameField, emailField, addButton);
        dialogLayout.setPrefWidth(300);

        Scene dialogScene = new Scene(dialogLayout);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }

    private void insertUserIntoDatabase(User user) {
        try (Connection connection = connexion.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO users (name, surname, email) VALUES ('"
                    + user.getName() + "', '"
                    + user.getSurname() + "', '"
                    + user.getEmail() + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion de l'utilisateur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
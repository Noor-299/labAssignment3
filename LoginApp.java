import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginApp extends Application {

    // Predefined usernames and passwords
    private final String[][] credentials = {
            {"user1", "pass1"},
            {"user2", "pass2"},
            {"admin", "adminpass"}
    };

    @Override
    public void start(Stage primaryStage) {
        // Load an image
        Image image = new Image("im.png"); // Adjust the path if needed
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);

        // Username and Password fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // Buttons
        Button loginButton = new Button("Login");
        Button cancelButton = new Button("Cancel");
        Button exitButton = new Button("Exit");

        // Label for notifications
        Label notificationLabel = new Label();

        // Login button action
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (validateCredentials(username, password)) {
                notificationLabel.setText("Login successful!");
            } else {
                notificationLabel.setText("Invalid username or password.");
            }
        });

        // Cancel button action
        cancelButton.setOnAction(e -> {
            usernameField.clear();
            passwordField.clear();
            notificationLabel.setText("");
        });

    
        exitButton.setOnAction(e -> primaryStage.close());

    
        VBox layout = new VBox(10);
        layout.getChildren().addAll(imageView, usernameField, passwordField, loginButton, cancelButton, exitButton, notificationLabel);

    
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private boolean validateCredentials(String username, String password) {
        for (String[] pair : credentials) {
            if (pair[0].equals(username) && pair[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
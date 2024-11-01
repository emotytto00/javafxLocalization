import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedDBApp extends Application {

    private ResourceBundle bundle;
    private ComboBox<String> languageSelector;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField emailField;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label emailLabel;
    private Button saveButton;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Localized Database");

        // Language Selection Dropdown
        languageSelector = new ComboBox<>();
        languageSelector.getItems().addAll("English", "Farsi", "Japanese");
        languageSelector.setValue("English"); // Default language

        // Labels and Input Fields
        firstNameLabel = new Label();
        lastNameLabel = new Label();
        emailLabel = new Label();
        firstNameField = new TextField();
        lastNameField = new TextField();
        emailField = new TextField();
        saveButton = new Button();

        // Language change listener
        languageSelector.setOnAction(e -> updateLanguage());

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("Select Language:"), 0, 0);
        grid.add(languageSelector, 1, 0);
        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameField, 1, 1);
        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(emailLabel, 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(saveButton, 1, 4);

        // Load default language (English)
        updateLanguage();

        // Save button action
        saveButton.setOnAction(e -> saveEmployee());

        // Scene setup
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Update the UI language based on selection
    private void updateLanguage() {
        Locale locale;
        switch (languageSelector.getValue()) {
            case "Farsi":
                locale = new Locale("fa");
                break;
            case "Japanese":
                locale = new Locale("ja");
                break;
            default:
                locale = new Locale("en");
                break;
        }
        bundle = ResourceBundle.getBundle("Bundle", locale);
        firstNameLabel.setText(bundle.getString("first_name"));
        lastNameLabel.setText(bundle.getString("last_name"));
        emailLabel.setText(bundle.getString("email"));
        saveButton.setText(bundle.getString("save"));
    }

    // Save employee to the respective language table in the database
    private void saveEmployee() {
        String language = languageSelector.getValue();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();

        // Call method to insert into the respective table based on selected language
        DatabaseHelper.insertEmployee(language, firstName, lastName, email);
    }
}

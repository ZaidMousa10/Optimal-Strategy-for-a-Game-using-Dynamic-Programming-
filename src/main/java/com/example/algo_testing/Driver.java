package com.example.algo_testing;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Driver class that serves as the main entry point for the JavaFX application.
 * This application is a "Win Max Money Game" with different game modes, dynamic programming solutions,
 * and a visually appealing UI.
 */

public class Driver extends Application {
    private Solution solution; // Instance of the Solution class that handles the DP logic and game mechanics.

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Win Max Money Game");
        primaryStage.getIcons().add(new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/coin (1).png"));
        solution = new Solution();

        Scene firstPageScene = welcomePageScene(primaryStage);
        primaryStage.setScene(firstPageScene);
        primaryStage.show();
    }

    // Creates the first page with "Play" and "Exit" buttons
    private Scene welcomePageScene(Stage primaryStage) {
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.57_de8646b4.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        Image icon = new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/tokens.png");
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);

        Label welcomeLabel = new Label("Welcome to Win Max Money Game!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #ef0afc; -fx-font-weight: bold;");

        Button playButton = createIconButton("Play", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/play (2).png");
        Button exitButton = createIconButton("Exit", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/exit (1).png");

        // Button actions
        playButton.setOnAction(e -> primaryStage.setScene(modeSelectionScene(primaryStage)));
        exitButton.setOnAction(e -> primaryStage.close());

        VBox layout = new VBox(20.0, imageView, welcomeLabel, playButton, exitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");
        layout.setBackground(new Background(bgImage));

        return new Scene(layout, 1500, 750);
    }
    // Scene for selecting game mode (Computer vs Computer or Player vs Player)
    private Scene modeSelectionScene(Stage primaryStage) {
        // Set stage size and alignment
        primaryStage.setWidth(1500);
        primaryStage.setHeight(750);
        primaryStage.centerOnScreen();
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.57_7cd5e3ec.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        Image icon = new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/assign.png");
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);

        Label modeLabel = new Label("Choose Game Mode!");
        modeLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #ef0afc; -fx-font-weight: bold;");

        Button computerVsComputerButton = createIconButton("Computer vs Computer", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/match.png");
        Button playerVsPlayerButton = createIconButton("Player vs Player", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/competition (1).png");
        Button backButton = createIconButton("Back", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");

        // Button actions
        computerVsComputerButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlaySceneComputerVsComputer(primaryStage)));
        playerVsPlayerButton.setOnAction(e -> primaryStage.setScene(playerNameInputScene(primaryStage)));
        backButton.setOnAction(e -> primaryStage.setScene(welcomePageScene(primaryStage)));

        HBox selectionButtons = new HBox(20.0, computerVsComputerButton, playerVsPlayerButton);
        selectionButtons.setAlignment(Pos.CENTER);
        VBox layout = new VBox(20.0, imageView, modeLabel,selectionButtons, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");
        layout.setBackground(new Background(bgImage));

        return new Scene(layout, 1500, 750);
    }
    // Scene for input selection for computer vs computer
    private Scene chooseHowtoPlaySceneComputerVsComputer(Stage primaryStage) {
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.58_b02e5a96.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );

        Image icon = new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/cost.png");
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);

        Label welcomeLabel = new Label("Choose how to enter values!");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #ef0afc; -fx-font-weight: bold;");

        Button browseButton = createIconButton("Browse File", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/folder (1).png");
        Button keyboardButton = createIconButton("By Keyboard", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/keyboard (2).png");
        Button randomButton = createIconButton("Random", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/random.png");
        Button backButton = createIconButton("Back", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");

        // Button actions for different input methods
        browseButton.setOnAction(e -> displayFileInputWithNavigationComputerVsComputer(primaryStage));
        keyboardButton.setOnAction(e -> displayKeyboardInputComputerVsComputer(primaryStage));
        randomButton.setOnAction(e -> displayRandomInputComputerVsComputer(primaryStage));
        backButton.setOnAction(e -> primaryStage.setScene(modeSelectionScene(primaryStage)));

        VBox layout = new VBox(20.0, imageView, welcomeLabel, browseButton, keyboardButton, randomButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");
        layout.setBackground(new Background(bgImage));
        primaryStage.centerOnScreen();

        return new Scene(layout, 1500, 750);
    }
    // Enter the name of the two players
    private Scene playerNameInputScene(Stage primaryStage) {
        // Center the stage on the screen
        primaryStage.setWidth(600);  // Set the stage width
        primaryStage.setHeight(600); // Set the stage height
        primaryStage.centerOnScreen(); // Center the stage on the screen
        // Load the background image
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.58_b02e5a96.jpg",
                        1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        Image icon = new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/sports.png");
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);


        // Label for the title
        Label nameInputLabel = new Label("Enter Player Names");
        nameInputLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #ef0afc; -fx-font-weight: bold;");

        // Input fields for player names
        TextField player1Field = new TextField();
        player1Field.setPromptText("Enter Player 1 Name");
        player1Field.setStyle("-fx-font-size: 16px;");

        TextField player2Field = new TextField();
        player2Field.setPromptText("Enter Player 2 Name");
        player2Field.setStyle("-fx-font-size: 16px;");

        // Buttons with icons
        Button proceedButton = createIconButton("Start", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/start-here.png");
        Button backButton = createIconButton("Back", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");

        // Button actions
        proceedButton.setOnAction(e -> {
            String player1Name = player1Field.getText().trim();
            String player2Name = player2Field.getText().trim();

            if (player1Name.isEmpty() || player2Name.isEmpty()) {
                showAlert("Invalid Input", "Please enter names for both players!");
            } else {
                // Proceed to the next scene, passing player names
                primaryStage.setScene(chooseHowtoPlayScenePlayerVsPlayer(primaryStage, player1Name, player2Name));
            }
        });

        backButton.setOnAction(e -> primaryStage.setScene(modeSelectionScene(primaryStage)));

        // Center layout containing all elements
        VBox layout = new VBox(20,imageView, nameInputLabel, player1Field, player2Field, proceedButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");

        // Add the background image and center everything
        StackPane root = new StackPane(layout);
        root.setBackground(new Background(bgImage));

        // Create and return the scene
        Scene scene = new Scene(root, 600, 600);

        return scene;
    }
    /* Scene for selecting game mode (Player vs Player Scene)
        * this scene make a choices to play by (keyboard,file,and random0
    */
    private Scene chooseHowtoPlayScenePlayerVsPlayer(Stage primaryStage, String player1Name, String player2Name) {
        primaryStage.setWidth(1500);  // Set the stage width
        primaryStage.setHeight(750); // Set the stage height
        primaryStage.centerOnScreen(); // Center the stage on the screen

        // Background image
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.58_b02e5a96.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );

        Image icon = new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/versus (2).png");
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);

        // Title label
        Label titleLabel = new Label("Choose Input Method");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #e80af6; -fx-font-weight: bold;");

        // Buttons for input options
        Button keyboardInputButton = createIconButton("Keyboard Input", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/keyboard (2).png");
        Button fileInputButton = createIconButton("File Input", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/drive.png");
        Button randomInputButton = createIconButton("Random Input", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/random.png");
        Button backButton = createIconButton("Back", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");

        // Button actions
        keyboardInputButton.setOnAction(e -> primaryStage.setScene(displayKeyboardInputPlayerVsPlayer(primaryStage, player1Name, player2Name)));
        fileInputButton.setOnAction(e -> displayFileInputWithNavigationPlayerVsPlayer(primaryStage, player1Name, player2Name));
        randomInputButton.setOnAction(e -> displayRandomInputPlayerVsPlayer(primaryStage, player1Name, player2Name));
        backButton.setOnAction(e -> primaryStage.setScene(playerNameInputScene(primaryStage)));

        // Layout
        VBox layout = new VBox(20.0, imageView, titleLabel, keyboardInputButton, fileInputButton, randomInputButton, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(bgImage));

        return new Scene(layout, 1500, 750);
    }
    /* Scene for keyboard (Player vs Player Scene)
        * this scene allows users to enter elements and values using keyboard input
    */
    private Scene displayKeyboardInputPlayerVsPlayer(Stage primaryStage, String player1Name, String player2Name) {
        primaryStage.setWidth(500);  // Set the stage width
        primaryStage.setHeight(300); // Set the stage height
        primaryStage.centerOnScreen(); // Center the stage on the screen

        // Layout components
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #2d2d2d;");

        Label headerLabel = new Label("Enter the number of elements and values:");
        headerLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #ffffff; -fx-font-weight: bold;");

        TextField numElementsField = new TextField();
        numElementsField.setPromptText("Number of Elements (even number)");
        numElementsField.setStyle("-fx-font-size: 14px; -fx-padding: 8px;");

        TextField valuesField = new TextField();
        valuesField.setPromptText("Enter values separated by space");
        valuesField.setStyle("-fx-font-size: 14px; -fx-padding: 8px;");

        Label errorLabel = new Label(); // Label for error messages
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 10px 20px;");
        submitButton.setCursor(Cursor.HAND);
        submitButton.setDisable(true); // Disable submit initially

        Button cancelButton = new Button("Cancel");
        cancelButton.setCursor(Cursor.HAND);
        cancelButton.setStyle("-fx-font-size: 16px; -fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 10px 20px;");

        // Real-time validation for inputs
        ChangeListener<String> validationListener = (observable, oldValue, newValue) -> {
            errorLabel.setText(""); // Clear previous errors
            submitButton.setDisable(!isInputValidPlayerVsPlayer(numElementsField, valuesField, errorLabel));
        };

        numElementsField.textProperty().addListener(validationListener);
        valuesField.textProperty().addListener(validationListener);

        // Submit button action
        submitButton.setOnAction(e -> {
            int numElements = Integer.parseInt(numElementsField.getText().trim());
            String[] values = valuesField.getText().trim().split("\\s+");
            Integer[] elements = new Integer[numElements];
            for (int i = 0; i < numElements; i++) {
                elements[i] = Integer.parseInt(values[i]);
            }
            startPlayerVsPlayerGame(primaryStage, player1Name, player2Name, elements);
        });

        // Cancel button action
        cancelButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlayScenePlayerVsPlayer(primaryStage, player1Name, player2Name)));

        // Buttons layout
        HBox buttonBox = new HBox(20, submitButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add components to layout
        layout.getChildren().addAll(headerLabel, numElementsField, valuesField, errorLabel, buttonBox);

        // Create scene
        return new Scene(layout, 500, 300);
    }
    // Helper method to validate input for keyboard
    private boolean isInputValidPlayerVsPlayer(TextField numElementsField, TextField valuesField, Label errorLabel) {
        try {
            String numElementsText = numElementsField.getText().trim();
            String valuesText = valuesField.getText().trim();

            // Ensure the number of elements is a valid integer
            int numElements = Integer.parseInt(numElementsText);

            // Ensure the number of elements is even
            if (numElements % 2 != 0) {
                errorLabel.setText("The number of elements must be an even number.");
                return false;
            }

            // Split and validate values
            String[] values = valuesText.split("\\s+");
            if (values.length != numElements) {
                errorLabel.setText("Number of values must match the number of elements.");
                return false;
            }

            // Ensure all values are positive integers
            for (String value : values) {
                int coinValue = Integer.parseInt(value);
                if (coinValue < 0) {
                    errorLabel.setText("All coin values must be positive integers.");
                    return false;
                }
            }

            return true; // Input is valid
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid integers for elements and values.");
            return false;
        }
    }
    // Display file input with navigation Player Vs Player mode
    private void displayFileInputWithNavigationPlayerVsPlayer(Stage primaryStage, String player1Name, String player2Name) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try (Scanner scanner = new Scanner(file)) {
                int gameCount = 0;
                int maxGames = 100; // Adjust the maximum number of games as needed
                Integer[][] games = new Integer[maxGames][];

                // Parse the file for multiple games
                while (scanner.hasNextInt() && gameCount < maxGames) {
                    int numElements = scanner.nextInt();
                    Integer[] elements = new Integer[numElements];
                    for (int i = 0; i < numElements; i++) {
                        if (scanner.hasNextInt()) {
                            elements[i] = scanner.nextInt();
                        } else {
                            showAlert("File Error", "File does not contain enough elements for one of the games.");
                            return;
                        }
                    }
                    games[gameCount++] = elements; // Add game to the array
                }

                if (gameCount == 0) {
                    showAlert("File Error", "The file does not contain any valid game data.");
                    return;
                }

                // Start navigation
                navigateGamesPlayerVsPlayer(primaryStage, player1Name, player2Name, games, gameCount);
            } catch (Exception e) {
                showAlert("File Error", "Error reading the file.");
            }
        }
    }
    //Display Games number and elements method
    private void navigateGamesPlayerVsPlayer(Stage primaryStage, String player1Name, String player2Name, Integer[][] games, int gameCount) {
        // Background image
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.58_b02e5a96.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );

        final int[] currentGameIndex = {0}; // Track the current game

        // Create UI components
        Label gameLabel = new Label("Game 1");
        gameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #e80af6;");

        VBox gameInputBox = new VBox(10); // Container for the game's inputs
        gameInputBox.setAlignment(Pos.CENTER);

        // Buttons with icons
        Button nextButton = createIconButton("Next", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/arrow (1).png");
        Button previousButton = createIconButton("Previous", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");
        previousButton.setDisable(true); // Disable previous button initially

        Button playButton = createIconButton("Play", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/play.png");

        // Event handler for the Next button
        nextButton.setOnAction(e -> {
            currentGameIndex[0]++;
            updateGameNavigationUIPlayerVsPlayer(gameLabel, previousButton, nextButton, currentGameIndex[0], gameCount);
            updateGameInputsPlayerVsPlayer(gameInputBox, games, currentGameIndex[0]);
        });

        // Event handler for the Previous button
        previousButton.setOnAction(e -> {
            currentGameIndex[0]--;
            updateGameNavigationUIPlayerVsPlayer(gameLabel, previousButton, nextButton, currentGameIndex[0], gameCount);
            updateGameInputsPlayerVsPlayer(gameInputBox, games, currentGameIndex[0]);
        });

        // Event handler for the Play button
        playButton.setOnAction(e -> {
            Integer[] selectedGame = games[currentGameIndex[0]];
            startPlayerVsPlayerGame(primaryStage, player1Name, player2Name, selectedGame);
        });

        // HBox for Previous and Next buttons
        HBox navigationButtons = new HBox(20, previousButton, nextButton);
        navigationButtons.setAlignment(Pos.CENTER);

        // Layout
        VBox navigationLayout = new VBox(20, gameLabel, gameInputBox, navigationButtons, playButton);
        navigationLayout.setAlignment(Pos.CENTER);
        navigationLayout.setStyle("-fx-padding: 20px;");
        navigationLayout.setBackground(new Background(bgImage)); // Add the background

        primaryStage.setScene(new Scene(navigationLayout, 600, 400)); // Adjust dimensions for layout
        primaryStage.centerOnScreen();

        // Initially set the game inputs
        updateGameInputsPlayerVsPlayer(gameInputBox, games, currentGameIndex[0]);
    }
    // Helper method to update the navigation UI
    private void updateGameNavigationUIPlayerVsPlayer(Label gameLabel, Button previousButton, Button nextButton, int currentGameIndex, int gameCount) {
        gameLabel.setText("Game " + (currentGameIndex + 1));
        previousButton.setDisable(currentGameIndex == 0); // Disable if it's the first game
        nextButton.setDisable(currentGameIndex == gameCount - 1); // Disable if it's the last game
    }
    // Helper method to update the displayed inputs for the current game
    private void updateGameInputsPlayerVsPlayer(VBox gameInputBox, Integer[][] games, int currentGameIndex) {
        // Clear the previous game inputs
        gameInputBox.getChildren().clear();

        Integer[] currentGame = games[currentGameIndex];
        Label inputsLabel = new Label("Game Inputs:");
        inputsLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;  -fx-text-fill: #e80af6;");

        // Create input fields for the current game (if needed, you can adjust based on how you want to display them)
        Label gameElementsLabel = new Label("Elements: " + Arrays.toString(currentGame));
        gameElementsLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #e80af6;");

        // Add elements to the game input box
        gameInputBox.getChildren().addAll(inputsLabel, gameElementsLabel);
    }
    /* Scene for random input (Player vs Player Scene)
     * this scene allows users to enter elements and values generating randomly input
     */
    private void displayRandomInputPlayerVsPlayer(Stage primaryStage, String player1Name, String player2Name) {
        primaryStage.setWidth(700); // Set the stage width
        primaryStage.setHeight(700); // Set the stage height
        primaryStage.centerOnScreen(); // Center the stage on the screen

        // Layout setup
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2d2d2d;");

        Label headerLabel = new Label("Generate Random Input Configuration");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

        TextField numElementsField = new TextField();
        numElementsField.setPromptText("Number of Elements (even number)");
        numElementsField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        TextField minRangeField = new TextField();
        minRangeField.setPromptText("Minimum Range");
        minRangeField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        TextField maxRangeField = new TextField();
        maxRangeField.setPromptText("Maximum Range");
        maxRangeField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        Label errorLabel = new Label(); // Label to display error messages
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");

        Button generateButton = new Button("Generate");
        generateButton.setCursor(Cursor.HAND);
        generateButton.setStyle("-fx-font-size: 16px; -fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 10px 20px;");
        generateButton.setDisable(true); // Initially disabled

        Button backButton = new Button("Back");
        backButton.setCursor(Cursor.HAND);
        backButton.setStyle("-fx-font-size: 16px; -fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 10px 20px;");

        // Real-time validation for inputs
        ChangeListener<String> validationListener = (observable, oldValue, newValue) -> {
            errorLabel.setText(""); // Clear previous errors
            generateButton.setDisable(!isRandomInputValidPlayerVsPlayer(numElementsField, minRangeField, maxRangeField, errorLabel));
        };

        numElementsField.textProperty().addListener(validationListener);
        minRangeField.textProperty().addListener(validationListener);
        maxRangeField.textProperty().addListener(validationListener);

        // Generate button action
        generateButton.setOnAction(e -> {
            int numElements = Integer.parseInt(numElementsField.getText().trim());
            int minRange = Integer.parseInt(minRangeField.getText().trim());
            int maxRange = Integer.parseInt(maxRangeField.getText().trim());

            // Generate random numbers
            Integer[] elements = new Integer[numElements];
            for (int i = 0; i < numElements; i++) {
                elements[i] = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
            }

            startPlayerVsPlayerGame(primaryStage, player1Name, player2Name, elements);
        });

        // Back button action
        backButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlayScenePlayerVsPlayer(primaryStage, player1Name, player2Name)));

        // Buttons layout
        HBox buttonBox = new HBox(20, generateButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add components to layout
        layout.getChildren().addAll(headerLabel, numElementsField, minRangeField, maxRangeField, errorLabel, buttonBox);

        // Set the scene and display
        Scene randomInputScene = new Scene(layout, 700, 700);
        primaryStage.setScene(randomInputScene);
    }
    // Helper method for input validation
    private boolean isRandomInputValidPlayerVsPlayer(TextField numElementsField, TextField minRangeField, TextField maxRangeField, Label errorLabel) {
        try {
            String numElementsText = numElementsField.getText().trim();
            String minRangeText = minRangeField.getText().trim();
            String maxRangeText = maxRangeField.getText().trim();

            // Validate number of elements
            int numElements = Integer.parseInt(numElementsText);
            if (numElements % 2 != 0) {
                errorLabel.setText("The number of elements must be an even number.");
                return false;
            }

            // Validate range values
            int minRange = Integer.parseInt(minRangeText);
            int maxRange = Integer.parseInt(maxRangeText);

            // Check if minimum range is negative
            if (minRange < 0) {
                errorLabel.setText("Minimum range must be a non-negative number (no minus coins allowed).");
                return false;
            }

            // Check if minimum range is greater than maximum range
            if (minRange > maxRange) {
                errorLabel.setText("Minimum range must be less than or equal to the maximum range.");
                return false;
            }


            return true; // All inputs are valid
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid integers for all fields.");
            return false;
        }
    }
    // Method to start(enter) the game of Player vs Player
    private void startPlayerVsPlayerGame(Stage primaryStage, String player1Name, String player2Name, Integer[] elements) {
        primaryStage.setWidth(1500);  // Set the stage width
        primaryStage.setHeight(750); // Set the stage height

        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.56_fbebc9e8.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        // Initialize player scores and current indices
        int[] player1Score = {0};
        int[] player2Score = {0};
        final int[] leftIndex = {0};
        final int[] rightIndex = {elements.length - 1};

        // Player turn tracker (true = Player 1, false = Player 2)
        boolean[] isPlayer1Turn = {true};

        // Create labels for the game state
        Label player1Label = new Label(player1Name + ": 0");
        player1Label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #e80af6;");
        Label player2Label = new Label(player2Name + ": 0");
        player2Label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #e80af6;");
        Label turnLabel = new Label(player1Name + "'s Turn");
        turnLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #e80af6;");

        // Create a list of styled buttons for all elements
        HBox buttonsBox = new HBox(10);
        buttonsBox.setAlignment(Pos.CENTER);

        Button[] elementButtons = new Button[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementButtons[i] = new Button(elements[i].toString());
            elementButtons[i].setDisable(true);
            elementButtons[i].setMinSize(80, 80); // Uniform size
            elementButtons[i].setStyle(
                    "-fx-background-color: #e80af6; " + // Soft pink background
                            "-fx-border-color: #4a3e93; " + // Dark pink border
                            "-fx-border-width: 5px; " + // Thin border
                            "-fx-text-fill: #000000; " + // Magenta text color
                            "-fx-font-size: 16px; " +
                            "-fx-font-weight: bold; " +
                            "-fx-alignment: center;" +
                            "-fx-border-radius: 20px; " +
                            "-fx-background-radius: 20px;"
            );
            elementButtons[i].setCursor(Cursor.HAND);
            final int index = i;

            // Button actions
            elementButtons[i].setOnAction(e -> {
                if (isPlayer1Turn[0]) {
                    if (index == leftIndex[0]) {
                        player1Score[0] += elements[leftIndex[0]];
                    } else if (index == rightIndex[0]) {
                        player1Score[0] += elements[rightIndex[0]];
                    }
                    player1Label.setText(player1Name + ": " + player1Score[0]);
                } else {
                    if (index == leftIndex[0]) {
                        player2Score[0] += elements[leftIndex[0]];
                    } else if (index == rightIndex[0]) {
                        player2Score[0] += elements[rightIndex[0]];
                    }
                    player2Label.setText(player2Name + ": " + player2Score[0]);
                }

                // Disable the selected button and update the game state
                elementButtons[index].setDisable(true);
                if (index == leftIndex[0]) {
                    leftIndex[0]++;
                } else if (index == rightIndex[0]) {
                    rightIndex[0]--;
                }

                // Update the game state
                updateGameStatePlayerVsPlayer(primaryStage, turnLabel, player1Name, player2Name, isPlayer1Turn, elements, leftIndex[0], rightIndex[0], player1Score, player2Score, elementButtons);
            });
        }

        // Initially enable only the first and last buttons
        elementButtons[0].setDisable(false);
        elementButtons[elements.length - 1].setDisable(false);

        // Add all buttons to the HBox
        buttonsBox.getChildren().addAll(elementButtons);

        // Layout
        VBox scoreBox = new VBox(10, player1Label, player2Label);
        scoreBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(30, turnLabel, scoreBox, buttonsBox);
        layout.setBackground(new Background(bgImage));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30px;");

        // Set the stage
        primaryStage.setScene(new Scene(layout, 1500, 750));
        primaryStage.centerOnScreen(); // Ensure the stage is centered
        primaryStage.show();
    }
    // Method to display the game result (Player vs Player)
    private void updateGameStatePlayerVsPlayer(Stage primaryStage, Label turnLabel,
                                               String player1Name, String player2Name, boolean[] isPlayer1Turn,
                                               Integer[] elements, int leftIndex, int rightIndex,
                                               int[] player1Score, int[] player2Score, Button[] elementButtons) {
        primaryStage.setWidth(1500);  // Set the stage width
        primaryStage.setHeight(750); // Set the stage height
        // Check if the game is over
        if (leftIndex > rightIndex) {
            String winner;
            if (player1Score[0] > player2Score[0]) {
                winner = player1Name + " wins with a score of " + player1Score[0];
            } else if (player2Score[0] > player1Score[0]) {
                winner = player2Name + " wins with a score of " + player2Score[0];
            } else {
                winner = "It's a tie!";
            }

            // Display game result
            showGameResultPlayerVsPlayer(primaryStage, winner,player1Name,player2Name);
            return;
        }

        // Update turn
        isPlayer1Turn[0] = !isPlayer1Turn[0];
        turnLabel.setText((isPlayer1Turn[0] ? player1Name : player2Name) + "'s Turn");

        // Disable the buttons for the first and last elements if they are selected
        for (int i = 0; i < elementButtons.length; i++) {
            if (i == leftIndex) {
                elementButtons[i].setText("" + elements[leftIndex]);
                elementButtons[i].setDisable(false);
            } else if (i == rightIndex) {
                elementButtons[i].setText("" + elements[rightIndex]);
                elementButtons[i].setDisable(false);
            } else {
                elementButtons[i].setDisable(true);
            }
        }
    }

    // Method to display the game result (Player vs player)
    private void showGameResultPlayerVsPlayer(Stage primaryStage, String result, String player1Name, String player2Name) {

        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/abstract-elegant-gold-glowing-with-lighting-effect-sparkle-on-black-background-template-premium-award-design-free-vector.jpg", 1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );


        Image icon = new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/winner.png");
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(100.0);
        imageView.setFitHeight(100.0);

        Label resultLabel = new Label(result);
        resultLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: gold ; -fx-font-weight: bold;");

        // Back to Main Menu button
        Button backButton = new Button("Back to Main Menu");
        backButton.setStyle("-fx-font-size: 18px; -fx-background-color: #4B3E94; -fx-text-fill: gold; " +
                "-fx-font-weight: bold; -fx-padding: 12px 24px; -fx-border-radius: 18px; -fx-background-radius: 18px;");

        // Apply hover effects for button
        backButton.setOnMouseEntered(e -> {
            backButton.setStyle("-fx-background-color: #151515; -fx-font-size: 18px; " +
                    "-fx-text-fill: gold; -fx-font-weight: bold; -fx-padding: 12px 24px; " +
                    "-fx-border-radius: 18px; -fx-background-radius: 18px;");
            backButton.setCursor(Cursor.HAND);
        });
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #4B3E94; -fx-font-size: 18px; " +
                "-fx-text-fill: gold; -fx-font-weight: bold; -fx-padding: 12px 24px; " +
                "-fx-border-radius: 18px; -fx-background-radius: 18px;"));

        backButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlayScenePlayerVsPlayer(primaryStage, player1Name, player2Name)));


        VBox layout = new VBox(20, imageView, resultLabel, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(bgImage));
        layout.setStyle("-fx-padding: 30px;");

        primaryStage.setScene(new Scene(layout, 800, 600));
    }


    // Method to display the keyboard input UI (Computer vs Computer)
    private void displayKeyboardInputComputerVsComputer(Stage primaryStage) {
        // Set stage size and alignment
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.centerOnScreen();

        // Layout setup
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2d2d2d;");

        Label headerLabel = new Label("Enter Values Manually");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

        // Input fields
        TextField numElementsField = new TextField();
        numElementsField.setPromptText("Number of Elements (even number)");
        numElementsField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        TextField valuesField = new TextField();
        valuesField.setPromptText("Enter values separated by space");
        valuesField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        Label errorLabel = new Label(); // Label to display error messages
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");

        Button submitButton = new Button("Submit");
        submitButton.setCursor(Cursor.HAND);
        submitButton.setStyle("-fx-font-size: 16px; -fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 10px 20px;");
        submitButton.setDisable(true); // Initially disabled

        Button backButton = new Button("Back");
        backButton.setCursor(Cursor.HAND);
        backButton.setStyle("-fx-font-size: 16px; -fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 10px 20px;");

        // Real-time validation for inputs
        ChangeListener<String> validationListener = (observable, oldValue, newValue) -> {
            errorLabel.setText(""); // Clear previous errors
            submitButton.setDisable(!isKeyboardInputValidComputerVsComputer(numElementsField, valuesField, errorLabel));
        };

        numElementsField.textProperty().addListener(validationListener);
        valuesField.textProperty().addListener(validationListener);

        // Submit button action
        submitButton.setOnAction(e -> {
            int numElements = Integer.parseInt(numElementsField.getText().trim());
            String[] valuesText = valuesField.getText().split("\\s+");

            Integer[] elements = new Integer[numElements];
            for (int i = 0; i < numElements; i++) {
                elements[i] = Integer.parseInt(valuesText[i]);
            }

            // Process the input elements
            solution.setDPTable(elements);
            loadDPTable(primaryStage); // Call the method that processes the elements and shows the result
        });

        // Back button action
        backButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlaySceneComputerVsComputer(primaryStage))); // Go back to the previous scene

        // Buttons layout
        HBox buttonBox = new HBox(20, submitButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add components to layout
        layout.getChildren().addAll(headerLabel, numElementsField, valuesField, errorLabel, buttonBox);

        // Set the scene and display
        Scene keyboardInputScene = new Scene(layout, 700, 700);
        primaryStage.setScene(keyboardInputScene);
    }

    // Helper method for input validation
    private boolean isKeyboardInputValidComputerVsComputer(TextField numElementsField, TextField valuesField, Label errorLabel) {
        try {
            String numElementsText = numElementsField.getText().trim();
            String valuesText = valuesField.getText().trim();

            // Validate number of elements
            int numElements = Integer.parseInt(numElementsText);
            if (numElements % 2 != 0) {
                errorLabel.setText("The number of elements must be an even number.");
                return false;
            }

            // Validate the values list
            String[] valuesArray = valuesText.split("\\s+");
            if (valuesArray.length != numElements) {
                errorLabel.setText("The number of values does not match the number of elements.");
                return false;
            }

            // Check if each value is a valid integer
            for (String value : valuesArray) {
                Integer.parseInt(value); // Will throw exception if not a valid integer
            }
            // Ensure all values are positive integers
            for (String value : valuesArray) {
                int coinValue = Integer.parseInt(value);
                if (coinValue < 0) {
                    errorLabel.setText("All coin values must be positive integers.");
                    return false;
                }
            }

            return true; // All inputs are valid
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid integers.");
            return false;
        }
    }

    // Method to display the file input UI and navigate between games (Computer vs Computer)
    private void displayFileInputWithNavigationComputerVsComputer(Stage primaryStage) {
        // Set stage size and alignment
        primaryStage.setWidth(1550);
        primaryStage.setHeight(750);
        primaryStage.centerOnScreen();
        // Create the file chooser for opening a file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        // Open the file dialog
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            try (Scanner scanner = new Scanner(file)) {
                // First pass: Count the number of game configurations in the file
                int gameCount = 0;
                while (scanner.hasNextInt()) {
                    int numElements = scanner.nextInt();
                    for (int i = 0; i < numElements; i++) {
                        if (scanner.hasNextInt()) {
                            scanner.nextInt(); // Skip element
                        } else {
                            showError("File format incorrect: not enough elements for a game.");
                            return;
                        }
                    }
                    gameCount++;
                }

                // Re-open scanner for second pass to load the games
                Scanner reloadScanner = new Scanner(file);
                Integer[][] games = new Integer[gameCount][];
                int index = 0;

                while (reloadScanner.hasNextInt()) {
                    int numElements = reloadScanner.nextInt();
                    Integer[] elements = new Integer[numElements];
                    for (int i = 0; i < numElements; i++) {
                        if (reloadScanner.hasNextInt()) {
                            elements[i] = reloadScanner.nextInt();
                        } else {
                            showError("File format incorrect: not enough elements for a game.");
                            return;
                        }
                    }
                    games[index++] = elements;
                }

                if (gameCount == 0) {
                    showError("File contains no valid game configurations.");
                    return;
                }

                // Initialize navigation state
                int[] currentGameIndex = {0};

                // Load the first game configuration
                solution.setDPTable(games[currentGameIndex[0]]);

                // Get optimal moves and winner details for the first game
                String[] optimalMoves = solution.getOptimalMoves();
                int winnerScore = solution.getWinnerScore();
                String winner = solution.getWinner();

                // Create the first DP table scene with navigation
                Scene dpTableScene = createDPTableSceneFile(primaryStage, optimalMoves, winner, winnerScore, games, currentGameIndex);

                // Set the initial scene
                primaryStage.setScene(dpTableScene);

            } catch (FileNotFoundException e) {
                showError("File not found.");
            } catch (NumberFormatException e) {
                showError("File format incorrect: expected integers.");
            }
        }
    }

    /* Scene for random input (computer vs computer Scene)
     * this scene allows users to enter elements and values generating randomly input
     */
    private void displayRandomInputComputerVsComputer(Stage primaryStage) {
        // Set stage size and alignment
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.centerOnScreen();

        // Layout setup
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2d2d2d;");

        Label headerLabel = new Label("Generate Random Input Configuration");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

        // Input fields
        TextField numElementsField = new TextField();
        numElementsField.setPromptText("Number of Elements (even number)");
        numElementsField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        TextField minRangeField = new TextField();
        minRangeField.setPromptText("Minimum Range");
        minRangeField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        TextField maxRangeField = new TextField();
        maxRangeField.setPromptText("Maximum Range");
        maxRangeField.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        Label errorLabel = new Label(); // Label to display error messages
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 14px;");

        Button generateButton = new Button("Generate");
        generateButton.setCursor(Cursor.HAND);
        generateButton.setStyle("-fx-font-size: 16px; -fx-background-color: #4caf50; -fx-text-fill: white; -fx-padding: 10px 20px;");
        generateButton.setDisable(true); // Initially disabled

        Button backButton = new Button("Back");
        backButton.setCursor(Cursor.HAND);
        backButton.setStyle("-fx-font-size: 16px; -fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 10px 20px;");

        // Real-time validation for inputs
        ChangeListener<String> validationListener = (observable, oldValue, newValue) -> {
            errorLabel.setText(""); // Clear previous errors
            generateButton.setDisable(!isRandomInputValidComputerVsComputer(numElementsField, minRangeField, maxRangeField, errorLabel));
        };

        numElementsField.textProperty().addListener(validationListener);
        minRangeField.textProperty().addListener(validationListener);
        maxRangeField.textProperty().addListener(validationListener);

        // Generate button action
        generateButton.setOnAction(e -> {
            int numElements = Integer.parseInt(numElementsField.getText().trim());
            int minRange = Integer.parseInt(minRangeField.getText().trim());
            int maxRange = Integer.parseInt(maxRangeField.getText().trim());

            // Generate random numbers
            Integer[] elements = new Integer[numElements];
            for (int i = 0; i < numElements; i++) {
                elements[i] = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
            }

            // Process the generated elements
            solution.setDPTable(elements);
            loadDPTable(primaryStage); // Call the method that processes the elements and shows the result
        });

        // Back button action
        backButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlaySceneComputerVsComputer(primaryStage))); // Go back to the previous scene

        // Buttons layout
        HBox buttonBox = new HBox(20, generateButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add components to layout
        layout.getChildren().addAll(headerLabel, numElementsField, minRangeField, maxRangeField, errorLabel, buttonBox);

        // Set the scene and display
        Scene randomInputScene = new Scene(layout, 700, 700);
        primaryStage.setScene(randomInputScene);
    }

    // Helper method for input validation
    private boolean isRandomInputValidComputerVsComputer(TextField numElementsField, TextField minRangeField, TextField maxRangeField, Label errorLabel) {
        try {
            String numElementsText = numElementsField.getText().trim();
            String minRangeText = minRangeField.getText().trim();
            String maxRangeText = maxRangeField.getText().trim();

            // Validate number of elements
            int numElements = Integer.parseInt(numElementsText);
            if (numElements % 2 != 0) {
                errorLabel.setText("The number of elements must be an even number.");
                return false;
            }

            // Validate range values
            int minRange = Integer.parseInt(minRangeText);
            int maxRange = Integer.parseInt(maxRangeText);

            // Check if minimum range is negative
            if (minRange < 0) {
                errorLabel.setText("Minimum range must be a non-negative number (no minus coins allowed).");
                return false;
            }

            // Check if minimum range is greater than maximum range
            if (minRange > maxRange) {
                errorLabel.setText("Minimum range must be less than or equal to the maximum range.");
                return false;
            }

            return true; // All inputs are valid
        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid integers for all fields.");
            return false;
        }
    }

    // Method to load the DP table scene
    private void loadDPTable(Stage primaryStage) {

        // Set stage size and alignment
        primaryStage.setWidth(1500);
        primaryStage.setHeight(750);
        primaryStage.centerOnScreen();
        // Calculate the optimal moves and the winner from the DP table
        String[] optimalMoves = solution.getOptimalMoves();
        int winnerScore = solution.getWinnerScore();
        String winner = solution.getWinner();

        // Create the scene to show the DP table, moves, winner, and score
        Scene dpTableScene = createDPTableScene(primaryStage, optimalMoves, winner, winnerScore);
        primaryStage.setScene(dpTableScene);

    }

    /**
    * Creates the scene that displays the dynamic programming (DP) table and game results.
    * This scene shows the input array, the DP table, optimal moves, and the winner with their score.
     * */
    private Scene createDPTableScene(Stage primaryStage, String[] optimalMoves, String winner, int winnerScore) {
        // Set stage size and alignment
        primaryStage.setWidth(1500);
        primaryStage.setHeight(850);
        primaryStage.centerOnScreen();
        // Background setup
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.56_e0553975.jpg",
                        1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );

        // Back button
        Button backButton = createIconButton("Back", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");
        backButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlaySceneComputerVsComputer(primaryStage)));

        // Show input array
        Label inputArrayLabel = new Label("Input Array: " + Arrays.toString(solution.getInputArray()));
        inputArrayLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #d691d8; -fx-font-weight: bold;");

        // Show DP table
        ScrollPane dpGridPane = createDPTableGrid(solution.getDPTable());

        StringBuilder player1Moves = new StringBuilder("Player 1: ");
        StringBuilder player2Moves = new StringBuilder("Player 2: ");

        for (int i = 0; i < optimalMoves.length; i++) {
            if (i % 2 == 0) {
                player1Moves.append(optimalMoves[i] + " -> ");
            } else {
                player2Moves.append(optimalMoves[i] + " -> ");
            }
        }

        // Remove the last " -> " for both players
        if (player1Moves.length() > 0) {
            player1Moves.setLength(player1Moves.length() - 4); // Removes last " -> "
        }
        if (player2Moves.length() > 0) {
            player2Moves.setLength(player2Moves.length() - 4); // Removes last " -> "
        }

        StringBuilder movesText = new StringBuilder();
        movesText.append(player1Moves.toString()).append("\n");
        movesText.append(player2Moves.toString());

            Label movesLabel = new Label(movesText.toString());
        movesLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #fdfdfd; -fx-font-weight: bold;");


        // Show winner and score
        Label winnerLabel = new Label("Winner: " + winner + "        " + " Score: " + winnerScore);
        winnerLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #8e0df6; -fx-font-weight: bold;");



        // Layout setup
        VBox layout = new VBox(20.0, backButton, inputArrayLabel, dpGridPane, movesLabel, winnerLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");
        layout.setBackground(new Background(bgImage));

        return new Scene(layout, 1500, 850);
    }

    /**
    * Creates a scene to display multiple games sequentially with navigation buttons.
    * The scene allows users to view the input array, DP table, optimal moves, and the winner for each game.
    */
    private Scene createDPTableSceneFile(Stage primaryStage, String[] optimalMoves, String winner, int winnerScore, Integer[][] games, int[] currentGameIndex) {
        // Background setup
        BackgroundImage bgImage = new BackgroundImage(
                new Image("file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/WhatsApp Image 2024-11-11 at 20.58.56_e0553975.jpg",
                        1920, 1080, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );

        // Create navigation buttons
        Button previousButton = createIconButton("Previous", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left-arrow.png");
        Button nextButton = createIconButton("Next", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/next-page.png");

        // Disable buttons if at the start or end
        previousButton.setDisable(currentGameIndex[0] == 0);
        nextButton.setDisable(currentGameIndex[0] == games.length - 1);

        // Navigation button actions
        previousButton.setOnAction(e -> {
            if (currentGameIndex[0] > 0) {
                currentGameIndex[0]--;
                solution.setDPTable(games[currentGameIndex[0]]);
                solution.findMaxGain(); // Recalculate optimal moves and winner for the next game
                primaryStage.setScene(createDPTableSceneFile(primaryStage,solution.getOptimalMoves(), solution.getWinner(), solution.getWinnerScore(), games, currentGameIndex));
            }
        });

        nextButton.setOnAction(e -> {
            if (currentGameIndex[0] < games.length - 1) {
                currentGameIndex[0]++;
                solution.setDPTable(games[currentGameIndex[0]]);
                solution.findMaxGain(); // Recalculate optimal moves and winner for the next game
                primaryStage.setScene(createDPTableSceneFile(primaryStage, solution.getOptimalMoves(), solution.getWinner(), solution.getWinnerScore(), games, currentGameIndex));
            }
        });

        // Back button
        Button backButton = createIconButton("Back", "file:///C:/Users/user/IdeaProjects/algo_testing/src/main/resources/com/example/algo_testing/images/left.png");
        backButton.setOnAction(e -> primaryStage.setScene(chooseHowtoPlaySceneComputerVsComputer(primaryStage)));

        // Show input array
        Label inputArrayLabel = new Label("Input Array: " + Arrays.toString(solution.getInputArray()));
        inputArrayLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #d691d8; -fx-font-weight: bold;");

        // Show DP table
        ScrollPane dpGridPane = createDPTableGrid(solution.getDPTable());

        StringBuilder player1Moves = new StringBuilder("Player 1: ");
        StringBuilder player2Moves = new StringBuilder("Player 2: ");

        for (int i = 0; i < optimalMoves.length; i++) {
            if (i % 2 == 0) {
                player1Moves.append(optimalMoves[i] + " -> ");
            } else {
                player2Moves.append(optimalMoves[i] + " -> ");
            }
        }

// Remove the last " -> " for both players
        if (player1Moves.length() > 0) {
            player1Moves.setLength(player1Moves.length() - 4); // Removes last " -> "
        }
        if (player2Moves.length() > 0) {
            player2Moves.setLength(player2Moves.length() - 4); // Removes last " -> "
        }

        StringBuilder movesText = new StringBuilder();
        movesText.append(player1Moves.toString()).append("\n");
        movesText.append(player2Moves.toString());

        Label movesLabel = new Label(movesText.toString());
        movesLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #d691d8; -fx-font-weight: bold;");


        // Show winner and score
        Label winnerLabel = new Label("Winner: " + winner + "        " + " Score: " + winnerScore);
        winnerLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #8e0df6; -fx-font-weight: bold;");

        // Main content layout
        VBox contentBox = new VBox(20, backButton, inputArrayLabel, dpGridPane, movesLabel, winnerLabel);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setStyle("-fx-padding: 20px;");

        // Navigation buttons layout
        HBox navigationBox = new HBox(1200, previousButton, nextButton);
        navigationBox.setAlignment(Pos.CENTER);
        navigationBox.setPadding(new Insets(10));

        // Combine content and navigation layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(contentBox);
        mainLayout.setBottom(navigationBox);
        mainLayout.setBackground(new Background(bgImage));

        // Create and set the scene
        Scene navigationScene = new Scene(mainLayout, 1500, 750);
        return navigationScene;
    }

    /**
    * Creates a scrollable grid layout to display the DP table.
    * Each cell in the grid represents a value from the DP table, styled with custom formatting.
    */
    private ScrollPane createDPTableGrid(Integer[][] dpTable) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5.0);
        gridPane.setHgap(5.0);

        for (int i = 0; i < dpTable.length; i++) {
            for (int j = 0; j < dpTable[i].length; j++) {
                String value = dpTable[i][j] != null ? dpTable[i][j].toString() : "0"; // Handle null values

                Label label = new Label(value);
                label.setMinSize(80, 80); // Ensure uniform cell size for equal area coverage
                label.setAlignment(Pos.CENTER);
                label.setStyle(
                        "-fx-background-color: #FFC0CB; " + // Soft pink background
                                "-fx-border-color: #ff69b4; " + // Border in a darker pink shade for distinction
                                "-fx-border-width: 2px; " + // Thin border for separation
                                "-fx-text-fill: #8B008B; " + // Dark pink/magenta for text color
                                "-fx-font-size: 16px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-padding: 12px;"
                );

                gridPane.add(label, j, i);
            }
        }

        // Wrap the GridPane in a ScrollPane to make it scrollable
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true); // Ensures the ScrollPane resizes to fit the width of its content
        scrollPane.setFitToHeight(true); // Ensures the ScrollPane resizes to fit the height of its content
        scrollPane.setPannable(true); // Enables panning if the content is larger than the viewable area

        return scrollPane;
    }

    // Method to create a button with an icon
    private Button createIconButton(String text, String iconPath) {
        Button button = new Button(text);
        Image icon = new Image(iconPath);
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(30);
        iconView.setFitHeight(30);
        button.setGraphic(iconView);
        button.setStyle("-fx-font-size: 18px; -fx-background-color: #4B3E94; -fx-text-fill: #ea0af8; " +
                "-fx-font-weight: bold; -fx-padding: 12px 24px; -fx-border-radius: 18px; -fx-background-radius: 18px;");

        // Apply hover styling
        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: #151515; -fx-font-size: 18px; " +
                    "-fx-text-fill: #ea0af8; -fx-font-weight: bold; -fx-padding: 12px 24px; " +
                    "-fx-border-radius: 18px; -fx-background-radius: 18px;");
            button.setCursor(Cursor.HAND);
        });
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #4B3E94; -fx-font-size: 18px; " +
                "-fx-text-fill: #e80af6; -fx-font-weight: bold; -fx-padding: 12px 24px; " +
                "-fx-border-radius: 18px;; -fx-background-radius: 18px;"));
        return button;
    }

    // display the errors message as alert
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    // display the alert messages
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

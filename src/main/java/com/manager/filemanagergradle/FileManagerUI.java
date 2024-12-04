package com.manager.filemanagergradle;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Класс для создания и управления пользовательским интерфейсом FileManager.
 */
public class FileManagerUI {
    private static final Logger logger = LogManager.getLogger(FileManagerUI.class);

    private final FileService fileService = new FileService();
    private final TextArea logArea = new TextArea();
    private final Label statusLabel = new Label("Status: Waiting for input...");
    private final TextField sourcePathField = new TextField();
    private final TextField destinationPathField = new TextField();

    /**
     * Настройка UI компонентов.
     *
     * @param primaryStage Основная сцена приложения.
     */
    public void setupUI(Stage primaryStage) {
        primaryStage.setTitle("File Manager");

        // Запрещаем редактирование полей пути
        sourcePathField.setEditable(false);
        destinationPathField.setEditable(false);
        logArea.setEditable(false);

        // Создаем сетку и добавляем в нее элементы управления
        GridPane grid = createGrid();
        addUIControls(grid);

        Scene scene = new Scene(grid, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Создание макета сетки для UI.
     *
     * @return Объект GridPane.
     */
    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        return grid;
    }

    /**
     * Добавление элементов управления UI в сетку.
     *
     * @param grid Сетка для добавления элементов.
     */
    private void addUIControls(GridPane grid) {
        grid.addRow(0, createLabel("Source File:"), sourcePathField, createButton("Browse", this::browseSourceFile));
        grid.addRow(1, createLabel("Destination Folder:"), destinationPathField, createButton("Browse", this::browseDestinationFolder));
        grid.addRow(2, createButton("Copy File", this::copyFile), createButton("Show Folder Files", this::showFolderSizes), createButton("Clear List", this::clearLog));
        grid.add(logArea, 0, 3, 3, 1);
        grid.add(statusLabel, 0, 4, 3, 1);
    }

    /**
     * Создание метки с текстом.
     *
     * @param text Текст метки.
     * @return Созданная метка.
     */
    private Label createLabel(String text) {
        return new Label(text);
    }

    /**
     * Создание кнопки с текстом и действием.
     *
     * @param text Текст кнопки.
     * @param action Действие при нажатии.
     * @return Созданная кнопка.
     */
    private Button createButton(String text, Runnable action) {
        Button button = new Button(text);
        button.setOnAction(event -> action.run());
        return button;
    }

    /**
     * Открытие диалогового окна для выбора исходного файла.
     */
    private void browseSourceFile() {
        File file = new FileChooser().showOpenDialog(null);
        handleFileSelection(file, "Source file selected.");
    }

    /**
     * Открытие диалогового окна для выбора целевой папки.
     */
    private void browseDestinationFolder() {
        File folder = new DirectoryChooser().showDialog(null);
        handleFolderSelection(folder, "Destination folder selected.");
    }

    /**
     * Обработка выбора исходного файла.
     *
     * @param file Файл, выбранный пользователем.
     * @param statusMessage Сообщение состояния.
     */
    private void handleFileSelection(File file, String statusMessage) {
        if (file != null) {
            sourcePathField.setText(file.getAbsolutePath());
            updateStatus(statusMessage);
            logAction(statusMessage + ": " + file.getAbsolutePath());
        }
    }

    /**
     * Обработка выбора целевой папки.
     *
     * @param folder Папка, выбранная пользователем.
     * @param statusMessage Сообщение состояния.
     */
    private void handleFolderSelection(File folder, String statusMessage) {
        if (folder != null) {
            destinationPathField.setText(folder.getAbsolutePath());
            updateStatus(statusMessage);
            logAction(statusMessage + ": " + folder.getAbsolutePath());
        }
    }

    /**
     * Копирование файла из исходной папки в целевую.
     */
    private void copyFile() {
        String sourcePath = sourcePathField.getText();
        String destinationPath = destinationPathField.getText();
        if (validatePaths(sourcePath, destinationPath)) {
            try {
                fileService.copyFile(sourcePath, destinationPath);
                updateStatus("File copied successfully.");
                logAction("File copied: " + sourcePath + " -> " + destinationPath);
            } catch (FileOperationException e) {
                handleError(e);
            }
        }
    }

    /**
     * Отображение размеров файлов в целевой папке.
     */
    private void showFolderSizes() {
        String destinationPath = destinationPathField.getText();
        if (destinationPath.isEmpty()) {
            showAlert("Input Error", "Please select a destination folder.", Alert.AlertType.WARNING);
            return;
        }

        try {
            String sizes = fileService.getFolderSizes(destinationPath);
            if (sizes.isEmpty()) {
                showAlert("Empty Folder", "The folder is empty.", Alert.AlertType.WARNING);
            } else {
                logArea.appendText(sizes);
                updateStatus("Folder files displayed.");
                logAction("Folder files displayed for: " + destinationPath);
            }
        } catch (FileOperationException e) {
            handleError(e);
        }
    }

    /**
     * Обработка ошибки при файловой операции.
     *
     * @param e Исключение, возникшее при операции.
     */
    private void handleError(FileOperationException e) {
        updateStatus("Error: " + e.getMessage());
        logAction("Error: " + e.getMessage());
    }

    /**
     * Очистка журнала действий.
     */
    private void clearLog() {
        logArea.clear();
        updateStatus("List cleared.");
        logAction("List cleared.");
    }

    /**
     * Валидация путей исходного и целевого файлов.
     *
     * @param source Путь исходного файла.
     * @param destination Путь целевой папки.
     * @return true, если оба пути корректны.
     */
    private boolean validatePaths(String source, String destination) {
        if (source.isEmpty() || destination.isEmpty()) {
            showAlert("Input Error", "Please select both source file and destination folder.", Alert.AlertType.WARNING);
            updateStatus("Input error.");
            return false;
        }
        return true;
    }

    /**
     * Обновление статуса в пользовательском интерфейсе.
     *
     * @param message Сообщение для отображения.
     */
    private void updateStatus(String message) {
        statusLabel.setText("Status: " + message);
    }

    /**
     * Отображение предупреждающего сообщения в диалоговом окне.
     *
     * @param title Заголовок сообщения.
     * @param message Текст сообщения.
     * @param type Тип сообщения (предупреждение, ошибка).
     */
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Логирование действий пользователя.
     *
     * @param message Сообщение для записи в лог.
     */
    private void logAction(String message) {
        logger.info(message);
    }
}

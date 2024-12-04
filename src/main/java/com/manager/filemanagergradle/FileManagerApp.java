package com.manager.filemanagergradle;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Основной класс приложения FileManagerApp. Запускает UI для управления файлами.
 */
public class FileManagerApp extends Application {

    /**
     * Метод для запуска UI приложения.
     *
     * @param primaryStage Основная сцена приложения.
     */
    @Override
    public void start(Stage primaryStage) {
        FileManagerUI ui = new FileManagerUI();
        ui.setupUI(primaryStage);
    }

    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

package com.manager.filemanagergradle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Базовый класс для сервисов работы с файлами.
 */
public class BaseFileService {
    protected static final Logger logger = LogManager.getLogger(BaseFileService.class);

    /**
     * Проверяет существование файла по заданному пути.
     *
     * @param path Путь к файлу.
     * @throws FileOperationException Если файл не существует.
     */
    protected void validateFileExists(Path path) throws FileOperationException {
        if (!Files.exists(path)) {
            throw new FileOperationException("File does not exist: " + path.toAbsolutePath());
        }
    }

    /**
     * Проверяет, является ли указанный путь папкой.
     *
     * @param folderPath Путь к папке.
     * @throws FileOperationException Если путь не указывает на папку.
     */
    protected void validateFolder(String folderPath) throws FileOperationException {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            throw new FileOperationException("Provided path is not a directory: " + folderPath);
        }
    }

    /**
     * Получает имя файла из пути.
     *
     * @param path Путь к файлу.
     * @return Имя файла.
     */
    protected String getFileName(Path path) {
        return path.getFileName().toString();
    }
}

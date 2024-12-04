package com.manager.filemanagergradle;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Класс для выполнения операций с файлами.
 */
public class FileService extends BaseFileService {

    /**
     * Копирует файл из исходного пути в целевой.
     *
     * @param sourcePath Путь исходного файла.
     * @param destinationPath Путь назначения.
     * @throws FileOperationException Исключение при ошибке копирования.
     */
    public void copyFile(String sourcePath, String destinationPath) throws FileOperationException {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath, getFileName(source));

        validateFileExists(source);
        ensureDestinationWritable(destination);

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            logger.info("File copied: " + source.toAbsolutePath() + " -> " + destination.toAbsolutePath());
        } catch (IOException e) {
            throw new FileOperationException("Failed to copy file: " + e.getMessage(), e);
        }
    }

    /**
     * Получает размеры файлов в указанной папке.
     *
     * @param folderPath Путь к папке.
     * @return Строка с размерами файлов.
     * @throws FileOperationException Исключение при ошибке получения размеров.
     */
    public String getFolderSizes(String folderPath) throws FileOperationException {
        validateFolder(folderPath);
        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            logger.warn("Folder is empty: " + folder.getAbsolutePath());
            return ""; // Папка пуста
        }

        StringBuilder sizes = new StringBuilder("File sizes in folder:\n");
        for (File file : files) {
            sizes.append(file.getName())
                    .append(": ")
                    .append(file.length() / 1024)
                    .append(" KB\n");
        }
        logger.info("Folder sizes calculated for: " + folder.getAbsolutePath());
        return sizes.toString();
    }

    /**
     * Проверяет, доступна ли целевая папка для записи.
     *
     * @param destination Путь к целевому файлу.
     * @throws FileOperationException Исключение, если папка не доступна.
     */
    private void ensureDestinationWritable(Path destination) throws FileOperationException {
        if (!Files.exists(destination.getParent())) {
            throw new FileOperationException("Destination folder does not exist.");
        }
        if (!Files.isWritable(destination.getParent())) {
            throw new FileOperationException("Destination folder is not writable.");
        }
    }
}

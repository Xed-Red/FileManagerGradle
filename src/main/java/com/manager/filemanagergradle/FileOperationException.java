package com.manager.filemanagergradle;

import java.io.IOException;

/**
 * Исключение, представляющее ошибки файловых операций.
 * Является основным классом для всех исключений, связанных с операциями над файлами.
 */
public class FileOperationException extends IOException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public FileOperationException(String message) {
    super(message);
  }

  /**
   * Конструктор, принимающий сообщение об ошибке и причину ошибки.
   *
   * @param message Сообщение, описывающее ошибку.
   * @param cause Причина ошибки.
   */
  public FileOperationException(String message, Throwable cause) {
    super(message, cause);
  }
}

/**
 * Исключение, возникающее, если файл не найден.
 */
class FileNotFoundException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public FileNotFoundException(String message) {
    super(message);
  }
}

/**
 * Исключение, возникающее при отказе в разрешении доступа.
 */
class PermissionDeniedException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке и причину ошибки.
   *
   * @param message Сообщение, описывающее ошибку.
   * @param cause Причина ошибки.
   */
  public PermissionDeniedException(String message, Throwable cause) {
    super(message, cause);
  }
}

/**
 * Исключение, возникающее, если путь является директорией, а не файлом.
 */
class IsADirectoryException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public IsADirectoryException(String message) {
    super(message);
  }
}

/**
 * Исключение, возникающее при системной ошибке (например, ошибка ОС).
 */
class OSError extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке и причину ошибки.
   *
   * @param message Сообщение, описывающее ошибку.
   * @param cause Причина ошибки.
   */
  public OSError(String message, Throwable cause) {
    super(message, cause);
  }
}

/**
 * Исключение, возникающее, если файл уже существует.
 */
class FileAlreadyExistsException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public FileAlreadyExistsException(String message) {
    super(message);
  }

  /**
   * Конструктор, принимающий сообщение об ошибке и причину ошибки.
   *
   * @param message Сообщение, описывающее ошибку.
   * @param cause Причина ошибки.
   */
  public FileAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }
}

/**
 * Исключение, возникающее, если путь слишком длинный.
 */
class PathTooLongException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public PathTooLongException(String message) {
    super(message);
  }
}

/**
 * Исключение, возникающее при нехватке памяти.
 */
class OutOfMemoryException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public OutOfMemoryException(String message) {
    super(message);
  }
}

/**
 * Исключение, возникающее при отказе в доступе к файлу.
 */
class AccessDeniedException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public AccessDeniedException(String message) {
    super(message);
  }
}

/**
 * Исключение, возникающее при попытке выполнить неподдерживаемую операцию.
 */
class UnsupportedOperationException extends FileOperationException {

  /**
   * Конструктор, принимающий сообщение об ошибке.
   *
   * @param message Сообщение, описывающее ошибку.
   */
  public UnsupportedOperationException(String message) {
    super(message);
  }
}

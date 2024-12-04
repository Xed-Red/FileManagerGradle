# [EN] File Manager Application
![Papirus-Team-Papirus-Apps-System-file-manager 512](https://github.com/user-attachments/assets/c6f06577-3eca-49ee-82a6-9979ba9927a5)



File Manager Application is a JavaFX-based file management tool designed to make file operations intuitive and efficient. This application features a clean, minimalist UI and includes essential functionalities for handling files and directories.

## Features
* File Copying: Easily copy files between directories with clear status messages.
* Directory Content Display: View and verify the contents of directories at any time.
* Error Handling: Robust handling of missing files and invalid operations with detailed error messages.
* Logging: Logs operations and errors to both the console and a log file using Log4j.
* Cross-Platform Compatibility: Runs seamlessly on Windows, macOS, and Linux systems.
* Executable Jar: The project supports building fat JAR files, making deployment and distribution straightforward.
## Screenshots
![image](https://github.com/user-attachments/assets/91206faa-3188-4879-a3ef-01a7d2c984ba)

## Prerequisites
* Java 17 or higher: The application uses JavaFX 17 and requires at least Java 17.
* Gradle: For building and running the application.
## Building the Application
### Requirements:
* JDK 17 or newer
* Gradle 8.0 or newer
### Build:
Run the following command to build the application:

``` ./gradlew clean build ```

This will:

* Compile the source code.
* Create a fat JAR with all dependencies included.
### Running the Application
To run the application locally, execute:

``` ./gradlew run ```

This will launch the application using the Main class.

### Creating a Fat (Shadow) JAR
To package the application with all its dependencies into a single JAR file, run:

``` ./gradlew shadowJar ```

The resulting JAR file will be located in the build/libs directory.

## Logging
The application logs critical operations and errors using Log4j:

* Logs are output to both the console and a logs/application.log file.
* Helps in debugging and monitoring application activity.
## Documentation
The project is fully documented with JavaDoc:

* Includes descriptions for all classes, methods, and exceptions.
* HTML documentation is generated and available in the docs directory.

# [RU] Файловый менеджер
![Papirus-Team-Papirus-Apps-System-file-manager 512](https://github.com/user-attachments/assets/387ef809-f496-4df0-94d0-4cc91b044f26)




Файловый менеджер — это инструмент на основе JavaFX для удобной и эффективной работы с файлами. Приложение обладает минималистичным интерфейсом и включает базовые функции для управления файлами и папками.

## Основные функции
* Копирование файлов: Легко копируйте файлы между папками с отображением статуса операций.
* Просмотр содержимого папок: Просматривайте и проверяйте содержимое папок в любой момент.
* Обработка ошибок: Надежная обработка отсутствующих файлов и некорректных операций с подробными сообщениями об ошибках.
* Логирование: Все операции и ошибки записываются в консоль и в файл с помощью Log4j.
* Кроссплатформенность: Приложение работает на Windows, macOS и Linux.
* Исполняемый Jar: Проект поддерживает создание Fat JAR, упрощая развертывание и распространение.
## Скриншоты
![image](https://github.com/user-attachments/assets/91206faa-3188-4879-a3ef-01a7d2c984ba)
## Требования
* Java 17 или новее: Приложение использует JavaFX 17 и требует минимум Java 17.
* Gradle: Для сборки и запуска приложения.
## Сборка приложения
### Требования:
* JDK 17 или новее
* Gradle 8.0 или новее
### Сборка:
Выполните следующую команду для сборки приложения:

``` ./gradlew clean build ```

Это выполнит:

* Компиляцию исходного кода.
* Создание Fat JAR с включенными зависимостями.
* Запуск приложения
### Для локального запуска выполните:

``` ./gradlew run ```

* Это запустит приложение, используя главный класс Main.

### Создание Fat (Shadow) JAR
Для упаковки приложения со всеми зависимостями в один JAR файл выполните:

``` ./gradlew shadowJar ```
* Собранный JAR файл будет находиться в директории build/libs.

## Логирование
Приложение использует Log4j для записи логов:

* Логи выводятся в консоль и файл logs/application.log.
* Это упрощает отладку и мониторинг активности приложения.
## Документация
Проект полностью документирован с помощью JavaDoc:

* Содержит описания всех классов, методов и исключений.
* HTML-документация доступна в директории docs.

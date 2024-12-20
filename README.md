# [EN] File Manager Application
![Papirus-Team-Papirus-Apps-System-file-manager 512](https://github.com/user-attachments/assets/69af5090-dfe0-4e3d-85d2-9aa00a5edeb8)



File Manager Application is a JavaFX-based file management tool designed to make file operations intuitive and efficient. This application features a clean, minimalist UI and includes essential functionalities for handling files and directories.

## Features
* File Copying: Easily copy files between directories with clear status messages.
* Directory Content Display: View and verify the contents of directories at any time.
* Error Handling: Robust handling of missing files and invalid operations with detailed error messages.
* Logging: Logs operations and errors to both the console and a log file using Log4j.
* Cross-Platform Compatibility: Runs seamlessly on Windows, macOS, and Linux systems.
* Executable Jar: The project supports building fat JAR files, making deployment and distribution straightforward.
## Screenshots
![image](https://github.com/user-attachments/assets/1e06f85b-8c59-40a4-8bfc-f44e99317961)


## Prerequisites
* Java 17 or higher: The application uses JavaFX 17 and requires at least Java 17.
* Gradle: For building and running the application.
## Building the Application
### Requirements:
* JDK 17 or newer
* Gradle 8.0 or newer
### Running the Application
To run the application locally, execute:

 ``` ./gradlew run ```
  
or 

 ``` java -jar build/libs/FileManagerGradle-1.0-SNAPSHOT.jar ```
 
It will work if you created JAR earlier.

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
![Papirus-Team-Papirus-Apps-System-file-manager 512](https://github.com/user-attachments/assets/69dc4763-67d0-4cef-9ac9-c1a90be9dd3b)




Файловый менеджер — это инструмент на основе JavaFX для удобной и эффективной работы с файлами. Приложение обладает минималистичным интерфейсом и включает базовые функции для управления файлами и папками.

## Основные функции
* Копирование файлов: Легко копируйте файлы между папками с отображением статуса операций.
* Просмотр содержимого папок: Просматривайте и проверяйте содержимое папок в любой момент.
* Обработка ошибок: Надежная обработка отсутствующих файлов и некорректных операций с подробными сообщениями об ошибках.
* Логирование: Все операции и ошибки записываются в консоль и в файл с помощью Log4j.
* Кроссплатформенность: Приложение работает на Windows, macOS и Linux.
* Исполняемый Jar: Проект поддерживает создание Fat JAR, упрощая развертывание и распространение.
## Скриншоты
![image](https://github.com/user-attachments/assets/c9dddf04-9438-47d4-981f-29ef8dbcbe59)

## Требования
* Java 17 или новее: Приложение использует JavaFX 17 и требует минимум Java 17.
* Gradle: Для сборки и запуска приложения.
## Сборка приложения
### Требования:
* JDK 17 или новее
* Gradle 8.0 или новее
### Запуск приложения
Для локального запуска выполните:

``` ./gradlew run ```
  
или  

``` java -jar build/libs/FileManagerGradle-1.0-SNAPSHOT.jar ```

Это сработает если вы создали JAR ранее.

Это запустит приложение, используя главный класс Main.

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

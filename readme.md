## Предварительные требования
- Установите Java 17+

## Как собрать проект
Выполните следующую команду из корня чтобы собрать проект. В результате будет создана подпапка target с соответствующим jar-файлом.
```shell
.\mvnw clean package
```

## Как запустить проект
Выполните следующую команду из корня проекта чтобы создать базу данных и запустить MySQL-сервер.
```shell
docker compose up -d
```
Выполните следующую команду из корня проекта чтобы запустить jar-файл после успешной сборки проекта.
```shell
java -jar presentation\target\presentation-0.0.1-SNAPSHOT.jar
```

## Описание ендпоинтов
-  GET http://localhost:8080/projects?page={page}&size={size} - получение всех проектов
- POST http://localhost:8080/projects - добавление проекта
- POST http://localhost:8080/projects/{projectId}/employees - добавление сотрудника к проекту
- POST http://localhost:8080/employees - добавление сотрудника
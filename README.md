# Простое RESTful API для управления библиотекой книг

### Используемый стек технологий:
- **Язык программирования**: Java
- **Версия JDK**: 21
- **Система сборки**: Maven
- **СУБД**: PostgreSQL
- **Фреймворк приложений**: Spring Boot
- **Веб-фреймворк**: Spring Web MVC
- **Фреймворк маппинга**: MapStruct
- **Фреймворк работы с БД**: Spring Data JPA
- **Брокер сообщений**: RabbitMQ
- **Контейнеризация**: Docker

---

### О приложении:

В приложении разработано 2 версии API. 

### Версия №1


- **GET** `/api/v1/books`  
  Получение списка всех книг.

- **GET** `/api/v1/books/{id}`  
  Получение книги по идентификатору.

- **POST** `/api/v1/books`  
  Добавление новой книги.

  _Требуется тело запроса с информацией о книге._
  **Пример тела запроса**:
    ```json
    {
      "title": "Война и мир",
      "author": "Лев Толстой",
      "publishedDate": "1869-01-01T00:00:00"
    }
    ```

- **PUT** `/api/v1/books/{id}`  
  Обновление информации о книге.  

  _Требуется тело запроса с информацией о книге._
  **Пример тела запроса**:
    ```json
    {
      "title": "Война и мир",
      "author": "Лев Толстой",
      "publishedDate": "1869-01-01T00:00:00"
    }
    ```

- **DELETE** `/api/v1/books/{id}`  
  Удаление книги по идентификатору.

---

### Версия №2

- **POST** `/api/v2/books`  
  Отправка уведомления на добавление новой книги.

  _Требуется тело запроса с информацией о книге._
  **Пример тела запроса**:
    ```json
    {
      "title": "Война и мир",
      "author": "Лев Толстой",
      "publishedDate": "1869-01-01T00:00:00"
    }
    ```

- **PUT** `/api/v2/books/{id}`  
  Отправка уведомления на обновление информации о книге.

  _Требуется тело запроса с информацией о книге._
  **Пример тела запроса**:
    ```json
    {
      "title": "Война и мир",
      "author": "Лев Толстой",
      "publishedDate": "1869-01-01T00:00:00"
    }
    ```

- **DELETE** `/api/v2/books/{id}`  
  Отправка уведомления на удаление книги по идентификатору.

### Примечание:

В проекте в папке _"postman-collections"_ вложены коллекции, которые можно импортировать в Postman и использовать для тестирования методов API.

---

### Инструкция по запуску приложения:

Перед выполнением инструкции, убедитесь, что у вас установлен _"docker"_ и _"docker-compose"_:
```bash
docker --version
docker-compose --version
```

1. Клонируйте репозиторий проекта _"libraryApp"_ на ваш локальный компьютер.
2. Откройте терминал и перейдите в директорию проекта _"libraryApp"_.
3. Выполните скрипт _"start.sh"_ командой:
```bash
./start.sh
```
4. После успешного выполнения скрипта можно приступать к работе.

### Примечание:
Доступные адреса на локальном компьютере:
- http://localhost:5050 - pgAdmin
- http://localhost:15672 - RabbitMQ Management

Логины и пароли:
- postgres:
  - username: ```bob```
  - password: ```password```
- rabbitmq:
  - username: ```user```
  - password: ```password```
- pgAdmin
  - password: ```admin```

 В _"pgAdmin"_ при добавлении сервера, на вкладке _"Connection"_ в поле _"Host name/address"_ необходимо указать _"postgres"_. Порт стандартный: ```5432```. 
 
Дополнительную информацию о подключениях можно посмотреть в файлах _"application.yml"_ или _"docker-compose.yml"_.

По завершению работы, если хотите остановить и удалить контейнеры, а также удалить созданный образ по приложению _"libraryApp"_ и все тома, связанные с сервисами, определенными в _"docker-compose.yml"_, выполните скрипт _"cleanup.sh"_ командой:
```bash
./cleanup.sh
```

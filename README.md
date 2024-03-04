# Bybit API

## Цель проекта
Целью данного проекта является создание мобильного приложения для устройств Android, предназначенного для отображения списка объявлений с использованием API Bybit.
<details><summary><b>Описание v1.0</b></summary>

## Структура проекта
Проект разделен на следующие основные компоненты:
1) Model:
ConnectionStatus необходим для выявления типа ошибки, в следствии чего и выводиться соответствующее сообщение.
IService используется для соединения с API.
В папке dto находятся классы, с помощью которых получают данные из API.
В папке entities находятся классы, которые хранят в себе только необходимые данные.
Repository отвечает за получение и обработку данных из API.
2) ViewModel. Представляет данные и бизнес-логику таким образом, чтобы их можно было легко использовать в пользовательском интерфейсе.
3) View. Item отображает детали объявления, а DataList выводит на экран список таких объявлений.
4) DI. Предоставляет необходимые зависимости.

## Обработка ошибок
Приложение обрабатывает ошибки, которые могут возникнуть при загрузке данных из API или при обработке полученных данных. В случае ошибок, пользователю отображается сообщение о проблеме и возможность попробовать снова обратиться к этому сервису. Также при отсутствии данных (например, если API вернул пустой список объявлений), пользователю отображается соответствующее сообщение.

## Результаты
### Вывод объявлений из API в дневном режиме.
![image](https://github.com/FredNekrasov/Test_MVVM_application/assets/152185797/b4cdf2bb-daec-4cf0-9307-a3fb9f7b4119)
### Загрузка данных
![image](https://github.com/FredNekrasov/Test_MVVM_application/assets/152185797/d2a1ddf7-0c00-4e7b-b2ae-bec7e449cda1)
### Ошибка связанная с загрузкой данных при отключенном интернете
![image](https://github.com/FredNekrasov/Test_MVVM_application/assets/152185797/64dee4a1-8774-44e1-bc14-7443e7abeaaa)
### Ночной режим
![image](https://github.com/FredNekrasov/Test_MVVM_application/assets/152185797/dd0e78a0-0e3a-4e61-aefd-95d9176c5d45)

## Используемые библиотеки
- retrofit;
- moshi converter;
- dagger-hilt.
</details>
<details><summary><b>Описание v2.0</b></summary>

## Структура проекта
Проект разделен на следующие основные компоненты:
1) Model. Находятся база данных, интерфейс ретрофита, репозитории для обработки данных, сущности базы данных и dto классы.
2) ViewModel. Представляет данные и бизнес-логику таким образом, чтобы их можно было легко использовать в пользовательском интерфейсе.
3) View. Хранятся окна авторизации, регистрации, профиля, списки объявлений и избранных, а также элементы, отображающие содержание объявления и данные пользователя.
4) DI. Предоставляет необходимые зависимости.

## Обработка ошибок
При авторизации и регистрации пользователя обрабатываются входные данные, кроме фамилии и имени при регистрации. Чтобы не заставлять пользователя вводить свои личные данные. Приложение обрабатывает ошибки, которые могут возникнуть при загрузке данных из API или при обработке полученных данных. В случае ошибок, пользователю отображается сообщение о проблеме и возможность попробовать снова обратиться к этому сервису. Также при отсутствии данных (например, если API вернул пустой список объявлений), пользователю отображается соответствующее сообщение.

## Изображения

<details><summary><b>Дневной режим</b></summary>

### Авторизация
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/6c7be98e-a0ea-4e27-a25d-6ef5b67d7153)
### Регистрация
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/ed55355a-2950-44c7-8978-d86af20ee813)
### Профиль
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/33d41773-64b5-4247-9403-9382be4ca3d3)
### Список объявлений
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/4b0ee397-39d6-4f3e-8733-44defa6312a1)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/c072fbd7-a36d-426c-9e2c-ad820b8cf406)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/62a37ce6-9d1d-4c4e-b7b3-217caf34cccc)
### Избранное
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/502702cd-20db-464a-a9c3-697701bd8073)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/9afb7abb-8518-47f4-aa66-f584f39934eb)
### Обработка ошибочных данных
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/9ebda829-4fa4-4dca-8e04-fe0be52b8fa8)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/f7aedb80-86a6-4134-9af7-06bc51dcdaf3)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/0815b059-137a-4d58-9fdd-09ec4b067560)
</details>

<details><summary><b>Ночной режим</b></summary>

### Авторизация
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/6224c240-feb4-487b-aba2-e9bce0872aa1)
### Регистрация
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/481357d9-3054-444c-b823-c8d29e0471b6)
### Профиль
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/8d690066-8498-4bb1-946e-704beca797b9)
### Список объявлений
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/76d9a2d8-57e2-49d8-9531-c6c871c5fe74)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/d1421df1-6c63-46f6-8097-08e87ec81a7b)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/cc44dde3-5504-4530-a71f-fdfaeefb1dfa)
### Избранное
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/61457793-d851-4941-9251-f92d3c2dce87)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/50661cd8-e544-47de-8f90-37907dcf986e)
### Обработка ошибочных данных
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/d6b71d5a-d6aa-42b7-aff3-696a614a9b63)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/36500e6f-cb44-41cb-8205-ab1969a086e6)
![image](https://github.com/FredNekrasov/Bybit_Shop/assets/152185797/6fc4d568-897e-476b-858f-5659535bbef6)
</details>

## Используемые библиотеки
- retrofit;
- gson converter;
- dagger-hilt;
- room.

</details>

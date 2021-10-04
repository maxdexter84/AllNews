## Техническое Задание

## Приложение «MyNews»

-- Общая информация Используемое API: https://newsapi.org/
Приложение должно поддерживать навигацию назад. Базовый функционал приложения:
Отоброжение текущих новосте й списком Экран детализации выбранной новости Добовление новостей в
избранное Кеширование новостей в локальро бд. Работа приложения без интернета.

Основные экраны приложения Splash screen Главный экран - основные новости Экран детализации новости
Экран закладок Экран поиска новостей Splash screen При открытии приложения должен показываться
Splash экран. Простой текст с названием приложение с анимированным появлением

## Главный экран

На экране отображаются главные новости на текущую дату. Новости отображаются в виде списка
RecyclerView. В случае ошибки загрузки данных необходимо оповестить пользователя. В момент загрузки
данных необходимо отображать прогресс-индикатор. При нажатии на элемент списка должен открываться
экран с детальной информацией о выбранной новости. Экран должен поддерживать pull-to-refresh , так
же экран должен поддерживать пагинацию.

Экран детальной информации На экране должна отображаться основная информация о новости: Заголовок
статьи, подробное описание новости, дата публикации. Необходимо реализовать возможность добавления
новости в избранное. Должна быть возможность возврата назад на главный экран приложения.

## Экран избранного

Избранный новости отображатся в виде списка recyclerview, должна быть возможность удалить новость из
списка с помощью смахивания или иконки на элементе списка. Данные избранного хроняться в локальной
базе данных.

## Экран поиска новостей

В верхней части экрана должен быть эллемент SearchView для ввода текста, ниже по результатам поиска
будут выводиться новости в виде списка recyclerview. При клике на новость должны переходить на экран
детализации. Экран должен поддерживать пагинацию.

##   Стек технологий
+ [Kotlin]
+ [MVVM]
+ [Retrofit]
+ [Glide]
+ [Room]
+ [Coroutine]
+ [Navigation]
+ [Dagger2]

## Ссылка на Jira
https://maxdexter.atlassian.net/jira/software/projects/MYN/boards/1

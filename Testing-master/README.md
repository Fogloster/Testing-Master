# Создан учебный проект в рамках курса QA Automation

 Цель проекта: автоматизация теситрования.

 Задачи проекта: Тестирование веб формы(Анкета) на сайте https://www.tinkoff.ru/career/vacancies/

 Проект содержит 3 набора тестов:
 1) WebTest - содержит в себе два теста:
 testEmptyValue - проверка сообщений об ошибках при пустых в форму ввода в анкете.
 testInvalidValue - проверка сообщений об ошибках при введении неккоректных значений в форму ввода в акенте.

 2) SecondWebTests - Содержит в себе тест:
 PageSwitcher - отправляает запрос в www.google.ru находит ссылку https://www.tinkoff.ru/mobile-operator/tariffs/
 и выполняет переход на нее.

 3)RegionChanger - Содержит в себе тест:
 RegionChanger - на сайте  https://www.tinkoff.ru/mobile-operator/tariffs/ сравнивает стоимость пакетов по разным
 городам (Москва и Краснодар).

  Для запуска проекта из командной строки перейдите в корень проекта и введите:

  ---

  mvn test -Dbrowser=**browserName** verify

  ---

  browserName принимает значения: chrome, firefox.
  
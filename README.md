# Manufacturer-data

## Описание
Веб-приложение позволяет выполнять CRUD
операции над объектами:
* Product:
     * UUID id;
     * name;
     * BigDecimal price;
     * Manufacturer manufacturer;
* Manufacturer
     * UUID id;
     * String name;
     * Set products;

В базе данных хранятся данные о производителях (Manufacturer) и
товарах (Product). Каждый товар имеет одного производителя, и каждый
производитель имеет набор товаров.


## Инструкция по разворачиванию
1. Создать базу данных HibernateCRUD - `CREATE DATABASE IF NOT EXISTS HibernateCRUD;` или с помощью [sql скрипта](https://github.com/kurotkin/Manufacturer-data/blob/master/src/main/resources/init.sql);
2. Заполнить ip адрес базы данных, имя пользователя, пароль в [файле](https://github.com/kurotkin/Manufacturer-data/blob/master/src/main/resources/hibernate.cfg.xml) hibernate.cfg.xml
3. Запустить приложение, набрав в консоле `mvn tomcat7:run`

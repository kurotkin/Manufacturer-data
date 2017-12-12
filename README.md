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


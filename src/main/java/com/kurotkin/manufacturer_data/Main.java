package com.kurotkin.manufacturer_data;

import com.kurotkin.manufacturer_data.dao.hibernate.HManufacturerDAO;
import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;
import com.kurotkin.manufacturer_data.model.Product;


import java.math.BigDecimal;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {

        HProductDAO productDAO = new HProductDAO();
        HManufacturerDAO manDAO = new HManufacturerDAO();

        Product product = new Product("Test product 1", new BigDecimal(1232), new Manufacturer("Manufacturer"));
        productDAO.save(product);

        Product product2 = new Product("Test product 2", new BigDecimal(1232), new Manufacturer("Manufacturer"));
        productDAO.save(product2);

        Product product3 = new Product("Test product 3", new BigDecimal(1232), new Manufacturer("Manufacturer"));
        productDAO.save(product3);

        Manufacturer manufacturer = manDAO.getByName("Manufacturer");
        System.out.println(manufacturer);

    }


}

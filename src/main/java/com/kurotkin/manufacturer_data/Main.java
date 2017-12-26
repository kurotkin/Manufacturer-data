package com.kurotkin.manufacturer_data;

import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;
import com.kurotkin.manufacturer_data.model.Product;


import java.math.BigDecimal;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {

        HProductDAO productDAO = new HProductDAO();

        Product product = new Product("Test product 2", new BigDecimal(1232), new Manufacturer("Manufacturer"));
        productDAO.save(product);

        Product loadProduct = productDAO.getByName("Test product 2");
        System.out.println(loadProduct);
    }


}

package com.kurotkin.manufacturer_data;

import com.kurotkin.manufacturer_data.dao.hibernate.HProductDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;
import com.kurotkin.manufacturer_data.model.Product;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        HProductDAO productDAO = new HProductDAO();

        Product product = new Product("Test product", new BigDecimal(1232), new Manufacturer("Manufacturer"));
        productDAO.save(product);
    }

    private static void init() {
        ServiceRegistry serviceRegistry = buildCfg();
        MetadataImplementor metadata = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport(metadata);
        schemaExport.setOutputFile("init.sql");
        schemaExport.create(true, true);
        ( (StandardServiceRegistryImpl) serviceRegistry ).destroy();
    }

    public static StandardServiceRegistryImpl buildCfg() {
        return (StandardServiceRegistryImpl) new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
    }
}

package com.kurotkin.manufacturer_data.dao.hibernate;

import com.kurotkin.manufacturer_data.dao.ProductDAO;
import com.kurotkin.manufacturer_data.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HProductDAO implements ProductDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Product getById(Long id) {
        Product product = null;
        try (Session session = this.sessionFactory.openSession()){
            product = session.get(Product.class, id);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product getByName(String name) {
        Product product = null;
        try (Session session = this.sessionFactory.openSession()) {
            String query = "select c from Product c where c.name like :name";
            List<Product> products = session.createQuery(query).setParameter("name", name).list();
            if (products.size() != 0) {
                product = products.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getAll() {
        List<Product> result = null;
        try (Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from Product");
            result = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Long save(Product product) {
        Long id = null;
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Long) session.save(product);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void update(Product val) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.get(Product.class, val.getId());
            product.setName(val.getName());
            session.update(product);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Product val) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.get(Product.class, val.getId());
            session.delete(product);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

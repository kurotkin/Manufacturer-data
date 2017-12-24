package com.kurotkin.manufacturer_data.dao.hibernate;

import com.kurotkin.manufacturer_data.dao.ManufacturerDAO;
import com.kurotkin.manufacturer_data.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HManufacturerDAO implements ManufacturerDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Manufacturer getById(Long id) {
        Manufacturer manufacturer = null;
        try (Session session = this.sessionFactory.openSession()){
            manufacturer = session.get(Manufacturer.class, id);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacturer;
    }

    public Manufacturer getByName(String name) {
        Manufacturer manufacturer = null;
        try (Session session = this.sessionFactory.openSession()) {
            String query = "select c from Manufacturer c where c.name like :name";
            List<Manufacturer> manufactures = session.createQuery(query).setParameter("name", name).list();
            if (manufactures.size() != 0) {
                manufacturer = manufactures.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manufacturer;
    }

    public List<Manufacturer> getAll() {
        List<Manufacturer> result = null;
        try (Session session = this.sessionFactory.openSession()) {
            Query query = session.createQuery("from Manufacturer");
            result = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Long save(Manufacturer manufacturer) {
        Long id = null;
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Long) session.save(manufacturer);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void update(Manufacturer val) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Manufacturer manufacturer = session.get(Manufacturer.class, val.getId());
            manufacturer.setName(val.getName());
            session.update(manufacturer);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Manufacturer val) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Manufacturer manufacturer = session.get(Manufacturer.class, val.getId());
            session.delete(manufacturer);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

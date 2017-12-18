package com.kurotkin.manufacturer_data.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <VAL, ID> {
    VAL getById(ID id) throws SQLException;
    VAL getByName(String name) throws SQLException;
    List<VAL> getAll() throws SQLException;
    Long save(VAL val) throws SQLException;
    void update(VAL val) throws SQLException;
    void delete(VAL val) throws SQLException;
}

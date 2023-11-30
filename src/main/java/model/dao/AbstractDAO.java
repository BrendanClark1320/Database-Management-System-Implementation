package model.dao;

import model.entity.AbstractEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO<E extends AbstractEntity> {
    protected String conUrl = "jdbc:mysql://localhost:3306/project2?user=root&password=topsecretdatabase1";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(conUrl);
    }
    public abstract void create(E entity) throws SQLException;
    public abstract E read(int ID) throws SQLException;
    public abstract void delete(E entity) throws SQLException;
    public abstract void update(E entity) throws SQLException;
}
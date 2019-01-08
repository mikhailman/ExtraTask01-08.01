package dao;

import entity.Catalog;

public interface IJAXBParser {
    Catalog read() throws DAOException;

    void write(Catalog catalog) throws DAOException;
}

package jd2.htp.verishko.dao;

import jd2.htp.verishko.entity.Catalog;

public interface IJAXBParser {
    Catalog readFromXml() throws DAOException;

    void writeToXml(Catalog catalog) throws DAOException;
}

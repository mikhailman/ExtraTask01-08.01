package jd2.htp.verishko.dao;

import jd2.htp.verishko.entity.News;
import jd2.htp.verishko.entity.criteria.Criteria;

import java.util.List;

public interface IDAOCatalog {
    List<News> find(Criteria criteria) throws DAOException;

    void add(News news) throws DAOException;
}

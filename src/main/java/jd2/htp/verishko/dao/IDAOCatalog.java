package jd2.htp.verishko.dao;

import jd2.htp.verishko.entity.News;
import jd2.htp.verishko.entity.criteria.Criteria;

public interface IDAOCatalog {
    News findNews(Criteria criteria) throws DAOException;

    void addNews(News news, Criteria criteria) throws DAOException;
}

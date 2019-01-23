package jd2.htp.verishko.service;

import jd2.htp.verishko.dao.DAOException;
import jd2.htp.verishko.entity.News;
import jd2.htp.verishko.entity.criteria.Criteria;

public interface IServiceCatalog {
    News find(Criteria criteria) throws DAOException;

    void addNews(Criteria criteria, String setName, String setProvider, String setDateOfIssue, String setNewsBody) throws DAOException;

}

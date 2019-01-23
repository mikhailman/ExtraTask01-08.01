package jd2.htp.verishko.service.implementation;

import jd2.htp.verishko.dao.DAOException;
import jd2.htp.verishko.dao.IDAOCatalog;
import jd2.htp.verishko.dao.implementation.DAOCatalog;
import jd2.htp.verishko.entity.News;
import jd2.htp.verishko.entity.criteria.Criteria;
import jd2.htp.verishko.service.IServiceCatalog;
import jd2.htp.verishko.service.validation.Validator;

public class ServiceCatalog implements IServiceCatalog {

    public News find(Criteria criteria) throws DAOException {
        IDAOCatalog idaoCatalog = new DAOCatalog();
        News newsFind = idaoCatalog.findNews(criteria);
        if (newsFind == null) {
            System.out.println("News not found");
        }
        return newsFind;
    }

    public void addNews(Criteria criteria, String setName, String setNewsBody, String setProvider, String setDateOfIssue) throws DAOException {
        IDAOCatalog idaoCatalog = new DAOCatalog();
        News news = new News();
        Validator validator = new Validator();

        if (!(news == null) &&
                validator.isValidateAddNews(setName) &&
                validator.isValidateAddNews(setProvider) &&
                validator.isValidateAddNews(setDateOfIssue) &&
                validator.isValidateAddNews(setNewsBody)) {
            news.setName(setName);
            news.setProvider(setProvider);
            news.setDateOfIssue(setDateOfIssue);
            news.setNewsBody(setNewsBody);

            idaoCatalog.addNews(news, criteria);
            System.out.println("The \'"+ news+ "\' is written");
            System.out.println("All Is Well");

        } else {
            System.out.println("Invalid news. Go *ill yourself");
        }
    }
}

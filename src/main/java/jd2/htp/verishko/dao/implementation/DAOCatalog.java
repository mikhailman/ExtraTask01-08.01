package jd2.htp.verishko.dao.implementation;

import jd2.htp.verishko.dao.DAOException;
import jd2.htp.verishko.dao.IDAOCatalog;
import jd2.htp.verishko.dao.IJAXBParser;
import jd2.htp.verishko.entity.Catalog;
import jd2.htp.verishko.entity.Category;
import jd2.htp.verishko.entity.News;
import jd2.htp.verishko.entity.SubCategory;
import jd2.htp.verishko.entity.criteria.Criteria;
import jd2.htp.verishko.entity.criteria.SearchCriteria;

public class DAOCatalog implements IDAOCatalog {
    public News findNews(Criteria criteria) throws DAOException {
        IJAXBParser ijaxbParser = new JAXBParser();
        Catalog catalog = ijaxbParser.readFromXml();
        for (Category category : catalog.getCategory()) {
            if (category.getName().equals(criteria.getCriteriaMap().get(SearchCriteria.Catalog.CATEGORY))) {
                for (SubCategory subCategory : category.getSubcategory()) {
                    if (subCategory.getName().equals(criteria.getCriteriaMap().get(SearchCriteria.Catalog.SUBCATEGORY))) {
                        for (News news : subCategory.getNews()) {
                            if (news.getName().equals(criteria.getCriteriaMap().get(SearchCriteria.Catalog.NEWS))) {
                                return news;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void addNews(News news, Criteria criteria) throws DAOException {
        IJAXBParser ijaxbParser = new JAXBParser();
        Catalog readFromXml = ijaxbParser.readFromXml();
        for (Category category : readFromXml.getCategory()) {
            if (category.getName().equals(criteria.getCriteriaMap().get(SearchCriteria.Catalog.CATEGORY))) {
                for (SubCategory subCategory : category.getSubcategory()) {
                    if (subCategory.getName().equals(criteria.getCriteriaMap().get(SearchCriteria.Catalog.SUBCATEGORY))) {
                        subCategory.getNews().add(news);
                    }
                }
            }
        }
        ijaxbParser.writeToXml(readFromXml);
    }
}

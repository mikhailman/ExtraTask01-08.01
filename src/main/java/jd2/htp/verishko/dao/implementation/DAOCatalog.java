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

import java.util.ArrayList;
import java.util.List;

public class DAOCatalog implements IDAOCatalog {
    public List<News> find(Criteria criteria) throws DAOException {
        IJAXBParser jaxbParser = new JAXBParser();
        Catalog catalog = jaxbParser.readFromXml();
        List<News> list = new ArrayList<>();
        for (Category category : catalog.getCategory()) {
            if (category.getName().equals(SearchCriteria.Catalog.CATEGORY)) {
                for (SubCategory subCategory : category.getSubcategory()) {
                    if (subCategory.getName().equals(SearchCriteria.Catalog.SUBCATEGORY)) {
                        for (News newsOne : subCategory.getNews()) {
                            if (newsOne.getName().equals(SearchCriteria.Catalog.NEWS)) {
                                list.add(newsOne);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public void add(News news) throws DAOException {

    }
}

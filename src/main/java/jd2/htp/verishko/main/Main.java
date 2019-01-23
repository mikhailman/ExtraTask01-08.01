package jd2.htp.verishko.main;

import jd2.htp.verishko.dao.DAOException;
import jd2.htp.verishko.dao.implementation.JAXBParser;
import jd2.htp.verishko.entity.News;
import jd2.htp.verishko.entity.criteria.Criteria;
import jd2.htp.verishko.entity.criteria.SearchCriteria;
import jd2.htp.verishko.service.IServiceCatalog;
import jd2.htp.verishko.service.implementation.ServiceCatalog;

public class Main {
    public static void main(String[] args) throws DAOException {

        // search news
        Criteria criteria = new Criteria();
        criteria.addCriteria(SearchCriteria.Catalog.CATEGORY, "Books");
        criteria.addCriteria(SearchCriteria.Catalog.SUBCATEGORY, "Novel");
        criteria.addCriteria(SearchCriteria.Catalog.NEWS, "Gone with the Wind");

        IServiceCatalog serviceCatalog = new ServiceCatalog();

        // sout find result
        try {
            News news = serviceCatalog.find(criteria);
            System.out.println("Result find of News: \n" + " name = " + news.getName() + "\n dataOfIssue = " + news.getDateOfIssue()
                    + "\n news body = " + news.getNewsBody() + "\n provider = " + news.getProvider());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        System.out.println();
        JAXBParser jaxbParser = new JAXBParser();
        System.out.println("PATH " + jaxbParser.path);

        // add news
        try {
            System.out.println();
            serviceCatalog.addNews(criteria, "A", "B", "C", "D");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
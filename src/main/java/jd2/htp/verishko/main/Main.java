package jd2.htp.verishko.main;

import jd2.htp.verishko.dao.DAOException;
import jd2.htp.verishko.dao.IJAXBParser;
import jd2.htp.verishko.dao.implementation.DAOCatalog;
import jd2.htp.verishko.dao.implementation.JAXBParser;
import jd2.htp.verishko.entity.criteria.Criteria;
import jd2.htp.verishko.entity.criteria.SearchCriteria;

public class Main {
    public static void main(String[] args) throws DAOException {
        IJAXBParser ijaxbParser = new JAXBParser();
//        System.out.println(ijaxbParser.readFromXml());

        Criteria criteria = new Criteria();
        criteria.addCriteria(SearchCriteria.Catalog.NAME, "Avengers");
        System.out.println(DAOCatalog.class.toString());
    }
}
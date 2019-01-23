package jd2.htp.verishko.service.validation;

import jd2.htp.verishko.entity.criteria.Criteria;
import jd2.htp.verishko.entity.criteria.SearchCriteria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public final static String RU = "[А-Яа-я0-9]*";
    public final static String EN = "[A-Za-z0-9]*";

    public boolean isValidateAddNews(String criteriaForAddNews) {
        Pattern patternRu = Pattern.compile(RU);
        Pattern patternEn = Pattern.compile(EN);
        Matcher matcherRu = patternRu.matcher(criteriaForAddNews);
        Matcher matcherEn = patternEn.matcher(criteriaForAddNews);
        Criteria criteria = new Criteria();
        if (matcherRu.matches() || matcherEn.matches()) {
            criteria.addCriteria(SearchCriteria.Catalog.NEWS, criteriaForAddNews);
            return true;
        } else {
            return false;
        }
    }
}

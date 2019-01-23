package jd2.htp.verishko.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    public Criteria() {
    }

    private Map<SearchCriteria.Catalog, String> criteriaMap = new HashMap<SearchCriteria.Catalog, String>();

    public Map<SearchCriteria.Catalog, String> getCriteriaMap() {
        return criteriaMap;
    }

    public void addCriteria(SearchCriteria.Catalog searchCriteria, String value) {
        criteriaMap.put(searchCriteria, value);
    }
}

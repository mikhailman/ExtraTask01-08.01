package jd2.htp.verishko.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private Map<SearchCriteria.Catalog, String> criteriaMap = new HashMap<>();

    public Criteria() {
    }

    public void addCriteria(SearchCriteria.Catalog searchCriteria, String value) {
        criteriaMap.put(searchCriteria, value);

    }

}

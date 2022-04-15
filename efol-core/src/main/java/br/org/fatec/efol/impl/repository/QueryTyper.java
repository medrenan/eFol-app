package br.org.fatec.efol.impl.repository;

import javax.persistence.Query;
import java.util.List;

public class QueryTyper {

    public static <T> List<T> getResultList(Query query) {
        return query.getResultList();
    }

    public static <T> T getPossibleSingleResult(Query query) {
        List<T> results = getResultList(query);
        if(results.size() > 0) {
            return results.get(0);
        }
        return null;
    }
}

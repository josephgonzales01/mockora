package co.lps.mockora.respository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import co.lps.mockora.model.dao.Mock;

public class MockDynamicQueryImpl implements MockDynamicQuery {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MockDynamicQueryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Mock> query(String queryName, String queryValue) {
        Query query = new Query();
        query.addCriteria(Criteria.where(queryName).is(queryValue));
        return new ArrayList<>();
    }
}

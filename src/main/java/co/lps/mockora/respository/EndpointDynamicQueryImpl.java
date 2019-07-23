package co.lps.mockora.respository;

import co.lps.mockora.model.dao.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class EndpointDynamicQueryImpl implements EndpointDynamicQuery {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public EndpointDynamicQueryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Endpoint> query(String queryName) {
        Query query = new Query();
        query.addCriteria(Criteria.where(queryName).is(""));
        return null;
    }
}

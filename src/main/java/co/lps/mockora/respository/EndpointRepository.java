package co.lps.mockora.respository;

import co.lps.mockora.model.dao.Endpoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * co.lps.mockora.respository
 *
 * @author : josephg
 * @since : 15/07/2019
 */
@Repository
public interface EndpointRepository
    extends MongoRepository<Endpoint, String>, EndpointDynamicQuery {

  List<Endpoint> findByOrgIdAndResourceId(String orgId, String resourceId);

  List<Endpoint> findByOrgId(String orgId);

}

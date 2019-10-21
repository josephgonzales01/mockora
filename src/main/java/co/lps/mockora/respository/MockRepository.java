package co.lps.mockora.respository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import co.lps.mockora.model.dao.Mock;

/**
 * co.lps.mockora.respository
 *
 * @author : josephg
 * @since : 15/07/2019
 */
@Repository
public interface MockRepository extends MongoRepository<Mock, String>, MockDynamicQuery {

  List<Mock> findByOrgIdAndResourceId(String orgId, String resourceId);

  List<Mock> findByOrgId(String orgId);

}

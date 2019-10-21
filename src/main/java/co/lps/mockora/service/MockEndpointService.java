package co.lps.mockora.service;

import java.util.List;
import co.lps.mockora.model.dao.Mock;
import co.lps.mockora.model.dto.MockDto;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */
public interface MockEndpointService {

  void save(MockDto dto);

  List<Mock> findByOrgIdAndResourceId(String orgId, String resourceId);

  List<Mock> findByOrgId(String orgId);
}

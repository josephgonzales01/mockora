package co.lps.mockora.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Mock;
import co.lps.mockora.model.dto.MockDto;
import co.lps.mockora.respository.MockRepository;
import co.lps.mockora.service.mapper.MockModelMapper;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@Service
public class MockEndpointServiceImpl implements MockEndpointService {


  private MockModelMapper mockModelMapper;
  private MockRepository mockRepository;

  @Autowired
  public MockEndpointServiceImpl(MockModelMapper mockModelMapper,
      MockRepository mockRepository) {
    this.mockModelMapper = mockModelMapper;
    this.mockRepository = mockRepository;
  }

  @Override
  public void save(MockDto dto) {

    Mock mock = mockModelMapper.mapToDao(dto);
    mockRepository.save(mock);

  }

  @Override
  public List<Mock> findByOrgIdAndResourceId(String orgId, String resourceId) {
    return mockRepository.findByOrgIdAndResourceId(orgId, resourceId);
  }

  @Override
  public List<Mock> findByOrgId(String orgId) {
    return mockRepository.findByOrgId(orgId);
  }
}

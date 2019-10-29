package co.lps.mockora.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.lps.mockora.constants.HttpMethod;
import co.lps.mockora.error.ErrorMsg;
import co.lps.mockora.error.MockoraException;
import co.lps.mockora.model.dao.Mock;
import co.lps.mockora.model.dto.MockDto;
import co.lps.mockora.respository.MockRepository;
import co.lps.mockora.service.mapper.MockModelMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@Service
@Slf4j
public class MockEndpointServiceImpl implements MockEndpointService {


  private MockModelMapper mockModelMapper;
  private MockRepository mockRepository;

  @Autowired
  public MockEndpointServiceImpl(MockModelMapper mockModelMapper, MockRepository mockRepository) {
    this.mockModelMapper = mockModelMapper;
    this.mockRepository = mockRepository;
  }

  @Override
  public void save(MockDto dto) {
    // extract and validate methods
    List<String> methods = dto.getMethods().stream().map(m -> m.getMethodType().toUpperCase())
        .collect(Collectors.toList());
    validateMethods(methods);
    
    Mock mock = mockModelMapper.mapToDao(dto);
    mockRepository.save(mock);
  }

  @Override
  public void delete(String orgId, String resourceId, List<String> methods) {

    Mock mock = findByOrgIdAndResourceId(orgId, resourceId);

    if (null == mock) {
      String errMsg = String.format(ErrorMsg.LOG_MOCK_NOT_FOUND, orgId, resourceId);
      log.error(errMsg);
      throw new MockoraException(errMsg, HttpStatus.NOT_FOUND);
    }
    // delete the whole mock if no method is selected
    if (null == methods || methods.isEmpty()) {
      mockRepository.delete(mock);
      return;
    }
    // check all selected method is valid
    List<String> upperCaseMethods =
        methods.stream().map(String::toUpperCase).collect(Collectors.toList());
    validateMethods(upperCaseMethods);

    // remove selected methods
    mock.getMethods().removeIf(m -> upperCaseMethods.contains(m.getMethodType()));

    // if no remaining method then remove the whole mock
    if (mock.getMethods().isEmpty()) {
      mockRepository.delete(mock);
      return;
    }

    mockRepository.save(mock);

  }


  private Mock findByOrgIdAndResourceId(String orgId, String resourceId) {
    return mockRepository.findByOrgIdAndResourceId(orgId, resourceId);
  }

  private void validateMethods(List<String> methods) {
    for (String m : methods) {
      if (!HttpMethod.getNames().contains(m)) {
        String errMsg = String.format(ErrorMsg.LOG_REQUEST_METHOD_NOT_FOUND, m);
        log.error(errMsg);
        throw new MockoraException(errMsg, HttpStatus.BAD_REQUEST);
      }
    }
  }



}

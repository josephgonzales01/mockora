package co.lps.mockora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.respository.EndpointRepository;
import co.lps.mockora.service.mapper.EndpointModelMapper;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@Service
public class MockEndpointServiceImpl implements MockEndpointService {

    @Autowired
    private EndpointModelMapper endpointModelMapper;

    @Autowired
    private EndpointRepository endpointRepository;

    @Override
    public void save(EndpointDto dto) {

        Endpoint endpoint = endpointModelMapper.mapToDao(dto);
        endpointRepository.save(endpoint);

    }

    @Override
    public List<Endpoint> findByOrgIdAndUrl(String orgId, String url) {
        return endpointRepository.findByOrgIdAndUrl(orgId, url);
    }

    public List<Endpoint> findByOrgId(String orgId) {
        return endpointRepository.query("organizationId", orgId);
    }

}

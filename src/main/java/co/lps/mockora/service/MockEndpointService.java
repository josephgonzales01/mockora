package co.lps.mockora.service;

import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dto.EndpointDto;

import java.util.List;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */
public interface MockEndpointService {

    void save(EndpointDto endpointRequest);

    List<Endpoint> findByOrgIdAndUrl(String orgId, String url);
}

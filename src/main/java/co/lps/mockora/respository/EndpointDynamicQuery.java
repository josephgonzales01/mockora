package co.lps.mockora.respository;

import co.lps.mockora.model.dao.Endpoint;

import java.util.List;

public interface EndpointDynamicQuery {

    List<Endpoint> query(String queryName, String queryValue);
}

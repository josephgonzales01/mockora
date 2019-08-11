package co.lps.mockora.service;

import co.lps.mockora.constants.ApplicationURL;
import org.springframework.stereotype.Service;

@Service
public class UrlUtilityService {


    private static final String EMTPY = "";

    public String getServeUrlWithoutOrg(final String requestURI, final String orgId) {
        return requestURI.replace(ApplicationURL.SERVE_URL + "/" + orgId, EMTPY);

    }

    public String getMockUrlWithoutOrg(final String requestURI, final String orgId) {
        return requestURI.replace(ApplicationURL.MOCK_URL + "/" + orgId, EMTPY);
    }
}

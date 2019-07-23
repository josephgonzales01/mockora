package co.lps.mockora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.configuration.ApplicationProperties;

@Service
public class UrlUtilityService {

  private ApplicationProperties appProperties;
  private static final String EMTPY = "";

  @Autowired
  public UrlUtilityService(ApplicationProperties appProperties) {
    this.appProperties = appProperties;
  }


  public String getServeOrgUrl(final String requestURI) {
    return requestURI.replace(appProperties.getBaseUrl() + ApplicationProperties.SERVE_URL, EMTPY);

  }

  public String getMockOrgUrl(final String requestURI) {
    return requestURI.replace(appProperties.getBaseUrl() + ApplicationProperties.MOCK_URL, EMTPY);
  }
  

  public String getOrg(final String uri) {
    return uri.split("/")[0];
  }

}

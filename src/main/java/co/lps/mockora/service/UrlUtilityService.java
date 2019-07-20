package co.lps.mockora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.configuration.ApplicationProperties;

@Service
public class UrlUtilityService {

  private ApplicationProperties appProperties;

  private static final String SERVER_URL = "/serve";
  private static final String EMTPY = "";

  @Autowired
  public UrlUtilityService(ApplicationProperties appProperties) {
    this.appProperties = appProperties;
  }


  public String getOrgUrl(final String requestURI) {
    return requestURI.replace(appProperties.getBaseUrl() + SERVER_URL, EMTPY);

  }

}

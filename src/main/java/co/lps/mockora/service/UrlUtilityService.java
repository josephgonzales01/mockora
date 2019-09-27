package co.lps.mockora.service;

import co.lps.mockora.constants.ApplicationURL;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class UrlUtilityService {


  private static final String EMTPY = "";
  @Autowired
  private Environment env;

  public String getHostAndPort() {
    InetAddress address;
    address = InetAddress.getLoopbackAddress();
    return String.format("%s:%s", address.getHostName(), env.getProperty("server.port"));
  }

  public String getServeUrlWithoutOrg(final String requestURI, final String orgId) {
    return requestURI.replace(ApplicationURL.SERVE_URL + "/" + orgId, EMTPY);
  }

  public String getMockUrlWithoutOrg(final String requestURI, final String orgId) {
    return requestURI.replace(ApplicationURL.MOCK_URL + "/" + orgId, EMTPY);
  }
}

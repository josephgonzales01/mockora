package co.lps.mockora.service;

import java.net.InetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import co.lps.mockora.constants.ApplicationURL;

//TODO create unit test
@Service
public class UrlUtilityService {
  private static final String EMPTY = "";
  private static final String SLASH ="/";
  private Environment env;

  @Autowired
  public UrlUtilityService(Environment env) {
    this.env = env;
  }

  public String getHostAndPort() {
    InetAddress address;
    address = InetAddress.getLoopbackAddress();
    return String.format("%s:%s", address.getHostName(), env.getProperty("server.port"));
  }

  public String getServeUrlWithoutOrg(final String requestURI, final String orgId) {
    return requestURI.replace(ApplicationURL.SERVE_URL + "/" + orgId, EMPTY).toLowerCase();
  }

  public String getMockUrlWithoutOrg(final String requestURI, final String orgId) {
    return requestURI.replace(ApplicationURL.MOCK_URL + "/" + orgId, EMPTY).toLowerCase();
  }

  public static String fixEndpointUrl(String url) {
    // ensure url must not contain '\' and multiple '/'
    url = url.replace("\\", EMPTY).replace(SLASH, EMPTY);
    return (SLASH + url).toLowerCase();
  }
}

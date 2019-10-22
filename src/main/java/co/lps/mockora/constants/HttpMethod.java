package co.lps.mockora.constants;

import java.util.Arrays;
import java.util.List;

/**
 * co.lps.mockora.model.dao.endpoint
 *
 * @author : josephg
 * @since : 6/07/2019
 */

public enum HttpMethod {
  GET, POST, PUT, PATCH, DELETE;

  public static final List<String> getNames() {
    return Arrays.asList(GET.name(), POST.name(), PUT.name(), PATCH.name(), DELETE.name());
  }

}

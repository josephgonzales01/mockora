package co.lps.mockora.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ResponseTemplateServiceImpl implements ResponseTemplateService {

  private static final String ROOT_SYMBOL = "$";

  @SuppressWarnings("unchecked")
  public List<String> extractTemplates(Map<String, Object> body) {
    List<String> jsonProperties = new ArrayList<String>();
    for (Object value : body.values()) {
      if (value instanceof HashMap) {
        // extract templates from inner maps
        extractTemplates((HashMap<String, Object>) value);

      } else if (value.toString().contains(ROOT_SYMBOL)) {
        String valString = value.toString();
        jsonProperties
            .add(valString.substring(valString.indexOf(ROOT_SYMBOL), valString.length() - 1));

      }
    }

    return jsonProperties;
  }

}

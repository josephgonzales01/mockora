package co.lps.mockora.model.dao;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class Mock {
  private String orgId;
  private String resourceId;
  private List<Method> methods;
  @Id
  private String id;
  

}

package co.lps.mockora.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

/**
 * co.lps.mockora.dao.endpoint
 *
 * @author : josephg
 * @since : 15/07/2019
 */
@Data
@NoArgsConstructor
@Document
public class RequestProperty {

  @Id
  private String id;
  private String name;
  private String value;
 

}

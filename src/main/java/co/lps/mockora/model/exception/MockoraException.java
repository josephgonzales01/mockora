package co.lps.mockora.model.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class MockoraException extends RuntimeException {
  private final String message;
  private final HttpStatus status;

  public MockoraException(HttpStatus status) {
    this("", status);
  }
}

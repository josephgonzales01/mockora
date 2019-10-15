package co.lps.mockora.model.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MockoraException extends RuntimeException {
  private String message;
  private HttpStatus status;

}

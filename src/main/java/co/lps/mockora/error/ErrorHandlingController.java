package co.lps.mockora.error;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import co.lps.mockora.model.dto.CommonResponseDto;
import co.lps.mockora.model.dto.ErrorDto;
import co.lps.mockora.model.exception.MockoraException;

@ControllerAdvice
public class ErrorHandlingController {

 
  @ExceptionHandler({MockoraException.class, MethodArgumentNotValidException.class})
  public ResponseEntity<CommonResponseDto> handleError(Exception ex, WebRequest request) {
    List<ErrorDto> errors = new ArrayList<ErrorDto>();

    if (ex instanceof MockoraException) {
      MockoraException mex = (MockoraException) ex;
      errors.add(new ErrorDto(mex.getStatus().getReasonPhrase(), mex.getMessage()));

      return ResponseEntity.status(mex.getStatus())
          .body(new CommonResponseDto(mex.getStatus().value(), "", "", errors));

    } else if (ex instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException manvex = (MethodArgumentNotValidException) ex;
      manvex.getBindingResult().getAllErrors().stream()
          .map(e -> new ErrorDto("invalid " + ((FieldError) e).getField(), e.getDefaultMessage()))
          .forEach(errors::add);

    }

    errors.add(new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage()));
    return ResponseEntity.status(500).body(new CommonResponseDto(500, "", "", errors));

  }

}

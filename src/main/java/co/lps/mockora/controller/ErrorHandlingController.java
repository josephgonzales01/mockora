package co.lps.mockora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import co.lps.mockora.model.dto.CommonMessageDto;
import co.lps.mockora.model.exception.MockoraException;

@ControllerAdvice
public class ErrorHandlingController {

  @ExceptionHandler({MockoraException.class})
  public ResponseEntity<CommonMessageDto> handleError(RuntimeException rex, WebRequest request) {

    if (rex instanceof MockoraException) {

      MockoraException mex = (MockoraException) rex;

      return ResponseEntity.status(mex.getStatus()).body(new CommonMessageDto(
          mex.getStatus().getReasonPhrase(), mex.getMessage(), mex.getStatus().value()));
    }

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new CommonMessageDto(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null,
            HttpStatus.INTERNAL_SERVER_ERROR.value()));

  }

}

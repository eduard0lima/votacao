package br.com.sicredi.votacao.config.exceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(CustomRestException.class)
    public ResponseEntity<ResponseError> handleCustomRestException(CustomRestException ex) {
        ResponseError responseError = new ResponseError(ex.getExceptionCode(),
                getMessage(ex.getExceptionCode(), ex.getParameters()));
        return new ResponseEntity<>(responseError, ex.getExceptionCode().getHttpStatus());
    }


    private String getMessage(ExceptionEnum code, String[] parameters) {
        return messageSource.getMessage(code.getMessage(), parameters, LocaleContextHolder.getLocale());
    }

}

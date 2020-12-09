package uni.eszterhazy.keretrendszer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String methodnotallowed(HttpRequestMethodNotSupportedException e){
        return "Ez a metódus nem engedélyzett " + e.getMethod() + ", használja valamelyiket ezek közül " + e.getSupportedHttpMethods();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badrequest(HttpMessageNotReadableException e){
        Throwable c = e.getCause().getCause();
        return c.getClass().getSimpleName()+ ": " + c.getMessage();
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public String unsupported(HttpMediaTypeNotSupportedException e){
        return "Kérem használja ezt: " + e.getSupportedMediaTypes();
    }

    @ExceptionHandler(TermekNotFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String unknownTermekId(TermekNotFound e){
        return "Az adott azonosítóval: " +e.getMessage() + ", nem létezik egy termék sem";
    }
}

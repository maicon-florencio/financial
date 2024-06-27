package br.com.objetive.financial.financial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BussinessExceptionErro extends RuntimeException{

    public BussinessExceptionErro(String msg){
        super(msg);
    }
}

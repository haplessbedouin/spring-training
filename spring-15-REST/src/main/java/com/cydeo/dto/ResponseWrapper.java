package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data){ // this constructor for the methods that returns data (POST, GET)
        this.message = message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message){  // this constructor for the methods that doesn't return data like void methods (DELETE, PUT)
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

}

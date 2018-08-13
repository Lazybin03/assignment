package com.example.demo.utills;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
        private String resourceName;
        private String errorMsg;

    public ResourceNotFoundException(String resourceName, String errorMsg) {
        super(String.format("%s not found !!errormsg:: %s ", resourceName,errorMsg));
        this.resourceName = resourceName;
        this.errorMsg = errorMsg;
    }

}

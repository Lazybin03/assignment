package com.example.demo.utills;

public class CustomResponse {
    String resourceName;
    Object resource;

    public CustomResponse(String resourceName, Object resource) {
        this.resourceName = resourceName;
        this.resource = resource;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }
}

package com.amer.circuit.dal.model;

import java.util.Properties;

public class RequestModel {

    Properties properties = new Properties();

    String serviceName;

    public RequestModel(Properties properties, String serviceName) {
        this.properties = properties;
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public RequestModel(Properties properties) {
        this.properties = properties;
    }

    public RequestModel() {
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

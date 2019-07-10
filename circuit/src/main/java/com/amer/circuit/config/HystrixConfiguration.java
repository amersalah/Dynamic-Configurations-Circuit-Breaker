package com.amer.circuit.config;

import com.amer.circuit.dal.model.MovieResponse;
import com.amer.circuit.dal.model.RequestModel;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.web.client.RestTemplate;

public class HystrixConfiguration extends HystrixCommand<MovieResponse> {


    private RestTemplate restTemplate = new RestTemplate();

    public HystrixConfiguration(RequestModel  model) {

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(model.getServiceName()))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(Integer.parseInt((String) model.getProperties().getProperty("hystrix.command.movies.execution.isolation.thread.timeoutInMilliseconds"))
                        ).withFallbackEnabled(true)));

    }

//    @Override
//    public String execute() {
//        MovieResponse response =restTemplate.getForObject("http://localhost:8090/movies" , MovieResponse.class);
//        return response.toString();
//    }

    @Override
    protected MovieResponse run() throws Exception {
        MovieResponse response =restTemplate.getForObject("http://localhost:8090/movies" , MovieResponse.class);
        return response;
    }

    @Override
    protected MovieResponse getFallback() {
        MovieResponse response = new MovieResponse();
        response.setErrorCode("mv001");
        response.setErrorMessage("Fallback Called");
        return response;
    }


}

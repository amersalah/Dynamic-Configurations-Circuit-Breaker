package com.amer.circuit;


import com.amer.circuit.config.HystrixConfiguration;
import com.amer.circuit.dal.model.MovieResponse;
import com.amer.circuit.dal.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@RestController
@RequestMapping(value = "/movies")
public class HystrixService {


    @Autowired
    Environment env;

    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping
//    @HystrixCommand(fallbackMethod = "fallback"
//            ,
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = env),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "50")
//            })
    public MovieResponse getAllMovies() {
        Properties props = new Properties();
        props.setProperty("hystrix.command.movies.execution.isolation.thread.timeoutInMilliseconds", env.getProperty("hystrix.command.movies.execution.isolation.thread.timeoutInMilliseconds"));

        RequestModel requestModel = new RequestModel(props, "movies");

        HystrixConfiguration hystrixConfiguration = new HystrixConfiguration(requestModel);
        return hystrixConfiguration.execute();
    }


    public MovieResponse fallback()
    {

        MovieResponse response = new MovieResponse();
        response.setErrorCode("mv004");
        response.setErrorMessage("Fallback Called");
        return response;
    }

}

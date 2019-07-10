package com.amer.circuit.dal.model;

import java.util.List;

public class MovieResponse {

    List<Movie> movieList ;
    private String errorCode;
    private String errorMessage;


    public MovieResponse(List<Movie> movieList, String errorCode, String errorMessage) {
        this.movieList = movieList;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public MovieResponse() {
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movieList=" + movieList +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

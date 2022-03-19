package ru.learnup.rushmanov.spring.mvc.rest.exception_handling;

public class NoSuchPerformanceException extends RuntimeException{

    public NoSuchPerformanceException(String message) {
        super(message);
    }
}

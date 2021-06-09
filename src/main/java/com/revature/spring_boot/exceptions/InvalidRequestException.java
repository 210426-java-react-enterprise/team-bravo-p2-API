package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 8:05 PM
 * Description: {Insert Description}
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }

}

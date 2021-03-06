package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 7:59 PM
 * Description: Authintication error for when users enter the wrong login information.
 */
public class AuthException extends RuntimeException {

    public AuthException(String s) {
        super(s);
    }

    public AuthException() {
        super("Could not authenticate using the provided credentials");
    }

}

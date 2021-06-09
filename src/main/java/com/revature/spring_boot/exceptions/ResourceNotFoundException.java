package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 8:07 PM
 * Description: {Insert Description}
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource was found using the provided search criteria.");
    }

}

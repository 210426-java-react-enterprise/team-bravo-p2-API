package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 8:07 PM
 * Description: Exception thrown when no item is found when searching
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource was found using the provided search criteria.");
    }

}

package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 8:23 PM
 * Description: {Insert Description}
 */
public class ResourcePersistenceException extends DataSourceException {

    public ResourcePersistenceException() {
        super("There was a problem when trying to persist the resource. Check the logs for more details.");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }
}

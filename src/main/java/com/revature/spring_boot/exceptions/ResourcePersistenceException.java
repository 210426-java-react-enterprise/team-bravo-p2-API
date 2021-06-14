package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 8:23 PM
 * Description: Exception for when there is an issue saving an item to the data layer
 */
public class ResourcePersistenceException extends DataSourceException {

    public ResourcePersistenceException() {
        super("There was a problem when trying to persist the resource. Check the logs for more details.");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }
}

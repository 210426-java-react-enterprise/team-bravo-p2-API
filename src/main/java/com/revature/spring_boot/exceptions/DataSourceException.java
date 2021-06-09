package com.revature.spring_boot.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/8/2021
 * Time: 8:10 PM
 * Description: {Insert Description}
 */
public class DataSourceException extends RuntimeException {

    public DataSourceException(Throwable e) {
        super("There was a problem when communicating with the database. Check the logs for more details.", e);
    }

    public DataSourceException(String message) {
        super(message);
    }

}

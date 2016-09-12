package com.matc.persistence;

/**
 * Created on 8/31/16.
 *
 * @author pwaite
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.*;

/**
 * Provides access to the database
 */
public class Database {

    private final Logger logger = Logger.getLogger(this.getClass());

    // create an object of the class Database
    private static Database instance = new Database();

    private Properties properties;

    private Connection connection;

    // private constructor prevents instantiating this class anywhere else
    private Database() {
        loadProperties();

    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.info("Database.loadProperties()...Cannot load the properties file");
            logger.info("Stack trace: " + ioe);
        } catch (Exception e) {
            logger.info("Database.loadProperties()..." + e);
            logger.info("stack trace for load proerites exept: " + e);
        }

    }

    // get the only Database object available
    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.info("Cannot close connection" + e);
            }
        }

        connection = null;
    }

}
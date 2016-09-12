package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SQL Error: " + e);
        } catch (Exception e) {
            logger.info("General Connection Error: " + e);
        }
        return users;
    }

    //TODO add a method or methods to return a single user based on search criteria
    public User getOneUserWith(String lastName) {
        Database database = Database.getInstance();
        Connection connection = null;
        User employee = null;
        String sql = "SELECT * FROM users WHERE last_name='" + lastName + "'";
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                employee = createUserFromResults(results);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SQL Error: " + e);
        } catch (Exception e) {
            logger.info("General Connection Error: " + e);
        }
        return employee;

    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setUserid(results.getString("id"));
        user.setBirthDate(results.getDate("date_of_birth"));
        user.calculateAge();
        user.setUserAge(user.getUserAge());
        return user;
    }

}

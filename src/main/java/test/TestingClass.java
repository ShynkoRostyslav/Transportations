package test;

import BD.Bd_connector;
import BD.Connector;
import org.junit.Assert;
import org.junit.Test;
import java.sql.*;

public class TestingClass {

    @Test
    public void test_getId() throws SQLException {
        Bd_connector bd = new Bd_connector();
        Assert.assertEquals(171, bd.getUserId("Pudge"));
        Assert.assertEquals(33, bd.getUserId("Kirkwood"));

    }

    @Test
    public void test_update_User() throws SQLException {
        Bd_connector bd = new Bd_connector();
        bd.updateSurname("Solar", "Logan");
        Assert.assertEquals("Logan", selectSurname("Logan"));
        bd.updateName("Steve" ,"Invoker");
        Assert.assertEquals("Invoker",selectName("Invoker"));

    }


    static public String selectSurname(String surname) throws SQLException {

        String query = "SELECT Surname FROM trucker WHERE Surname=?";
        try (Connection connection = DriverManager.getConnection(Connector.url, Connector.name, Connector.password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("Surname");
            }
        }
        return null;
    }

    static public String selectName(String name) throws SQLException {
        String query = "SELECT Name FROM trucker WHERE Name=?";
        try (Connection connection = DriverManager.getConnection(Connector.url, Connector.name, Connector.password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("Name");

            }
        }
        return null;

    }







}

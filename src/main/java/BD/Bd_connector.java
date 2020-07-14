package BD;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

public class Bd_connector implements Connector {
 static Logger logger = LogManager.getLogger(Bd_connector.class.getName());

    public boolean is_Password(String password, String name_1) throws SQLException {
        logger.log(Level.INFO,"enter the method isPassword");

        String query1 = "Select Password " +
                "from trucker.trucker  "
                + " Where Password like " + "'" + password + "'" + "and  Name like  ?";
        try (Connection connection = DriverManager.getConnection(url, name, this.password);
             PreparedStatement statemnt = connection.prepareStatement(query1);
        ) {
            statemnt.setString(1, name_1);
            ResultSet result = statemnt.executeQuery();
            while (result.next()) {

                if (result.getString("Password").equals(password))
                    return true;
            }

        }

        return false;
    }

    public boolean isPerson(String name1) throws SQLException, ClassNotFoundException {
        logger.log(Level.INFO,"enter the method isPerson");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(name1);
        try (
                Connection connection = DriverManager.getConnection(url, name, password);
                Statement statemnt = connection.createStatement()

        ) {

            String query = "Select Name " +
                    "from trucker.trucker  "
                    + " Where Name like " + "'" + name1 + "'";

            ResultSet resultSet = statemnt.executeQuery(query);
            File file = new File("TXT.txt");
            System.out.println(file.exists());

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            /*   System.setOut(new PrintStream(fileOutputStream));*/
            int i = 0;
            while (resultSet.next()) {

                System.out.println(resultSet.getString(1));

                if (resultSet.getString(1).equals(name1))
                    return true;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void connect(String name1, int age) throws SQLException {

        logger.log(Level.INFO,"enter the method method");
        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statemnt = connection.createStatement();
        ) {
            String query1 = "insert into trucker.trucker (Surname,Age) values(?,?)";
            PreparedStatement preparedStatemnt = connection.prepareStatement(query1);
            preparedStatemnt.setString(1, name1);
            preparedStatemnt.setInt(2, age);
            preparedStatemnt.execute();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * from trucker.trucker");
            while (result.next()) {
                System.out.println(result.getString(" name    " + 1));
                System.out.println(result.getString("Surname   " + 2));
                System.out.println(result.getInt("Age   " + 3));
                System.out.println(result.getInt("id " + 4));
                System.out.println(result.getInt(" id  " + 5));
            }
        }
    }

    public int getUserId(String surname) throws SQLException {
        logger.log(Level.INFO,"enter the method getUserId");
        String query = "SELECT id_person FROM trucker.trucker WHERE Surname= ?";

        try (Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Integer.parseInt(resultSet.getString("id_person"));

            }
            return 0;

        }

    }

    public void addUser(String name, String surname, String passworrd, int age) throws SQLException {
        logger.log(Level.INFO,"enter the method addUser");
        try (Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
             Statement statement = connection.createStatement();) {

            if (!isPerson(name)) {
                String query1 = "insert into trucker.trucker (Name,Surname,Age,Password) values(?,?,?,?)";
                PreparedStatement preparedStatemnt = connection.prepareStatement(query1);
                preparedStatemnt.setString(1, name);
                preparedStatemnt.setString(2, surname);
                preparedStatemnt.setInt(3, age);
                preparedStatemnt.setString(4, passworrd);
                preparedStatemnt.execute();

            } else {
                throw new SQLException();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void connect(String name1, String PAssword) throws SQLException {
        logger.log(Level.INFO,"enter the method connection_2");

        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statemnt = connection.createStatement();
        ) {

            String query1 = "insert into trucker.trucker (Surname,Password) values(?,?)";

            PreparedStatement preparedStatemnt = connection.prepareStatement(query1);

            preparedStatemnt.setString(1, name1);
            preparedStatemnt.setString(2, PAssword);
            preparedStatemnt.execute();
            ResultSet result = preparedStatemnt.executeQuery("SELECT * from trucker.trucker");

            while (result.next()) {
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(6));

                /*      System.out.println(result.getInt("id_truck"));*/
            }
        }
    }

    public void addTransporation(String Name, String City_to, String date_to, String City_from, String date_from) throws SQLException {
        logger.log(Level.INFO,"enter the method addTransportation");

        try (Connection connection = DriverManager.getConnection(url, name, password)) {

            String query = "Insert into trucker.station_from (City,date) values(?,?)";
            String query1 = "Insert into trucker.station_to (City,arrival_at) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            PreparedStatement statement_1 = connection.prepareStatement(query1);

            statement.setString(1, City_from);
            statement.setString(2, date_from);
            statement_1.setString(1, City_to);
            statement_1.setString(2, date_to);
            statement_1.execute();
            statement.execute();

        }


    }


    public void deleteUser(int id) throws SQLException {
        logger.log(Level.INFO,"enter the method deleteUser");


        String query = "DELETE FROM trucker.trucker WHERE id_person=?";
        try (Connection connection = DriverManager.getConnection(this.url, this.name, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.execute();
        }

    }


    public void updateSurname(String oldSurame, String newSurname) throws SQLException {
        logger.log(Level.INFO,"enter the method updateSurname");
        String query = "UPDATE trucker SET Surname =? where Surname= ?";
        try (Connection connection = DriverManager.getConnection(url, name, password);
             PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setString(1, newSurname);
            statement.setString(2, oldSurame);
            statement.execute();
        }

    }

    public void updateName(String oldName, String newName)throws SQLException {
        logger.log(Level.INFO,"enter the method updateName");

        String query = "UPDATE trucker SET Name =? where Name= ?";
        try (Connection connection = DriverManager.getConnection(url, name, password);
             PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1,newName);
            statement.setString(2, oldName);
            statement.execute();
        }

    }



}




package db;

import User.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBConnection extends Configs {
    private Connection connection;
    private Statement statement;

    public Connection GetConnection() throws SQLException {
     try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lab9?serverTimezone=Europe/Moscow&useSSL=false", "root", "Ksusha20031007");
            System.out.println("Connection successful!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return connection;
    }

    public ArrayList<Users> GetAllUsers() throws SQLException {
        String sqlQuery="select * from users;";
        statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlQuery);

        ArrayList<Users> users = new ArrayList<Users>();
        while(resultSet.next()){
            String username = resultSet.getString(1);
            String password = resultSet.getString(2);
            String role = resultSet.getString(3);

            Users user = new Users(username,password,role);
            users.add(user);
        }
        return users;
    }

    public boolean AddUser(Users user) throws SQLException {
        //проверка на существующее имя пользователя
        String select="insert users(username,password,role) values('"+user.getUsername() + "','"+ user.getPassword()+ "','user');";
        statement = GetConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(select);
        return true;
    }

    public Users GetByUsername(String Username, String Password) throws SQLException {
        String select ="select * from users where username = '"+ Username+ "';";
        statement = GetConnection().createStatement();
        ResultSet resultSet= statement.executeQuery(select);
        Users user=null;
        if(resultSet != null){
            while(resultSet.next()){
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                String role = resultSet.getString(3);
                user = new Users(username,password,role);
            }
        }
        return  user;
    }
}

package Letters;

import com.company.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO extends Configs implements IDAO {
    private final Connection dbConnection;
    public Statement statement;

    private final String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

    public DAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        if(dbConnection != null)
        {
            System.out.println("Connected to db!");
            statement = dbConnection.createStatement();
        }
    }

    @Override
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connectionString, dbUser, dbPass);
    }
    @Override
    public IGenDAO<Letter, Integer> getLetterDAO(Connection connection) {
        return new DAO_Letter(connection);
    }
    @Override
    public IGenDAO<Person, Integer> getPersonDAO(Connection connection) {
        return new DAO_Person(connection);
    }
}
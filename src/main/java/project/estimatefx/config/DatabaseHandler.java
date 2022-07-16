package project.estimatefx.config;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {

    private static final PGSimpleDataSource ds;
    private static final Connection connection;

    static{
        ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost2:5432"});
        ds.setDatabaseName("Estimate");
        ds.setUser("postgres");
        ds.setPassword("root");

        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection(){
        return connection;
    }


    public void signUpUser (String firstName, String lastName,String userName,
                           String password, String location, String gender){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_LOCATION + "," + Const.USER_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, gender);
            preparedStatement.executeUpdate();
        }catch (SQLException  e) {
            e.printStackTrace();
        }

    }
}

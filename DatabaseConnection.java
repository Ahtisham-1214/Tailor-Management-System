import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tailor_management";
    private static final String USER = "root";
    private static final String PASSWORD = "ahtisham123";

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
}

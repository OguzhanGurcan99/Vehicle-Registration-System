import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String databaseLink = "jdbc:postgresql://localhost:5432/postgres";
    private static final String userName = "postgres";
    private static final String password = "1234";

    Connection connection;

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(databaseLink,userName,password);
        return connection;
    }

    public void insertData(Vehicle vehicle) throws SQLException {
        String insertQuery = "INSERT INTO vehicles (name,color,kilometer,price,assurance,inspection) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(insertQuery);

        preparedStatement.setString(1, vehicle.getName());
        preparedStatement.setString(2, vehicle.getColor());
        preparedStatement.setInt(3, vehicle.getKilometer());
        preparedStatement.setDouble(4, vehicle.getPrice());
        preparedStatement.setBoolean(5, vehicle.getAssurance());
        preparedStatement.setBoolean(6, vehicle.getInspection());

        preparedStatement.executeUpdate();
    }


}

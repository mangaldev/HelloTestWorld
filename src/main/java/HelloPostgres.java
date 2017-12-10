import java.sql.*;

public class HelloPostgres {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:15432/db_metamorphosis?binaryTransfer=true", "postgres", "");
        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);
        statement.setFetchSize(1);
        final ResultSet resultSet = statement.executeQuery("select * from entitlements.test");
        while (resultSet.next()) {
            String reason = resultSet.getString(1);
            System.out.println("reason = " + reason);
        }
    }
}

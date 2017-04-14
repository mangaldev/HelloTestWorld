/**
 * Created by mdev on 7/28/16.
 */
import java.sql.*;

public class HelloSybase
{
    public static void main( String args[] )
    {
        try
        {
            String arg;
            Connection con;

            // Select the JDBC driver and create a connection.
            // May throw a SQLException.
            // Choices are:
            // 1. jConnect driver
            // 2. SQL Anywhere JDBC 3.0 driver
            // 3. SQL Anywhere JDBC 4.0 driver
            arg = "jdbc4";
            if( args.length > 0 ) arg = args[0];
            if( arg.compareToIgnoreCase( "jconnect" ) == 0 )
            {
                con = DriverManager.getConnection(
                        "jdbc:sybase:Tds:localhost:2638", "DBA", "sql");
            }
            else if( arg.compareToIgnoreCase( "jdbc3" ) == 0 )
            {
                DriverManager.registerDriver( (Driver)
                                Class.forName(
                                        "sybase.jdbc.sqlanywhere.IDriver").newInstance()
                );
                con = DriverManager.getConnection(
                        "jdbc:sqlanywhere:uid=DBA;pwd=sql" );
            }
            else
            {
                con = DriverManager.getConnection(
                        "jdbc:sqlanywhere:uid=DBA;pwd=sql" );
            }

            System.out.println("Using "+arg+" driver");

            // Create a statement object, the container for the SQL
            // statement. May throw a SQLException.
            Statement stmt = con.createStatement();

            // Create a result set object by executing the query.
            // May throw a SQLException.
            ResultSet rs = stmt.executeQuery(
                    "SELECT ID, GivenName, Surname FROM Customers");

            // Process the result set.
            while (rs.next())
            {
                int value = rs.getInt(1);
                String FirstName = rs.getString(2);
                String LastName = rs.getString(3);
                System.out.println(value+" "+FirstName+" "+LastName);
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch (SQLException sqe)
        {
            System.out.println("Unexpected exception : " +
                    sqe.toString() + ", sqlstate = " +
                    sqe.getSQLState());
            System.exit(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
    }
}
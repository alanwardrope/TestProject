package acme.expedia.framework.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by vanwh on 08/03/2017.
 */
public class DatabaseConnector {

    private Connection connection = null;
    private String serverName;
    private String portNumber;
    private String sid;
    private String url;
    private String username;
    private String password;
    private Statement stmt;
    public ResultSet rset;

    /* This constructor initializes the database variables that requires
        to connect to the database
      */
    public DatabaseConnector(String serName, String portNum,
                    String osid, String dbUrl, String dbUserName, String dbPassword ) throws IOException {
        connection = null;
        serverName = serName; // pass server name of IP from the calling class
        portNumber = portNum; // pass port number from the calling class
        sid = osid;    // pass oracle service name from the calling class od MySQL dbName
        url = dbUrl + serverName + ":" + portNumber + "/" + sid;
        // "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
        // "jdbc:mysql://" + serverName + ":" + portNumber + "/" + osid
        username = dbUserName;   // pass oracle database name from the calling classs
        password = dbPassword;   // pass oracle database password (plaintext) from the calling classs

    }

    public void openDBConnection()
    {
        try
        {

            // Load the JDBC driver
            //String driverName = "oracle.jdbc.driver.OracleDriver";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName).newInstance();

            System.out.println("openDBConnection: url is " + url);
            // Create a connection to the database
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("openDBConnection: DB Connection Open");
        }
        catch (ClassNotFoundException e)
        {
            // Handle errors for Class.forName
            System.out.println("Class not found from database" );
            e.printStackTrace();
        }
        catch (SQLException e1)
        {
            // Handle Errors for JDBC
            System.out.println("Database Connection error " );
            e1.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /* This Function executes the query on the connected database and
       returns the ResultSet collection
       Upon calling from the test case class where actual verification
       is being done on UI and Database.
          */
    public ResultSet runQuery(String Query) throws IOException
    {

        try{
            stmt = connection.createStatement();
            rset = stmt.executeQuery(Query);
        }
        catch(SQLException e1)
        {
            // Handle Errors for JDBC
            System.out.println("Query Execution Error" );
            e1.printStackTrace();
        }

        /*
        try {
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        return rset;

    }


    /* This Function closes the database connection from the Oracle Database Connection
   Upon calling from the test case class where actual verification is being done.
      */
    public void closeDBConnection() throws IOException
    {
        System.out.println("In closeDBConnection");
        try{
            if (rset != null){
                rset.close();
                System.out.println("closeDBConnection: rset closed");}
            if (stmt != null){
                stmt.close();
                System.out.println("closeDBConnection: stmt closed");}
            if (connection != null){
                 connection.close();
                System.out.println("closeDBConnection: connection closed");}
        }
        catch(SQLException e1)
        {
            System.out.println("Query Execution Error" );
            e1.printStackTrace();

        }

    }

}

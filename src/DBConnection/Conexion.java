
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion extends Config{

    private static Connection con;

    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String str = "jdbc:mysql://"+Config.dbhost+":"+Config.dbport+"/"+Config.dbname+"?serverTimezone=UTC";

        con = DriverManager.getConnection(str,Config.dbuser,Config.dbpassword);

        return con;
    }
}

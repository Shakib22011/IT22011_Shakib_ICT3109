import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connection {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    String url="jdbc:mysql://localhost:3306/test";
    String username="root";
    String password="dbmsshakib";
    public connection()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnection()  {
        try {
             con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    public void closeAll() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.con!= null) {
                this.con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class queries extends connection{
    public boolean InsetDB(String name ) {
        this.getConnection();
        String sql = "INSERT INTO STUDENT(NAME) VALUES(?)";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            //rs = ps.executeQuery();
            ps.executeUpdate();

            ps.close();
            //rs.close();
            con.close();
            System.out.println("Inserted into database");
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteStudent(int studentSerial) {
        this.getConnection();
        String sql ="delete from student where id=?";

        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1,studentSerial);
            ps.executeUpdate();
            ps.close();
            con.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public List<student_info> ReadFromDB() {
        List<student_info> list = new ArrayList<student_info>();
        student_info std = null;
        this.getConnection();
        String sql ="select * from student";
        try
        {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                std = new student_info();
                std.setId(rs.getInt(1));
                std.setName(rs.getString(2));
                list.add(std);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
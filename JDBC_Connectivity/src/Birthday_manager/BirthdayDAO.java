
package Birthday_manager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BirthdayDAO {

    public static List<Birthday> getAllBirthdays() {
        List<Birthday> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM birthdays ORDER BY dob")) {

            while (rs.next()) {
                list.add(new Birthday(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addBirthday(String name, LocalDate dob) {
        String sql = "INSERT INTO birthdays(name, dob) VALUES(?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDate(2, Date.valueOf(dob));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateBirthday(int id, String name, LocalDate dob) {
        String sql = "UPDATE birthdays SET name = ?, dob = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDate(2, Date.valueOf(dob));
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBirthday(int id) {
        String sql = "DELETE FROM birthdays WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Birthday> searchBirthdays(String keyword) {
        List<Birthday> list = new ArrayList<>();
        String sql = "SELECT * FROM birthdays WHERE name LIKE ? OR MONTHNAME(dob) LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Birthday(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/javafxlocalization";
    private static final String USER = "root";
    private static final String PASSWORD = "DonGio024"; // Change this to your password

    public static void insertEmployee(String language, String firstName, String lastName, String email) {
        String tableName = "employee_";

        switch (language) {
            case "Farsi":
                tableName += "fa";
                break;
            case "Japanese":
                tableName += "ja";
                break;
            default:
                tableName += "en";
                break;
        }

        String sql = "INSERT INTO " + tableName + " (first_name, last_name, email) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

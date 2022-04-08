package DB_Challenge;

import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:mysql://localhost:3306/challenge";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "SELECT province_id, name FROM province";

    public static void main(String[] args) {
        // Open a connection
        try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("province_id"));
                System.out.println(", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

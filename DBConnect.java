import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {
	public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/attendance_db";
        String user = "root";
        String password = "Aunghtoo19670412"; // パスワード設定してるなら入れて

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("接続成功！");
            return conn;
        } catch (SQLException e) {
            System.out.println("接続失敗: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}

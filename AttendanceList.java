import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class AttendanceList {
	 public static void main(String[] args) {
	        try (Connection conn = DBConnect.getConnection()) {
	            String sql = "SELECT * FROM attendance";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            System.out.println("【出席一覧】");
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                int userId = rs.getInt("user_id");
	                String username = rs.getString("username");
	                String time = rs.getString("timestamp");

	                System.out.printf("ID: %d | UserID: %d | 名前: %s | 出席時刻: %s%n",
	                        id, userId, username, time);
	            }
	        } catch (Exception e) {
	            System.out.println("一覧取得エラー: " + e.getMessage());
	        }
	    }
}

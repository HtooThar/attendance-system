import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Attendance {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ユーザー名を入力してください（ログインしている人）: ");
        String username = scanner.nextLine();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "INSERT INTO attendance (username) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();

            System.out.println("出席記録完了！" + username + " さんの出席が保存されました。");
        } catch (Exception e) {
            System.out.println("出席失敗: " + e.getMessage());
        }

        scanner.close();
    }
}

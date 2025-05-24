import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class UserRegister {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ユーザー名を入力してください: ");
        String username = scanner.nextLine();

        System.out.print("パスワードを入力してください: ");
        String password = scanner.nextLine();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();

            System.out.println("ユーザー登録成功！");
        } catch (Exception e) {
            System.out.println("登録失敗: " + e.getMessage());
        }

        scanner.close();
    }
}

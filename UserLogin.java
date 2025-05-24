import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ユーザー名を入力してください: ");
        String username = scanner.nextLine();

        System.out.print("パスワードを入力してください: ");
        String password = scanner.nextLine();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("ログイン成功！ようこそ " + username + " さん");
            } else {
                System.out.println("ログイン失敗：ユーザー名かパスワードが間違っています。");
            }
        } catch (Exception e) {
            System.out.println("ログインエラー: " + e.getMessage());
        }

        scanner.close();
    }
}

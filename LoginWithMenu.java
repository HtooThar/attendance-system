import java.sql.*;
import java.util.Scanner;
public class LoginWithMenu {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ユーザー名を入力してください: ");
        String username = scanner.nextLine();
        System.out.print("パスワードを入力してください: ");
        String password = scanner.nextLine();

        try (Connection conn = DBConnect.getConnection()) {
            // ログイン確認
            String loginSql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(loginSql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");
                System.out.println("\nログイン成功！ようこそ " + username + " さん\n");

                while (true) {
                    System.out.println("===== メニュー =====");
                    System.out.println("1. 出席する");
                    System.out.println("2. 出席一覧を見る");
                    System.out.println("3. ログアウト");
                    System.out.print("番号を選んでください: ");
                    int choice = Integer.parseInt(scanner.nextLine());

                    if (choice == 1) {
                        // 出席処理
                        String attendSql = "INSERT INTO attendance (user_id, username) VALUES (?, ?)";
                        PreparedStatement attendStmt = conn.prepareStatement(attendSql);
                        attendStmt.setInt(1, userId);
                        attendStmt.setString(2, username);
                        attendStmt.executeUpdate();
                        System.out.println("出席完了！\n");

                    } else if (choice == 2) {
                        // 出席一覧表示
                        String listSql = "SELECT * FROM attendance WHERE user_id = ?";
                        PreparedStatement listStmt = conn.prepareStatement(listSql);
                        listStmt.setInt(1, userId);
                        ResultSet listRs = listStmt.executeQuery();

                        System.out.println("\n【あなたの出席一覧】");
                        while (listRs.next()) {
                            System.out.printf("ID: %d | 日時: %s\n",
                                    listRs.getInt("id"), listRs.getString("timestamp"));
                        }
                        System.out.println();

                    } else if (choice == 3) {
                        System.out.println("ログアウトしました。");
                        break;
                    } else {
                        System.out.println("無効な選択です。\n");
                    }
                }
            } else {
                System.out.println("ログイン失敗：ユーザー名またはパスワードが間違っています。");
            }
        } catch (Exception e) {
            System.out.println("エラー: " + e.getMessage());
            scanner.close();
        }
    }
}

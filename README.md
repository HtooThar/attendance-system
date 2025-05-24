# Attendance System（出席管理システム）

これは Java と MySQL を使用して作成した、コマンドライン形式の出席管理システムです。  
ユーザー登録、ログイン、出席記録、出席一覧表示などの基本機能を備えています。

## 📌 使用技術

- Java（オブジェクト指向プログラミング）
- MySQL（データベース）
- JDBC（Java Database Connectivity）
- CLI（コマンドラインインターフェース）

## 🧩 ファイル構成

| ファイル名 | 説明 |
|------------|------|
| `UserRegister.java` | 新規ユーザー登録処理 |
| `UserLogin.java` | ユーザーログイン処理 |
| `LoginWithMenu.java` | ログイン後のメニュー表示 |
| `Attendance.java` | 出席記録をDBに保存 |
| `AttendanceList.java` | 出席データを一覧表示 |
| `DBConnect.java` | データベース接続クラス（MySQL用） |

## ✅ 機能概要

- 登録済みユーザーのログイン機能
- 出席ボタンを押すと現在日時で記録
- 全ユーザーの出席記録を一覧表示
- エラー処理やDB接続の確認を含む

## 🛠️ 使用方法

1. MySQLに `users` と `attendance` テーブルを作成（構造はご自身で定義）
2. `DBConnect.java` にDB接続情報を入力（URL、ユーザー名、パスワードなど）
3. 任意の順番で `.java` ファイルをコンパイル・実行

## 💬 今後の展望（例）

- GUI対応（SwingやJavaFXなど）
- 出席状況をCSV形式で出力
- パスワードのハッシュ化によるセキュリティ強化

---

## 👤 作者情報

- 名前：Aung Htoo Thar  
- GitHub：[@HTOOTHAR](https://github.com/HTOOTHAR)  
- 日本語能力試験N2 / Javaプログラミング能力認定試験3級


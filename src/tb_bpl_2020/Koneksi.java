package tb_bpl_2020;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
	private static Connection MySQLConnection;
	static Connection conn;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/minimarket?serverTimezone=Asia/Jakarta";
    static final String USER = "root";
    static final String PASS = "";

	public static Connection koneksi() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(JDBC_DRIVER);
			MySQLConnection = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Gagal Terhubung Ke Database", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return MySQLConnection;
	}
}

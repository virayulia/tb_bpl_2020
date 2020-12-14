package tb_bpl_2020;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedHashMap;

public class DBUser {
	User datauser;
	User datauser2;
	FormRegistrasi form_registrasi;

	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	
	public Integer Login(User datauser) {
		Integer login=0;
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = ("SELECT * FROM user WHERE username =? AND password =?");
			statement = conn.prepareStatement(sql);
			statement.setString(1, datauser.getUsername());
			statement.setString(2, datauser.getPassword());
			ResultSet rs = statement.executeQuery();
	
		if(rs.next()) {
			try {
				String update = "UPDATE user SET login_terakhir = '"+datauser.getDate()+"' WHERE username ='"+datauser.getUsername()+"'";
				stmt = conn.createStatement();

				login = stmt.executeUpdate(update);
			}
			
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada "+e+"", "Peringatan", JOptionPane.WARNING_MESSAGE);
			
			}}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Username dan Password Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
			}
		
		return login;
	}
	
	public Integer Registrasi(User datauser2) {
		Integer registrasi = 0;
		
		//cek validasi email
		if(isValidEmail(datauser2.getEmail().toString())) {
			try {
				Connection conn = (Connection)Koneksi.koneksi();
				String check_akun = ("SELECT username FROM user WHERE username = ?");
				statement = conn.prepareStatement(check_akun);
				statement.setString(1, datauser2.getUsername());
				ResultSet rs_check = statement.executeQuery();
						
			if (rs_check.next()) {
				JOptionPane.showMessageDialog(null, "Username Sudah Terdaftar");	
				}
				
			else {
				try {
					String tambah = ("INSERT INTO user VALUES (?,?,?,?)");
					statement = conn.prepareStatement(tambah);
					statement.setString(1, datauser2.getUsername());
					statement.setString(2, datauser2.getDate());
					statement.setString(3, datauser2.getEmail());
					statement.setString(4, datauser2.getPassword());
					registrasi = statement.executeUpdate();
				}
				catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada "+e+"");
				}
			}
		}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada "+e+"");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Masukkan Email yang Valid", "Peringatan!", JOptionPane.ERROR_MESSAGE);	
		}
		return registrasi;	
	}
	
	private static boolean isValidEmail(String email) {
		boolean valid = false;
		String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
		String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";
		
		if(email.matches(emailPattern)) {
			valid = true;
		}
		else if(email.matches(emailPattern2)) {
			valid = true;
		}
		else {
			valid = false;
		}
		return valid;
	}
	
	//Hapus akun
	public Integer HapusAkun() {
		Integer hapus_akun = 0;
		
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			
			String sql = ("DELETE FROM user WHERE username=?");
			statement = conn.prepareStatement(sql);
			statement.setString(1, FormLogin.user);
			hapus_akun = statement.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Terjadi kesalahan");
		}
		return hapus_akun;
	}
	
	//Ganti Password
	public Integer GantiPassword(String passLama, String passBaru) {
		Integer ganti_password = 0;
		
		if(passLama.equals(FormLogin.pass)) {
			try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = ("UPDATE user SET password=? WHERE username=?");	
			statement = conn.prepareStatement(sql);
			statement.setString(1, passBaru);
			statement.setString(2, FormLogin.user);
			ganti_password = statement.executeUpdate();
			
			FormLogin.pass = passBaru;
			}
			
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Password Lama Anda Salah");
		}
		return ganti_password;
	}

	
	//Lihat Data
	public LinkedHashMap<String, User> lihatUser(){
		
		LinkedHashMap<String, User> listUser = new LinkedHashMap<>();
	
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = ("SELECT * FROM user");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				datauser = new User(rs.getString("username"), rs.getString("login_terakhir"), rs.getString("email"), rs.getString("password"));
				
			listUser.put(rs.getString("username"), datauser);	
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada "+e+"");
		}
		return listUser;
	}
	
	//Cari Data User
	public LinkedHashMap<String, User> cariUser(String cari){
		
		LinkedHashMap<String, User> Cari = new LinkedHashMap<>();
		
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String query = "SELECT * FROM user WHERE username LIKE ?";
			statement = conn.prepareStatement(query);
			statement.setString(1, "%" +cari+ "%");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				datauser = new User(rs.getString("username"), rs.getString("login_terakhir"), rs.getString("email"), rs.getString("password"));
				Cari.put(rs.getString("username"), datauser);
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada "+e);
		}
		return Cari;
	}
	
}

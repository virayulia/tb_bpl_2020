package tb_bpl_2020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DbBarang {
	
	public static Connection conn = null;
	public static PreparedStatement pstm = null;
	
	
	public void tambahBarang(Barang b) {	
		try {
			Connection conn = Koneksi.koneksi();
			String sql = "INSERT INTO barang VALUES (?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getSku());
			pstm.setString(2, b.getNama());
			pstm.setInt(3, b.getStock());
			pstm.setInt(4, b.getHargabeli());
			pstm.setInt(5, b.getHargajual());
			
			if(pstm.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			try {
				pstm.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
	}
	
		
	public void hapusBarang(String sku) {
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "DELETE FROM barang WHERE sku = '"+sku+"'";
			pstm = conn.prepareStatement(sql);
			
			if(pstm.executeUpdate(sql) > 0) {
				JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
			}
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			try {
				pstm.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		
	}
	
	
	public void updateBarang(Barang b) {
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "UPDATE barang SET nama=?, stock=?, harga_beli=?, harga_jual=? WHERE sku=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, b.getNama());
			pstm.setInt(2, b.getStock());
			pstm.setInt(3, b.getHargabeli());
			pstm.setInt(4, b.getHargajual());
			pstm.setString(5, b.getSku());
			
			if(pstm.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			try {
				pstm.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		
	}
	
	
	public Barang pilihBarang(String sku) {
		Barang b = null;
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "SELECT * FROM barang WHERE sku='"+sku+"'";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				b = new Barang(rs.getString("sku"), rs.getString("nama"),
						rs.getInt("stock"), rs.getInt("harga_beli"),
						rs.getInt("harga_jual"));
			}
			else {
				b = null;
				rs.close();
			}
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			try {
				pstm.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}	
		return b;	
	}
	
	
	public ArrayList<Barang> tampilkanData(){
		ArrayList<Barang> listBarang = new ArrayList<>();
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "SELECT * FROM barang";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				listBarang.add(new Barang(rs.getString("sku"), 
											rs.getString("nama"),
											rs.getInt("stock"), 
											rs.getInt("harga_beli"),
											rs.getInt("harga_jual")));
			}
			rs.close();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			try {
				pstm.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}	
		return listBarang;
	}
	
	
	public ArrayList<Barang> cariBarang(String keyword){
		ArrayList<Barang> listBarang = new ArrayList<>();
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String query = "SELECT * FROM barang WHERE nama LIKE ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, "%"+keyword+"%");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				listBarang.add(new Barang(rs.getString("sku"),
											rs.getString("nama"),
											rs.getInt("stock"), 
											rs.getInt("harga_beli"),
											rs.getInt("harga_jual")));
			}
			rs.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		return listBarang;
	}
	
	
}

	




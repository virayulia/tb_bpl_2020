package tb_bpl_2020;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DbPenjualan {
	
	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	DataPenjualan penjualan;
	
	
	//untuk Tambah data
	public void tambahData(DataPenjualan d) {
		
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "INSERT INTO transaksi(noresi, tanggal, username) VALUES (?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, d.getNoresi());
			statement.setString(2, d.getTanggal());
			statement.setString(3, d.getUsername());
			
			if(statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Data Penjualan berhasil ditambahkan!");	
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan "+e+"");
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
	
	}
	
//tambah detail
public void tambahDetail(DataPenjualan d) {
		
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sqll = "INSERT INTO transaksi_detail(id, sku, noresi, jumlah, harga)  VALUES (?,?,?,?,?) ";
			statement = conn.prepareStatement(sqll);
			statement.setInt(1, d.getId());
			statement.setString(2, d.getSku());
			statement.setString(3, d.getNoresi());
			statement.setInt(4, d.getJumlah());
			statement.setString(5, d.getHarga());
			
			
			if(statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Data Detail berhasil ditambahkan!!");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan "+e+"");
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
	
	}
	
	//untuk hapus data
	public Integer hapusData(String noresi) {
		Integer hapusdata=0;
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql ="DELETE FROM transaksi WHERE noresi = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, noresi);
			hapusdata = statement.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return hapusdata;
		
	}
	
	//untuk Update data
	public void updateData(DataPenjualan d) {
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "UPDATE transaksi SET tanggal =?, username=? WHERE noresi=? ";
			statement = conn.prepareStatement(sql);
			statement.setString(1, d.getTanggal());
			statement.setString(2, d.getUsername());
			statement.setString(3, d.getNoresi());
			if(statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
			}
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		
	}
	//pilih data
	public DataPenjualan pilihData(String noresi) {
		DataPenjualan d = null;
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "SELECT * FROM transaksi WHERE noresi='"+noresi+"'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				d = new DataPenjualan(rs.getString("noresi"), rs.getString("tanggal"),
						rs.getString("username") );
			}
			else {
				d = null;
				rs.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}	
			return d;
		
	}
	//tampil data
	public ArrayList<DataPenjualan> tampilData(){
		ArrayList<DataPenjualan> listdata = new ArrayList<>();
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "SELECT * FROM transaksi";
			statement = conn.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				listdata.add(new DataPenjualan (rs.getString("noresi"),
												rs.getString("tanggal"),
												rs.getString("username")));
				
			}
			rs.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
	
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return listdata;
		
	}
	
	//tampil detail
	public ArrayList<DataPenjualan> tampilDetail(){
		ArrayList<DataPenjualan> listdetail = new ArrayList<>();
		
		try {
			Connection conn = (Connection)Koneksi.koneksi();
			String sql = "SELECT * FROM transaksi_detail";
			statement = conn.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				listdetail.add(new DataPenjualan (rs.getInt("id"),
												rs.getString("sku"),
												rs.getString("noresi"),
												rs.getInt("jumlah"),
												rs.getString("harga")));
				
			}
			rs.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
	
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return listdetail;
		
	}
	
	//pilih detail
		public DataPenjualan pilihDetail(Integer id) {
			DataPenjualan d = null;
			try {
				Connection conn = (Connection)Koneksi.koneksi();
				String sql = "SELECT * FROM transaksi_detail WHERE id='"+id+"'";
				statement = conn.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()) {
					d = new DataPenjualan(rs.getInt("id"), rs.getString("sku"),
							rs.getString("noresi"), rs.getInt("jumlah"),
							rs.getString("harga") );
				}
				else {
					d = null;
					rs.close();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
			}
			finally {
				try {
					statement.close();
				} catch (Exception e) {}
				try {
					conn.close();
				} catch (Exception e) {}
			}	
				return d;
			
		}
		
		//untuk hapus detail
		public Integer hapusDetail(Integer id) {
			Integer hapusdetail=0;
			try {
				Connection conn = (Connection)Koneksi.koneksi();
				String sql ="DELETE FROM transaksi_detail WHERE id = ?";
				statement = conn.prepareStatement(sql);
				statement.setInt(1, id);
				hapusdetail = statement.executeUpdate();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			finally {
				try {
					statement.close();
				} catch (Exception e) {}
				try {
					conn.close();
				} catch (Exception e) {}
			}
			return hapusdetail;
			
		}
		
		//untuk Update detail
		public void updateDetail(DataPenjualan d) {
			try {
				Connection conn = (Connection)Koneksi.koneksi();
				String sql = "UPDATE transaksi_detail SET sku =?, noresi=?, jumlah= ?, harga= ? WHERE id= ?";
				statement = conn.prepareStatement(sql);
				statement.setString(1, d.getSku());
				statement.setString(2, d.getNoresi());
				statement.setInt(3, d.getJumlah());
				statement.setString(4, d.getHarga());
				statement.setInt(5, d.getId());
				if(statement.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
				}
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada "+e+"");
			}
			finally {
				try {
					statement.close();
				} catch (Exception e) {}
				try {
					conn.close();
				} catch (Exception e) {}
			}
			
		}
		
}

package tb_bpl_2020;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasterBarang extends JFrame {

	public DbBarang db;
	public BarangTableModel tabelbarang;
	public FTambahBarang formtambah;
	public FEditBarang formedit;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	public void refreshData() {
		tabelbarang.setData(db.tampilkanData());
		tabelbarang.fireTableDataChanged();
	}

	public MasterBarang() {
		super("Halaman Pengelolaan Data Barang");
		db = new DbBarang();
		
		tabelbarang = new BarangTableModel();
		tabelbarang.setData(db.tampilkanData());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kelola Data Barang");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(350, 5, 328, 34);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 885, 343);
		contentPane.add(scrollPane);
		
		table = new JTable(tabelbarang);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		//Add
		formtambah = new FTambahBarang(this);
		JButton btnTambah = new JButton("Tambah");
		btnTambah.setBackground(new Color(255, 222, 173));
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formtambah.txtSku.setText("");
				formtambah.txtNama.setText("");
				formtambah.txtStock.setText("");
				formtambah.txtHargabeli.setText("");
				formtambah.txtHargajual.setText("");
				formtambah.setVisible(true);
				refreshData();
			}
		});
		btnTambah.setBounds(10, 402, 89, 28);
		contentPane.add(btnTambah);
		
		//Edit
		formedit = new FEditBarang(this);
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(255, 222, 173));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rowIndex = table.getSelectedRow();
					String sku = (String)tabelbarang.getValueAt(rowIndex, 0);
					Barang b = db.pilihBarang(sku);	
					
					if(b!=null) 
					{
						formedit.setForm(b);
						formedit.setVisible(true);
						refreshData();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Barang dengan SKU "+sku+" tidak ditemukan.");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang akan diedit!");
				}
				
			}
		});
		btnEdit.setBounds(109, 402, 89, 28);
		contentPane.add(btnEdit);
		
		//Delete
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setBackground(new Color(255, 222, 173));
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rowIndex = table.getSelectedRow();
					String sku = (String)tabelbarang.getValueAt(rowIndex, 0);
					String nama = (String)tabelbarang.getValueAt(rowIndex, 1);
					
					Object[] pilihan = {"Ya", "Tidak"};
					int jawaban = JOptionPane.showOptionDialog(null, "Anda yakin data barang dengan SKU "+sku+" bernama "+nama+" akan dihapus?",
							"Peringatan", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, pilihan, pilihan[0]);
							if(jawaban==0) {
								db.hapusBarang(sku);
								refreshData();
							}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang akan dihapus!");
				}
				
			}
		});
		btnHapus.setBounds(213, 402, 89, 28);
		contentPane.add(btnHapus);
		
		//Refresh
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(255, 222, 173));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshData();
			}
		});
		btnRefresh.setBounds(411, 402, 89, 28);
		contentPane.add(btnRefresh);
		
		//Search
		JButton btnCari = new JButton("Cari");
		btnCari.setBackground(new Color(255, 222, 173));
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String response = JOptionPane.showInputDialog("Filter/Pencarian");
				if(response != null && response.length() > 0) {
					tabelbarang.setData(db.cariBarang(response));
					tabelbarang.fireTableDataChanged();
				}
				
			}
		});
		btnCari.setBounds(312, 402, 89, 28);
		contentPane.add(btnCari);
		
		
		//Restock
		JButton btnRestock = new JButton("Restock");
		btnRestock.setBackground(new Color(255, 222, 173));
		btnRestock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int rowIndex = table.getSelectedRow();
					String sku = (String) tabelbarang.getValueAt(rowIndex, 0);
					Integer stock = (Integer) tabelbarang.getValueAt(rowIndex, 2);
					String restock = JOptionPane.showInputDialog("Tambah Jumlah Barang");
				
					Barang b = new Barang(Integer.parseInt(restock));
					db.restock(sku, stock, b.getStock());
					refreshData();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang direstock!");
				}
				
			}
		});
		btnRestock.setBounds(511, 402, 89, 28);
		contentPane.add(btnRestock);
				
		//Kembali
		JButton btnKembali = new JButton("Kembali");
		btnKembali.setBackground(new Color(255, 222, 173));
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuUtama().setVisible(true);
			}
		});
		btnKembali.setBounds(611, 402, 89, 28);
		contentPane.add(btnKembali);
	}
}

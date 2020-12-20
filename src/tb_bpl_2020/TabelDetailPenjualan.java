package tb_bpl_2020;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TabelDetailPenjualan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public TabelModelDetailPenjualan tabeldetail;
	public DbPenjualan db;
	public FormEditDetail formedit;
	public FormTambahDetail formtambah;
	
	
	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	
	public void refreshData() {
		tabeldetail.setData(db.tampilDetail());
		tabeldetail.fireTableDataChanged();
	}

	public TabelDetailPenjualan() {
		db = new DbPenjualan();
		tabeldetail = new TabelModelDetailPenjualan();
		tabeldetail.setData(db.tampilDetail());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tabel Detail Penjualan");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(201, 23, 199, 24);
		contentPane.add(lblNewLabel);
		
		//refresh
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshData();
			}
		});
		btnRefresh.setBounds(392, 365, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btnkembali = new JButton("Kembali");
		btnkembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TabelPenjualan().setVisible(true);
			}
		});
		btnkembali.setBounds(504, 365, 89, 23);
		contentPane.add(btnkembali);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 82, 530, 263);
		contentPane.add(scrollPane);
		
		table = new JTable(tabeldetail);
		scrollPane.setViewportView(table);
		
		//tambah data
				JPanel tambah = new JPanel();
				tambah.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						FormTambahDetail tambahdetail = new FormTambahDetail();
						tambahdetail.setVisible(true);
						dispose();
					}
				});
				tambah.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				tambah.setBounds(new Rectangle(0, 0, 300, 50));
				tambah.setBounds(195, 215, 246, 50);
				contentPane.add(tambah);
				tambah.setLayout(null);
				formtambah = new FormTambahDetail();
				JButton btnTambah = new JButton("Tambah");
				btnTambah.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						formtambah.textid.setText("");
						formtambah.textsku.setText("");
						formtambah.textnoresi.setText("");
						formtambah.textjumlah.setText("");
						formtambah.textharga.setText("");
						formtambah.setVisible(true);
						refreshData();
					}
				});
				btnTambah.setBounds(27, 365, 89, 23);
				contentPane.add(btnTambah);
		
		//hapus detail
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int rowIndex = table.getSelectedRow();
					Integer id = (Integer)tabeldetail.getValueAt(rowIndex, 0);
					String sku = (String)tabeldetail.getValueAt(rowIndex, 1);
					String noresi = (String)tabeldetail.getValueAt(rowIndex, 2);
					
					Object[] pilihan = {"Ya", "Tidak"};
					int jawaban = JOptionPane.showOptionDialog(null, "Anda yakin data Penjualan dengan ID "+id+" pada Sku "+sku+" dan No. Resi "+noresi+" akan dihapus?",
							"Peringatan", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, pilihan, pilihan[0]);
							if(jawaban==0) {
								db.hapusDetail(id);
								refreshData();
							}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang akan dihapus!");
				}
				
			}
		});
		btnHapus.setBounds(283, 365, 89, 23);
		contentPane.add(btnHapus);
		
		//edit detail
		JPanel edit = new JPanel();
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormEditDetail editdetail = new FormEditDetail();
				editdetail.setVisible(true);
				dispose();
			}
		});
		edit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		edit.setBounds(new Rectangle(0, 0, 300, 50));
		edit.setBounds(195, 215, 246, 50);
		contentPane.add(edit);
		edit.setLayout(null);
		formedit = new FormEditDetail();
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int rowIndex = table.getSelectedRow();
					Integer id = (Integer)tabeldetail.getValueAt(rowIndex, 0);
					DataPenjualan d = db.pilihDetail(id);	
					
					if(d!=null) 
					{
						formedit.setForm(d);
						formedit.setVisible(true);
						refreshData();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Barang dengan Id "+id+" tidak ditemukan.");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang akan diedit!");
				}
				
			}
		});
		btnEdit.setBounds(175, 365, 89, 23);
		contentPane.add(btnEdit);
	}

}

package tb_bpl_2020;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;

public class TabelPenjualan extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static final long serialVersionUID = 1L;
	public DbPenjualan db;
	public TabelModelPenjualan tabelPenjualan;
	public FormTambahData formtambah;
	public FormEditData formedit;

	/**
	 * Launch the application.
	 */
	public void refreshData() {
		tabelPenjualan.setData(db.tampilData());
		tabelPenjualan.fireTableDataChanged();
	}
	

	/**
	 * Create the frame.
	 */
	public TabelPenjualan() {
		db = new DbPenjualan();
		tabelPenjualan = new TabelModelPenjualan();
		tabelPenjualan.setData(db.tampilData());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pengolahan Data Penjualan");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(220, 26, 267, 24);
		contentPane.add(lblNewLabel);
		
		//tambah data
		JPanel tambah = new JPanel();
		tambah.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormTambahData tambahdata = new FormTambahData();
				tambahdata.setVisible(true);
				dispose();
			}
		});
		tambah.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tambah.setBounds(new Rectangle(0, 0, 300, 50));
		tambah.setBounds(195, 215, 246, 50);
		contentPane.add(tambah);
		tambah.setLayout(null);
		formtambah = new FormTambahData();
		JButton btnTambah = new JButton("Tambah");
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formtambah.textnoresi.setText("");
				formtambah.setVisible(true);
				refreshData();
			}
		});
		btnTambah.setBounds(27, 365, 89, 23);
		contentPane.add(btnTambah);
		
		//edit data
		JPanel edit = new JPanel();
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormEditData editdata = new FormEditData();
				editdata.setVisible(true);
				dispose();
			}
		});
		edit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		edit.setBounds(new Rectangle(0, 0, 300, 50));
		edit.setBounds(195, 215, 246, 50);
		contentPane.add(edit);
		edit.setLayout(null);
		formedit = new FormEditData();
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rowIndex = table.getSelectedRow();
					String noresi = (String)tabelPenjualan.getValueAt(rowIndex, 0);
					DataPenjualan d = db.pilihData(noresi);	
					
					if(d!=null) 
					{
						formedit.setForm(d);
						formedit.setVisible(true);
						refreshData();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Barang dengan No. Resi "+noresi+" tidak ditemukan.");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang akan diedit!");
				}
				
			}
		});
		btnEdit.setBounds(126, 365, 89, 23);
		contentPane.add(btnEdit);
		
		//hapus data
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rowIndex = table.getSelectedRow();
					String noresi = (String)tabelPenjualan.getValueAt(rowIndex, 0);
					String tanggal = (String)tabelPenjualan.getValueAt(rowIndex, 1);
					
					Object[] pilihan = {"Ya", "Tidak"};
					int jawaban = JOptionPane.showOptionDialog(null, "Anda yakin data Penjualan dengan No. Resi "+noresi+" pada tanggal "+tanggal+" akan dihapus?",
							"Peringatan", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, pilihan, pilihan[0]);
							if(jawaban==0) {
								db.hapusData(noresi);
								refreshData();
							}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Anda belum memilih barang yang akan dihapus!");
				}
				
			}
		});
		btnHapus.setBounds(227, 365, 89, 23);
		contentPane.add(btnHapus);
		
		//refresh
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshData();
			}
		});
		btnRefresh.setBounds(326, 365, 89, 23);
		contentPane.add(btnRefresh);
		
		//kembali
		JButton btnKembali = new JButton("Kembali");
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuUtama().setVisible(true);
			}
		});
		btnKembali.setBounds(550, 365, 89, 23);
		contentPane.add(btnKembali);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 78, 568, 252);
		contentPane.add(scrollPane);
		
		table = new JTable(tabelPenjualan);
		scrollPane.setViewportView(table);
		
		//tampil detail
		JButton btnDetail = new JButton("Detail");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TabelDetailPenjualan().setVisible(true);
			}
		});
		btnDetail.setBounds(425, 365, 89, 23);
		contentPane.add(btnDetail);
	}
}

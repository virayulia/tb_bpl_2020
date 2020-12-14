package tb_bpl_2020;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class FormKelolaUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCari;
	public JLabel lblUser;
	DBUser db = new DBUser();
	private JTable table;

	public FormKelolaUser() {
		setForeground(new Color(205, 92, 92));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setForeground(new Color(205, 92, 92));
		contentPane.setBorder(new LineBorder(new Color(255, 218, 185), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setForeground(new Color(230, 230, 250));
		panel.setBorder(new LineBorder(new Color(255, 218, 185), 2, true));
		panel.setBounds(10, 78, 766, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnGantiPass = new JButton("Ganti Password");
		btnGantiPass.setBackground(new Color(255, 255, 224));
		btnGantiPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GantiPassword().setVisible(true);
			}
		});
		btnGantiPass.setBounds(246, 11, 123, 25);
		btnGantiPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel.add(btnGantiPass);
		
		JButton btnHapusAkun = new JButton("Hapus Akun"); 
		btnHapusAkun.setBackground(new Color(255, 255, 224));
		btnHapusAkun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hapus = JOptionPane.showConfirmDialog(btnHapusAkun, "Apakah Anda Yakin Akan Menghapus Akun?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(hapus == JOptionPane.YES_OPTION) {
					if(db.HapusAkun() == 1) {
						JOptionPane.showMessageDialog(btnHapusAkun, "Akun Berhasil di Hapus");
						dispose();
						new FormLogin().setVisible(true);
					}
				}
			}
		});
		btnHapusAkun.setBounds(393, 11, 123, 25);
		btnHapusAkun.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel.add(btnHapusAkun);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 181));
		panel_1.setForeground(new Color(230, 230, 250));
		panel_1.setBorder(new LineBorder(new Color(255, 218, 185), 2, true));
		panel_1.setBounds(10, 138, 766, 314);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtCari = new JTextField();
		txtCari.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtCari.setBounds(28, 48, 150, 26);
		panel_1.add(txtCari);
		txtCari.setColumns(10);
		
		JButton btnCari = new JButton("Cari");
		btnCari.setBackground(new Color(255, 255, 224));
		btnCari.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\search.png"));
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCari.getText().equals("")) {
					JOptionPane.showMessageDialog(btnCari, "Anda Belum Memasukkan Username\nyang Akan Dicari", "Peringatan", JOptionPane.WARNING_MESSAGE);
				}
				else{
					LinkedHashMap<String, User> Cari = db.cariUser(txtCari.getText());
					
					DefaultTableModel tb = new DefaultTableModel();
					
					//Judul Kolom
					tb.addColumn("Username");
					tb.addColumn("Login Terakhir");
					tb.addColumn("Email");
					table.setModel(tb);
					
					for(Map.Entry list : Cari.entrySet()){
			            User list2 = (User) list.getValue();
			            
			           tb.addRow(new Object[] {
			             list.getKey(),
			             list2.getDate(),
			             list2.getEmail(),
			           });
					}
					
				}
				txtCari.setText("");
			}
		});
		btnCari.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCari.setBounds(192, 48, 87, 26);
		panel_1.add(btnCari);
		
		JLabel lbl1 = new JLabel("Masukkan Username");
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbl1.setBounds(28, 23, 150, 20);
		panel_1.add(lbl1);
		
		JButton btnLihatData = new JButton("Lihat Data User");
		btnLihatData.setBackground(new Color(255, 255, 224));
		btnLihatData.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				LinkedHashMap<String, User> listUser = db.lihatUser();
				
				DefaultTableModel tb = new DefaultTableModel();
				
				//Judul Kolom
				tb.addColumn("Username");
				tb.addColumn("Login Terakhir");
				tb.addColumn("Email");
				table.setModel(tb);
				
				for(Map.Entry list : listUser.entrySet()){
		            User list2 = (User) list.getValue();
		            
		           tb.addRow(new Object[] {
		             list.getKey(),
		             list2.getDate(),
		             list2.getEmail(),
		           });
				}
				
			}
		});
		btnLihatData.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLihatData.setBounds(591, 48, 133, 26);
		panel_1.add(btnLihatData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(245, 222, 179));
		scrollPane.setBackground(new Color(245, 222, 179));
		scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setBounds(28, 84, 696, 207);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblKelolaUser = new JLabel("Kelola User");
		lblKelolaUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblKelolaUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblKelolaUser.setBounds(225, 28, 325, 30);
		contentPane.add(lblKelolaUser);
		
		lblUser = new JLabel(FormLogin.user);
		lblUser.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\user.png"));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUser.setBounds(669, 28, 107, 24);
		contentPane.add(lblUser);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 222, 173));
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuUtama().setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\reply.png"));
		btnBack.setBounds(10, 463, 101, 24);
		contentPane.add(btnBack);
		
	}
}

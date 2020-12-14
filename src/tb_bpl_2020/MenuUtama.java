package tb_bpl_2020;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class MenuUtama extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel MenuUtama;
	public JLabel lblUser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin login = new FormLogin();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuUtama() {
		setResizable(false);
		setAutoRequestFocus(false);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		MenuUtama = new JPanel();
		MenuUtama.setForeground(new Color(255, 255, 204));
		MenuUtama.setBackground(new Color(255, 248, 220));
		MenuUtama.setBorder(new LineBorder(new Color(255, 228, 181), 4, true));
		setContentPane(MenuUtama);
		MenuUtama.setLayout(null);
		
		JPanel kelolaUser = new JPanel();
		kelolaUser.setBorder(new LineBorder(new Color(244, 164, 96), 3, true));
		kelolaUser.setBackground(new Color(255, 228, 181));
		kelolaUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormKelolaUser kelolauser = new FormKelolaUser();
				kelolauser.setVisible(true);
				dispose();
			}
		});
		kelolaUser.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		kelolaUser.setBounds(new Rectangle(0, 0, 300, 50));
		kelolaUser.setBounds(195, 215, 246, 50);
		MenuUtama.add(kelolaUser);
		kelolaUser.setLayout(null);
		
		JLabel btnKelolaUser = new JLabel("Kelola User");
		btnKelolaUser.setBackground(new Color(255, 248, 220));
		btnKelolaUser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKelolaUser.setBounds(27, 11, 122, 28);
		kelolaUser.add(btnKelolaUser);
		
		JLabel lblIconKelolaUser = new JLabel("");
		lblIconKelolaUser.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\group.png"));
		lblIconKelolaUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKelolaUser.setBounds(181, 0, 55, 50);
		kelolaUser.add(lblIconKelolaUser);
		
		JPanel kelolaUser_1 = new JPanel();
		kelolaUser_1.setBorder(new LineBorder(new Color(244, 164, 96), 3, true));
		kelolaUser_1.setBackground(new Color(255, 228, 181));
		kelolaUser_1.setLayout(null);
		kelolaUser_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		kelolaUser_1.setBounds(new Rectangle(0, 0, 300, 50));
		kelolaUser_1.setBounds(195, 280, 246, 50);
		MenuUtama.add(kelolaUser_1);
		
		JLabel btnDataMaster = new JLabel("Data Master");
		btnDataMaster.setBackground(new Color(245, 222, 179));
		btnDataMaster.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDataMaster.setBounds(27, 11, 122, 28);
		kelolaUser_1.add(btnDataMaster);
		
		JLabel lblIconDataMaster = new JLabel("");
		lblIconDataMaster.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\groceries.png"));
		lblIconDataMaster.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDataMaster.setBounds(181, 0, 55, 50);
		kelolaUser_1.add(lblIconDataMaster);
		
		JPanel kelolaUser_1_1 = new JPanel();
		kelolaUser_1_1.setBorder(new LineBorder(new Color(244, 164, 96), 3, true));
		kelolaUser_1_1.setBackground(new Color(255, 228, 181));
		kelolaUser_1_1.setLayout(null);
		kelolaUser_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		kelolaUser_1_1.setBounds(new Rectangle(0, 0, 300, 50));
		kelolaUser_1_1.setBounds(506, 215, 246, 50);
		MenuUtama.add(kelolaUser_1_1);
		
		JLabel btnKelolaTransaksi = new JLabel("Transaksi Penjualan");
		btnKelolaTransaksi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKelolaTransaksi.setBounds(27, 11, 154, 28);
		kelolaUser_1_1.add(btnKelolaTransaksi);
		
		JLabel lblIconKelolaUser_1_1 = new JLabel("");
		lblIconKelolaUser_1_1.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\transaction.png"));
		lblIconKelolaUser_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKelolaUser_1_1.setBounds(181, 0, 55, 50);
		kelolaUser_1_1.add(lblIconKelolaUser_1_1);
		
		JPanel kelolaUser_1_2 = new JPanel();
		kelolaUser_1_2.setBorder(new LineBorder(new Color(244, 164, 96), 3, true));
		kelolaUser_1_2.setBackground(new Color(255, 228, 181));
		kelolaUser_1_2.setLayout(null);
		kelolaUser_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		kelolaUser_1_2.setBounds(new Rectangle(0, 0, 300, 50));
		kelolaUser_1_2.setBounds(506, 280, 246, 50);
		MenuUtama.add(kelolaUser_1_2);
		
		JLabel btnLaporan = new JLabel("Laporan Penjualan");
		btnLaporan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLaporan.setBounds(27, 11, 154, 28);
		kelolaUser_1_2.add(btnLaporan);
		
		JLabel lblIconKelolaUser_1_2 = new JLabel("");
		lblIconKelolaUser_1_2.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\salesreport.png"));
		lblIconKelolaUser_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKelolaUser_1_2.setBounds(181, 0, 55, 50);
		kelolaUser_1_2.add(lblIconKelolaUser_1_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setRequestFocusEnabled(false);
		btnLogout.setFocusable(false);
		btnLogout.setBackground(new Color(255, 222, 173));
		btnLogout.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\logout.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int keluar = JOptionPane.showConfirmDialog(btnLogout, "Anda Yakin Ingin Logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(keluar == JOptionPane.YES_OPTION) {
					dispose();
					new FormLogin().setVisible(true);
				}
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLogout.setBounds(28, 447, 97, 30);
		MenuUtama.add(btnLogout);
		
		lblUser = new JLabel(FormLogin.user);
		lblUser.setBackground(Color.BLACK);
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setIcon(new ImageIcon("E:\\Semester III\\BPL\\tb_bpl_2020\\res\\user.png"));
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUser.setBounds(772, 24, 98, 24);
		MenuUtama.add(lblUser);
		
		JLabel lblJudul = new JLabel("MINIMARKET BERSAMA");
		lblJudul.setForeground(new Color(0, 0, 0));
		lblJudul.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
		lblJudul.setBounds(340, 113, 270, 26);
		MenuUtama.add(lblJudul);
		setUndecorated(true);
	}
}

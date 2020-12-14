package tb_bpl_2020;


import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.Date;

public class FormRegistrasi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	User datauser2;
	DBUser db = new DBUser();
	static Date date = new Date();
	
	private JPanel FormRegistrasi;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	private JPasswordField txtCPass;

	public FormRegistrasi() {
		setTitle("Registrasi Akun Minimarket Bersama");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 360);
		FormRegistrasi = new JPanel();
		FormRegistrasi.setBackground(new Color(255, 248, 220));
		FormRegistrasi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		FormRegistrasi.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FormRegistrasi);
		FormRegistrasi.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsername.setBounds(58, 142, 104, 14);
		FormRegistrasi.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUsername.setBounds(199, 140, 142, 20);
		FormRegistrasi.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(199, 109, 142, 20);
		FormRegistrasi.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(58, 112, 104, 14);
		FormRegistrasi.add(lblEmail);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPass.setBounds(58, 173, 104, 14);
		FormRegistrasi.add(lblPass);
		
		JLabel lblCPass = new JLabel("Konfirmasi Password");
		lblCPass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCPass.setBounds(58, 204, 134, 14);
		FormRegistrasi.add(lblCPass);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPass.setBounds(199, 171, 142, 20);
		FormRegistrasi.add(txtPass);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(new Color(255, 0, 0));
		lblWarning.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblWarning.setBounds(58, 229, 283, 14);
		FormRegistrasi.add(lblWarning);
		
		JButton btnDaftar = new JButton("Daftar");
		btnDaftar.setBackground(new Color(255, 228, 181));
		btnDaftar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().equals("")|| txtEmail.getText().equals("")||txtPass.getPassword().equals("")||txtCPass.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
					hapuslayar();
				}
				
				else {
					String tanggal = String.format("%tF", date);
					datauser2 = new User(txtUsername.getText(), tanggal, txtEmail.getText(), txtPass.getText()); 
					hapuslayar();
				}
				
				if(db.Registrasi(datauser2)==1) {
					
					dispose();
					new FormLogin().setVisible(true);
				}
						
			}
		});
		btnDaftar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDaftar.setBounds(58, 250, 283, 23);
		FormRegistrasi.add(btnDaftar);
		
		
		txtCPass = new JPasswordField();
		txtCPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String registerPassword = new String(txtPass.getPassword());
				String retypePassword = new String (txtCPass.getPassword());
				
				if(registerPassword.equals(retypePassword)) {
					lblWarning.setText("");
					btnDaftar.setEnabled(true);
				}
				else if (!registerPassword.equals(retypePassword)) {
					lblWarning.setText("Password tidak sinkron");
					btnDaftar.setEnabled(false);
				}
			}
		});
		txtCPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtCPass.setBounds(199, 202, 142, 20);
		FormRegistrasi.add(txtCPass);
		
		JLabel Registrasi = new JLabel("REGISTRASI");
		Registrasi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Registrasi.setBounds(159, 35, 104, 14);
		FormRegistrasi.add(Registrasi);
		
		JLabel lblNewLabel = new JLabel("Sudah Memiliki Akun?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(58, 284, 128, 14);
		FormRegistrasi.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormLogin login = new FormLogin();
				login.setVisible(true);
				
				FormRegistrasi.setVisible(false);
				dispose();
			}
		});
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLogin.setBounds(183, 284, 49, 14);
		FormRegistrasi.add(lblLogin);
	
	}
	
	private void hapuslayar() {
		txtEmail.setText("");
		txtUsername.setText("");
		txtPass.setText("");
		txtCPass.setText("");
		
	}
	
}

package tb_bpl_2020;

import java.util.Date;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	User datauser;
	DBUser db = new DBUser();
	static Date date = new Date();
	
	static String user;
	static String pass;
	String coba1, coba2, coba3;
	static Integer ulang=2;
	
	MenuUtama menu_utama;
	FormKelolaUser form_kelolauser;
	
	private JPanel FormLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	public FormLogin() {
		setTitle("Login Akun Minimarket Bersama");
		setForeground(new Color(250, 250, 210));
		setBackground(new Color(255, 255, 224));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 360);
		FormLogin = new JPanel();
		FormLogin.setBackground(new Color(255, 248, 220));
		FormLogin.setForeground(new Color(255, 250, 205));
		FormLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FormLogin);
		FormLogin.setLayout(null);
		
		JLabel LOGIN = new JLabel("LOGIN");
		LOGIN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		LOGIN.setBounds(177, 38, 61, 14);
		FormLogin.add(LOGIN);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsername.setBounds(85, 108, 104, 14);
		FormLogin.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUsername.setColumns(10);
		txtUsername.setBounds(177, 106, 142, 20);
		FormLogin.add(txtUsername);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPass.setBounds(85, 145, 104, 14);
		FormLogin.add(lblPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPassword.setBounds(177, 143, 142, 20);
		FormLogin.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 222, 173));
		btnLogin.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			try {	
				if(txtUsername.getText().equals("") || txtPassword.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Anda belum memasukkan Username dan Password", "Pesan", JOptionPane.WARNING_MESSAGE);
					txtUsername.requestFocus();
					hapuslayar();
				}
				else {
					String tanggal = String.format("%tF", date);
					datauser = new User(txtUsername.getText(), tanggal, txtPassword.getText()); 
					
					if(ulang==2) {
						coba1 = txtUsername.getText();
					}
					
					else if(ulang==1){
						coba2 = txtUsername.getText();
						if(!coba2.equals(coba1)) {
							coba1=txtUsername.getText();
							ulang=2;
							coba2=null;
						}
					}
					
					else if(ulang==0) {
						coba3 = txtUsername.getText();
						if(!coba3.equals(coba2)) {
							ulang=2;
							coba1=txtUsername.getText();
							coba2=null; coba3=null;
						}
					}
					
					
					if(db.Login(datauser)>0) {
						
						menu_utama = new MenuUtama();
						form_kelolauser= new FormKelolaUser();
						user = txtUsername.getText();
						pass = txtPassword.getText();
						
						menu_utama.lblUser.setText(user);
						form_kelolauser.lblUser.setText(user);
						
						dispose();
						menu_utama.setVisible(true);
					}
					
					else {
						ulang--;
							
						if(ulang<0) {
							ulang=2;
						}
					}
				}
			}
			catch(Exception err) {
				JOptionPane.showMessageDialog(btnLogin, "Terjadi Kesalahan", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLogin.setBounds(64, 201, 283, 23);
		FormLogin.add(btnLogin);
		
		JLabel lblBelumMemilikiAkun = new JLabel("Belum Memiliki Akun?");
		lblBelumMemilikiAkun.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBelumMemilikiAkun.setBounds(61, 253, 128, 14);
		FormLogin.add(lblBelumMemilikiAkun);
		
		JLabel lblDaftar = new JLabel("Daftar");
		lblDaftar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FormRegistrasi().setVisible(true);
				dispose();
			}
		});
		lblDaftar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDaftar.setBounds(199, 253, 49, 14);
		FormLogin.add(lblDaftar);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblWarning.setBounds(187, 176, 49, 14);
		FormLogin.add(lblWarning);
	}
	
	public void hapuslayar() {
		txtUsername.setText("");
		txtPassword.setText("");
	}
}

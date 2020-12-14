package tb_bpl_2020;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GantiPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel UbahPassword;
	private JPasswordField txtPassLama;
	private JPasswordField txtPassBaru;
	DBUser db = new DBUser();

	public GantiPassword() {
		setBackground(new Color(255, 248, 220));
		setTitle("Ubah Password Akun");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 233);
		UbahPassword = new JPanel();
		UbahPassword.setBackground(new Color(255, 248, 220));
		UbahPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(UbahPassword);
		UbahPassword.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ganti Password Akun");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(112, 25, 137, 20);
		UbahPassword.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password Lama");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPassword.setBounds(38, 80, 90, 25);
		UbahPassword.add(lblPassword);
		
		txtPassLama = new JPasswordField();
		txtPassLama.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPassLama.setBounds(148, 80, 154, 25);
		UbahPassword.add(txtPassLama);
		
		JLabel lblPasswordBaru = new JLabel("Password Baru");
		lblPasswordBaru.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPasswordBaru.setBounds(38, 121, 90, 25);
		UbahPassword.add(lblPasswordBaru);
		
		txtPassBaru = new JPasswordField();
		txtPassBaru.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPassBaru.setBounds(148, 121, 154, 25);
		UbahPassword.add(txtPassBaru);
		
		JButton btnGanti = new JButton("Ganti");
		btnGanti.setBackground(new Color(255, 228, 181));
		btnGanti.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			if(db.GantiPassword(txtPassLama.getText(), txtPassBaru.getText()) == 1) {
				JOptionPane.showMessageDialog(btnGanti, "Berhasil Mengganti Password");
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(btnGanti, "Gagal Mengganti Password", "Peringatan", JOptionPane.WARNING_MESSAGE);
				dispose();
			}
			}
		});
		btnGanti.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnGanti.setBounds(213, 157, 89, 23);
		UbahPassword.add(btnGanti);
	}
}

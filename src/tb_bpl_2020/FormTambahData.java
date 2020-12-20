package tb_bpl_2020;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;

public class FormTambahData extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textnoresi;
	static Date date = new Date();
	private DbPenjualan db;

	public FormTambahData() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Tambah Data Penjualan");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblNewLabel.setBounds(111, 31, 209, 41);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("No. Resi");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(74, 115, 54, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textnoresi = new JTextField();
			textnoresi.setBounds(185, 112, 135, 20);
			contentPanel.add(textnoresi);
			textnoresi.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSimpan = new JButton("Simpan");
				btnSimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String tanggal = String.format("%tF", date);
						db = new DbPenjualan();
						db.tambahData(new DataPenjualan(textnoresi.getText(),
														tanggal,
														FormLogin.user));
						setVisible(false);
				
				
					}
				});
				btnSimpan.setActionCommand("OK");
				buttonPane.add(btnSimpan);
				getRootPane().setDefaultButton(btnSimpan);
			}
			{
				JButton btnbatal = new JButton("Batal");
				btnbatal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnbatal.setActionCommand("Cancel");
				buttonPane.add(btnbatal);
			}
		}
	}

}

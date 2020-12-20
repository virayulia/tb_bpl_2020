package tb_bpl_2020;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormEditData extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textnoresi;
	public JTextField texttgl;
	public JTextField textusername;
	private DbPenjualan db;

	
	public FormEditData() {
		setBounds(100, 100, 397, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Data Penjualan");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(137, 11, 182, 29);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No. Resi");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(71, 80, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tanggal");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(71, 121, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(71, 161, 69, 14);
		contentPanel.add(lblNewLabel_3);
		
		textnoresi = new JTextField();
		textnoresi.setBounds(187, 77, 111, 20);
		contentPanel.add(textnoresi);
		textnoresi.setColumns(10);
		
		texttgl = new JTextField();
		texttgl.setColumns(10);
		texttgl.setBounds(187, 118, 111, 20);
		contentPanel.add(texttgl);
		
		textusername = new JTextField();
		textusername.setColumns(10);
		textusername.setBounds(187, 158, 111, 20);
		contentPanel.add(textusername);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSimpan = new JButton("Simpan");
				btnSimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db = new DbPenjualan();
						db.updateData(new DataPenjualan(textnoresi.getText(), 
													texttgl.getText(), 
													textusername.getText()));
						setVisible(false);
					}
				});
				btnSimpan.setActionCommand("Simpan");
				buttonPane.add(btnSimpan);
				getRootPane().setDefaultButton(btnSimpan);
			}
			{
				JButton btnBatal = new JButton("Batal");
				btnBatal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnBatal.setActionCommand("Batal");
				buttonPane.add(btnBatal);
			}
		}
	}
	
	public void setForm(DataPenjualan d) {
		textnoresi.setText(d.getNoresi());
		texttgl.setText(d.getTanggal());
		textusername.setText(d.getUsername());
	}
}

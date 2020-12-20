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

public class FormTambahDetail extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textid;
	public JTextField textnoresi;
	public JTextField textsku;
	public JTextField textjumlah;
	public JTextField textharga;
	private DbPenjualan db;


	public FormTambahDetail() {
		setBounds(100, 100, 408, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tambah Detail");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(155, 11, 137, 24);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sku");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(64, 99, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No. Resi");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(64, 143, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jumlah");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(64, 182, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Harga");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(64, 222, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(64, 63, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		textid = new JTextField();
		textid.setBounds(155, 60, 117, 20);
		contentPanel.add(textid);
		textid.setColumns(10);
		
		textnoresi = new JTextField();
		textnoresi.setColumns(10);
		textnoresi.setBounds(155, 140, 117, 20);
		contentPanel.add(textnoresi);
		
		textsku = new JTextField();
		textsku.setColumns(10);
		textsku.setBounds(155, 96, 117, 20);
		contentPanel.add(textsku);
		
		textjumlah = new JTextField();
		textjumlah.setColumns(10);
		textjumlah.setBounds(155, 179, 117, 20);
		contentPanel.add(textjumlah);
		
		textharga = new JTextField();
		textharga.setColumns(10);
		textharga.setBounds(155, 219, 117, 20);
		contentPanel.add(textharga);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnsimpan = new JButton("Simpan");
				btnsimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db = new DbPenjualan();
						db.tambahDetail(new DataPenjualan(Integer.parseInt(textid.getText()), 
								textsku.getText(), textnoresi.getText(),Integer.parseInt(textjumlah.getText()),
								textharga.getText()));
						setVisible(false);
					}
				});
				btnsimpan.setActionCommand("OK");
				buttonPane.add(btnsimpan);
				getRootPane().setDefaultButton(btnsimpan);
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

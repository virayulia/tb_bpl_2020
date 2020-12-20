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

public class FormEditDetail extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textid;
	public JTextField textsku;
	public JTextField textnoresi;
	public JTextField textjumlah;
	public JTextField textharga;
	private DbPenjualan db;

	public FormEditDetail() {
		setBounds(100, 100, 442, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Edit Detail Penjualan");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblNewLabel.setBounds(129, 11, 204, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Id");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(65, 63, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Sku");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(65, 102, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("No. Resi");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(65, 141, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Jumlah");
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(65, 184, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Harga");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(65, 226, 46, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			textid = new JTextField();
			textid.setBounds(163, 60, 143, 20);
			contentPanel.add(textid);
			textid.setColumns(10);
		}
		{
			textsku = new JTextField();
			textsku.setColumns(10);
			textsku.setBounds(163, 99, 143, 20);
			contentPanel.add(textsku);
		}
		{
			textnoresi = new JTextField();
			textnoresi.setColumns(10);
			textnoresi.setBounds(163, 138, 143, 20);
			contentPanel.add(textnoresi);
		}
		{
			textjumlah = new JTextField();
			textjumlah.setColumns(10);
			textjumlah.setBounds(163, 178, 143, 20);
			contentPanel.add(textjumlah);
		}
		{
			textharga = new JTextField();
			textharga.setColumns(10);
			textharga.setBounds(163, 220, 143, 20);
			contentPanel.add(textharga);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSimpan = new JButton("Simpan");
				btnSimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db = new DbPenjualan();
						db.updateDetail(new DataPenjualan(Integer.parseInt(textid.getText()),
															textsku.getText(),
															textnoresi.getText(),
															Integer.parseInt(textjumlah.getText()),
															textharga.getText()));
						setVisible(false);
					}
				});
				btnSimpan.setActionCommand("OK");
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
				btnBatal.setActionCommand("Cancel");
				buttonPane.add(btnBatal);
			}
		}
	}
	
	public void setForm(DataPenjualan d) {
		textid.setText(Integer.toString(d.getId()));
		textsku.setText(d.getSku());
		textnoresi.setText(d.getNoresi());
		textjumlah.setText(Integer.toString(d.getJumlah()));
		textharga.setText(d.getHarga());
		
	}

}

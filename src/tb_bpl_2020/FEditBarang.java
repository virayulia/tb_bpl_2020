package tb_bpl_2020;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FEditBarang extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField txtSku, txtNama, txtStock, txtHargabeli, txtHargajual;
	public JButton tblSimpan, tblBatal;
	
	private DbBarang db;

	public FEditBarang(JFrame parent) {
		super(parent, "Pengeditan Barang", true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 222, 173));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtSku = new JTextField();
		txtSku.setBounds(110, 35, 138, 20);
		contentPanel.add(txtSku);
		txtSku.setColumns(10);
		
		txtNama = new JTextField();
		txtNama.setBounds(110, 66, 314, 20);
		contentPanel.add(txtNama);
		txtNama.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(110, 97, 138, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);
		
		txtHargabeli = new JTextField();
		txtHargabeli.setBounds(110, 128, 138, 20);
		contentPanel.add(txtHargabeli);
		txtHargabeli.setColumns(10);
		
		txtHargajual = new JTextField();
		txtHargajual.setBounds(110, 159, 138, 20);
		contentPanel.add(txtHargajual);
		txtHargajual.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SKU");
		lblNewLabel.setBounds(10, 38, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nama Barang");
		lblNewLabel_1.setBounds(10, 69, 84, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(10, 100, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Harga Beli");
		lblNewLabel_3.setBounds(10, 131, 90, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Harga Jual");
		lblNewLabel_4.setBounds(10, 162, 84, 14);
		contentPanel.add(lblNewLabel_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton tblSimpan = new JButton("Simpan");
				tblSimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db = new DbBarang();
						db.updateBarang(new Barang(txtSku.getText(), 
													txtNama.getText(), 
													Integer.parseInt(txtStock.getText()), 
													Integer.parseInt(txtHargabeli.getText()), 
													Integer.parseInt(txtHargajual.getText())));
						setVisible(false);
					}
				});
				tblSimpan.setActionCommand("Simpan");
				buttonPane.add(tblSimpan);
				getRootPane().setDefaultButton(tblSimpan);
			}
			{
				JButton tblBatal = new JButton("Batal");
				tblBatal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				tblBatal.setActionCommand("Batal");
				buttonPane.add(tblBatal);
			}
		}
	}
	
	public void setForm(Barang b) {
		txtSku.setText(b.getSku());
		txtNama.setText(b.getNama());
		txtStock.setText(Integer.toString(b.getStock()));
		txtHargabeli.setText(Integer.toString(b.getHargabeli()));
		txtHargajual.setText(Integer.toString(b.getHargajual()));
		
	}

}

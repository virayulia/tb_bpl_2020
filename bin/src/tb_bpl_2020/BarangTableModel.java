package tb_bpl_2020;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class BarangTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	private ArrayList<Barang> data;
	public void setData(ArrayList<Barang> data) {
		this.data = data;
	}
	
	private String[] namaField = {"SKU", "Nama", "Stock", "Harga Beli", "Harga Jual"};
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return namaField.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Barang b = data.get(rowIndex); //ambil data pada baris ke baris
		switch(columnIndex) {
			case 0: return b.getSku();
			case 1: return b.getNama();
			case 2: return b.getStock();
			case 3: return b.getHargabeli();
			case 4: return b.getHargajual();
			default: return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return namaField[column];
	}

}

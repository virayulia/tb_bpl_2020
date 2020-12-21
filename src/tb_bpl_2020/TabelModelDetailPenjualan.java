package tb_bpl_2020;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TabelModelDetailPenjualan extends AbstractTableModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DataPenjualan>data;
	public void setData(ArrayList<DataPenjualan>data) {
		this.data = data;
	}
	
	private String[] datatabel = {"id", "sku", "noresi", "jumlah", "harga"};
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return datatabel.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return datatabel[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DataPenjualan d = data.get(rowIndex);//ambil data pada baris ke baris
		switch(columnIndex) {
			case 0: return d.getId();
			case 1: return d.getSku();
			case 2: return d.getNoresi();
			case 3: return d.getJumlah();
			case 4: return d.getHarga();
			default: return null;
		}
	}

}

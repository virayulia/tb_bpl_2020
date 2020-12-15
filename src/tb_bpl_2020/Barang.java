package tb_bpl_2020;

public class Barang {
	private String sku;
	private String nama;
	private Integer stock;
	private Integer hargabeli;
	private Integer hargajual;
	
	public Barang(String sku, String nama, Integer stock, Integer hargabeli, Integer hargajual) {
		setSku(sku);
		setNama(nama);
		setStock(stock);
		setHargabeli(hargabeli);
		setHargajual(hargajual);
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setHargabeli(Integer hargabeli) {
		this.hargabeli = hargabeli;
	}
	
	public Integer getHargabeli() {
		return hargabeli;
	}
	
	public void setHargajual(Integer hargajual) {
		this.hargajual = hargajual;
	}
	
	public Integer getHargajual() {
		return hargajual;
	}
	
	
	
	
	
	
}

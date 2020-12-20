package tb_bpl_2020;

public class DataPenjualan {
	public String noresi;
	private String tanggal;
	private String username;
	private Integer id;
	private String sku;
	private Integer jumlah;
	private String harga;
	
	
	public DataPenjualan (String noresi, String tanggal, String username) {
		setNoresi(noresi);
		setTanggal(tanggal);
		setUsername(username);
		
	}
	
	public DataPenjualan (String noresi, String tanggal, String username, Integer id, String sku, Integer jumlah, String harga ) {
		this.noresi = noresi;
		this.tanggal = tanggal;
		this.username = username;
		this.id = id;
		this.jumlah = jumlah;
		this.harga = harga;
	}
	
	public DataPenjualan (Integer id, String sku, String noresi, Integer jumlah, String harga) {
		this.id = id;
		this.sku = sku;
		this.noresi = noresi;
		this.jumlah = jumlah;
		this.harga = harga;
	}
	
	public void setNoresi(String noresi) {
		this.noresi = noresi;
	}
	
	public String getNoresi() {
		return noresi;
	}
	
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	
	public String getTanggal() {
		return tanggal;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
	
	public Integer getJumlah() {
		return jumlah;
	}
	
	public void setHarga(String harga) {
		this.harga = harga;
	}
	
	public String getHarga() {
		return harga;
	}
	

}

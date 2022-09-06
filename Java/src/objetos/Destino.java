package objetos;

public class Destino {

	private String cidade;
	private String uf;
	private int id;
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Destino() {
	}
	
	public Destino(String cidade, String uf) {
		this.cidade = cidade;
		this.uf = uf;
	}
}

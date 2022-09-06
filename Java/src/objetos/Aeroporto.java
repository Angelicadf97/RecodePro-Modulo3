package objetos;

public class Aeroporto {

	private String cnpj, nome, cidade, uf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Aeroporto() {
	}
	
	public Aeroporto(String cnpj, String nome, String cidade, String uf) {
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
		this.cnpj = cnpj;
	}
}

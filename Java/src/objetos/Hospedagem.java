package objetos;

public class Hospedagem {

	private String cnpj, nome, tipo, cidade, uf;
	private Double preco;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
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
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public Hospedagem() {
	}
	
	public Hospedagem (String cnpj, String nome, String tipo, double preco, String cidade, String uf) {
		this.tipo = tipo;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
		this.cnpj = cnpj;
		this.preco = preco;
	}
	
}

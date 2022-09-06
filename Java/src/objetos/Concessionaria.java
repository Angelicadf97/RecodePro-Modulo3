package objetos;

public class Concessionaria {

	private String nome;
	private String cnpj;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Concessionaria() {
	}
	
	public Concessionaria(String cnpj, String nome) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
}

package objetos;
public class Cliente {
	
	private String cpf, nome, dataNasc, genero, telefone, endereco, uf, email, senha;
	
		
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public Cliente () {
	}
	
	public Cliente (String cpf, String nome, String dataNasc, String genero, String telefone, String endereco, String uf, String email, String senha) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.uf = uf;
		this.endereco = endereco;
		this.genero = genero;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone; 
	}
	
}

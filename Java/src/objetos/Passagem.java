package objetos;

public class Passagem {
	private int id;
	private String cpfPas, classe, data;
	private double preco;
	private Pacote pacote;
	private Destino destino;
	private Concessionaria concessionaria;
	private Aeroporto aeroporto;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCpfPas() {
		return cpfPas;
	}
	public void setCpfPas(String cpfPas) {
		this.cpfPas = cpfPas;
	}

	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Pacote getPacote() {
		return pacote;
	}
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public Concessionaria getConcessionaria() {
		return concessionaria;
	}
	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}
	public Aeroporto getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}
	public Passagem() {
	}
	
	public Passagem(Pacote pacote, Destino destino, Concessionaria concessionaria, Aeroporto aeroporto, String cpfPas, String classe, String data, double preco) {
		this.pacote = pacote;
		this.destino = destino;
		this.concessionaria = concessionaria;
		this.aeroporto = aeroporto;
		this.cpfPas = cpfPas;
		this.classe = classe;
		this.data = data;
		this.preco = preco;
	}
	
	
}

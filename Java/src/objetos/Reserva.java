package objetos;

public class Reserva {
	private int id, hospedes, quartos, diaria;
	private String dataEntrada, dataSaida;
	private double subTotal;
	private Hospedagem hospedagem;
	private Pacote pacote;
	private double valorFinal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getHospedes() {
		return hospedes;
	}
	public void setHospedes(int hospedes) {
		this.hospedes = hospedes;
	}

	public int getQuartos() {
		return quartos;
	}
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public int getDiaria() {
		return diaria;
	}
	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}
	
	public double getSubTotal() {
		return calc();
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	public Pacote getPacote() {
		return pacote;
	}
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	
	private double calc() {
		this.subTotal = this.diaria * hospedagem.getPreco() * this.quartos;
		return this.subTotal;
	}
	
	public Reserva() {
		
	}
	
	public Reserva(Pacote pacote, Hospedagem hospedagem, int hospedes, int quartos, String dataEntrada, String dataSaida, int diaria) {
		this.pacote = pacote;
		this.hospedagem = hospedagem;
		this.hospedes = hospedes;
		this.quartos = quartos;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.diaria = diaria;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
}

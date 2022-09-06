package objetos;

import DAO.PassagemDAO;
import DAO.ReservaDAO;

public class Pacote {

	private int id;
	private double total;
	private Cliente cliente;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getTotal() {
		return calTotal();
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Pacote() {
	}
	
	public Pacote(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double calTotal() {
		ReservaDAO reservaDAO = new ReservaDAO();
		for(Reserva r : reservaDAO.ReservaByPac(id)) {
			total += r.getValorFinal();
		}
		PassagemDAO passagemDAO = new PassagemDAO();
		for(Passagem p : passagemDAO.PassagemByPac(id)) {
			total += p.getPreco();
		}
		return total;
	}
}

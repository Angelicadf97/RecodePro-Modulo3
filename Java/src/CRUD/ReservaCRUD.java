package CRUD;

import java.util.Scanner;

import DAO.HospedagemDAO;
import DAO.PacoteDAO;
import DAO.ReservaDAO;
import objetos.Aeroporto;
import objetos.Concessionaria;
import objetos.Hospedagem;
import objetos.Pacote;
import objetos.Passagem;
import objetos.Reserva;

public class ReservaCRUD {

	public static void Reserva(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ReservaDAO reservaDAO = new ReservaDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		

		Reserva reserva = new Reserva();

		int menu;

		System.out.println("========== RESERVA ==========");
		System.out.println("1 - Cadastrar reserva");
		System.out.println("2 - Remover reserva");
		System.out.println("3 - Atualizar reserva");
		System.out.println("4 - Mostrar reservas");
		System.out.println("5 - Buscar reserva por ID");
		System.out.println("6 - Buscar reserva por pacote");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o ID do pacote: ");
			Pacote pacote = pacoteDAO.pacoteById(entrada.nextInt());
			reserva.setPacote(pacote);
			entrada.nextLine();

			System.out.println("Digite o CNPJ da hospedagem:");
			Hospedagem hospedagem = hospedagemDAO.hospedagemByCNPJ(entrada.next());
			reserva.setHospedagem(hospedagem);

			System.out.println("Digite a quantidade de hospedes: ");
			reserva.setHospedes(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite a quantidade de quartos: ");
			reserva.setQuartos(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite o numero de diarias: ");
			reserva.setDiaria(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite a data de entrada: (dd/mm/aaaa)");
			reserva.setDataEntrada(entrada.next());

			System.out.println("Digite a data de saida: (dd/mm/aaaa)");
			reserva.setDataSaida(entrada.next());
			
			reservaDAO.save(reserva);
			pacoteDAO.update(pacote);
			ReservaCRUD.Reserva(args);
			break;
		case 2:
			System.out.println("Digite o ID da reserva que sera deletada:");
			reservaDAO.removeById(entrada.nextInt());
			entrada.nextLine();
			ReservaCRUD.Reserva(args);
			break;
		case 3:
			System.out.println("Digite o ID do pacote: ");
			Pacote pacote1 = pacoteDAO.pacoteById(entrada.nextInt());
			reserva.setPacote(pacote1);
			entrada.nextLine();

			System.out.println("Digite o CNPJ da hospedagem:");
			Hospedagem hospedagem1 = hospedagemDAO.hospedagemByCNPJ(entrada.next());
			reserva.setHospedagem(hospedagem1);

			System.out.println("Digite a quantidade de hospedes: ");
			reserva.setHospedes(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite a quantidade de quartos: ");
			reserva.setQuartos(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite o numero de diarias: ");
			reserva.setDiaria(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite a data de entrada: (dd/mm/aaaa)");
			reserva.setDataEntrada(entrada.next());

			System.out.println("Digite a data de saida: (dd/mm/aaaa)");
			reserva.setDataSaida(entrada.next());

			reservaDAO.update(reserva);
			ReservaCRUD.Reserva(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Reserva r : reservaDAO.getReservas()) {
								
				System.out.println("ID da reserva: " + r.getId() + "       ID do pacote:" + r.getPacote().getId());
				System.out.println("CNPJ da Hospedagem: " + r.getHospedagem().getCnpj());
				System.out.println("Quantidade de hospedes: " + r.getHospedes());
				System.out.println("Quantidade de quartos: " + r.getQuartos());
				System.out.println("Quantidade de diarias: " + r.getDiaria());
				System.out.println("Data de entrada: " + r.getDataEntrada());
				System.out.println("Data de saida: " + r.getDataSaida());
				System.out.println("Total da Reserva: R$ " + r.getValorFinal());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ReservaCRUD.Reserva(args);
			break;
		case 5:
			System.out.println("Digite o ID da reserva:");
			int id = entrada.nextInt();
			entrada.nextLine();

			Reserva r = reservaDAO.reservaById(id);
			System.out.println("===============================");
			System.out.println("ID da reserva: " + r.getId() + "       ID do pacote:" + r.getPacote().getId());
			System.out.println("CNPJ da Hospedagem: " + r.getHospedagem().getCnpj());
			System.out.println("Quantidade de hospedes: " + r.getHospedes());
			System.out.println("Quantidade de quartos: " + r.getQuartos());
			System.out.println("Quantidade de diarias: " + r.getDiaria());
			System.out.println("Data de entrada: " + r.getDataEntrada());
			System.out.println("Data de saida: " + r.getDataSaida());
			System.out.println("Total da Reserva: R$ " + r.getValorFinal());
			System.out.println("===============================");
			ReservaCRUD.Reserva(args);
			break;
		case 6:
			System.out.println("Digite o ID do pacote: ");
			int id1 = entrada.nextInt();
			entrada.nextLine();
			System.out.println("===============================");
			for (Reserva re : reservaDAO.ReservaByPac(id1)) {

				System.out.println("ID da reserva: " + re.getId() + "       ID do pacote:" + re.getPacote().getId());
				System.out.println("CNPJ da Hospedagem: " + re.getHospedagem().getCnpj());
				System.out.println("Quantidade de hospedes: " + re.getHospedes());
				System.out.println("Quantidade de quartos: " + re.getQuartos());
				System.out.println("Quantidade de diarias: " + re.getDiaria());
				System.out.println("Data de entrada: " + re.getDataEntrada());
				System.out.println("Data de saida: " + re.getDataSaida());
				System.out.println("Total da Reserva: R$ " + re.getValorFinal());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ReservaCRUD.Reserva(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			ReservaCRUD.Reserva(args);
			break;
		}
	}
}
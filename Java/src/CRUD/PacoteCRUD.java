package CRUD;

import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.PacoteDAO;
import objetos.Cliente;
import objetos.Hospedagem;
import objetos.Pacote;

public class PacoteCRUD {

	public static void Pacote(String[] args) {
		Scanner entrada = new Scanner(System.in);
		PacoteDAO pacoteDAO = new PacoteDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

		Pacote pacote = new Pacote();

		int menu;

		System.out.println("========== PACOTE ==========");
		System.out.println("1 - Cadastrar pacote");
		System.out.println("2 - Remover pacote");
		System.out.println("3 - Atualizar pacote");
		System.out.println("4 - Mostrar pacotes");
		System.out.println("5 - Buscar pacote por ID");
		System.out.println("6 - Buscar pacote por cliente");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CPF do cliente: (xxx.xxx.xxx-xx)");
			Cliente cliente = clienteDAO.clienteByCPF(entrada.nextLine());
			pacote.setCliente(cliente);

			pacoteDAO.save(pacote);
			PacoteCRUD.Pacote(args);
			break;
		case 2:
			System.out.println("Digite o ID do pacote que sera deletado:");
			pacoteDAO.removeById(entrada.nextInt());
			PacoteCRUD.Pacote(args);
			break;
		case 3:
			System.out.println("Digite o ID do pacote: ");
			pacote.setId(entrada.nextInt());
			entrada.nextLine();

			System.out.println("Digite o CPF do cliente:");
			Cliente cliente1 = clienteDAO.clienteByCPF(entrada.nextLine());
			pacote.setCliente(cliente1);

			pacoteDAO.update(pacote);
			PacoteCRUD.Pacote(args);
			break;
		case 4:
			System.out.println("===============================");
			for (Pacote p : pacoteDAO.getPacotes()) {
				System.out.println("ID do pacote: " + p.getId());
				System.out.println("CPF do cliente: " + p.getCliente().getCpf());
				System.out.println("Valor total: R$" + p.getTotal());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			PacoteCRUD.Pacote(args);
			break;
		case 5:
			System.out.println("Digite o ID do pacote: ");
			int id = entrada.nextInt();
			entrada.nextLine();			

			Pacote p = pacoteDAO.pacoteById(id);
			System.out.println("===============================");
			System.out.println("ID do pacote: " + p.getId());
			System.out.println("CPF do cliente: " + p.getCliente().getCpf());
			System.out.println("Valor total: R$" + p.getTotal());
			System.out.println("===============================");
			PacoteCRUD.Pacote(args);
			break;
		case 6:
			System.out.println("Digite o CPF do cliente: ");
			String cpf = entrada.next();
			System.out.println("===============================");
			for (Pacote pa : pacoteDAO.PacoteByCli(cpf)) {

				System.out.println("ID do pacote: " + pa.getId());
				System.out.println("CPF do cliente: " + pa.getCliente().getCpf());
				System.out.println("Valor total: R$" + pa.getTotal());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			PacoteCRUD.Pacote(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			PacoteCRUD.Pacote(args);
			break;
		}
	}
}
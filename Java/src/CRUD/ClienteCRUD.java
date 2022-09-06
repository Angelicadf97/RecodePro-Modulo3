package CRUD;

import java.util.Scanner;

import DAO.ClienteDAO;
import objetos.Cliente;

public  class ClienteCRUD {
	
	public static void Cliente(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		
		int menu;
		
		System.out.println("========== CLIENTE ==========");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Remover cliente");
		System.out.println("3 - Atualizar cliente");
		System.out.println("4 - Mostrar clientes");
		System.out.println("5 - Buscar cliente por CPF");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
			cliente.setCpf(entrada.nextLine());
			
			System.out.println("Digite o nome:");
			cliente.setNome(entrada.nextLine());
			
			System.out.println("Digite a data de nascimento:(dd/mm/aaaa)");
			cliente.setDataNasc(entrada.next());
			
			System.out.println("Digite o genero: (F/M/O(Outros))");
			cliente.setGenero(entrada.next());
			
			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			cliente.setTelefone(entrada.next());
			
			System.out.println("Digite o endereço:");
			cliente.setEndereco(entrada.next());
			
			System.out.println("Digite o UF:");
			cliente.setUf(entrada.next());
			
			System.out.println("Digite o email:");
			cliente.setEmail(entrada.next());
			
			System.out.println("Digite a senha:");
			cliente.setSenha(entrada.next());
			
			clienteDAO.save(cliente);

			ClienteCRUD.Cliente(args);
			break;
		case 2:
			System.out.println("Digite o CPF do cliente que sera deletado:");
			clienteDAO.removeByCPF(entrada.next());
			ClienteCRUD.Cliente(args);
			break;
		case 3:
			System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
			cliente.setCpf(entrada.nextLine());
			
			System.out.println("Digite o nome:");
			cliente.setNome(entrada.nextLine());
			
			System.out.println("Digite a data de nascimento:(dd/mm/aaaa)");
			cliente.setDataNasc(entrada.next());
			
			System.out.println("Digite o genero: (F/M/O(Outros))");
			cliente.setGenero(entrada.next());
			
			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			cliente.setTelefone(entrada.next());
			
			System.out.println("Digite o endereço:");
			cliente.setEndereco(entrada.next());
			
			System.out.println("Digite o UF:");
			cliente.setUf(entrada.next());
			
			System.out.println("Digite o email:");
			cliente.setEmail(entrada.next());
			
			System.out.println("Digite a senha:");
			cliente.setSenha(entrada.next());

			clienteDAO.update(cliente);
			ClienteCRUD.Cliente(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Cliente c : clienteDAO.getClientes()) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("CPF: " + c.getCpf());
				System.out.println("Data de Nascimento: " + c.getDataNasc());
				System.out.println("Genero: " + c.getGenero());
				System.out.println("Telefone: "+ c.getTelefone());
				System.out.println("Endereço: "+ c.getEndereco() + "     UF: " + c.getUf());
				System.out.println("Email: " + c.getEmail());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ClienteCRUD.Cliente(args);
			break;
		case 5:
			System.out.println("Digite o CPF do cliente:");
			String cpf = entrada.next();
			
			Cliente c = clienteDAO.clienteByCPF(cpf);
			System.out.println("===============================");
			System.out.println("Nome: " + c.getNome());
			System.out.println("CPF: " + c.getCpf());
			System.out.println("Data de Nascimento: " + c.getDataNasc());
			System.out.println("Genero: " + c.getGenero());
			System.out.println("Telefone: "+ c.getTelefone());
			System.out.println("Endereço: "+ c.getEndereco() + "     UF: " + c.getUf());
			System.out.println("Email: " + c.getEmail());
			System.out.println("===============================");
			ClienteCRUD.Cliente(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			ClienteCRUD.Cliente(args);
			break;
		}
	}
}

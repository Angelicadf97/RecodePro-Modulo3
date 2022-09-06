package CRUD;

import java.util.Scanner;

import DAO.HospedagemDAO;
import objetos.Hospedagem;

public class HospedagemCRUD {

	public static void Hospedagem(String[] args) {
		Scanner entrada = new Scanner(System.in);
		HospedagemDAO hospedagemDAO = new HospedagemDAO();

		Hospedagem hospedagem = new Hospedagem();

		int menu;

		System.out.println("========== HOSPEDAGEM ==========");
		System.out.println("1 - Cadastrar hospedagem");
		System.out.println("2 - Remover hospedagem");
		System.out.println("3 - Atualizar hospedagem");
		System.out.println("4 - Mostrar hospedagens");
		System.out.println("5 - Buscar hospedagem por CNPJ");
		System.out.println("6 - Buscar hospedagem por Cidade");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CNPJ da hospedagem: (xx.xxx.xxx/xxxx-xx)");
			hospedagem.setCnpj(entrada.next());

			System.out.println("Digite o nome:");
			hospedagem.setNome(entrada.nextLine());

			System.out.println("Digite o tipo de hospedagem:(hotel/pousada/hostel)");
			hospedagem.setTipo(entrada.next());

			System.out.println("Digite o valor da diária: ");
			hospedagem.setPreco(entrada.nextDouble());

			System.out.println("Digite a cidade: ");
			hospedagem.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			hospedagem.setUf(entrada.next());

			hospedagemDAO.save(hospedagem);
			HospedagemCRUD.Hospedagem(args);
			break;
		case 2:
			System.out.println("Digite o CNPJ da hospedagem que sera deletada:");
			hospedagemDAO.removeByCnpjHos(entrada.next());
			HospedagemCRUD.Hospedagem(args);
			break;
		case 3:
			System.out.println("Digite o CNPJ da hospedagem: (xx.xxx.xxx/xxxx-xx)");
			hospedagem.setCnpj(entrada.next());

			System.out.println("Digite o nome:");
			hospedagem.setNome(entrada.nextLine());

			System.out.println("Digite o tipo de hospedagem:(hotel/pousada/hostel)");
			hospedagem.setTipo(entrada.next());

			System.out.println("Digite o valor da diária: ");
			hospedagem.setPreco(entrada.nextDouble());

			System.out.println("Digite a cidade: ");
			hospedagem.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");

			hospedagemDAO.update(hospedagem);
			HospedagemCRUD.Hospedagem(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Hospedagem h : hospedagemDAO.getHospedagens()) {
				System.out.println("Nome: " + h.getNome());
				System.out.println("CNPJ: " + h.getCnpj());
				System.out.println("Tipo: " + h.getTipo());
				System.out.println("Valor da diária: R$" + h.getPreco());
				System.out.println("Cidade: " + h.getCidade() + "     UF: " + h.getUf());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			HospedagemCRUD.Hospedagem(args);
			break;
		case 5:
			System.out.println("Digite o CNPJ da hospedagem: (xx.xxx.xxx/xxxx-xx)");
			String cnpj = entrada.next();

			Hospedagem h = hospedagemDAO.hospedagemByCNPJ(cnpj);
			System.out.println("===============================");
			System.out.println("Nome: " + h.getNome());
			System.out.println("CNPJ: " + h.getCnpj());
			System.out.println("Tipo: " + h.getTipo());
			System.out.println("Valor da diária: R$" + h.getPreco());
			System.out.println("Cidade: " + h.getCidade() + "     UF: " + h.getUf());
			System.out.println("===============================");
			HospedagemCRUD.Hospedagem(args);
			break;
		case 6:
			System.out.println("Digite a cidade: ");
			String cidade = entrada.nextLine();
			System.out.println("===============================");
			for (Hospedagem ho : hospedagemDAO.hopedagensByCity(cidade)) {

				System.out.println("Nome: " + ho.getNome());
				System.out.println("CNPJ: " + ho.getCnpj());
				System.out.println("Tipo: " + ho.getTipo());
				System.out.println("Valor da diária: R$" + ho.getPreco());
				System.out.println("Cidade: " + ho.getCidade() + "     UF: " + ho.getUf());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			HospedagemCRUD.Hospedagem(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			HospedagemCRUD.Hospedagem(args);
			break;
		}
	}
}
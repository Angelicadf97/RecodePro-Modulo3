 package CRUD;

import java.util.Scanner;

import DAO.AeroportoDAO;
import objetos.Aeroporto;

public class AeroportoCRUD {

	public static void Aeroporto(String[] args) {
		Scanner entrada = new Scanner(System.in);
		AeroportoDAO aeroportoDAO = new AeroportoDAO();

		Aeroporto aeroporto = new Aeroporto();

		int menu;

		System.out.println("========== AEROPORTO ==========");
		System.out.println("1 - Cadastrar aeroporto");
		System.out.println("2 - Remover aeroporto");
		System.out.println("3 - Atualizar aeroporto");
		System.out.println("4 - Mostrar aeroportos");
		System.out.println("5 - Buscar aeroporto por ID");
		System.out.println("6 - Buscar aeroporto por Cidade");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CNPJ do aeroporto: (xx.xxx.xxx/xxxx-xx)");
			aeroporto.setCnpj(entrada.next());

			System.out.println("Digite o nome:");
			aeroporto.setNome(entrada.nextLine());

			System.out.println("Digite a cidade: ");
			aeroporto.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			aeroporto.setUf(entrada.next());

			aeroportoDAO.save(aeroporto);
			AeroportoCRUD.Aeroporto(args);
			break;
		case 2:
			System.out.println("Digite o CNPJ do aeroporto que sera deletado:");
			aeroportoDAO.removeByCnpjAer(entrada.next());
			AeroportoCRUD.Aeroporto(args);
			break;
		case 3:
			System.out.println("Digite o CNPJ do aeroporto: (xx.xxx.xxx/xxxx-xx)");
			aeroporto.setCnpj(entrada.next());

			System.out.println("Digite o nome:");
			aeroporto.setNome(entrada.nextLine());

			System.out.println("Digite a cidade: ");
			aeroporto.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			aeroporto.setUf(entrada.next());

			aeroportoDAO.update(aeroporto);
			AeroportoCRUD.Aeroporto(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Aeroporto a : aeroportoDAO.getAeroportos()) {
				System.out.println("Nome: " + a.getNome());
				System.out.println("CNPJ: " + a.getCnpj());
				System.out.println("Cidade: " + a.getCidade() + "     UF: " + a.getUf());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			AeroportoCRUD.Aeroporto(args);
			break;
		case 5:
			System.out.println("Digite o CNPJ do aeroporto: (xx.xxx.xxx/xxxx-xx)");
			String cnpj = entrada.next();

			Aeroporto a = aeroportoDAO.aeroById(cnpj);
			System.out.println("===============================");
			System.out.println("Nome: " + a.getNome());
			System.out.println("CNPJ: " + a.getCnpj());
			System.out.println("Cidade: " + a.getCidade() + "     UF: " + a.getUf());
			System.out.println("===============================");
			AeroportoCRUD.Aeroporto(args);
			break;
		case 6:
			System.out.println("Digite a cidade: ");
			String cidade = entrada.nextLine();
			System.out.println("===============================");
			for (Aeroporto ar : aeroportoDAO.aeroByCity(cidade)) {

				System.out.println("Nome: " + ar.getNome());
				System.out.println("CNPJ: " + ar.getCnpj());
				System.out.println("Cidade: " + ar.getCidade() + "     UF: " + ar.getUf());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			AeroportoCRUD.Aeroporto(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			AeroportoCRUD.Aeroporto(args);
			break;
		}
	}
}
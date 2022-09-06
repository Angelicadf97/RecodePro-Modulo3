package CRUD;

import java.util.Scanner;

import DAO.ConcessionariaDAO;
import objetos.Concessionaria;

public class ConcessionariaCRUD {

	public static void Concessionaria(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ConcessionariaDAO concessionariaDAO = new ConcessionariaDAO();

		Concessionaria concessionaria = new Concessionaria();

		int menu;

		System.out.println("========== CONCESSIONARIA ==========");
		System.out.println("1 - Cadastrar concessionaria");
		System.out.println("2 - Remover concessionaria");
		System.out.println("3 - Atualizar concessionaria");
		System.out.println("4 - Mostrar concessionarias");
		System.out.println("5 - Buscar concessionaria por ID");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CNPJ da concessionaria: (xx.xxx.xxx/xxxx-xx)");
			concessionaria.setCnpj(entrada.nextLine());

			System.out.println("Digite o nome:");
			concessionaria.setNome(entrada.nextLine());

			concessionariaDAO.save(concessionaria);
			ConcessionariaCRUD.Concessionaria(args);
			break;
		case 2:
			System.out.println("Digite o CNPJ da concessionaria que sera deletada:");
			concessionariaDAO.removeByCnpjCon(entrada.next());
			ConcessionariaCRUD.Concessionaria(args);
			break;
		case 3:
			System.out.println("Digite o CNPJ da concessionaria: (xx.xxx.xxx/xxxx-xx)");
			concessionaria.setCnpj(entrada.nextLine());

			System.out.println("Digite o nome:");
			concessionaria.setNome(entrada.nextLine());

			concessionariaDAO.update(concessionaria);
			ConcessionariaCRUD.Concessionaria(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Concessionaria c : concessionariaDAO.getConcessionarias()) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("CNPJ: " + c.getCnpj());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ConcessionariaCRUD.Concessionaria(args);
			break;
		case 5:
			System.out.println("Digite o CNPJ da concessionaria: (xx.xxx.xxx/xxxx-xx)");
			String cnpj = entrada.next();

			Concessionaria c = concessionariaDAO.concByCNPJ(cnpj);
			System.out.println("===============================");
			System.out.println("Nome: " + c.getNome());
			System.out.println("CNPJ: " + c.getCnpj());
			System.out.println("===============================");
			ConcessionariaCRUD.Concessionaria(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			ConcessionariaCRUD.Concessionaria(args);
			break;
		}
	}

}
package CRUD;

import java.util.Scanner;

import DAO.DestinoDAO;
import objetos.Destino;

public class DestinoCRUD {

	public static void Destino(String[] args) {
		Scanner entrada = new Scanner(System.in);
		DestinoDAO destinoDAO = new DestinoDAO();

		Destino destino = new Destino();

		int menu;

		System.out.println("========== DESTINO ==========");
		System.out.println("1 - Cadastrar destino");
		System.out.println("2 - Remover destino");
		System.out.println("3 - Atualizar destino");
		System.out.println("4 - Mostrar destinos");
		System.out.println("5 - Buscar destino por ID");
		System.out.println("6 - Buscar destino por UF");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		
		switch (menu) {
		case 1:
			System.out.println("Digite a cidade:");
			destino.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			destino.setUf(entrada.next());

			destinoDAO.save(destino);
			DestinoCRUD.Destino(args);
			break;
		case 2:
			System.out.println("Digite o ID do destino que sera deletado:");
			destinoDAO.removeByIdDes(entrada.nextInt());
			entrada.nextLine();
			DestinoCRUD.Destino(args);
			break;
		case 3:
			System.out.println("Digite o ID do destino:");
			destino.setId(entrada.nextInt());
			entrada.nextLine();
			
			System.out.println("Digite a cidade:");
			destino.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			destino.setUf(entrada.next());

			destinoDAO.update(destino);
			DestinoCRUD.Destino(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Destino d : destinoDAO.getDestinos()) {
				System.out.println("ID: " + d.getId());
				System.out.println("Cidade: " + d.getCidade() + "     UF: " + d.getUf());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			DestinoCRUD.Destino(args);
			break;
		case 5:
			System.out.println("Digite o ID do destino:");
			int id = entrada.nextInt();
			entrada.nextLine();

			Destino d = destinoDAO.destinoById(id);
			System.out.println("===============================");
			System.out.println("ID: " + d.getId());
			System.out.println("Cidade: " + d.getCidade() + "     UF: " + d.getUf());
			System.out.println("===============================");
			DestinoCRUD.Destino(args);
			break;
		case 6:
			System.out.println("Digite o UF: ");
			String uf = entrada.next();
			System.out.println("===============================");
			for (Destino de : destinoDAO.destinosByUf(uf)) {

				System.out.println("ID: " + de.getId() + "     Cidade: " + de.getCidade());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			DestinoCRUD.Destino(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			DestinoCRUD.Destino(args);
			break;
		}
	}
}
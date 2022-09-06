package CRUD;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int menu;

		System.out.println("========== MENU ==========");
		System.out.println("1 - Cliente");
		System.out.println("2 - Hospedagem");
		System.out.println("3 - Concessionaria");
		System.out.println("4 - Aeroporto");
		System.out.println("5 - Destino");
		System.out.println("6 - Pacote");
		System.out.println("7 - Reserva");
		System.out.println("8 - Passagem");
		System.out.println("0 - Sair");

		menu = entrada.nextInt();
		switch (menu) {
		case 1:
			ClienteCRUD.Cliente(args);
			break;
		case 2:
			HospedagemCRUD.Hospedagem(args);
			break;
		case 3:
			ConcessionariaCRUD.Concessionaria(args);
			break;
		case 4:
			AeroportoCRUD.Aeroporto(args);
			break;
		case 5:
			DestinoCRUD.Destino(args);
			break;
		case 6:
			PacoteCRUD.Pacote(args);
			break;
		case 7:
			ReservaCRUD.Reserva(args);
			break;
		case 8:
			PassagemCRUD.Passagem(args);
			break;
		case 0:
			System.out.println("Ate logo!");
			break;
		default:
			System.out.println("Opcao invalida!");
			main.main(args);
		}
	}
}

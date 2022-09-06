package CRUD;

import java.util.Scanner;

import DAO.AeroportoDAO;
import DAO.ConcessionariaDAO;
import DAO.DestinoDAO;
import DAO.PacoteDAO;
import DAO.PassagemDAO;
import objetos.Aeroporto;
import objetos.Concessionaria;
import objetos.Destino;
import objetos.Pacote;
import objetos.Passagem;

public class PassagemCRUD {

	public static void Passagem(String[] args) {
		Scanner entrada = new Scanner(System.in);
		PassagemDAO passagemDAO = new PassagemDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		ConcessionariaDAO concessionariaDAO = new ConcessionariaDAO();
		AeroportoDAO aeroportoDAO = new AeroportoDAO();
		DestinoDAO destinoDAO = new DestinoDAO();

		Passagem passagem = new Passagem();

		int menu;

		System.out.println("========== PASSAGEM ==========");
		System.out.println("1 - Cadastrar passagem");
		System.out.println("2 - Remover passagem");
		System.out.println("3 - Atualizar passagem");
		System.out.println("4 - Mostrar passagens");
		System.out.println("5 - Buscar passagem por ID:");
		System.out.println("6 - Buscar passagem por Pacote:");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o ID do pacote: ");
			Pacote pacote = pacoteDAO.pacoteById(entrada.nextInt());
			passagem.setPacote(pacote);
			entrada.nextLine();

			System.out.println("Digite o ID do destino:");
			Destino destino = destinoDAO.destinoById(entrada.nextInt());
			passagem.setDestino(destino);
			entrada.nextLine();

			System.out.println("Digite o CNPJ do aeroporto:");
			Aeroporto aeroporto = aeroportoDAO.aeroById(entrada.next());
			passagem.setAeroporto(aeroporto);

			System.out.println("Digite o CNPJ da concessionaria: ");
			Concessionaria concessionaria = concessionariaDAO.concByCNPJ(entrada.next());
			passagem.setConcessionaria(concessionaria);

			System.out.println("Digite o CPF do passageiro: ");
			passagem.setCpfPas(entrada.next());

			System.out.println("Digite a classe da passagem:");
			passagem.setClasse(entrada.next());

			System.out.println("Digite a data de partida:");
			passagem.setData(entrada.next());
			
			System.out.println("Digite o valor:");
			passagem.setPreco(entrada.nextDouble());
			
			passagemDAO.save(passagem);
			PassagemCRUD.Passagem(args);
			break;
		case 2:
			System.out.println("Digite o ID da passagem que sera deletada:");
			passagemDAO.removeById(entrada.nextInt());
			entrada.nextLine();
			PassagemCRUD.Passagem(args);
			break;
		case 3:
			System.out.println("Digite o ID do pacote: ");
			Pacote pacote1 = pacoteDAO.pacoteById(entrada.nextInt());
			passagem.setPacote(pacote1);
			entrada.nextLine();

			System.out.println("Digite o ID do destino:");
			Destino destino1 = destinoDAO.destinoById(entrada.nextInt());
			passagem.setDestino(destino1);
			entrada.nextLine();

			System.out.println("Digite o CNPJ do aeroporto:");
			Aeroporto aeroporto1 = aeroportoDAO.aeroById(entrada.next());
			passagem.setAeroporto(aeroporto1);

			System.out.println("Digite o CNPJ da concessionaria: ");
			Concessionaria concessionaria1 = concessionariaDAO.concByCNPJ(entrada.next());
			passagem.setConcessionaria(concessionaria1);

			System.out.println("Digite o CPF do passageiro: ");
			passagem.setCpfPas(entrada.next());

			System.out.println("Digite a classe da passagem:");
			passagem.setClasse(entrada.next());

			System.out.println("Digite a data de partida:");
			passagem.setData(entrada.next());
			
			System.out.println("Digite o valor:");
			passagem.setPreco(entrada.nextDouble());

			passagemDAO.update(passagem);
			PassagemCRUD.Passagem(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Passagem p : passagemDAO.getPassagens()) {
				System.out.println("ID da passagem: " + p.getId() + "       ID do pacote:" + p.getPacote().getId());
				System.out.println("ID do Destino: " + p.getDestino().getId());
				System.out.println("CNPJ da Concessionaria: " + p.getConcessionaria().getCnpj());
				System.out.println("CNPJ do Aeroporto: " + p.getAeroporto().getCnpj());
				System.out.println("CPF do passageiro: " + p.getCpfPas());
				System.out.println("Classe: " + p.getClasse());
				System.out.println("Data de partida: " + p.getData());
				System.out.println("Valor: R$ " + p.getPreco());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			PassagemCRUD.Passagem(args);
			break;
		case 5:
			System.out.println("Digite o ID da passagem:");
			int id = entrada.nextInt();
			entrada.nextLine();

			Passagem p = passagemDAO.passagemById(id);
			System.out.println("===============================");
			System.out.println("ID da passagem: " + p.getId() + "       ID do pacote:" + p.getPacote().getId());
			System.out.println("ID do Destino: " + p.getDestino().getId());
			System.out.println("CNPJ da Concessionaria: " + p.getConcessionaria().getCnpj());
			System.out.println("CNPJ do Aeroporto: " + p.getAeroporto().getCnpj());
			System.out.println("CPF do passageiro: " + p.getCpfPas());
			System.out.println("Classe: " + p.getClasse());
			System.out.println("Data de partida: " + p.getData());
			System.out.println("Valor: R$ " + p.getPreco());
			System.out.println("===============================");
			PassagemCRUD.Passagem(args);
			break;
		case 6:
			System.out.println("Digite o ID do pacote: ");
			int id1 = entrada.nextInt();
			entrada.nextLine();
			System.out.println("===============================");
			for (Passagem pa : passagemDAO.PassagemByPac(id1)) {

				System.out.println("ID da passagem: " + pa.getId() + "       ID do pacote:" + pa.getPacote().getId());
				System.out.println("ID do Destino: " + pa.getDestino().getId());
				System.out.println("CNPJ da Concessionaria: " + pa.getConcessionaria().getCnpj());
				System.out.println("CNPJ do Aeroporto: " + pa.getAeroporto().getCnpj());
				System.out.println("CPF do passageiro: " + pa.getCpfPas());
				System.out.println("Classe: " + pa.getClasse());
				System.out.println("Data de partida: " + pa.getData());
				System.out.println("Valor: R$ " + pa.getPreco());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			PassagemCRUD.Passagem(args);
			break;
		case 0:
			main.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			PassagemCRUD.Passagem(args);
			break;
		}
	}
}
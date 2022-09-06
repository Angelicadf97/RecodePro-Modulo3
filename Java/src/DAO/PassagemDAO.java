package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Aeroporto;
import objetos.Concessionaria;
import objetos.Destino;
import objetos.Pacote;
import objetos.Passagem;

public class PassagemDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Passagem passagem) {

		String sql = "INSERT INTO passagem(id_pas, id_pac, id_des, cnpj_con, cnpj_aer, cpf_pas, classe, data, preco)" + " VALUE(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, passagem.getId());

			pstm.setInt(2, passagem.getPacote().getId());

			pstm.setInt(3, passagem.getDestino().getId());

			pstm.setString(4, passagem.getConcessionaria().getCnpj());

			pstm.setString(5, passagem.getAeroporto().getCnpj());

			pstm.setString(6, passagem.getCpfPas());

			pstm.setString(7, passagem.getClasse());

			pstm.setString(8, passagem.getData());

			pstm.setDouble(9, passagem.getPreco());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM passagem WHERE id_pas=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Passagem passagem) {

		String sql = "UPDATE passagem SET id_pac = ?, id_des = ?, cnpj_con = ?, cnpj_aer = ?, cpf_pas = ?, classe = ?, data = ?, preco = ?" + "WHERE id_pas=?";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, passagem.getPacote().getId());

			pstm.setInt(2, passagem.getDestino().getId());

			pstm.setString(3, passagem.getConcessionaria().getCnpj());

			pstm.setString(4, passagem.getAeroporto().getCnpj());

			pstm.setString(5, passagem.getCpfPas());

			pstm.setString(6, passagem.getClasse());

			pstm.setString(7, passagem.getData());

			pstm.setDouble(8, passagem.getPreco());

			pstm.setInt(9, passagem.getId());


			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public List<Passagem> getPassagens() {

		String sql = "SELECT * FROM passagem";

		List<Passagem> passagens = new ArrayList<Passagem>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Passagem passagem = new Passagem();
				Pacote pacote = new Pacote();
				Destino destino = new Destino();
				Concessionaria concessionaria = new Concessionaria();
				Aeroporto aeroporto = new Aeroporto();

				passagem.setId(rset.getInt("id_pas"));

				pacote.setId(rset.getInt("id_pac"));
				passagem.setPacote(pacote);

				destino.setId(rset.getInt("id_des"));
				passagem.setDestino(destino);

				concessionaria.setCnpj(rset.getString("cnpj_con"));
				passagem.setConcessionaria(concessionaria);

				aeroporto.setCnpj(rset.getString("cnpj_aer"));
				passagem.setAeroporto(aeroporto);

				passagem.setCpfPas(rset.getString("cpf_pas"));

				passagem.setClasse(rset.getString("classe"));

				passagem.setData(rset.getString("data"));

				passagem.setPreco(rset.getDouble ("preco"));

				passagens.add(passagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return passagens;
	}

	public Passagem passagemById(int id) {
		String sql = "SELECT * FROM passagem WHERE id_pas=?";

		ResultSet rset = null;

		Passagem passagem = new Passagem();
		Pacote pacote = new Pacote();
		Destino destino = new Destino();
		Concessionaria concessionaria = new Concessionaria();
		Aeroporto aeroporto = new Aeroporto();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			passagem.setId(rset.getInt("id_pas"));

			pacote.setId(rset.getInt("id_pac"));
			passagem.setPacote(pacote);

			destino.setId(rset.getInt("id_des"));
			passagem.setDestino(destino);

			concessionaria.setCnpj(rset.getString("cnpj_con"));
			passagem.setConcessionaria(concessionaria);

			aeroporto.setCnpj(rset.getString("cnpj_aer"));
			passagem.setAeroporto(aeroporto);

			passagem.setCpfPas(rset.getString("cpf_pas"));

			passagem.setClasse(rset.getString("classe"));

			passagem.setData(rset.getString("data"));

			passagem.setPreco(rset.getDouble ("preco"));

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return passagem;
	}
	
	public List<Passagem> PassagemByPac(int id) {

		String sql = "SELECT * FROM passagem WHERE id_pac=?";

		List<Passagem> passagens = new ArrayList<Passagem>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Passagem passagem = new Passagem();
				Pacote pacote = new Pacote();
				Destino destino = new Destino();
				Concessionaria concessionaria = new Concessionaria();
				Aeroporto aeroporto = new Aeroporto();

				passagem.setId(rset.getInt("id_pas"));

				pacote.setId(rset.getInt("id_pac"));
				passagem.setPacote(pacote);

				destino.setId(rset.getInt("id_des"));
				passagem.setDestino(destino);

				concessionaria.setCnpj(rset.getString("cnpj_con"));
				passagem.setConcessionaria(concessionaria);

				aeroporto.setCnpj(rset.getString("cnpj_aer"));
				passagem.setAeroporto(aeroporto);

				passagem.setCpfPas(rset.getString("cpf_pas"));

				passagem.setClasse(rset.getString("classe"));

				passagem.setData(rset.getString("data"));

				passagem.setPreco(rset.getDouble ("preco"));

				passagens.add(passagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return passagens;
	}

}
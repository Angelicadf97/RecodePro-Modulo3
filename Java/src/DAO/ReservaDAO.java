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
import objetos.Hospedagem;
import objetos.Pacote;
import objetos.Passagem;
import objetos.Reserva;

public class ReservaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Reserva reserva) {

		String sql = "INSERT INTO reserva(id_res, id_pac, cnpj_hos, hospedes, quartos, data_entrada, data_saida, diaria, sub_total)" + " VALUE(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getId());

			pstm.setInt(2, reserva.getPacote().getId());
			
			pstm.setString(3, reserva.getHospedagem().getCnpj());

			pstm.setInt(4, reserva.getHospedes());

			pstm.setInt(5, reserva.getQuartos());

			pstm.setString(6, reserva.getDataEntrada());

			pstm.setString(7, reserva.getDataSaida());

			pstm.setInt(8, reserva.getDiaria());

			pstm.setDouble(9, reserva.getSubTotal());

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

		String sql = "DELETE FROM reserva WHERE id_res=?";

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

	public void update(Reserva reserva) {

		String sql = "UPDATE reserva SET id_pac = ?, cnpj_hos = ?, hospedes = ?, quartos = ?, data_entrada = ?, data_saida = ?, diaria = ?, sub_total = ?" + "WHERE id_res=?";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getPacote().getId());

			pstm.setString(2, reserva.getHospedagem().getCnpj());
			
			pstm.setInt(3, reserva.getHospedes());

			pstm.setInt(4, reserva.getQuartos());

			pstm.setString(5, reserva.getDataEntrada());

			pstm.setString(6, reserva.getDataSaida());

			pstm.setInt(7, reserva.getDiaria());

			pstm.setDouble(8, reserva.getSubTotal());

			pstm.setInt(9, reserva.getId());


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

	public List<Reserva> getReservas() {

		String sql = "SELECT * FROM reserva";

		List<Reserva> reservas = new ArrayList<Reserva>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Reserva reserva = new Reserva();
				Pacote pacote = new Pacote();
				Hospedagem hospedagem = new Hospedagem();

				reserva.setId(rset.getInt("id_res"));
				
				pacote.setId(rset.getInt("id_pac"));
				reserva.setPacote(pacote);

				hospedagem.setCnpj(rset.getString("cnpj_hos"));
				reserva.setHospedagem(hospedagem);

				reserva.setHospedes(rset.getInt("hospedes"));

				reserva.setQuartos(rset.getInt("quartos"));

				reserva.setDataEntrada(rset.getString("data_entrada"));

				reserva.setDataSaida(rset.getString("data_saida"));

				reserva.setDiaria(rset.getInt("diaria"));

				reserva.setValorFinal(rset.getDouble("sub_total"));

				reservas.add(reserva);
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
		return reservas;
	}

	public Reserva reservaById(int id) {
		String sql = "SELECT * FROM reserva WHERE id_res=?";

		ResultSet rset = null;

		Reserva reserva = new Reserva();
		Pacote pacote = new Pacote();
		Hospedagem hospedagem = new Hospedagem();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			reserva.setId(rset.getInt("id_res"));
			
			pacote.setId(rset.getInt("id_pac"));
			reserva.setPacote(pacote);

			hospedagem.setCnpj(rset.getString("cnpj_hos"));
			reserva.setHospedagem(hospedagem);

			reserva.setHospedes(rset.getInt("hospedes"));

			reserva.setQuartos(rset.getInt("quartos"));

			reserva.setDataEntrada(rset.getString("data_entrada"));

			reserva.setDataSaida(rset.getString("data_saida"));

			reserva.setDiaria(rset.getInt("diaria"));

			reserva.setValorFinal(rset.getDouble("sub_total"));

			

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
		return reserva;
	}
	
	public List<Reserva> ReservaByPac(int id) {

		String sql = "SELECT * FROM reserva WHERE id_pac=?";

		List<Reserva> reservas = new ArrayList<Reserva>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Reserva reserva = new Reserva();
				Pacote pacote = new Pacote();
				Hospedagem hospedagem = new Hospedagem();

				reserva.setId(rset.getInt("id_res"));
				
				pacote.setId(rset.getInt("id_pac"));
				reserva.setPacote(pacote);

				hospedagem.setCnpj(rset.getString("cnpj_hos"));
				reserva.setHospedagem(hospedagem);

				reserva.setHospedes(rset.getInt("hospedes"));

				reserva.setQuartos(rset.getInt("quartos"));

				reserva.setDataEntrada(rset.getString("data_entrada"));

				reserva.setDataSaida(rset.getString("data_saida"));

				reserva.setDiaria(rset.getInt("diaria"));

				reserva.setValorFinal(rset.getDouble("sub_total"));

				reservas.add(reserva);
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
		return reservas;
	}

}
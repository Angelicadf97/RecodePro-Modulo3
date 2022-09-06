package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Concessionaria;

public class ConcessionariaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Concessionaria concessionaria) {

		String sql = "INSERT INTO concessionaria(nome, cnpj_con)" + " VALUE(?,?)";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, concessionaria.getNome());

			pstm.setString(2, concessionaria.getCnpj());

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

	public void removeByCnpjCon(String cnpj) {

		String sql = "DELETE FROM concessionaria WHERE cnpj_con=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cnpj);

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

	public void update(Concessionaria concessionaria) {

		String sql = "UPDATE concessionaria SET nome = ?" + "WHERE cnpj_con=?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, concessionaria.getNome());
			
			pstm.setString(2, concessionaria.getCnpj());

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

	public List<Concessionaria> getConcessionarias() {

		String sql = "SELECT * FROM concessionaria";

		List<Concessionaria> concessionarias = new ArrayList<Concessionaria>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Concessionaria concessionaria = new Concessionaria();

				concessionaria.setNome(rset.getString("nome"));

				concessionaria.setCnpj(rset.getString("cnpj_con"));

				concessionarias.add(concessionaria);
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
		return concessionarias;
	}

	public Concessionaria concByCNPJ(String cnpj) {
		String sql = "SELECT * FROM concessionaria WHERE cnpj_con=?";

		ResultSet rset = null;

		Concessionaria concessionaria = new Concessionaria();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cnpj);
			rset = pstm.executeQuery();

			rset.next();
			
			concessionaria.setNome(rset.getString("nome"));

			concessionaria.setCnpj(rset.getString("cnpj_con"));

			

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
		return concessionaria;
	}

}
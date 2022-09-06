package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Aeroporto;

public class AeroportoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Aeroporto aero) {

		String sql = "INSERT INTO aeroporto(nome, cidade, uf, cnpj_aer)" + " VALUE(?,?,?,?)";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, aero.getNome());

			pstm.setString(2, aero.getCidade());

			pstm.setString(3, aero.getUf());

			pstm.setString(4, aero.getCnpj ());

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

	public void removeByCnpjAer(String cnpj) {

		String sql = "DELETE FROM aeroporto WHERE cnpj_aer=?";

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

	public void update(Aeroporto aero) {

		String sql = "UPDATE aeroporto SET nome = ?, cidade = ?, uf = ?" + "WHERE cnpj_aer=?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, aero.getNome());

			pstm.setString(2, aero.getCidade());

			pstm.setString(3, aero.getUf());

			pstm.setString(4, aero.getCnpj());

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

	public List<Aeroporto> getAeroportos() {

		String sql = "SELECT * FROM aeroporto";

		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Aeroporto aero = new Aeroporto();

				aero.setNome(rset.getString("nome"));

				aero.setCidade(rset.getString("cidade"));

				aero.setUf(rset.getString("uf"));

				aero.setCnpj(rset.getString("cnpj_aer"));

				aeroportos.add(aero);
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
		return aeroportos;
	}

	public List<Aeroporto> aeroByCity(String cidade) {

		String sql = "SELECT * FROM aeroporto WHERE cidade=?";

		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cidade);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Aeroporto aero = new Aeroporto();

				aero.setNome(rset.getString("Nome"));

				aero.setCnpj(rset.getString("cnpj_aer"));

				aeroportos.add(aero);
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
		return aeroportos;
	}
	
	public Aeroporto aeroById(String cnpj) {

		String sql = "SELECT * FROM aeroporto WHERE cnpj_aer=?";

		ResultSet rset = null;

		Aeroporto aero = new Aeroporto();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cnpj);
			rset = pstm.executeQuery();

			rset.next();

			aero.setNome(rset.getString("Nome"));

			aero.setCnpj(rset.getString("cnpj_aer"));

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
		return aero;
	}

}
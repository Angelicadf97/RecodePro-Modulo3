package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Hospedagem;

public class HospedagemDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Hospedagem hospedagem) {

		String sql = "INSERT INTO hospedagem(nome, tipo, cidade, uf, cnpj_hos, preco_dia)" + " VALUE(?,?,?,?,?,?)";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getNome());

			pstm.setString(2, hospedagem.getTipo());

			pstm.setString(3, hospedagem.getCidade());

			pstm.setString(4, hospedagem.getUf());

			pstm.setString(5, hospedagem.getCnpj ());
			
			pstm.setDouble(6, hospedagem.getPreco());

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

	public void removeByCnpjHos(String cnpj) {

		String sql = "DELETE FROM hospedagem WHERE cnpj_hos=?";

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

	public void update(Hospedagem hospedagem) {

		String sql = "UPDATE hospedagem SET nome = ?, tipo = ?, cidade = ?, uf = ?, preco_dia = ?" + "WHERE cnpj_hos=?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getNome());

			pstm.setString(2, hospedagem.getTipo());

			pstm.setString(3, hospedagem.getCidade());

			pstm.setString(4, hospedagem.getUf());
			
			pstm.setDouble(5, hospedagem.getPreco());

			pstm.setString(6, hospedagem.getCnpj());

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

	public List<Hospedagem> getHospedagens() {

		String sql = "SELECT * FROM hospedagem";

		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Hospedagem hospedagem = new Hospedagem();

				hospedagem.setNome(rset.getString("nome"));

				hospedagem.setTipo(rset.getString("tipo"));

				hospedagem.setCidade(rset.getString("cidade"));

				hospedagem.setUf(rset.getString("uf"));

				hospedagem.setPreco(rset.getDouble("preco_dia"));

				hospedagem.setCnpj(rset.getString("cnpj_hos"));

				hospedagens.add(hospedagem);
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
		return hospedagens;
	}
	
	public List<Hospedagem> hopedagensByCity(String cidade) {

		String sql = "SELECT * FROM hospedagem WHERE cidade=?";

		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cidade);
			
			rset = pstm.executeQuery();

			while (rset.next()) {

				Hospedagem hospedagem = new Hospedagem();

				hospedagem.setNome(rset.getString("nome"));
				hospedagem.setTipo(rset.getString("tipo"));
				hospedagem.setCidade(rset.getString("cidade"));
				hospedagem.setUf(rset.getString("uf"));
				hospedagem.setPreco(rset.getDouble("preco_dia"));
				hospedagem.setCnpj(rset.getString("cnpj_hos"));

				hospedagens.add(hospedagem);
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
		return hospedagens;
	}

	public Hospedagem hospedagemByCNPJ(String cnpj) {
		String sql = "SELECT * FROM hospedagem WHERE cnpj_hos=?";

		ResultSet rset = null;

		Hospedagem hospedagem = new Hospedagem();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cnpj);
			rset = pstm.executeQuery();

			rset.next();

			hospedagem.setNome(rset.getString("nome"));

			hospedagem.setTipo(rset.getString("tipo"));

			hospedagem.setCidade(rset.getString("cidade"));

			hospedagem.setUf(rset.getString("uf"));

			hospedagem.setPreco(rset.getDouble("preco_dia"));

			hospedagem.setCnpj(rset.getString("cnpj_hos"));

			

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
		return hospedagem;
	}

}
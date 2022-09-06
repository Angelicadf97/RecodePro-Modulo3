package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Destino;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {

		String sql = "INSERT INTO destino(cidade, uf, id_des)" + " VALUE(?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getCidade());

			pstm.setString(2, destino.getUf());

			pstm.setInt(3, destino.getId());

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

	public void removeByIdDes(int id) {

		String sql = "DELETE FROM destino WHERE ID_Des=?";

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
	
	public void update(Destino destino) {

		String sql = "UPDATE destino SET cidade = ?, uf = ?" + "WHERE id_des=?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getCidade());
			
			pstm.setString(2, destino.getUf());
			
			pstm.setInt(3, destino.getId());

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

	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Destino destino = new Destino();

				destino.setCidade(rset.getString("Cidade"));

				destino.setUf(rset.getString("UF"));

				destino.setId(rset.getInt("ID_Des"));
				;

				destinos.add(destino);
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
		return destinos;
	}

	public List<Destino> destinosByUf(String uf) {

		String sql = "SELECT * FROM destino WHERE UF=?";

		List<Destino> destinos = new ArrayList<Destino>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, uf);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Destino destino = new Destino();

				destino.setCidade(rset.getString("Cidade"));

				destino.setId(rset.getInt("ID_Des"));
				;

				destinos.add(destino);
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
		return destinos;
	}

	public Destino destinoById(int id) {

		String sql = "SELECT * FROM destino WHERE id_des=?";

		ResultSet rset = null;

		Destino destino = new Destino();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			destino.setCidade(rset.getString("cidade"));

			destino.setUf(rset.getString("uf"));

			destino.setId(rset.getInt("id_des"));
			;

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
		return destino;
	}
}
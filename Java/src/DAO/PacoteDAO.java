package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Cliente;
import objetos.Pacote;

public class PacoteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Pacote pacote) {

		String sql = "INSERT INTO pacote(id_pac, cpf_cli, total)" + " VALUE(?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pacote.getId());

			pstm.setString(2, pacote.getCliente().getCpf());

			pstm.setDouble(3, pacote.getTotal());

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

		String sql = "DELETE FROM pacote WHERE id_pac=?";

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

	public void update(Pacote pacote) {

		String sql = "UPDATE pacote SET id_cli = ?, total = ?" + "WHERE id_pac=?";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pacote.getCliente().getCpf());

			pstm.setDouble(2, pacote.getTotal());

			pstm.setInt(3, pacote.getId());

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

	public List<Pacote> getPacotes() {

		String sql = "SELECT * FROM pacote";

		List<Pacote> pacotes = new ArrayList<Pacote>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Pacote pacote = new Pacote();
				Cliente cliente = new Cliente();

				pacote.setId(rset.getInt("id_pac"));

				pacote.setTotal(rset.getDouble("total"));

				cliente.setCpf(rset.getString("cpf_cli"));
				
				pacote.setCliente(cliente);

				pacotes.add(pacote);
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
		return pacotes;
	}

	public Pacote pacoteById(int id) {
		String sql = "SELECT * FROM pacote WHERE id_pac=?";

		ResultSet rset = null;

		Pacote pacote = new Pacote();
		
		Cliente cliente = new Cliente();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			pacote.setId(rset.getInt("id_pac"));

			pacote.setTotal(rset.getDouble("total"));

			cliente.setCpf(rset.getString("cpf_cli"));
			
			pacote.setCliente(cliente);


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
		return pacote ;
	}
	
	public List<Pacote> PacoteByCli(String cpf) {

		String sql = "SELECT * FROM pacote WHERE cpf_cli=?";

		List<Pacote> pacotes = new ArrayList<Pacote>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cpf);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Pacote pacote = new Pacote();
				Cliente cliente = new Cliente();

				pacote.setId(rset.getInt("id_pac"));

				pacote.setTotal(rset.getDouble("total"));

				cliente.setCpf(rset.getString("cpf_cli"));
				
				pacote.setCliente(cliente);

				pacotes.add(pacote);
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
		return pacotes;
	}

}
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import objetos.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente(cpf_cli, nome, data_nasc, genero, telefone, endereco, uf, email, senha)" + " VALUE(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getCpf());

			pstm.setString(2, cliente.getNome());

			pstm.setString(3, cliente.getDataNasc());

			pstm.setString(4, cliente.getGenero());

			pstm.setString(5, cliente.getTelefone());

			pstm.setString(6, cliente.getEndereco());

			pstm.setString(7, cliente.getUf());

			pstm.setString(8, cliente.getEmail());

			pstm.setString(9, cliente.getSenha());

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

	public void removeByCPF(String cpf) {

		String sql = "DELETE FROM cliente WHERE cpf_cli=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cpf);

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

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET nome = ?, data_nasc = ?, genero = ?, telefone = ?, endereco = ?, uf = ?, email = ?, senha = ?" + "WHERE cpf_cli=?";

		try {
			
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());

			pstm.setString(2, cliente.getDataNasc());

			pstm.setString(3, cliente.getGenero());

			pstm.setString(4, cliente.getTelefone());

			pstm.setString(5, cliente.getEndereco());

			pstm.setString(6, cliente.getUf());

			pstm.setString(7, cliente.getEmail());

			pstm.setString(8, cliente.getEmail());

			pstm.setString(9, cliente.getCpf());

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

	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Cliente cliente = new Cliente();

				cliente.setCpf(rset.getString("cpf_cli"));

				cliente.setNome(rset.getString("nome"));

				cliente.setDataNasc(rset.getString("data_nasc"));

				cliente.setGenero(rset.getString("genero"));

				cliente.setTelefone(rset.getString("telefone"));

				cliente.setEndereco(rset.getString("endereco"));

				cliente.setUf(rset.getString("uf"));

				cliente.setEmail(rset.getString("email"));

				cliente.setSenha(rset.getString("senha"));

				clientes.add(cliente);
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
		return clientes;
	}

	public Cliente clienteByCPF(String cpf) {
		String sql = "SELECT * FROM cliente WHERE CPF_CLI=?";

		ResultSet rset = null;

		Cliente cliente = new Cliente();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			rset = pstm.executeQuery();

			rset.next();
			
			cliente.setCpf(rset.getString("cpf_cli"));

			cliente.setNome(rset.getString("nome"));

			cliente.setDataNasc(rset.getString("data_nasc"));

			cliente.setGenero(rset.getString("genero"));

			cliente.setTelefone(rset.getString("telefone"));

			cliente.setEndereco(rset.getString("endereco"));

			cliente.setUf(rset.getString("uf"));

			cliente.setEmail(rset.getString("email"));

			cliente.setSenha(rset.getString("senha"));

			

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
		return cliente;
	}

}

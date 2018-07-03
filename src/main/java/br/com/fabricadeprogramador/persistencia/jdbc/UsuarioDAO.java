package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConection();

	public void cadastrar(Usuario usuario) {

		String sql = "insert into usuario(nome, login, senha) values(?, ?, ?);";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			// Executando o SQL no banco
			preparador.execute();
			// fechando o preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome= ?, login= ?, senha= ? where id= ? ;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			// Executando o SQL no banco
			preparador.execute();
			// fechando o preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(Usuario usu) {

		String sql = "delete from usuario where id= ? ;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());
			// Executando o SQL no banco
			preparador.execute();
			// fechando o preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			alterar(usuario);
		} else
			cadastrar(usuario);
	}

	/**
	 * Busca um registro pelo id do usuario
	 * 
	 * @param id
	 *            é um inteiro que representa o numero do id do usuario
	 * @return retorna nulo quando não encontra o registro, e um objeto usuario
	 *         quando encontra
	 */
	public Usuario buscarPorId(Integer id) {

		String sql = "select * from usuario where id= ? ;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();
			// posicionando o cursor no primeiro registro
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;

			}
			preparador.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * realiza a busca de todos os objetos de usuario  	
	 * @return uma lista de objetos usuario contendo 0 elementos quando não  tiver registro ou n elementos
	 * quando tiver resultado.
	 */
	public List<Usuario> buscarTodos() {

		String sql = "select * from usuario ;";
		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();
			// posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				//adiciona usuario na lista 
				lista.add(usuario);
				

			}
			preparador.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

}

package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		//Executando o SQL no banco
		preparador.execute();
		//fechando o preparador
		preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

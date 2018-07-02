package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {
	
	public static void main(String[] args) {
		
		Usuario usu = new Usuario();
		usu.setNome("Jaozao");
		usu.setLogin("jzao");
		usu.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("cadastrado !");
		
		
	}

}

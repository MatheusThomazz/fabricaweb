package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {

		testeexcluir();

	}

	public static void testeAlterar() {
		Usuario usu = new Usuario();
		usu.setId(1);
		usu.setNome("Jaozao da silva");
		usu.setLogin("jzaoss");
		usu.setSenha("123345");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado !");

	}

	public static void testeCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Jaozao");
		usu.setLogin("jzao");
		usu.setSenha("123");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("cadastrado !");

	}

	public static void testeexcluir() {
		Usuario usu = new Usuario();
		usu.setId(1);
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("excluido !");

	}

}

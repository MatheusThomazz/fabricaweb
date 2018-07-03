package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {

		buscartodos();

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
	
	public static void testeSalvar() {
		Usuario usuario = new Usuario();
		usuario.setId(null);
		usuario.setNome("Marcos");
		usuario.setLogin("Macoss");
		usuario.setSenha("465");
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("cadastrado ou alterado com sucesso");
		
	}
	
	public static void buscarPorId() {
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.buscarPorId(2);
		System.out.println(usuario);
		
	}
	
public static void buscartodos() {
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> lista = usuDAO.buscarTodos();
		for(Usuario u: lista) {
			System.out.println(u);
		}
		
		
	}

}

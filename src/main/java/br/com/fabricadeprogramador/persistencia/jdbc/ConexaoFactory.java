package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fabricaweb"
					, "root", "admin");
		} catch (SQLException e) {
			//relançando a exception
			throw new RuntimeException(e);
		}
	}

}

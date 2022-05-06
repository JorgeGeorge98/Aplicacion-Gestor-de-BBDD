package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	
	private String url = "jdbc:mysql://localhost/world";
	private String usuario = "admin";
	private String contrasenia ="123";
	
	public Connection conectar() {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, "root", "");
			
			if(con != null) {
				System.out.println("Conectado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("Desconectado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}

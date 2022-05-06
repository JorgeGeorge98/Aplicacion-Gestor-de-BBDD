package gestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ConexionMySQL conexion = new ConexionMySQL();
		Gestor gestor = new Gestor();
		
		boolean usuarioCorrecto = false, contCorrecta = false, salir = false;
		int tabla;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*---------BIENVENIDO AL GESTOR DE BASE DE DATOS---------*");
		
		//Comprobar usuario y contraseña
		while(!usuarioCorrecto) {
			System.out.println("Introduzca nombre de usuario: ");
			String usuarioInput = scan.next();
			if(usuarioInput.equals(conexion.getUsuario())) {
				usuarioCorrecto = true;
			} else {
				System.out.println("Usuario incorrecto, intente de nuevo.");
			}
		}
		
		while(!contCorrecta) {
			System.out.println("Introduzca contraseña: ");
			String contInput = scan.next();
			if(contInput.equals(conexion.getContrasenia())) {
				contCorrecta = true;
			} else {
				System.out.println("Contraseña incorrecta, intente de nuevo.");
			}
		}
		
		//Se elije la tabla
		tabla = gestor.elegirTabla();
		if(tabla == 0) {
			System.out.println("Fatal error x_x");
			return;
		}
		
		//Menu
		while(!salir) {
			try {
				System.out.println("\n(1). Ingresar datos\n(2). Consulta general\n(3). Consultar dato determinado\n(4). Actualizacion de regsitro\n(5). Eliminacion de regsitro\n(0)Salir de la aplicacion\n\nQue gestion desea realizar: ");
				int opcion = scan.nextInt();
				
				switch(opcion) {
				case 1:
					gestor.insert(tabla);
					break;
				case 2:
					gestor.selectAll(tabla);
					break;
				case 3:
					System.out.println();
				case 4:
					System.out.println();
				case 5:
					System.out.println();
				case 0:
					System.out.println("Hasta luego!");
					salir = true;
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Fatal error x_x");
				return;
			}
		}

	}

}

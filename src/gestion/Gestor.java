package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Gestor {
	
	public int elegirTabla() {
		Scanner scan = new Scanner(System.in);
		
		boolean eleccionCorrecta  = false;
		int eleccion = 0;
		
		while(!eleccionCorrecta) {
			try {
				System.out.println("1. \"City\"\n2. \"Country\"\n3. \"CountryLanguage\"\nElija la tabla con la que desea trabajar: ");
				eleccion = scan.nextInt();
				
				switch(eleccion) {
				case 1:
					eleccionCorrecta = true;
					break;
				case 2:
					eleccionCorrecta = true;
					break;
				case 3:
					eleccionCorrecta = true;
					break;
				default:
					System.out.println("Elija una opcion valida");
					break;
				}
			} catch (Exception e) {
				return 0;
			}
		}
		return eleccion;
	}
	
	//1
	public void insert(int tabla) {
		Scanner scan = new Scanner(System.in);
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.conectar();
		
		String insert;
		
		switch(tabla) {
		case 1:
			System.out.println("Introduzca el valor 'ID': ");
			String id = scan.next();
			System.out.println("Introduzca el valor 'Name': ");
			String name = scan.next();
			System.out.println("Introduzca el valor 'Country Code': ");
			String countryCode = scan.next();
			System.out.println("Introduzca el valor 'District': ");
			String district = scan.next();
			System.out.println("Introduzca el valor 'Population': ");
			String population = scan.next();
			
			try {
				Statement s = con.createStatement();
				
				insert = "INSERT INTO `city` VALUES ("+id+", '"+name+"', '"+countryCode+"', '"+district+"', "+population+")";
				
				s.execute(insert);
				
				System.out.println("Registro insertado correctamente.");
			} catch (Exception e) {
				System.out.println("Error al insertar");
			} finally {
				conexion.desconectar(con);
			}
			break;
		case 2:
			System.out.println("Introduzca el valor 'Code': ");
			String code = scan.next();
			System.out.println("Introduzca el valor 'Name': ");
			name = scan.next();
			System.out.println("Introduzca el valor 'Continent': ");
			String continent = scan.next();
			System.out.println("Introduzca el valor 'Region': ");
			String region = scan.next();
			System.out.println("Introduzca el valor 'SurfaceArea': ");
			String surfArea = scan.next();
			System.out.println("Introduzca el valor 'IndepYear': ");
			String indepYear = scan.next();
			System.out.println("Introduzca el valor 'Population': ");
			population = scan.next();
			System.out.println("Introduzca el valor 'LifeExpectancy': ");
			String lifeExp = scan.next();
			System.out.println("Introduzca el valor 'GNP': ");
			String gnp = scan.next();
			System.out.println("Introduzca el valor 'GNPOld': ");
			String gnpOld = scan.next();
			System.out.println("Introduzca el valor 'LocalName': ");
			String localName = scan.next();
			System.out.println("Introduzca el valor 'GovernmentForm': ");
			String govForm = scan.next();
			System.out.println("Introduzca el valor 'HeadOfState': ");
			String hos = scan.next();
			System.out.println("Introduzca el valor 'Capital': ");
			String capital = scan.next();
			System.out.println("Introduzca el valor 'Code2': ");
			String code2 = scan.next();
			
			try {
				Statement s = con.createStatement();
				
				insert = "INSERT INTO `country` VALUES ('"+code+"', '"+name+"', "+continent+", '"+region+"', "+surfArea+", "+indepYear+", "+population+", "+lifeExp+", "+gnp+", "+gnpOld+", '"+localName+"', '"+govForm+"', '"+hos+"', "+capital+", '"+code2+"')";
				
				s.execute(insert);
				
				System.out.println("Registro insertado correctamente.");
			} catch (Exception e) {
				System.out.println("Error al insertar");
			} finally {
				conexion.desconectar(con);
			}
			break;
		case 3:
			System.out.println("Introduzca el valor 'CountryCode': ");
			countryCode = scan.next();
			System.out.println("Introduzca el valor 'Language': ");
			String lang = scan.next();
			System.out.println("Introduzca el valor 'isOfficial': ");
			String isOfficial = scan.next();
			System.out.println("Introduzca el valor 'Percentage': ");
			String percentage = scan.next();
			
			try {
				Statement s = con.createStatement();
				
				insert = "INSERT INTO `countrylanguage` VALUES ('"+countryCode+"', '"+lang+"', "+isOfficial+", "+percentage+")";
				
				s.execute(insert);
				
				System.out.println("Registro insertado correctamente.");
			} catch (Exception e) {
				System.out.println("Error al insertar");
			} finally {
				conexion.desconectar(con);
			}
			break;
		}
	}
	
	//2
	public void selectAll(int tabla) {
		
		Scanner scan = new Scanner(System.in);
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.conectar();
		
		String consulta;
		
		switch(tabla) {
		case 1:
			try {
			
				Statement s = con.createStatement();
				
				consulta  = "SELECT * FROM `city`";
				
				ResultSet rs = s.executeQuery(consulta); 
				
				while(rs.next()) {
					System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5));
				}
				
			} catch (Exception e) {
				e.getStackTrace();
			} finally {
				conexion.desconectar(con);
			}
			break;
		case 2:
			try {
				
				Statement s = con.createStatement();
				
				consulta  = "SELECT * FROM `country`";
				
				ResultSet rs = s.executeQuery(consulta); 
				
				while(rs.next()) {
					System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)+", "+rs.getString(7)+", "+rs.getString(8)+", "+rs.getString(9)+", "+rs.getString(10)+", "+rs.getString(11)+", "+rs.getString(12)+", "+rs.getString(13)+", "+rs.getString(14)+", "+rs.getString(15));
				}
				
			} catch (Exception e) {
				e.getStackTrace();
			} finally {
				conexion.desconectar(con);
			}
			break;
		case 3:
			try {
				
				Statement s = con.createStatement();
				
				consulta  = "SELECT * FROM `country`";
				
				ResultSet rs = s.executeQuery(consulta); 
				
				while(rs.next()) {
					System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));
				}
				
			} catch (Exception e) {
				e.getStackTrace();
			} finally {
				conexion.desconectar(con);
			}
			break;
		}
	}
}

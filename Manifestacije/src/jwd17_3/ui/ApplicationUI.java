package jwd17_3.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import rs.ac.uns.ftn.jwts.prvenstva.ui.ScannerWrapper;



public class ApplicationUI {
	
	public static Connection conn;

	static {
		try {				
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.55.33:3306/jwd17_3", "jwd17_3", "jwd17_3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		int odluka = -1;
		while (odluka != 0) {
			ApplicationUI.ispisiMenu();

			System.out.print("opcija:");
			odluka = ScannerWrapper.ocitajCeoBroj();

			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}

	}
	
	public static void ispisiMenu() {
		System.out.println(" - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - ");
		System.out.println("\tOpcija broj 2 - ");
		System.out.println("\tOpcija broj 3 - ");
		System.out.println("\tOpcija broj 4 - ");			
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

}

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
					"jdbc:mysql://localhost:3306/manifestacije", "root", "aop1");
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
				GradUI.prikaziSveGradove();
				break;
			case 2:
				ManifestacijaUI.prikaziSveManifestacije();
				break;
			case 3:				
				System.out.println(ManifestacijaUI.pronadjiManifestaciju());
				break;
			case 4:
				ManifestacijaUI.izmeniNazivManifestacije();
				break;
			case 5:
				ManifestacijaUI.izmeniManifestaciju();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}

	}
	
	public static void ispisiMenu() {
		System.out.println(" - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Prikazi sve gradove");
		System.out.println("\tOpcija broj 2 - Prikazi sve manifestacije");
		System.out.println("\tOpcija broj 3 - Pronadji manifestaciju");
		System.out.println("\tOpcija broj 4 - Izmena naziva manifestacije");
		System.out.println("\tOpcija broj 5 - Izmena podataka o manifestaciji");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

}

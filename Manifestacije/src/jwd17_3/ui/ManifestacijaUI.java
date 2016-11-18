package jwd17_3.ui;

import java.util.ArrayList;

import jwd17_3.dao.GradDao;
import jwd17_3.dao.ManifestacijaDao;
import jwd17_3.model.Grad;
import jwd17_3.model.Manifestacija;
import rs.ac.uns.ftn.jwts.prvenstva.ui.ScannerWrapper;

public class ManifestacijaUI {
	
	public static void prikaziSveManifestacije() {
		ArrayList<Manifestacija> sveManifestacije = ManifestacijaDao.getAll(ApplicationUI.conn);
		for (Manifestacija manifest : sveManifestacije) {
			System.out.println(manifest);
		}		
	}
	
	public static Manifestacija pronadjiManifestaciju(int id) {
		Manifestacija retVal = ManifestacijaDao.getManifestacijaById(ApplicationUI.conn, id);
		return retVal;
	}
	
	public static Manifestacija pronadjiManifestaciju() {
		Manifestacija retVal = null;
		System.out.println("Unesi id manifestacije: ");
		int id = ScannerWrapper.ocitajCeoBroj();
		retVal = pronadjiManifestaciju(id);
		if (retVal == null) {
			System.out.println("Ne postoji Manifestacija sa id: " + id);
		}
		return retVal;
	}
	
	public static void izmeniNazivManifestacije() {
		Manifestacija manif = pronadjiManifestaciju();
		if (manif != null) {
			System.out.println("Unesi novi naziv: ");
			String nazivNovi = ScannerWrapper.ocitajTekst();
			manif.setNazivMan(nazivNovi);
			ManifestacijaDao.updateNazivManifestacije(ApplicationUI.conn, manif);
		}
	}
	
	public static void izmeniManifestaciju() {
		Manifestacija manif = pronadjiManifestaciju();
		if (manif != null) {
			System.out.println("Unesi novi naziv: ");
			String nazivNovi = ScannerWrapper.ocitajTekst();
			manif.setNazivMan(nazivNovi);
			System.out.println("Unesi novi br posetilaca: ");
			int brojNovi = ScannerWrapper.ocitajCeoBroj();
			manif.setBrPos(brojNovi);
			System.out.println("Unesi novi grad: ");
			int gradNovi = ScannerWrapper.ocitajCeoBroj();
			Grad grad = GradDao.getGradById(ApplicationUI.conn, gradNovi);
			manif.setGrad(grad);
			ManifestacijaDao.updateManifestacije(ApplicationUI.conn, manif);
		}
	}

}

package jwd17_3.ui;

import java.util.ArrayList;

import jwd17_3.dao.GradDao;
import jwd17_3.model.Grad;

public class GradUI {
	
	public static void prikaziSveGradove() {
		ArrayList<Grad> sviGradovi = GradDao.getAll(ApplicationUI.conn);
		for (Grad grad : sviGradovi) {
			System.out.println(grad);
		}
	}

}

package jwd17_3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jwd17_3.model.Grad;
import jwd17_3.model.Manifestacija;

public class ManifestacijaDao {
	
	public static ArrayList<Manifestacija> getAll(Connection conn) {
		ArrayList<Manifestacija> retVal = new ArrayList<Manifestacija>();		
		try {
			String query = "SELECT m.id, m.nazivman, m.brpos, m.grad_ptt, g.naziv FROM manifestacija m "
					+ "LEFT JOIN grad g ON m.grad_ptt = g.ptt";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				int id = rset.getInt(1);
				String nazivMan = rset.getString(2);
				int brojPos = rset.getInt(3);
				int gradPtt = rset.getInt(4);	
				String nazivGr = rset.getString(5);
				Grad grad = new Grad(gradPtt, nazivGr);
				Manifestacija manif = new Manifestacija(id, nazivMan, brojPos, grad);
				retVal.add(manif);
			}
			stmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static Manifestacija getManifestacijaById(Connection conn, int id) {
		Manifestacija retVal = null;
		try {
			String query = "SELECT nazivman, brpos, grad_ptt FROM manifestacija WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				String nazivMan = rset.getString(1);
				int brojPos = rset.getInt(2);
				int gradPtt = rset.getInt(3);
				Grad grad = GradDao.getGradById(conn, gradPtt);
				retVal = new Manifestacija(id, nazivMan, brojPos, grad);
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static boolean updateNazivManifestacije(Connection conn, Manifestacija manif) {
		boolean retVal = false;
		try {
			String query = "UPDATE manifestacija SET nazivman = ? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manif.getNazivMan());
			pstmt.setInt(2, manif.getId());
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Uspesna izmena");				
			} else {
				System.out.println("Neuspesna izmena");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static boolean updateManifestacije(Connection conn, Manifestacija manif) {
		boolean retVal = false;
		try {
			String query = "UPDATE manifestacija SET nazivman = ?, brpos = ?, grad_ptt = ? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manif.getNazivMan());
			pstmt.setInt(2, manif.getBrPos());
			pstmt.setInt(3, manif.getGrad().getPtt());
			pstmt.setInt(4, manif.getId());
			if (pstmt.executeUpdate() == 1) {
				retVal = true;
				System.out.println("Uspesna izmena");				
			} else {
				System.out.println("Neuspesna izmena");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}

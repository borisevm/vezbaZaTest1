package jwd17_3.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jwd17_3.model.Grad;

public class GradDao {
	
	public static ArrayList<Grad> getAll(Connection conn) {
		ArrayList<Grad> retVal = new ArrayList<Grad>();		
		try {
			String query = "SELECT ptt, naziv FROM grad";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				int id = rset.getInt(1);
				String naziv = rset.getString(2);
				Grad grad = new Grad(id, naziv);
				retVal.add(grad);
			}
			stmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static Grad getGradById(Connection conn, int id) {
		Grad retVal = null;
		try {
			String query = "SELECT naziv FROM grad WHERE ptt = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				retVal = new Grad(id, rset.getString(1));
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

}

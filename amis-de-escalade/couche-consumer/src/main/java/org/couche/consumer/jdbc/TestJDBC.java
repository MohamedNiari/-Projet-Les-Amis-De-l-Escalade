package org.couche.consumer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Test de connexion à la base de donnée
 */
public class TestJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/escalade?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String user = "openclassroom";
		String pass = "openclassroom";
		
		System.out.println("Connexion à la base de donnée : " + url);
		
		try {
			Connection myConn =
					DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Connexion réussi!!!");

	}

}

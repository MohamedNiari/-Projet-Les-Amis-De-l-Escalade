package org.couche.webapp.test;

public class test {

	public static void main(String[] args) {
		
		System.out.println(InscriptionForm.CHAMP_EMAIL.contains("o"));

	}
	
	public final class InscriptionForm {
	    private static final String CHAMP_EMAIL  = "email";
	    private static final String CHAMP_PASS   = "motdepasse";
	    private static final String CHAMP_CONF   = "confirmation";
	    private static final String CHAMP_NOM    = "nom";

	   
	}

}

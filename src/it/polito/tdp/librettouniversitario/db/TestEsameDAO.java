package it.polito.tdp.librettouniversitario.db;

import it.polito.tdp.librettouniversitario.model.Esame;

public class TestEsameDAO {

	public static void main(String[] args) {
	EsameDAO dao= new EsameDAO();
	
	Esame e1= dao.find("03FYZ");
	System.out.println(e1);
	
	Esame e2= dao.find("099www");
	System.out.println(e2);
	
	
	

	}

}

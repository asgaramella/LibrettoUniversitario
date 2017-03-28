package it.polito.tdp.librettouniversitario.model;

import java.util.*;

import it.polito.tdp.librettouniversitario.db.EsameDAO;

public class Model {
	private List<Esame> esami;

	public Model() {
		super();
		this.esami=new ArrayList<Esame>();
	}
	/**
	 * Aggiungo un nuovo esame all'elenco degli esami presenti,
	 * verificando non ci sia già non posso inserirlo:
	 * 1) SILENT FAILURE (non metto niente in else)
	 * 2) ritorno boolean se op a buon fine true, altrimenti false
	 * 3) eccezione
	 * 
	 */
	 
	public boolean addEsame(Esame e){
		EsameDAO dao=new EsameDAO();
		
		return dao.create(e);
			
			
	}
	
	/**
	 * Ricerca se esiste esame con codice specificato,
	 * se esite lo restituisce
	 * altrimenti restituisce null
	 * @param codice esame da cercare
	 * @return esame trovato o null
	 */
	public  Esame trovaEsame(String codice){
		EsameDAO dao=new EsameDAO();
		
		Esame e= dao.find(codice);
		
		return e;
       
	}
	

}

package it.polito.tdp.librettouniversitario.model;

import java.util.*;

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
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}
		else
			return false;
			
	}
	
	/**
	 * Ricerca se esiste esame con codice specificato,
	 * se esite lo restituisce
	 * altrimenti restituisce null
	 * @param codice esame da cercare
	 * @return esame trovato o null
	 */
	public  Esame trovaEsame(String codice){
        int pos=esami.indexOf(new Esame(codice,null,null));
		if(pos==-1)
			return null;
		else
			return esami.get(pos);
	
	}
	

}

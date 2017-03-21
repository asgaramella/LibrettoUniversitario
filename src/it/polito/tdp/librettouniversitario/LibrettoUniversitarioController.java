package it.polito.tdp.librettouniversitario;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.librettouniversitario.model.Esame;
import it.polito.tdp.librettouniversitario.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoUniversitarioController {
	//non è il controllore che crea il modello  ma MAIN perchè
	// nel caso ci siano più controllori devono lavorare su un unico modello
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice=txtCodice.getText();
    	
    	if(codice.length()<5){
    		txtMessage.appendText("Codice non valido\n");
    		return;
    	}
    	
    	Esame e=model.trovaEsame(codice);
    	
    	if(e==null)
    		txtMessage.appendText("Codice "+codice+" non trovato\n");
    	else{
    		txtMessage.appendText("Codice "+codice+" trovato\n");
    		
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    		
    	}
    }

    
    
    @FXML
    void handleInserisci(ActionEvent event) {
    	//recupera i dati dalla vista getText non ritorna mai null,ma al max stringa vuota
    	String codice=txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente= txtDocente.getText();
    	
    	
    	
    	
    	//verifica validità dei dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esame insufficienti\n");
    		return;
    	}
    	
    	//chiedi al Model di effettuare operazione
    	Esame e=new Esame(codice,titolo,docente);
    	boolean result=model.addEsame(e);
    	
    	
    	//aggiorna vista con risultato operazione
    	if(result)
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	else
    		txtMessage.appendText("Esame no aggiunto(codice duplicato)\n");

    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}


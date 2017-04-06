package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtImput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private TextArea txtErrato;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	String daCercare = txtImput.getText() ;
    	Set<Anagramma> anagrammi = model.cercaAnagramma(daCercare);
    	for(Anagramma a : anagrammi){
    		if(a.isCorretta()== true)
    			txtCorretto.appendText(a.toString()+"\n");
    		else
    			txtErrato.appendText(a.toString()+"\n");
    	}
    	
    }
    	
    

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretto.clear();
    	txtImput.clear();
    	txtErrato.clear();
    }

    @FXML
    void initialize() {
        assert txtImput != null : "fx:id=\"txtImput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrato != null : "fx:id=\"txtErrato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    void setModel(Model model){
    	this.model = model;
    }
}

package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;

import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FXMLController {
	private AlienDictionary dizionario;

	public AlienDictionary getDizionario() {
		return dizionario;
	}

	public void setDizionario(AlienDictionary dizionario) {
		this.dizionario = dizionario;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnTranslate;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtInserisci;

	@FXML
	private TextArea txtRisultato;

	@FXML
	void doTranslate(ActionEvent event) {

		String array[] = txtInserisci.getText().split(" ");

		if (array.length == 2) {
			try {
				dizionario.addWord(array[0], array[1]);
			} catch (InvalidParameterException e) {
				txtRisultato.appendText(e.getMessage());
				return;
			}
			txtRisultato.appendText("Parola aggiunta al dizionario\n");
		}

		if (array.length == 1) {
			String s = "";
			try {
				s = dizionario.translateWord(array[0]);
			} catch (InvalidParameterException e) {
				txtRisultato.appendText(e.getMessage());
				return;
			}

			txtRisultato.appendText(s);
		}
	}

	@FXML
	void doReset(ActionEvent event) {
		txtRisultato.clear();
		dizionario.reset();
	}

	@FXML
	void initialize() {
		assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
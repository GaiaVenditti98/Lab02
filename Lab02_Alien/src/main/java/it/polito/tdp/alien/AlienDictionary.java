package it.polito.tdp.alien;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class AlienDictionary {
	private List<WordEnhanced> elencoParole = new LinkedList<>();

	public void addWord(String alienWord, String translation) {

		if (!controllaParola(translation) || !controllaParola(alienWord))
			throw new InvalidParameterException("La parola non può contenere numeri!\n");
		for (WordEnhanced w : elencoParole) {
			if (w.equals(alienWord)) {
				w.addTranslation(translation);
				return;
			}
		}
		WordEnhanced nW = new WordEnhanced(alienWord.toLowerCase());
		nW.addTranslation(translation.toLowerCase());

		elencoParole.add(nW);

	}

	public String translateWord(String alienWord) {
		String s = null;
		String c="";
		if (parolaPuntoInterrogativo(alienWord) != null) {
			for (WordEnhanced w:parolaPuntoInterrogativo(alienWord))
				c += w.getTranslation();
			
			return c;
		}
			
		if (!controllaParola(alienWord))
			throw new InvalidParameterException("La parola non può contenere numeri!\n");

		
		for (WordEnhanced w : elencoParole) {
			if (w.equals(alienWord))
				s = w.getTranslation();
		}
		return s;
	}

	public void reset() {
		elencoParole.clear();

	}

	public boolean controllaParola(String s) {

		return s.matches("[a-zA-Z]*");
		

	}
	
	 /**
	  * se la parola contiene un punto interrogativo sostituisce il punto interrogativo con un . perchè
	  * il "." funziona come un wildcard che matcha qualsiasi carattere. Effettua quindi il match e ritorna l'insieme di parole nel dizionario
	  * con cui la parola passata come parametro matcha

	  * @param parola
	  * @return
	  */

	public LinkedList<WordEnhanced> parolaPuntoInterrogativo(String parola) {
		 LinkedList<WordEnhanced> parole=new  LinkedList<WordEnhanced>();
		
		if (parola.matches("[a-zA-Z?]*") && !parola.matches("[a-zA-Z]*")) {
			
			parola=parola.replace('?', '.');
			
			for (WordEnhanced w : elencoParole) {
				if (Pattern.matches(parola, w.getAlienWord())) {
					System.out.println("sisisi");
					parole.add(w);
				}

			}
			System.out.println(parole.size());
			return parole;
		}

		
		return null;
	}

	
}

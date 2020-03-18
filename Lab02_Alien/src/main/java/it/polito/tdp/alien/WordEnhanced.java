package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {
	private String alienWord;
	private List<String> translation;
	
	/**
	 * Costruttore di una nuova parola del dizionario
	 * @param alienWord
	 * @param translation
	 */
	
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		translation=new LinkedList<String>();
		
	}
	public String getAlienWord() {
		return alienWord;
	}
	public String getTranslation() {
		String s="";
		if (translation.size()>1)
		 s="Più traduzioni della stessa parola aliena ' "+ this.alienWord+"' :\n";
		for (String ci:translation)
			s+=ci+"\n";
		return s;
	}
	
	public boolean equals(String s){
		if (s.toUpperCase().compareTo(this.alienWord.toUpperCase())==0)
			return true;
		return false;
		
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public void addTranslation(String translation) {
		this.translation.add(translation);
	}
	
	
	
	
	
	

}

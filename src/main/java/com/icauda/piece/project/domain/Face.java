package com.icauda.piece.project.domain;


// Interface implementee par SimpleFace.java
public interface Face {

	// Noms des methodes necessaires a surcharger
	public String toString();
	
	String getType();
	Integer getId_face();
	Integer getCouleur_R();
	Integer getCouleur_G();
	Integer getCouleur_B();
	
}

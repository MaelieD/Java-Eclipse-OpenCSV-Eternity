package com.icauda.piece.project.domain;

//Interface implementee par SimplePiece.java
public interface Piece {

	// Noms des methodes necessaires a surcharger
	public String toString();
	
	String getType();
	
	Integer getId_piece();
	
	Integer getId_gauche();
	
	Integer getId_haut();
	
	Integer getId_droite();
	
	Integer getId_bas();
}

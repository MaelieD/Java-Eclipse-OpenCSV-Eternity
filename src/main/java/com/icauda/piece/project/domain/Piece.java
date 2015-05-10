package com.icauda.piece.project.domain;

//Interface implementee par SimplePiece.java
public interface Piece {

	// Noms des methodes necessaires a surcharger
	public String toString();
	
	String getId_piece();
	
	Integer getId_haut();
	
	Integer getId_bas();
	
	Integer getId_gauche();
	
	Integer getId_droite();
}

package com.icauda.piece.project.domain;

public class SimplePiece implements Piece{

	private String type;
	private Integer id_piece;
	private Integer id_gauche;	
	private Integer id_haut;	
	private Integer id_droite;	
	private Integer id_bas;
		
	// Constructeur de SimplePiece
	public SimplePiece(String type, Integer id_piece, Integer id_gauche, Integer id_haut, Integer id_droite, Integer id_bas) {
		this.type = type;
		this.id_piece = id_piece;
		this.id_gauche = id_gauche;
		this.id_haut = id_haut;
		this.id_droite = id_droite;
		this.id_bas = id_bas;
	}

	// Conversion des attributs en chaine de caracteres
	public String toString() {
		return "("+id_gauche+id_haut+id_droite+id_bas+")";
	}
		
	// Getters/setters
	public String getType() {
		return type;
	}
	
	public Integer getId_piece(){
		return id_piece;
	}
	
	public Integer getId_gauche() {
		return id_gauche;
	}
	
	public Integer getId_haut() {
		return id_haut;
	}
	
	public Integer getId_droite() {
		return id_droite;
	}
	
	public Integer getId_bas() {
		return id_bas;
	}
}

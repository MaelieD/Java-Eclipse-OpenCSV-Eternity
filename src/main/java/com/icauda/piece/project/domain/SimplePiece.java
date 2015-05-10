package com.icauda.piece.project.domain;

public class SimplePiece implements Piece{

	private String id_piece;
	private Integer id_haut;	
	private Integer id_bas;	
	private Integer id_gauche;	
	private Integer id_droite;
		
	public SimplePiece(String id_piece, Integer id_haut, Integer id_bas, Integer id_gauche, Integer id_droite) {
		this.id_piece = id_piece;
		this.id_haut = id_haut;
		this.id_bas = id_bas;
		this.id_gauche = id_gauche;
		this.id_droite = id_droite;
	}
		
	public String toString() {
		return "("+id_haut+id_bas+id_gauche+id_droite+")";
	}
		
	// plus getters/setters
	public String getId_piece(){
		return id_piece;
	}
	
	public Integer getId_haut() {
		return id_haut;
	}
	
	public Integer getId_bas() {
		return id_bas;
	}
	
	public Integer getId_gauche() {
		return id_gauche;
	}
	
	public Integer getId_droite() {
		return id_droite;
	}
}

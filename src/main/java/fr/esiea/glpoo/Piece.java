package fr.esiea.glpoo;

import java.util.List;

public class Piece implements PieceDao {
	
	private int id_piece;
	private int id_haut;
	private int id_bas;
	private int id_gauche;
	private int id_droite;
	
	public Piece(int id_piece, int id_haut, int id_bas, int id_gauche, int id_droite) {
		this.id_piece = id_piece;
		this.id_haut = id_haut;
		this.id_bas = id_bas;
		this.id_gauche = id_gauche;
		this.id_droite = id_droite;
		
	}
	
	public List<Piece> findPieces() {
		final PieceDao pieceDao = new PieceDao();
		final List<Piece> pieces = pieceDao.findPieces();
		
		for (Piece piece : pieces) {
			System.out.println(piece);
		}
	}

	public int getId_piece() {
		return id_piece;
	}
	
	public int getId_haut() {
		return id_haut;
	}
	
	public int getId_bas() {
		return id_bas;
	}
	
	public int getId_gauche() {
		return id_gauche;
	}
	
	public int getId_droite() {
		return id_droite;
	}
	
}

package com.icauda.piece.project;

import java.util.List;

import com.icauda.piece.project.domain.SimplePiece;

public class TableauPiece {

	private static TableauPiece instance;
	public static String[][] tabPiece = new String[3][3];
	//private static JLabel[][] tabLabel = new JLabel[3][3];
	private int p = 0;
	
	private TableauPiece(List<SimplePiece> pieces) {
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				tabPiece[i][j] = pieces.get(p).toString();
				System.out.println("tab["+i+"]["+j+"] = "+ tabPiece[i][j]+" -> "+pieces.get(p)); // test
				p++;
			}
		}
	}
	
	public static TableauPiece getInstance(List<SimplePiece> pieces){
		if(instance == null)
			instance = new TableauPiece(pieces);
		return instance;
	}
	
}

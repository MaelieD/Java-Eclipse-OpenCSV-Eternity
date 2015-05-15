package com.icauda.piece.project;

public class Launcher {
	
    public static void main(String[] args) {
    	// CREATION FACES
    	
    	// Lancement de la recuperation des donnees dans le fichier piece.csv et les charger dans la Liste pieces
        /*final PieceDao pieceDao = new CsvPieceDao1();
        final List<SimplePiece> pieces = pieceDao.findAllPieces();

        // Affichage de la liste des pieces
        System.out.println("Liste des pieces");
        for (SimplePiece piece : pieces) {
            System.out.println(piece);
        }*/
        
        // CREATION PIECES
        
        // Lancement de la recuperation des donnees dans le fichier face.csv et les charger dans la Liste faces
        /*final FaceDao faceDao = new CsvFaceDao1();
        final List<SimpleFace> faces = faceDao.findAllFaces();

        // Affichage de la liste des faces
        System.out.println("Liste des faces");
        for (SimpleFace face : faces) {
            System.out.println(face);
        }*/
        
        // CREATION FENETRE
        /*try {
        	Frame fenetre = new Frame(pieces);
        } catch(Exception e) {
        	e.printStackTrace();
        }*/
        
        new JeuFrameListener();
    }
}

package com.icauda.piece.project.dao;

// Import de la methode readCsvFile contenue dans la classe CsvFileHelper pour l'utiliser
import static com.icauda.piece.project.dao.csv.CsvFileHelper.readCsvFile;

import java.util.ArrayList;
import java.util.List;

import com.icauda.piece.project.domain.SimplePiece;

public class CsvPieceDao1 implements PieceDao {

	// Informations concernant la syntaxe et le chemin du fichier .CSV
    private final static char SEPARATOR = ';';
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String PIECES_FILE_NAME = "piece.csv";

    // Surcharge de la methode de recherche des donnees
    @Override
    public List<SimplePiece> findAllPieces() {
    	// data : tableau de stockage des donnees brutes
        final List<String[] > data = readCsvFile(RESOURCES_PATH + PIECES_FILE_NAME, SEPARATOR);

        // faces : liste d'objets crees a partir des donnees brutes de data
        final List<SimplePiece> pieces = dataToPieces(data);

        // Renvoie la liste des objets nouvellement instancies
        return pieces;
    }

    // Methode qui cree la liste d'objets instancies a partir des donnees brutes de data
    private List<SimplePiece> dataToPieces(List<String[] > data) {
    	// Creation de la liste contenant les objets qui vont etre instancies ci-dessous
    	final List<SimplePiece> pieces = new ArrayList<SimplePiece>();

        try {           
            // Parcours des donnees brutes de data pour les stocker dans les variables adequates
            for (String[] oneData : data) {
            	final String type = oneData[0];
                final String id_piece = oneData[1];
                final String id_gauche = oneData[2];
                final String id_haut = oneData[3];
                final String id_droite = oneData[4];
                final String id_bas = oneData[5];

                // Conversion dans les types demandes : string to int
                final Integer idpiece = Integer.parseInt(id_piece);
                final Integer face_gauche = Integer.parseInt(id_gauche);
                final Integer face_haut = Integer.parseInt(id_haut);
                final Integer face_droite = Integer.parseInt(id_droite);
                final Integer face_bas = Integer.parseInt(id_bas);
     
                // Creation de l'objet grace aux variables obtenues ci-dessus
                final SimplePiece piece = new SimplePiece(type, idpiece, face_gauche, face_haut, face_droite, face_bas);
                // Ajout de l'objet dans la liste d'objets
                pieces.add(piece);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retourne la liste des objets nouvellement instancies
        return pieces;
    }
}

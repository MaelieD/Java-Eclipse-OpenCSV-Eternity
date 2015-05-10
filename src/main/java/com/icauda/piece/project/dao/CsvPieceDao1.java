package com.icauda.piece.project.dao;

import static com.icauda.piece.project.dao.csv.CsvFileHelper.readCsvFile;

//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icauda.piece.project.domain.SimplePiece;

public class CsvPieceDao1 implements PieceDao {

    private final static char SEPARATOR = ';';
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String PIECES_FILE_NAME = "piece.csv";

    @Override
    public List<SimplePiece> findAllPieces() {

        final List<String[] > data = readCsvFile(RESOURCES_PATH + PIECES_FILE_NAME, SEPARATOR);

        final List<SimplePiece> pieces = dataToPieces(data);

        return pieces;
    }

    private List<SimplePiece> dataToPieces(List<String[] > data) {
        final List<SimplePiece> pieces = new ArrayList<SimplePiece>();

        try {
            //final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            // Recuperation des donnees du .csv et stockage dans un tab oneData
            for (String[] oneData : data) {
                final String id_piece = oneData[0];
                final String id_haut = oneData[1];
                final String id_bas = oneData[2];
                final String id_gauche = oneData[3];
                final String id_droite = oneData[4];

                // Conversion dans les types demandes : string to int
                final Integer face_haut = Integer.parseInt(id_haut);
                final Integer face_bas = Integer.parseInt(id_bas);
                final Integer face_gauche = Integer.parseInt(id_gauche);
                final Integer face_droite = Integer.parseInt(id_droite);
     

                final SimplePiece piece = new SimplePiece(id_piece, face_haut, face_bas, face_gauche, face_droite);
                pieces.add(piece);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pieces;
    }
}

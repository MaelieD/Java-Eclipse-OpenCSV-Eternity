
package com.icauda.piece.project;

import java.util.List;

import com.icauda.piece.project.dao.*;
import com.icauda.piece.project.domain.*;

public class Launcher {

    public static void main(String[] args) {

        final PieceDao pieceDao = new CsvPieceDao1();
        final List<SimplePiece> pieces = pieceDao.findAllPieces();

        System.out.println("Liste des pieces");
        for (SimplePiece piece : pieces) {
            System.out.println(piece);
        }
        
        final FaceDao faceDao = new CsvFaceDao1();
        final List<SimpleFace> faces = faceDao.findAllFaces();

        System.out.println("Liste des faces");
        for (SimpleFace face : faces) {
            System.out.println(face);
        }
    }
}

package com.icauda.piece.project.dao;

// Import de la methode readCsvFile contenue dans la classe CsvFileHelper pour l'utiliser
import static com.icauda.piece.project.dao.csv.CsvFileHelper.readCsvFile;
import java.util.ArrayList;
import java.util.List;

import com.icauda.piece.project.domain.SimpleFace;

public class CsvFaceDao1 implements FaceDao {
	
	// Informations concernant la syntaxe et le chemin du fichier .CSV
	private final static char SEPARATOR = ';';
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String FACES_FILE_NAME = "face.csv";

    // Surcharge de la methode de recherche des donnees
    @Override
    public List<SimpleFace> findAllFaces() {
    	// data : tableau de stockage des donnees brutes
        final List<String[] > data = readCsvFile(RESOURCES_PATH + FACES_FILE_NAME, SEPARATOR);
        
        // faces : liste qui creee des objets a partir des donnees brutes de data
        final List<SimpleFace> faces = dataToFaces(data);

        // Renvoie la liste des objets nouvellement instancies
        return faces;
    }

    // Methode qui cree la liste d'objets instancies a partir des donnees brutes de data
    private List<SimpleFace> dataToFaces(List<String[] > data) {
    	// Creation de la liste contenant les objets qui vont etre instancies ci-dessous
        final List<SimpleFace> faces = new ArrayList<SimpleFace>();

        try {         
            // Parcours des donnees brutes de data pour les stocker dans les variables adequates
            for (String[] oneData : data) {
            	final String type = oneData[0];
                final String id_face = oneData[1];
                final String couleur_R = oneData[2];
                final String couleur_G = oneData[3];
                final String couleur_B = oneData[4];

                // Conversion dans les types demandes : string to int
                final Integer idface = Integer.parseInt(id_face);
                final Integer couleurR = Integer.parseInt(couleur_R);
                final Integer couleurG = Integer.parseInt(couleur_G);
                final Integer couleurB = Integer.parseInt(couleur_B);
                
                // Creation de l'objet grace aux variables obtenues ci-dessus
                final SimpleFace face = new SimpleFace(type, idface, couleurR, couleurG, couleurB);
                // Ajout de l'objet dans la liste d'objets
                faces.add(face);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retourne la liste des objets nouvellement instancies
        return faces;
    }
}

package com.icauda.piece.project.dao;

import static com.icauda.piece.project.dao.csv.CsvFileHelper.readCsvFile;


//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icauda.piece.project.domain.SimpleFace;

public class CsvFaceDao1 implements FaceDao {
	
	private final static char SEPARATOR = ';';
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String FACES_FILE_NAME = "face.csv";

    @Override
    public List<SimpleFace> findAllFaces() {

        final List<String[] > data = readCsvFile(RESOURCES_PATH + FACES_FILE_NAME, SEPARATOR);

        final List<SimpleFace> faces = dataToFaces(data);

        return faces;
    }

    private List<SimpleFace> dataToFaces(List<String[] > data) {
        final List<SimpleFace> faces = new ArrayList<SimpleFace>();

        try {
            //final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            // Recuperation des donnees du .csv et stockage dans un tab oneData
            for (String[] oneData : data) {
                final String id_face = oneData[0];
                final String couleur_face = oneData[1];

                // Conversion dans les types demandes : string to int
                final Integer idface = Integer.parseInt(id_face);

                final SimpleFace face = new SimpleFace(idface, couleur_face);
                faces.add(face);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return faces;
    }
}

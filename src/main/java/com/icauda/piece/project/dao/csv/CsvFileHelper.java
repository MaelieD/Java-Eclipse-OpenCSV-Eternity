package com.icauda.piece.project.dao.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class CsvFileHelper {

	// Methode de recuperation des donnees brutes directement sur le fichier .CSV
    public static List<String[] > readCsvFile(String fileName, char separator) {
        // Liste de stockage des donnees brutes
    	final List<String[] > data = new ArrayList<String[] >();

        try {
        	// Creation de l'objet fichier file
            final File file = new File(fileName);
            // Creation de l'objet qui va permettre de lire le fichier fileName
            final FileReader fr = new FileReader(file);

            // Methode de la lib OpenCsv qui va utiliser l'objet fr pour lire le fichier .CSV avec l'information du type de separateur
            final CSVReader csvReader = new CSVReader(fr, separator);

            // Methode pour separer chaque ligne du fichier .CSV
            String[] nextLine = null;
            while ((nextLine = csvReader.readNext()) != null) {
                final int size = nextLine.length;

                // Cas d'une ligne vide
                if (size == 0) {
                    continue;
                }
                final String debut = nextLine[0].trim();
                if (debut.length() == 0 && size == 1) {
                    continue;
                }

                // Cas d'une ligne de commentaire
                if (debut.startsWith("#")) {
                    continue;
                }
                // Ajout a la liste de la ligne recuperee dans le fichier .CSV
                data.add(nextLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retourne la liste de ligne (donnees brutes)
        return data;
    }
}

package com.icauda.piece.project.dao.csv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvFile01 implements CsvFile {
    
	public final static char DEFAULT_SEPARATOR = ',';
	public char separator;
	private File file;
	private CSVReader reader;

	// Constructeur vide par defaut
    private CsvFile01() {
    }

    // Constructeur avec pour parametre l'objet du fichier .CSV
    public CsvFile01(File file) {
        this(file, DEFAULT_SEPARATOR);
    }

    // Constructeur avec pour parametres l'objet du fichier .CSV et le separateur particulier a ce fichier
    public CsvFile01(File file, char separator) {

        this.file = file;
        this.separator = separator;

        // Initialisation
        init();
    }

    // Methode d'initialisation
    private void init() {
        try {
        	// Objet utilise pour la lecture du fichier .CSV
			reader = new CSVReader(new FileReader(file), separator);
		
			// Instanciation du tableau data qui contiendra les lignes de donnees brutes du fichier .CSV
			ArrayList<String[]> data = new ArrayList<String[] >();

			String[] nextLine;
			// Tant que la ligne suivante existe ...
			while ((nextLine = reader.readNext()) != null) {
				// Recuperation de la taille de la ligne suivante
				final int size = nextLine.length;
				
				// Cas de ligne vide
				if(size == 0) {
					continue;
				}
				String debut = nextLine[0].trim();
				if(debut.length() == 0 && size == 1 ) {
					continue;
				}
				// Cas d'une ligne de commentaire
				if(debut.startsWith("#")) {
					continue;
				}
                // Ajout a la liste de la ligne recuperee dans le fichier .CSV
				data.add(nextLine);
			}

			// Suppression de la premiere ligne de data
			data.remove(0);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    // Surcharge de la methode de recuperaton du fichier .CSV car l'attribut file est prive (Secure)
	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

    // Surcharge de la methode de recuperaton des donnees brutes du fichier .CSV car l'attribut data est prive (Secure)
	@Override
	public List<String[]> getData() {
		// TODO Auto-generated method stub
		return null;
	}
}

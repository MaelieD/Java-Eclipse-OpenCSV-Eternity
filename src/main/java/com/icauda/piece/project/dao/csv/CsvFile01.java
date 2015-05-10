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

    private CsvFile01() {
    }

    public CsvFile01(File file) {
        this(file, DEFAULT_SEPARATOR);
    }

    public CsvFile01(File file, char separator) {

        this.file = file;
        this.separator = separator;

        // Init
        init();
    }

    private void init() {
        try {
			reader = new CSVReader(new FileReader(file), separator);
		
			ArrayList<String[]> data = new ArrayList<String[] >();

			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				final int size = nextLine.length;
				if(size == 0) {
					continue;
				}

				String debut = nextLine[0].trim();
				if(debut.length() == 0 && size == 1 ) {
					continue;
				}
				if(debut.startsWith("#")) {
					continue;
				}
				data.add(nextLine);
			}

			data.remove(0);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String[]> getData() {
		// TODO Auto-generated method stub
		return null;
	}

    // GETTERS ...
}

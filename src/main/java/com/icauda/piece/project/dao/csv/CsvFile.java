package com.icauda.piece.project.dao.csv;

import java.io.File;
import java.util.List;

// Interface implementee par CsvFile01.java
public interface CsvFile {
	File getFile();
	List<String[] > getData();
}

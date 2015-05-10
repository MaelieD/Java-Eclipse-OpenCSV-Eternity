package com.icauda.piece.project.dao.csv;

import java.io.File;
import java.util.List;

public interface CsvFile {
	File getFile();
	List<String[] > getData();
}

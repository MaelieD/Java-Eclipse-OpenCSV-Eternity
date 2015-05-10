package com.icauda.piece.project.dao;

import java.util.List;
import com.icauda.piece.project.domain.SimpleFace;

// Interface implementee par CsvFaceDao1.java
public interface FaceDao {
	
	List<SimpleFace> findAllFaces();
}

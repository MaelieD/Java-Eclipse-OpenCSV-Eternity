package com.icauda.piece.project.dao;

import java.util.List;
import com.icauda.piece.project.domain.SimpleFace;

public interface FaceDao {
	
	List<SimpleFace> findAllFaces();
}

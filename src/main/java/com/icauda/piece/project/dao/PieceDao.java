package com.icauda.piece.project.dao;

import java.util.List;

import com.icauda.piece.project.domain.SimplePiece;

// Interface implementee par CsvPieceDao1.java
public interface PieceDao{

    List<SimplePiece> findAllPieces();

}

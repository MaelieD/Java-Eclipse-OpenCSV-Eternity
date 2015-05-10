package com.icauda.piece.project.dao;

import java.util.List;

import com.icauda.piece.project.domain.SimplePiece;

public interface PieceDao{

    List<SimplePiece> findAllPieces();

}

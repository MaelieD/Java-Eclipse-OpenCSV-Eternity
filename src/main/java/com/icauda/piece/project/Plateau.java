package com.icauda.piece.project;

import java.awt.Point;
import java.util.List;
import java.awt.Color;

import com.icauda.piece.project.dao.CsvFaceDao1;
import com.icauda.piece.project.dao.CsvPieceDao1;
import com.icauda.piece.project.dao.FaceDao;
import com.icauda.piece.project.dao.PieceDao;
import com.icauda.piece.project.domain.SimpleFace;
import com.icauda.piece.project.domain.SimplePiece;

public class Plateau {

	public SimpleFace face[]; // tableau (comme une liste) de faces
	public Point size;
	public int s;
	public GraphicPiece pieces[][]; // tableau 2D de pieces -> plateau
	
	public Plateau(int x, int y, int s){
		
		System.out.println("Creation du plateau size :" + x + ";" + y);
		size = new Point(x,y); // taille du plateau x*y
		pieces = new GraphicPiece[x][y]; // tableau 2D de pieces de taille x*y 
		this.s = s; // taille d'une piece		
		
		read_face();
		
		for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){				
				pieces[i][j] = new GraphicPiece(s,face[0],face[0],face[0],face[0]);		 
			}
		}
		
		if(s == 50){
			remplir_pieces();
		}
		update();
	}
	
	public void read_face() {
		final FaceDao faceDao = new CsvFaceDao1();
        final List<SimpleFace> faces = faceDao.findAllFaces();
        face = new SimpleFace[10];
        for(int i = 0; i < 10 ; i++) {
        	face[i] = faces.get(i);
        	//System.out.println("Recuperation des faces dans Plateau :"+face[i]);
        }
	}
	
	public void remplir_pieces() {
		final PieceDao pieceDao = new CsvPieceDao1();
        final List<SimplePiece> piecesList = pieceDao.findAllPieces();
        System.out.println("Liste des pieces");
       
        int k = 0;
		for(int i = 0; i < size.x ; i++) {
			for(int j = 0; j < size.y ; j++) {
				//System.out.println(i+" : "+j+" : "+face[piecesList.get(k).getId_droite()]);
				pieces[i][j].setFace(face[piecesList.get(k).getId_gauche()], face[piecesList.get(k).getId_haut()], face[piecesList.get(k).getId_droite()], face[piecesList.get(k).getId_bas()]);
				k++;
			}
		}
		
		//On melange tout sa a la sauce random
		melange_rnd();
		
		//On fait des rotations a la sauce random			
		retourne_rnd();		
		
	}
	
	public void init(){		
		// creer le plateau initiale avec toutes les cases(=faces) qui sont grises
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){				
				pieces[i][j].setFace(face[0],face[0],face[0],face[0]);		 
			}
		}	
		if(s == 50){
			remplir_pieces();
		}
		update();
	}
	
	// MELANGER LE PLATEAU POUR LE DEBUT DU JEU -> echanger des pieces
		private void melange_rnd(){
			// parcours du plateau ligne par ligne
			for(int i=0; i<size.x ; i++){
				for(int j=0; j<size.y ; j++){
					// piece selectionnee echangee avec une piece random entre 0 et 5
					pieces[i][j].swapPiece(pieces[rnd(0,5)][rnd(0,5)]);					
				}
			}
		}
		
		// MELANGER LE PLATEAU POUR LE DEBUT DU JEU -> rotation d'une piece sur la droite
		private void retourne_rnd(){
			// parcours du plateau ligne par ligne
			for(int i=0; i<size.x ; i++){
				for(int j=0; j<size.y ; j++){		
					// selection d'une piece autour de la piece courante
					for(int r=0; r<rnd(0,5) ; r++){	
						pieces[i][j].rotateDirect();
					}									
				}
			}		
		}
		public boolean win(){	
			
			//On verifie que toutes les cases du plateau sont pleines
			for(int i=0; i<size.x ; i++){
				for(int j=0; j<size.y ; j++){	
					if(pieces[i][j].faces[0].getId_face() == 0){	
						return false;
					}			
				}
			}
			
			//On verifie que toutes les bordures noires sont bien au bord
			for(int i=0; i<size.x ; i++){				
					if(pieces[i][0].faces[1].getId_face() != 1 || pieces[i][size.y-1].faces[3].getId_face() != 1 ){	
						return false;
					}					
			}	
			for(int j=0; j<size.y ; j++){				
				if(pieces[0][j].faces[0].getId_face() != 1 || pieces[size.x-1][j].faces[2].getId_face() != 1){	
					return false;
				}			
			}	
			
			//On verifie que les faces voisines sont les memes
			for(int i=1; i<size.x-1 ; i++){
				for(int j=1; j<size.y-1 ; j++){	
					
					if(pieces[i][j].faces[0] != pieces[i-1][j].faces[2]){	
						return false;
					}	
					
					if(pieces[i][j].faces[2] != pieces[i+1][j].faces[0]){	
						return false;
					}
					
					if(pieces[i][j].faces[1] != pieces[i][j-1].faces[3]){	
						return false;
					}	
					
					if(pieces[i][j].faces[3] != pieces[i][j+1].faces[1]){	
						return false;
					}		
				}
			}
			//C'est gagne :)
			return true;	
		}
		
	private int rnd(int min,int max){		
		return (int)(Math.random() * (max-min)) + min;
	}
		
	public void update(){
		for(int i=0; i<size.x ; i++){
			for(int j=0; j<size.y ; j++){				
				pieces[i][j].update();	 
			}
		}
	}
}

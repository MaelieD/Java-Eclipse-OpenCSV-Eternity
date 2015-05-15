package com.icauda.piece.project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.Polygon;

import javax.swing.JComponent;

import com.icauda.piece.project.domain.SimpleFace;

public class GraphicPiece extends JComponent {
	
	public SimpleFace faces[] = new SimpleFace[4];	// tableau (comme une liste) de faces
	private int rotate;	
	private Point size;	// taille de la piece
	
	//Constructeur piece vide
	public GraphicPiece(int s){
		System.out.println("Creation d'une piece vide");		
		rotate = 0;		
		size = new Point(s,s);
		repaint();		
		}
	
	//Constructeur piece vide complete
	public GraphicPiece(int s, SimpleFace face_gauche, SimpleFace face_haut, SimpleFace face_droite, SimpleFace face_bas){
		System.out.println("Creation d'une piece complete");		
		faces[0] = face_gauche;
		faces[1] = face_haut;
		faces[2] = face_droite;
		faces[3] = face_bas;		
		size = new Point(s,s);
		repaint();		
	}
	
	public void setFace(SimpleFace face_gauche, SimpleFace face_haut, SimpleFace face_droite, SimpleFace face_bas){
		faces[0] = face_gauche;
		faces[1] = face_haut;
		faces[2] = face_droite;
		faces[3] = face_bas;
	}
	
	//GETTER
	public SimpleFace getFace(int nb){
		return faces[nb];
	}
	
	public int getFace_id(int nb){
		return faces[nb].getId_face();
	}
	
	public void update() {
		repaint();		    
	}
	
	// ROTATION DROITE
	public void rotationDroite(){
		SimpleFace tmp = faces[0];
		faces[0]=faces[1];
		faces[1]=faces[2];
		faces[2]=faces[3];
		faces[3]=tmp;
		rotate = (rotate+1)%4;
	}	
		
	// ROTATION GAUCHE
	public void rotationGauche(){
		SimpleFace temp = faces[0];
		faces[0]=faces[3];
		faces[3]=faces[2];
		faces[2]=faces[1];
		faces[1]=temp;
		rotate = (rotate-1)%4;
	}
		
		
	// ECHANGE DEUX PIECES
	public void swapPiece(GraphicPiece piece2)	{
		GraphicPiece piece3 = new GraphicPiece(size.x,piece2.faces[0], piece2.faces[1], piece2.faces[2], piece2.faces[3]);
		piece2.faces[0]=this.faces[0];
		piece2.faces[1]=this.faces[1];
		piece2.faces[2]=this.faces[2];
		piece2.faces[3]=this.faces[3];

		this.faces[0]=piece3.faces[0];
		this.faces[1]=piece3.faces[1];
		this.faces[2]=piece3.faces[2];
		this.faces[3]=piece3.faces[3];
	}
		
//////////////////////////////////////////////////////////////FONCTION POUR LE COLORIAGE/////////////////////////////////////////////////////
	public void paintComponent(Graphics g) {
	    g.setColor(Color.white);
	    g.fillRect(0, 0, 100, 100);	    
	    build(g);	    
	}
		
	private void build(Graphics g){
		
		//setColorFace(faces[1], g);
		g.setColor(faces[1].getC());
		Polygon p1 = new Polygon();
		p1.addPoint(0,0);
		p1.addPoint(size.x,0);
		p1.addPoint(size.x/2,size.y/2);        
		((Graphics2D) g).fill(p1);
			
		//setColorFace(faces[0], g);
		g.setColor(faces[0].getC());
	    Polygon p2 = new Polygon();
	    p2.addPoint(0,0);
	    p2.addPoint(0,size.y);
	    p2.addPoint(size.x/2,size.y/2);       
	    ((Graphics2D) g).fill(p2);
		    
		//setColorFace(faces[2], g);
	    g.setColor(faces[2].getC());
	    Polygon p3 = new Polygon();
	    p3.addPoint(size.x,0);
	    p3.addPoint(size.x,size.y);
	    p3.addPoint(size.x/2,size.y/2);        
	    ((Graphics2D) g).fill(p3);
		    
	    g.setColor(faces[3].getC());
		//setColorFace(faces[3], g);
	    Polygon p4 = new Polygon();
	    p4.addPoint(size.x,size.y);
	    p4.addPoint(0,size.y);
	    p4.addPoint(size.x/2,size.y/2);       
	    ((Graphics2D) g).fill(p4);  
	}
}

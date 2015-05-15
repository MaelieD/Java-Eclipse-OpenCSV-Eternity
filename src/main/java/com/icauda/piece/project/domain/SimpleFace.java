package com.icauda.piece.project.domain;

import java.awt.Color;

public class SimpleFace implements Face {

		private String type;
		private Integer id_face;	
		private Integer couleur_R;
		private Integer couleur_G;
		private Integer couleur_B;
		private Color c; // objet couleur qui regroupera les RGB du CSV
			
		// Constructeur de SimpleFace vide
		public SimpleFace() {
			this.type = "N";
			this.id_face = 0;
			this.couleur_R = 0;
			this.couleur_G = 0;
			this.couleur_B = 0;
			this.c = new Color(couleur_R,couleur_G,couleur_B);
		}
		
		// Constructeur de SimpleFace complet
		public SimpleFace(String type, Integer id_face, Integer couleur_R, Integer couleur_G, Integer couleur_B) {
			this.type = type;
			this.id_face = id_face;
			this.couleur_R = couleur_R;
			this.couleur_G = couleur_G;
			this.couleur_B = couleur_B;
			this.c = new Color(couleur_R,couleur_G,couleur_B);
		}
		
		// Conversion des attributs en chaine de caracteres
		public String toString() {
			return "("+id_face+"="+couleur_R+" "+couleur_G+" "+couleur_B+"="+c+")";
		}
			
		// Getters/setters
		public String getType(){
			return type;
		}
		
		public Integer getId_face(){
			return id_face;
		}
		
		public Integer getCouleur_R() {
			return couleur_R;
		}
		
		public Integer getCouleur_G() {
			return couleur_G;
		}
		
		public Integer getCouleur_B() {
			return couleur_B;
		}
		
		public Color getC() {
			return c;
		}
}

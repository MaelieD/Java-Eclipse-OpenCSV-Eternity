package com.icauda.piece.project.domain;

public class SimpleFace implements Face {

		private Integer id_face;	
		private String couleur_face;
			
		public SimpleFace(Integer id_face, String couleur_face) {
			this.id_face = id_face;
			this.couleur_face = couleur_face;
		}
			
		public String toString() {
			return "("+id_face+"="+couleur_face+")";
		}
			
		// plus getters/setters
		public Integer getId_face(){
			return id_face;
		}
		
		public String getCouleur_face() {
			return couleur_face;
		}

}

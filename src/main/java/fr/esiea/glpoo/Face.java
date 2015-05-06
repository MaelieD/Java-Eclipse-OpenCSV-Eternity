package fr.esiea.glpoo;

import java.util.List;

public class Face implements FaceDao {
	
	private char type;
	private int id_face;
	private String	couleur_face;
	
	public Face(char type, int id_face, String couleur_face) {
		this.type = type;
		this.id_face = id_face;
		this.couleur_face = couleur_face;
	}

	public List<Face> findFaces() {
		final FaceDao faceDao = new FaceDao();
		final List<Face> faces = faceDao.findFaces();
	
		for (Face face : faces) {
			System.out.println(face);
		}
	}	
		
	public char getType() {
		return type;
	}
	
	public int getId_face() {
		return id_face;
	}
	
	public String getCouleur_face() {
		return couleur_face;
	}
}

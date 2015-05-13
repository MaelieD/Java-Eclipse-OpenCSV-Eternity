package com.icauda.piece.project;

import javax.swing.*;

import com.icauda.piece.project.domain.SimplePiece;

import java.awt.*;
import java.util.List;

public class Frame extends JFrame {
	
	public int p = 0;
	private JFrame fenetre;
	JPanel panel = new JPanel();
	
	private final static String RESOURCES_PATH = "src/main/resources/image";
	
	public Frame(List<SimplePiece> pieces){
		super();
 
		build(pieces);//On initialise notre fenêtre
	}
	
	private void build(List<SimplePiece> pieces){

		// INITALISE FENETRE
		fenetre = new JFrame("Eternity");
		fenetre.setSize(680,730); 
		fenetre.setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		fenetre.setResizable(true); // On permet le redimensionnement
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix
		fenetre.setVisible(true);
		
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		panel.add(label);
		
		// CREATION TABLEAU
		TableauPiece tab = TableauPiece.getInstance(pieces);
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				//label = new JLabel("tab["+i+"]["+j+"] = "+ tab.tabPiece[i][j]+" -> "+pieces.get(p));
				
				p++;
			}
		}
		
		/*Object[][] data = {
				{icon1, icon2, icon3},
				{icon4, icon5, icon6},
				{icon7, icon8, icon9}

		};*/
	}
	

	
	/*private ImageIcon icon1 = new ImageIcon("image/piece1.png");
	private ImageIcon icon2 = new ImageIcon("image/piece2.png");
	private ImageIcon icon3 = new ImageIcon("image/piece3.png");
	private ImageIcon icon4 = new ImageIcon("image/piece4.png");
	private ImageIcon icon5 = new ImageIcon("image/piece5.png");
	private ImageIcon icon6 = new ImageIcon("image/piece6.png");
	private ImageIcon icon7 = new ImageIcon("image/piece7.png");
	private ImageIcon icon8 = new ImageIcon("image/piece8.png");
	private ImageIcon icon9 = new ImageIcon("image/piece9.png");*/

}

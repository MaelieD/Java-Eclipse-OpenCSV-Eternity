package fr.esiea.glpoo;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	
	public Frame()
	{
		// bob
		//Définit un titre pour notre fenêtre
		this.setTitle("Eternity");
		//Définit sa taille : 400 pixels de large et 100 pixels de haut
		this.setSize(800, 500);
		//Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Empecher le redimensionnement de la fenêtre
		this.setResizable(false); 
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Instanciation d'un objet JPanel
	    JPanel panel = new JPanel();
	    //Définition de sa couleur de fond
	    panel.setBackground(Color.ORANGE);        
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    this.setContentPane(panel); 
		
		//Et enfin, la rendre visible        
		this.setVisible(true);
	}
}

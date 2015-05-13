package com.icauda.piece.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.ArrayList;


import com.icauda.piece.project.domain.SimplePiece;

import java.awt.*;

public class Frame extends JFrame {
	
	public int p = 0;
	public String str1 = null, str2 = null;
	private ArrayList<String> resourcesPath = new ArrayList<String>();  
	private JFrame fenetre;
	private JTable tableau;
	private JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JLabel label = new JLabel();
	
	// champs de texte pour entre les coord des pieces a tourner / echanger
	private JTextField textFieldCoordX;
	private JTextField textFieldCoordY;
	private JTextField textFieldCoordXExI;
	private JTextField textFieldCoordYExI;
	private JTextField textFieldCoordXExF;
	private JTextField textFieldCoordYExF;
	
	private final static String RESOURCES_PATH = "src/main/resources/image/";
	
	public Frame(List<SimplePiece> pieces){
		super();
 
		build(pieces);//On initialise notre fenêtre
	}
	
	private void build(List<SimplePiece> pieces){

		// INITALISE FENETRE
		fenetre = new JFrame("Eternity");
		//fenetre.setSize(680,730);
		fenetre.setSize(1000,1000); 
		fenetre.setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
		fenetre.setResizable(true); // On permet le redimensionnement
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix
		fenetre.setVisible(true);
		
		panel1.setLayout(new FlowLayout());
		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		panel1.add(label);
		
		// CREATION TABLEAU
		TableauPiece tab = TableauPiece.getInstance(pieces);
		for(int i = 0 ; i < tab.tabPiece.length ; i++) {
			for(int j = 0 ; j < tab.tabPiece[0].length ; j++) {
				//label = new JLabel("tab["+i+"]["+j+"] = "+ tab.tabPiece[i][j]+" -> "+pieces.get(p));
				str1 = tab.tabPiece[i][j] + ".png";
				str2 = RESOURCES_PATH + str1;
				
				resourcesPath.add(str2);
				//System.out.println(resourcesPath.get(p)); // ca fonctionne !
				
				//p++;
			}
		}
		
		for(String name : resourcesPath){
			System.out.println(name);
		}
		

		final ImageIcon icon1 = new ImageIcon(resourcesPath.get(0));
		final ImageIcon icon2 = new ImageIcon(resourcesPath.get(1));
		final ImageIcon icon3 = new ImageIcon(resourcesPath.get(2));
		final ImageIcon icon4 = new ImageIcon(resourcesPath.get(3));
		final ImageIcon icon5 = new ImageIcon(resourcesPath.get(4));
		final ImageIcon icon6 = new ImageIcon(resourcesPath.get(5));
		final ImageIcon icon7 = new ImageIcon(resourcesPath.get(6));
		final ImageIcon icon8 = new ImageIcon(resourcesPath.get(7));
		final ImageIcon icon9 = new ImageIcon(resourcesPath.get(8));
	
		Object[][] data = {
				{icon1, icon2, icon3},
				{icon4, icon5, icon6},
				{icon7, icon8, icon9}
		};
		
		String title[] = {"0","1","2"};
		panel1.add(tableau = new JTable(data, title));
		
		DefaultTableModel model;
		model = new DefaultTableModel(data, title);
		tableau = new JTable(model){
			public Class getColumnClass(int column){
				return getValueAt(0, column).getClass();				
			}
		};
		
		tableau.setRowHeight(220);
		tableau.setRowMargin(1);
		tableau.getColumnModel().getColumn(0).setResizable(false);
		tableau.getColumnModel().getColumn(1).setResizable(false);
		tableau.getColumnModel().getColumn(2).setResizable(false);
		//tableau.getColumnModel().getColumn(3).setResizable(false);

		fenetre.getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
		fenetre.getContentPane().add(tableau, BorderLayout.CENTER);
		
		pack();
		
		fenetre.setVisible(true);
		
		//initComposant();
		
		fenetre.setContentPane(buildContentPane());
	}
	
	/*private void initComposant(){
	    //On définit la police d'écriture à utiliser
	    Font police = new Font("Arial", Font.BOLD, 20);
	    label = new JLabel("0");
	    label.setFont(police);
	    //On aligne les informations à droite dans le JLabel
	    label.setHorizontalAlignment(JLabel.RIGHT);
	    label.setPreferredSize(new Dimension(220, 20));
	    JPanel operateur = new JPanel();      
	    operateur.setPreferredSize(new Dimension(55, 225));
	    JPanel chiffre = new JPanel();
	    chiffre.setPreferredSize(new Dimension(165, 225));
	    JPanel panEcran = new JPanel();
	    panEcran.setPreferredSize(new Dimension(220, 30));
	}*/
	
	private JPanel buildContentPane() {
		panel2.setLayout(new FlowLayout());
		
		textFieldCoordX = new JTextField();
		textFieldCoordX.setColumns(1);
		
		textFieldCoordY = new JTextField();
		textFieldCoordY.setColumns(1);
		
		panel2.add(textFieldCoordX);
		panel2.add(textFieldCoordY);
		
		/*label = new JLabel("Coordonnées de la piece (X, Y)");
		
		panel.add(label);

		JButton boutonTourneDroite = new JButton("Tourne Droite");
		boutonTourneDroite.addActionListener(new BoutonTourneDroite());
		
		JButton boutonTourneGauche = new JButton("Tourne Gauche");
		boutonTourneGauche.addActionListener(new BoutonTourneGauche());
		
		panel.add(boutonTourneGauche);
		panel.add(boutonTourneDroite);
		
		labelSpace1 = new JLabel("Echange de deux pieces : 1ere");
		panel.add(labelSpace1);
////////////////////////////////////////////////
////////////////////////////////////////////////
		textFieldCoordXExI = new JTextField();
		textFieldCoordXExI.setColumns(1);
		
		textFieldCoordYExI = new JTextField();
		textFieldCoordYExI.setColumns(1);
		
		panel.add(textFieldCoordXExI);
		panel.add(textFieldCoordYExI);
////////////////////////////////////////////////
////////////////////////////////////////////////
		labelSpace2 = new JLabel("   2eme");
		panel.add(labelSpace2);
////////////////////////////////////////////////
////////////////////////////////////////////////
		textFieldCoordXExF = new JTextField();
		textFieldCoordXExF.setColumns(1);
		
		textFieldCoordYExF = new JTextField();
		textFieldCoordYExF.setColumns(1);
		
		panel.add(textFieldCoordXExF);
		panel.add(textFieldCoordYExF);
////////////////////////////////////////////////
////////////////////////////////////////////////
		
		JButton boutonEchange = new JButton("Echange !");
		boutonEchange.addActionListener(new BoutonEchange());
		
		panel.add(boutonEchange);
		
		JButton boutonVerification = new JButton("Verification du Puzzle");
		boutonVerification.addActionListener(new BoutonVerification());
		
		panel.add(boutonVerification);
		
		labelPhraseFin = new JLabel("Vous n'avez pas gagné.");
		panel.add(labelPhraseFin);
		*/
		return panel2;
	}

}

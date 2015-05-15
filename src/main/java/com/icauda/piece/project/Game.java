package com.icauda.piece.project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import javafx.scene.image.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.Timer;
import javax.swing.UIManager;

//import com.sun.javafx.tk.Toolkit;

public class Game extends JFrame implements KeyListener, ActionListener, MouseListener{
	
	//Parametres Globaux
	private int size = 6; // taille plateau de 6x6
	private String name; // methode timerWin pour recuperation du pseudo dans la PopUp
	
	//Objets graphiques
	private JFrame frame;
	private JPanel panel;
	private JButton restart;
	private JButton help; 	
	private JButton Rotate;
	private JLabel time = new JLabel("00:00");
	private JButton[][] PiecePlat;
	private JButton[][] PieceDec;
	
	//Plateau, dec, piece
	Plateau Plat;
	Plateau Dec;
	
    //Timer
	Timer timer1;
    int var_time = 0;
    ActionListener tache_timer = new ActionListener()  {
		  public void actionPerformed(ActionEvent e1)  {
			  // +1 et conversion en minute seconde
			  var_time++;				  
			  int minute = var_time/60;
	          int seconde = var_time - (minute*60);
	          String sm = Integer.toString(minute);
	          if (minute < 10){ sm = "0" + Integer.toString(minute);}
	          String ss = Integer.toString(seconde);
	          if (seconde < 10){ ss = "0" + Integer.toString(seconde);}
			  //Actualiser le JLabel
			  time.setText(sm+":"+ss);				  
		 }
     };		 
     
	
	public Game() {
		
		//Debut nouvelle partie
		System.out.println("Debut nouvelle partie");	
		renderGame();
		
		//Creation du plateau et du dec
	    creat_plat(size,size);
	    creat_dec(size,size);
        
        //Une fois que tout est cree, on autorise l'affichage
        //frame.setSize(1024, 768); 
	    frame.setSize(1152, 864);
		frame.setVisible(true);	
		frame.setResizable(false);
		
		//On cree le timer			
		time.setForeground(new Color(255,255,255));
		timer1 = new Timer(1000, tache_timer);		
		//On lance le timer
		timer1.start();     
		
	}
	
	
	private void renderGame(){	
		
		ImageIcon iconAlien = new ImageIcon("src/main/resources/alien.png");
		//Creation de la fenetre
		System.out.println("Creation de la fenetre");	
		frame = new JFrame("Alien : Eternity");  
		frame.setIconImage(iconAlien.getImage());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	    
	    panel = (JPanel)frame.getContentPane();  
	    panel.setLayout(null);
	    panel.setBackground(new Color(0,0,0));
	    //frame.setIconImage(image);
	    
	    frame.setUndecorated(true);
	    frame.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
	    
	    /*
	    frame.setDefaultLookAndFeelDecorated( false );
	    frame.getRootPane( ).setWindowDecorationStyle( JDialog.DISPOSE_ON_CLOSE );
		*/
		
	    
	    //Creation des object graphique
	    System.out.println("Creation des objets graphiques");	
	    
	    //timer
		Font font = new Font("Arial",Font.BOLD,50);
		time.setFont(font);		
		time.setBounds(430,30,500,50);	
		
		//bouton restart
	    restart = new JButton("Recommencer");	 
        restart.addActionListener(this);
        restart.setBounds(10,125,215,30);
        
        //bouton help
        help = new JButton("Aide");
        help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Help.main();
			}
		});        
        help.setBounds(390,125,215,30);
        
        //Bouton rotate
        Rotate = new JButton("Rotation");       
        Rotate.addActionListener(this);
        Rotate.setBounds(790,125,215,30);
        
        //On ajoute tout sa a la page
        panel.add(time);
        panel.add(restart);
        panel.add(help);
        panel.add(Rotate);                
      
	}
	
	// CREATION DU PLATEAU
	private void creat_plat(int x, int y){
		
		PiecePlat = new JButton[size][size];
	    Plat = new Plateau(size,size,100);	
		
		//Creation des bouton des piece du plateau
		for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){	
				//bouton
				PiecePlat[i][j] = new JButton();			    
				PiecePlat[i][j].addActionListener(this); 
				PiecePlat[i][j].addMouseListener(this); 
				PiecePlat[i][j].setBounds(440+5*i+100*i, 205+5*j+100*j, 100,100);
				PiecePlat[i][j].setContentAreaFilled(false); 
				panel.add(PiecePlat[i][j]);
				//image				
				Plat.pieces[i][j].setBounds(440+5*i+100*i, 205+5*j+100*j, 100,100);	
				panel.add(Plat.pieces[i][j]);
			}
		}		
	}
	
	// CREATION DU PLATEAU DE SELECTION DES PIECES
	private void creat_dec(int x, int y){
		
		PieceDec = new JButton[size][size];
		Dec = new Plateau(size,size,50);		
		//Dec.read_face_csv();
		
		//Creation des bouton des pieces du dec
	    for(int i=0; i<x ; i++){
			for(int j=0; j<y ; j++){		
				//bouton
				PieceDec[i][j] = new JButton();			
				PieceDec[i][j].addActionListener(this); 
			    PieceDec[i][j].addMouseListener(this); 			    
			    PieceDec[i][j].setBounds(105+5*i+50*i, 310+5*j+50*j, 50,50); 
			    PieceDec[i][j].setContentAreaFilled(false);	
			    panel.add(PieceDec[i][j]);
			    //image		   
			    Dec.pieces[i][j].setBounds(105+5*i+50*i, 310+5*j+50*j, 50,50);	
			    panel.add(Dec.pieces[i][j]);
			}
		}	 
     }
	

	// Remise a zero du timer
	private void ResetTimer(){
		timer1.stop(); 
		timer1 = new Timer(1000, tache_timer);		
		timer1.start();  
		var_time = -1;
	}	
		
	// Arret du timer si le jeu est gagne et box demandant le pseudo
	
	private void timerWin(){
		if(Plat.win() == true){
			timer1.stop();
			name = JOptionPane.showInputDialog(null, "Good Game ! U've found the Alien !!! \nVeuillez entrer un Pseudo", "Sauvegarde du Score", JOptionPane.QUESTION_MESSAGE);
		}
	}
	
	// Evenement	
	private GraphicPiece last = null;
	public void actionPerformed(ActionEvent e) {			
		
		// Si bouton Restart presse
		if(e.getSource() == restart){
			System.out.println("Remise a Zero .");				
			Plat.init();		
			Dec.init();	
			Dec.read_face();
			Dec.update();
			Plat.update();
			ResetTimer();
		}
		
		// Si bouton help presse
		if(e.getSource() == help){
			System.out.println("Affichage de l'aide"); 			
		}
		
		// Si bouton Rotation presse	
		if(e.getSource() == Rotate){
			System.out.println("Rotation de la piece"); 
			if (last != null){
				last.rotateDirect();	
				last.update();
			}	
		}	
		
	}
	

	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();	
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseClicked(MouseEvent e) {	
		 
	    if (e.getButton() == MouseEvent.BUTTON1) {
	           // Bouton GAUCHE enfoncé
	    	//Pour chaque piece du dec
			for(int i=0; i<5 ; i++){
				for(int j=0; j<5 ; j++){	
					if(e.getSource() == PieceDec[i][j]){
						Dec.pieces[i][j].rotateDirect();
						//Plat.win();
						timerWin();
						last = Dec.pieces[i][j];
					}				
				}
			}	
			
			//Pour chaque piece du plat
			for(int i=0; i<6 ; i++){
				for(int j=0; j<6 ; j++){	
					if(e.getSource() == PiecePlat[i][j]){					
						Plat.pieces[i][j].rotateDirect();
						//Plat.win();
						timerWin();
						last = Plat.pieces[i][j];
					}				
				}
			}	
	    } else if(e.getButton() == MouseEvent.BUTTON2) {
	           // Bouton du MILIEU enfoncé
	    } else if(e.getButton() == MouseEvent.BUTTON3) {
	        // Bouton DROIT enfoncé
	    	//Pour chaque piece du plat
			for(int i=0; i<6 ; i++){
				for(int j=0; j<6 ; j++){	
					if(e.getSource() == PiecePlat[i][j]){
						
						System.out.println("Ici ??");	
						start = Plat.pieces[i][j];
						
						//On cherche la 1er place vide du dec
						for(int k=0; k<6 ; k++){
							for(int l=0; l<6 ; l++){	
								if(Dec.pieces[k][l].faces[0].getId_face() == 0){
									Plat.pieces[i][j].swapPiece(Dec.pieces[k][l]);
									Plat.pieces[i][j].update();
									Dec.pieces[k][l].update();	
								}				
							}
						}
						
						
					}				
				}
			}	
	    	
	    }
	    
	}

		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	
	//Drag'n'Drop
	private GraphicPiece start = null;
	public void mousePressed(MouseEvent e) {
		
		//Pour chaque piece du dec
		for(int i=0; i<6 ; i++){
			for(int j=0; j<6 ; j++){	
				if(e.getSource() == PieceDec[i][j]){
					start = Dec.pieces[i][j];
				}				
			}
		}
		
		//Pour chaque piece du plat
		for(int i=0; i<6 ; i++){
			for(int j=0; j<6 ; j++){	
				if(e.getSource() == PiecePlat[i][j]){
					start = Plat.pieces[i][j];
				}				
			}
		}	
		
		if (start != null){
			System.out.println("Press !!");	
			//setCursor(new Cursor(Cursor.MOVE_CURSOR) );
		}
		
	}
	
	
		
	private GraphicPiece stop = null;
	public void mouseEntered(MouseEvent e) {
		
		//Pour chaque piece du dec
				for(int i=0; i<6 ; i++){
					for(int j=0; j<6 ; j++){	
						if(e.getSource() == PieceDec[i][j]){
							stop = Dec.pieces[i][j];
						}				
					}
				}
						
				//Pour chaque piece du plat
				for(int i=0; i<6 ; i++){
					for(int j=0; j<6 ; j++){	
						if(e.getSource() == PiecePlat[i][j]){
							stop = Plat.pieces[i][j];
						}				
					}
				}	
	}
	
	
	
	public void mouseReleased(MouseEvent e) {
				
		if (stop != null && start != null){
			System.out.println("Relachee !!");
			stop.swapPiece(start);
			stop.update();
			start.update();	
			last = stop;
			//Plat.win();
			timerWin();
		}
		stop = null;
		start = null;	
	}
	
}

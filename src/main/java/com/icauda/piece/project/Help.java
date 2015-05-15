package com.icauda.piece.project;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.BoxLayout;

import java.awt.Panel;

import javax.swing.JTextPane;

import java.awt.Color;

public class Help extends JFrame {

	private JFrame help;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main() {
		JFrame about = new JFrame();
		Font font = new Font("Comic Sans MS", Font.BOLD, 15);
		about.setEnabled(true);
		about.setResizable(false);
		about.setAlwaysOnTop(true);
		about.setTitle("Help\r\n");
		about.setMinimumSize(new Dimension(700, 200));
		about.getContentPane().setLayout(
				new BoxLayout(about.getContentPane(), BoxLayout.X_AXIS));

		Panel panel_2 = new Panel();
		about.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JTextPane Help = new JTextPane();
		Help.setToolTipText("");
		Help.setEnabled(false);
		Help.setEditable(false);
		Help.setBounds(0, 0, 700, 200);
		panel_2.add(Help);
		Help.setFont(font);
		Help.setText("Bienvenue dans l'aide !!\r\n\n Pour deplacer les pieces : cliquer sur la piece et glisser la jusqu'à l'endroit souhaité.\r\n Pour tourner une pièce : cliquer sur la pièce.");
		about.setVisible(true);
	}
}

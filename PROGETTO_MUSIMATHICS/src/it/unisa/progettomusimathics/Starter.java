package it.unisa.progettomusimathics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Starter {

	public static void main(String[] args) {
		//definizione dell'interfaccia utente
		
		JFrame frame= new MyFrame();
		frame.setTitle("FRACTAL MUSIC");
		frame.setLocation(550,300);
		frame.setSize(650,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	
		frame.setVisible(true);
		
		
		ImageIcon image= new ImageIcon("icon.jpg");		
		frame.setIconImage(image.getImage());
		

	}

}

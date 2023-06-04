package it.unisa.progettomusimathics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MyFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel latonote;
	private JPanel latoinput;
	private JButton do4;
	private JButton do4d;
	private JButton re4b;
	private JButton re4;
	private JButton mi4b;
	private JButton mi4;
	private JButton fa4;
	private JButton fa4d;
	private JButton sol4b;
	private JButton sol4;
	private JButton la4b;
	private JButton la4;
	private JButton si4b;
	private JButton si4;
	private JButton do5b;
	private ActionListener button1;
	private ActionListener button2;
	private ActionListener button3;
	private ActionListener button4;
	private ActionListener button5;
	private ActionListener button6;
	private ActionListener button7;
	private ActionListener button8;
	private ActionListener button9;
	private ActionListener button10;
	private ActionListener button11;
	private ActionListener button12;
	private ActionListener button13;
	private ActionListener button14;
	private ActionListener button15;
	private JTextField nota1;
	private JTextField nota2;
	private JTextArea area;
	private JPanel text;
	private JButton play;
	private JButton random;
	private ActionListener b;
	private ActionListener p;
	private Fractals frattale;	
	private JButton clear;
	private ActionListener c;
	private JTextField ricorsioni;
	
	
	
	
	public MyFrame() {
		
		class Play implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//valore di default: suono delle singole due note scelte
				if(ricorsioni.getText().equals("")) frattale= new Fractals(1, nota1.getText(), nota2.getText());
				else if((Integer.parseInt(ricorsioni.getText())>6) || (Integer.parseInt(ricorsioni.getText())<1)) area.setText("Il valore deve essere compreso tra 1 e 6");
				else frattale= new Fractals(Integer.parseInt(ricorsioni.getText()), nota1.getText(), nota2.getText());
				frattale.toString();
				area.setText("Music Played: \n" + frattale.notes());
				frattale.play();
				
			}
		}
		
		class Random implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				nota1.setText(change(frattale.getRandomNote()));
				nota2.setText(change(frattale.getRandomNote()));

				ricorsioni.setText(frattale.getRandomRecursion());
				
			}
		}
		frattale = new Fractals();
		latonote= creaLatoNote();
		latoinput= creaLatoInput();
		setLayout(new BorderLayout(5,5));
		area= new JTextArea();
		text = new JPanel();
		play= new JButton("PLAY");
		play.setSize(80, 30);
	    play.setLocation(90, 4);
	    random= new JButton("RANDOM");
		random.setSize(80, 30);
	    random.setLocation(90, 4);
	    
		b = new Play();
		p = new Random();
		random.addActionListener(p);
		play.addActionListener(b);
		area.setEditable(false);
		area.setLineWrap(true);
		
		setLayout(new BorderLayout());
		add(latonote, BorderLayout.SOUTH);
		add(latoinput, BorderLayout.NORTH);
		text.setLayout(new BorderLayout(6,5));
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2));
		buttons.add(play);
		buttons.add(random);
		text.add(buttons, BorderLayout.SOUTH);
		//text.add(random, BorderLayout.SOUTH);

		text.add(area, BorderLayout.CENTER);
		add(text);
	}
	
	
	private JPanel creaLatoNote() {
		JPanel panel = new JPanel();
		
		class Button1 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("DO");
				else {
					nota2.setText("DO");
				}
				
			}
		}
		
		class Button2 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("DO#");
				else {
					nota2.setText("DO#");
				}

				
			}
		}
		class Button3 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("REb");
				else {
					nota2.setText("REb");
				}

				
			}
		}
		class Button4 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("RE");
				else {
					nota2.setText("RE");
				}

				
			}
		}
		class Button5 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("MIb");
				else {
					nota2.setText("MIb");
				}

				
			}
		}
		class Button6 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("MI");
				else {
					nota2.setText("MI");
				}

				
			}
		}
		class Button7 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("FA");
				else {
					nota2.setText("FA");
				}

				
			}
		}
		class Button8 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("FA#");
				else {
					nota2.setText("FA#");
				}

				
			}
		}
		class Button9 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("SOLb");
				else {
					nota2.setText("SOLb");
				}

				
			}
		}
		class Button10 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("SOL");
				else {
					nota2.setText("SOL");
				}

				
			}
		}
		class Button11 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("LAb");
				else {
					nota2.setText("LAb");
				}

				
			}
		}
		class Button12 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("LA");
				else {
					nota2.setText("LA");
				}

				
			}
		}
		class Button13 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("SIb");
				else {
					nota2.setText("SIb");
				}

				
			}
		}
		class Button14 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("SI");
				else {
					nota2.setText("SI");
				}

				
			}
		}
		class Button15 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nota1.getText().isEmpty()) nota1.setText("DOb");
				else {
					nota2.setText("DOb");
				}

				
			}
		}
		
		
		button1= new Button1();
		button2= new Button2();
		button3= new Button3();
		button4= new Button4();
		button5= new Button5();
		button6= new Button6();
		button7= new Button7();
		button8= new Button8();
		button9= new Button9();
		button10= new Button10();
		button11= new Button11();
		button12= new Button12();
		button13= new Button13();
		button14= new Button14();
		button15= new Button15();
		
		do4 = new JButton("DO");
		do4.addActionListener(button1);
		do4d = new JButton("DO#");
		do4d.addActionListener(button2);
		re4b = new JButton("REb");
		re4b.addActionListener(button3);
		re4 = new JButton("RE");
		re4.addActionListener(button4);
		mi4b= new JButton("MIb");
		mi4b.addActionListener(button5);
		mi4 = new JButton("MI");
		mi4.addActionListener(button6);
		fa4 = new JButton("FA");
		fa4.addActionListener(button7);
		fa4d = new JButton("FA#");
		fa4d.addActionListener(button8);
		sol4b= new JButton("SOLb");
		sol4b.addActionListener(button9);
		sol4 = new JButton("SOL");
		sol4.addActionListener(button10);
		la4b= new JButton("LAb");
		la4b.addActionListener(button11);
		la4= new JButton("LA");
		la4.addActionListener(button12);
		si4b= new JButton("SIb");
		si4b.addActionListener(button13);
		si4= new JButton("SI");
		si4.addActionListener(button14);
		do5b= new JButton("DOb");
		do5b.addActionListener(button15);
		
		
		panel.add(do4);
		panel.add(do4d);
		panel.add(re4b);
		panel.add(re4);
		panel.add(mi4b);
		panel.add(mi4);
		panel.add(fa4);
		panel.add(fa4d);
		panel.add(sol4b);
		panel.add(sol4);
		panel.add(la4b);
		panel.add(la4);
		panel.add(si4);
		panel.add(si4b);
		panel.add(do5b);
		
		panel.setLayout(new GridLayout(2,7));
		return panel;
	}
	
	
	private JPanel creaLatoInput() {	
		class Clear implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				nota1.setText("");
				nota2.setText("");
				}
			}
		
		JPanel panel = new JPanel();
		JLabel title = new JLabel("Inserire il numero di ricorsioni: ");
		JLabel title2 = new JLabel("Note scelte: ");
		ricorsioni = new JTextField(5);
		nota1 = new JTextField(5);
		nota2 = new JTextField(5);
		clear = new JButton("clear");
		c= new Clear();
		clear.addActionListener(c);
		
		panel.add(title);
		panel.add(ricorsioni);
		panel.add(title2);
		panel.add(nota1);
		panel.add(nota2);
		panel.add(clear);
		return panel;
	}
	
	public String change(String nota) {
		if(nota.equals("C4")) return "DO";
		if(nota.equals("C#4")) return "DO#";
		if(nota.equals("Db4")) return "REb";
		if(nota.equals("D4")) return "RE";
		if(nota.equals("Eb4")) return "MIb";
		if(nota.equals("E4")) return "MI";
		if(nota.equals("F4")) return "FA";
		if(nota.equals("F#4")) return "FA#";
		if(nota.equals("Gb4")) return "SOLb";
		if(nota.equals("G4")) return "SOL";
		if(nota.equals("Ab4")) return "LAb";
		if(nota.equals("A4")) return "LA";
		if(nota.equals("Bb4")) return "SIb";
		if(nota.equals("B4")) return "SI";
		if(nota.equals("Cb5")) return "DOb";
		
		return null;
	}
	
}

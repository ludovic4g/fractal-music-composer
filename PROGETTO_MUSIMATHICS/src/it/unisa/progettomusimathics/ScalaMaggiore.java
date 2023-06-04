package it.unisa.progettomusimathics;

import java.util.Arrays;
import java.util.Scanner;


import org.jfugue.player.Player;

public class ScalaMaggiore {
	static String[] notes = {"C4", "C4#", "D4b", "D4", "E4b", "E4", "F4", "F4#", "G4b", "G4", "A4b", "A4", "B4b", "B4", "C5b", "C5", "C5#", "D5b", "D5", "E5b", "E5", "F5", "F5#", "G5b", "G5", "A5b", "A5", "B5b", "B5", "C6b", "C6"};
	static String[] durations = {"w", "h", "q", "i", "s", "t"};
	static int lunghezze=0;
	static String[][] scales = new String[][] {
		{"C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5"},
		{"C4#", "D4#", "E4#", "F4#", "G4#", "A4#", "B4#", "C5#"},
		{"D4b", "E4b", "F4", "G4b", "A4b", "B4b", "C5", "D5b" },
		{"D4", "E4", "F4#", "G4", "A4", "B4", "C5#", "D5"},
		{"E4b", "F4", "G4", "A4b", "B4b", "C5", "D5", "E5"},
		{"E4", "F4#", "G4#", "A4", "B4", "C5#", "D5#", "E5"},
		{"F4", "G4", "A4", "B4b", "C5", "D5#", "E5", "F5"},
		{"F4#", "G4#", "A4#", "B4", "C5#", "D5#", "E5#", "F5#"},
		{"G4b", "A4b", "B4b", "C5b", "D5b", "E5b", "F5", "G5b"},
		{"G4", "A4", "B4", "C5", "D5", "E5", "F5#", "G5"},
		{"A4b", "B4b", "C5", "D5b", "E5b", "F5", "G5", "A5b"},
		{"A4", "B4", "C5#", "D5", "E5", "F5#", "G5#", "A5"},
		{"B4b", "C5", "D5#", "E5b", "F5", "G5", "A5", "B5b"},
		{"B4", "C5#", "D5#", "E5", "F5#", "G5#", "A5#", "B5"},
		{"C5b", "D5b", "E5b", "F5b", "G5b", "A5b", "B5b", "C6b"},		
	};

		
	
	
	public static void main(String[] args) {
		String music ="";
		String[] frattali= new String[400];
		//System.out.println("Inserire il numero di ricorsioni: ");
		//Scanner in = new Scanner(System.in);
		//int k = in.nextInt();
		int k =2;
		
		
		int c=k;
		int voce=0;
		
		String note1= "E#4"; //mi4
		String note2= "B#4"; //si4
		//String note1= "G4b";
		//String note2= "E4b";
		String m1 ="";
		String m2 ="";
		String m3 ="";
		String m4 ="";
		String m5 ="";
		String m6 ="";
		
		int ric=1;
		int last=2;
		int pointer=0;
		int indice1=0;
		int intervallo=0;
		
		for(int p=0; p<notes.length; p++) {
			if(notes[p].equals(note1)) {
				indice1=p;
			}
		}
		
		for(int w=0; w<scales[indice1].length; w++) {
			if(scales[indice1][w].equals(note2)) intervallo=w;
		}
		
		System.out.println("nota1= " + indice1);
		System.out.println("intervallo nota2= " + intervallo);
		
		frattali[0]= note1 + "w";
		frattali[1]= note2 + "w";	
		
		
		
		while(true) {
			//k=1
			for(int i=0; i<c; i++) {
			m1+= frattali[0] + " " + frattali[1] + " ";
			}
			music+= "\nV0 I[Piano] " + m1 + " ";
			
			ric++;
			++voce;
			if(ric>k) break;
			 //k=2
			for(int i=0; i<2; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+1];
				frattali[last]= temp1;
				m2+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(1));
					String change= frattali[pointer].substring(0,1) + --num;
					frattali[last+1]=scales[Arrays.asList(notes).indexOf(change)][3] + durations[lunghezze+1];
					m2+=frattali[last+1]+ " ";
					last+=2;
					
				}
				else {
					frattali[last+1] = scales[Arrays.asList(notes).indexOf(temp)][3] + durations[lunghezze+1];
					m2+=frattali[last+1]+ " ";
					last+=2;
				}
				
				++pointer;
				 				
			}
	
			music+= "V1 I[Piano] rw rw ";
			for(int i=0; i<c-1; i++) {
				music+= m2;
			}
			
			
			ric++;
			if(ric>k) break;
			
			//k=3
			for(int i=0; i<4; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+2];
				frattali[last]= temp1;
				m3+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(1));
					String change= frattali[pointer].substring(0,1) + --num;
					frattali[last+1]=scales[Arrays.asList(notes).indexOf(change)][3] + durations[lunghezze+2];
					m3+=frattali[last+1]+ " ";
					last+=2;
					
				}
				else {
					frattali[last+1] = scales[Arrays.asList(notes).indexOf(temp)][3] + durations[lunghezze+2];
					m3+=frattali[last+1]+ " ";
					last+=2;
				}
				
				pointer++;
				
			}
			music+= " V2 I[Piano] rw rw rw rw ";
			
			for(int i=0; i<c-2; i++) {
				music+= m3;
			}
			ric++;
			if(ric>k) break;
			
			//k=4
			
			for(int i=0; i<8; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+3];
				frattali[last]= temp1;
				m4+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(1));
					String change= frattali[pointer].substring(0,1) + --num;
					frattali[last+1]=scales[Arrays.asList(notes).indexOf(change)][3] + durations[lunghezze+3];
					m4+=frattali[last+1]+ " ";
					last+=2;
					
				}
				else {
					frattali[last+1] = scales[Arrays.asList(notes).indexOf(temp)][3] + durations[lunghezze+3];
					m4+=frattali[last+1]+ " ";
					last+=2;
				}
				
				pointer++;
				
			}
			music+= "V3 I[Piano] rw rw rw rw rw rw ";
			for(int i=0; i<c-3; i++) {
				music+= m4;
			}
			ric++;
			if(ric>k) break;
			
			//k=5
			for(int i=0; i<16; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+4];
				frattali[last]= temp1;
				m5+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(1));
					String change= frattali[pointer].substring(0,1) + --num;
					frattali[last+1]=scales[Arrays.asList(notes).indexOf(change)][3] + durations[lunghezze+4];
					m5+=frattali[last+1]+ " ";
					last+=2;
					
				}
				else {
					frattali[last+1] = scales[Arrays.asList(notes).indexOf(temp)][3] + durations[lunghezze+4];
					m5+=frattali[last+1]+ " ";
					last+=2;
				}
				
				pointer++;
				
			}
			music+= " V4 I[Piano] rw rw rw rw rw rw rw rw ";
			
			for(int i=0; i<c-4; i++) {
				music+= m5;
			}
			ric++;
			if(ric>k) break;
			
			//k=6
			for(int i=0; i<32; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+5];
				frattali[last]= temp1;
				m6+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>=15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(1));
					String change= frattali[pointer].substring(0,1) + --num;
					frattali[last+1]=scales[Arrays.asList(notes).indexOf(change)][3] + durations[lunghezze+5];
					m6+=frattali[last+1]+ " ";
					last+=2;
					
				}
				else {
					frattali[last+1] = scales[Arrays.asList(notes).indexOf(temp)][3] + durations[lunghezze+5];
					m6+=frattali[last+1]+ " ";
					last+=2;
				}
				
				pointer++;
				
			}
			music+= " V5 I[Piano] rw rw rw rw rw rw rw rw rw rw ";
			
			for(int i=0; i<c-5; i++) {
				music+= m6;
			}
			ric++;
			if(ric>k) break;			
		}
		
		
		
		Player player = new Player();
		System.out.print("Music played: ");
		System.out.print(music);
		//player.play(music);
		}


}

 


package it.unisa.progettomusimathics;

import java.util.Arrays;
import java.util.Random;

import org.jfugue.player.Player;

public class Fractals {
	//definizione delle note (più del dovuto per evitare eccezioni)
	private String[] notes = {"C4", "C#4", "Db4", "D4", "Eb4", "E4", "F4", "F#4", "Gb4", "G4", "Ab4", "A4", "Bb4", "B4", "Cb5", "C5", "C#5", "Db5", "D5", "Eb5", "E5", "F5", "F#5", "Gb5", "G5", "Ab5", "A5", "Bb5", "B5", "Cb6", "C6"};
	//lunghezze di ogni nota partendo dalla semibreve, minima, semi-minima, croma, semicroma, biscroma
	private String[] durations = {"w", "h", "q", "i", "s", "t"};
	private int lunghezze=0;
	//definizione delle scale maggiori delle 15 note accessibili all'utente
	private String[][] scales = new String[][] {
		{"C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5"},
		{"C#4", "D#4", "E#4", "F#4", "G#4", "A#4", "B#4", "C#5"},
		{"Db4", "Eb4", "F4", "Gb4", "Ab4", "Bb4", "C5", "Db5" },
		{"D4", "E4", "F#4", "G4", "A4", "B4", "C#5", "D5"},
		{"Eb4", "F4", "G4", "Ab4", "Bb4", "C5", "D5", "E5"},
		{"E4", "F#4", "G#4", "A4", "B4", "C#5", "D#5", "E5"},
		{"F4", "G4", "A4", "Bb4", "C5", "D#5", "E5", "F5"},
		{"F#4", "G#4", "A#4", "B4", "C#5", "D#5", "E#5", "F#5"},
		{"Gb4", "Ab4", "Bb4", "Cb5", "Db5", "Eb5", "F5", "Gb5"},
		{"G4", "A4", "B4", "C5", "D5", "E5", "F#5", "G5"},
		{"Ab4", "Bb4", "C5", "Db5", "Eb5", "F5", "G5", "Ab5"},
		{"A4", "B4", "C#5", "D5", "E5", "F#5", "G#5", "A5"},
		{"Bb4", "C5", "D#5", "Eb5", "F5", "G5", "A5", "Bb5"},
		{"B4", "C#5", "D#5", "E5", "F#5", "G#5", "A#5", "B5"},
		{"Cb5", "Db5", "Eb5", "Fb5", "Gb5", "Ab5", "Bb5", "Cb6"},		
	};
	private int ricorsioni;
	private String nota1;
	private String nota2;
	private String music;
	private String[] frattali;
	private Player player;
	private String m1 =""; //stringa contenente la prima voce e i calcoli del caso base
	private String m2 =""; //stringa contenente la seconda voce e i calcoli della prima ricorsione
	private String m3 =""; //stringa contenente la terza voce e i calcoli della seconda ricorsione
	private String m4 =""; //stringa contenente la quarta voce e i calcoli della terza ricorsione
	private String m5 =""; //stringa contenente la quinta voce e i calcoli della quarta ricorsione
	private String m6 =""; //stringa contenente la sesta voce e i calcoli della quinta ricorsione
	private Random rand;
	
	public Fractals() {
		
	}
	
	public Fractals(int ricorsioni, String nota1,  String nota2) {
		if(ricorsioni==0) ricorsioni=1;
		this.ricorsioni=ricorsioni;
		if(nota1.equals("DO")) this.nota1="C4";
		if(nota2.equals("DO")) this.nota2="C4";
		if(nota1.equals("DO#")) this.nota1="C#4";
		if(nota2.equals("DO#")) this.nota2="C#4";
		if(nota1.equals("REb")) this.nota1="Db4";
		if(nota2.equals("REb")) this.nota2="Db4";
		if(nota1.equals("RE")) this.nota1="D4";
		if(nota2.equals("RE")) this.nota2="D4";
		if(nota1.equals("MIb")) this.nota1="Eb4";
		if(nota2.equals("MIb")) this.nota2="Eb4";
		if(nota1.equals("MI")) this.nota1="E4";
		if(nota2.equals("MI")) this.nota2="E4";
		if(nota1.equals("FA")) this.nota1="F4";
		if(nota2.equals("FA")) this.nota2="F4";
		if(nota1.equals("FA#")) this.nota1="F#4";
		if(nota2.equals("FA#")) this.nota2="F#4";
		if(nota1.equals("SOLb")) this.nota1="Gb4";
		if(nota2.equals("SOLb")) this.nota2="Gb4";
		if(nota1.equals("SOL")) this.nota1="G4";
		if(nota2.equals("SOL")) this.nota2="G4";
		if(nota1.equals("LAb")) this.nota1="Ab4";
		if(nota2.equals("LAb")) this.nota2="Ab4";
		if(nota1.equals("LA")) this.nota1="A4";
		if(nota2.equals("LA")) this.nota2="A4";
		if(nota1.equals("SIb")) this.nota1="Bb4";
		if(nota2.equals("SIb")) this.nota2="Bb4";
		if(nota1.equals("SI")) this.nota1="B4";
		if(nota2.equals("SI")) this.nota2="B4";
		if(nota1.equals("DOb")) this.nota1="Cb5";
		if(nota2.equals("DOb")) this.nota2="Cb5";
	
	}
	
	public String toString() {
		music=""; //stringa finale da far suonare al player
		int c = ricorsioni;
		frattali= new String[400]; //stringa per il calcolo delle note da suonare
		
		
		int ric=1; //variabile utile per uscire fuori dal while quando finiscono i calcoli richiesti
		int last=2; //prima posizione libera dell'array di calcolo
		int pointer=0; //posizione della nota su cui effettuare il calcolo
		int indice1=0;
		int intervallo=0;
				
		//posizione della prima nota nell'array delle note e aggiunta all'array del calcolo con la sua durata
		for(int p=0; p<notes.length; p++) {
			if(notes[p].equals(nota1)) {
				indice1=p;
			}
		}
		frattali[0]= nota1 + "w";
		
		//calcolo dell'intervallo tra la prima e la seconda nota
		for(int w=0; w<scales[indice1].length; w++) {
			if(scales[indice1][w].equals(nota2)) intervallo=w;
		}
		/*caso eccezionale dove la nota non è presente nella scala (o comunque presente ma con alterazione diversa/ senza alterazione) :
		si prende la prima nota disponibile con alterazione diversa o senza alterazione  e si aggiunge la durata max*/
		if(intervallo==0) {
			for(int lala=0; lala<scales[indice1].length; lala++) {
				if(scales[indice1][lala].contains(nota2.substring(0,1))) {
					frattali[1]= scales[indice1][lala] + "w";
					intervallo = lala;
				}
			}
		}else {
			frattali[1]= nota2 + "w";	
		}
		
		/* Tecnica dei Frattali per la composizione musicale automatica:
		 * La tecnica consiste nel far scegliere due note all'utente, trovare l'intervallo i tra i due nella scala maggiore della prima nota,
		 * e facendo iterare ricorsivamente per k volte (con k stabilito dall'utente, se non stabilito questo porta al caso base ovvero
		 * solo il play delle due note scelte) le due note scegliendo man mano per ogni nota la nota stessa e la nota all'intervallo i nella scala 
		 * dimezzando di metà la loro durata ad ogni passo.
		 * Il seguente while prevede tutti i casi possibili ma verranno calcolati solo quelli richiesti dall'utente grazie alla variabile ric
		 */
		while(true) {
			//k=1 : caso base
			for(int i=0; i<c; i++) {
			m1+= frattali[0] + " " + frattali[1] + " ";
			}
			music+= "\nV0 I[Piano] " + m1 + " ";
			
			ric++;
			if(ric>ricorsioni) break;
			 //k=2
			for(int i=0; i<2; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+1];
				frattali[last]= temp1;
				m2+=frattali[last] + " ";
					
				/* Controllo nel quale la ricerca della nota ad intervallo i risulta o non essere nella lista di note o va nelle note non disponibili all'utente:
					si procede diminuendo l'ottava della nota in questione
				*/
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(2));
					String change= frattali[pointer].substring(0,2) + --num;
					//Caso dove troviamo la nota precisa ad intervallo i con la sua ottava dimezzata all'interno della matrice contenenti le scale
					// si aggiunge la durata della nota dimezzata di metà
					if(Arrays.asList(notes).indexOf(change)>0) {
					frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+1];
					m2+=frattali[last+1]+ " ";
					last+=2;
					
				}else {
					//Caso dove non troviamo la nota precisa e ci limitiamo a trovare la sua versione senza alterazione o con alterazione diversa
					// si aggiunge la durata della nota dimezzata di metà
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) change = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+1];
						m2+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				/*Caso in cui la ricerca della nota ad intervallo i con la giusta ottava risulta immediata
				 *  */
				else {
					//Caso in cui troviamo la nota ad intervallo i con giusta ottava e giusta alterazione
					// si aggiunge la durata della nota dimezzata di metà
					if(Arrays.asList(notes).indexOf(temp)>0){
					frattali[last+1] = scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+1];
					m2+=frattali[last+1]+ " ";
					last+=2;
				}else {
					//Caso in cui troviamo la nota ad intervallo i con giusta ottava ma diversa alterazione
					// si aggiunge la durata della nota dimezzata di metà
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) temp = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+1];
						m2+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				
				//si passa al calcolo delle due note prendendo di riferimento la prossima nota in frattali[]
				++pointer;
				 				
			}
			
			//setting per la voce e della prima ricorsione e mettere la prima ricorsione nella sua versione finale nella stringa finale
			music+= "V1 I[Piano] rw rw ";
			for(int i=0; i<c-1; i++) {
				music+= m2;
			}
			
			//utilizziamo la variabile ric per poter controllare di aver effettuato le iterazioni richieste dall'utente
			
			ric++;
			if(ric>ricorsioni) break;
			
			//procedimento rimane uguale per tutti gli altri casi
			
			//k=3
			for(int i=0; i<4; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+2];
				frattali[last]= temp1;
				m3+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>=15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(2));
					String change= frattali[pointer].substring(0,2) + --num;
					if(Arrays.asList(notes).indexOf(change)>0){
					frattali[last+1]=scales[Arrays.asList(notes).indexOf(change)%15][intervallo] + durations[lunghezze+2];
					m3+=frattali[last+1]+ " ";
					last+=2;
				
					}else {
						
						for(int b=0; b<notes.length;b++) {
							if(notes[b].contains(frattali[pointer].substring(0,1))) change = notes[b]; 
						}
							frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+2];
							m3+=frattali[last+1]+ " ";
							last+=2;
					}
				}
				else {
					if(Arrays.asList(notes).indexOf(temp)>0){
					frattali[last+1] = scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+2];
					m3+=frattali[last+1]+ " ";
					last+=2;
				}else {
					
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) temp = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+2];
						m3+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				
				pointer++;
				
			}
			music+= " V2 I[Piano] rw rw rw rw ";
			
			for(int i=0; i<c-2; i++) {
				music+= m3;
			}
			ric++;
			if(ric>ricorsioni) break;
			
			//k=4
			
			for(int i=0; i<8; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+3];
				frattali[last]= temp1;
				m4+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>=15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(2));
					String change= frattali[pointer].substring(0,2) + --num;
					if(Arrays.asList(notes).indexOf(change)>0){
					frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+3];
					m4+=frattali[last+1]+ " ";
					last+=2;
					
				}else {
					
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) change = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+3];
						m4+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				else {
					if(Arrays.asList(notes).indexOf(temp)>0){
					frattali[last+1] = scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+3];
					m4+=frattali[last+1]+ " ";
					last+=2;
				}else {
					
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) temp = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+3];
						m4+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				
				pointer++;
				
			}
			music+= "V3 I[Piano] rw rw rw rw rw rw ";
			for(int i=0; i<c-3; i++) {
				music+= m4;
			}
			ric++;
			if(ric>ricorsioni) break;
			
			//k=5
			for(int i=0; i<16; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+4];
				frattali[last]= temp1;
				m5+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>=15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(2));
					String change= frattali[pointer].substring(0,2) + --num;
					if(Arrays.asList(notes).indexOf(change)>0){//lo troviamo nell'array
					frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+4];
					m5+=frattali[last+1]+ " ";
					last+=2;
					
				}else {
					//nel caso in cui non si trova nell'array
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) change = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+4];
						m5+=frattali[last+1]+ " ";
						last+=2;
			}
				}
				else {
					if(Arrays.asList(notes).indexOf(temp)>0){//lo troviamo nell'array
					frattali[last+1] = scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+4];
					m5+=frattali[last+1]+ " ";
					last+=2;
				}else {
					//nel caso in cui non si trova nell'array
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) temp = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+4];
						m5+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				
				pointer++;
				
			}
			music+= " V4 I[Piano] rw rw rw rw rw rw rw rw ";
			
			for(int i=0; i<c-4; i++) {
				music+= m5;
			}
			ric++;
			if(ric>ricorsioni) break;
			
			//k=6
			for(int i=0; i<32; i++) {
				String temp = frattali[pointer].substring(0,frattali[pointer].length()-1);
				String temp1 = temp+durations[lunghezze+5];
				frattali[last]= temp1;
				m6+=frattali[last] + " ";
				if(Arrays.asList(notes).indexOf(temp)<0 || Arrays.asList(notes).indexOf(temp)>=15) {
					int num = Character.getNumericValue(frattali[pointer].charAt(2));
					String change= frattali[pointer].substring(0,2) + --num;
					if(Arrays.asList(notes).indexOf(change)>0){//lo troviamo nell'array
					frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+5];
					m6+=frattali[last+1]+ " ";
					last+=2;
					
				}else {
					//nel caso in cui non si trova nell'array
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) change = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(change))%15][intervallo] + durations[lunghezze+5];
						m6+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				else {
					if(Arrays.asList(notes).indexOf(temp)>0){//lo troviamo nell'array
					frattali[last+1] = scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+5];
					m6+=frattali[last+1]+ " ";
					last+=2;
				}else {
					//nel caso in cui non si trova nell'array
					for(int b=0; b<notes.length;b++) {
						if(notes[b].contains(frattali[pointer].substring(0,1))) temp = notes[b]; 
					}
						frattali[last+1]=scales[(Arrays.asList(notes).indexOf(temp))%15][intervallo] + durations[lunghezze+5];
						m6+=frattali[last+1]+ " ";
						last+=2;
				}
				}
				
				pointer++;
				
			}
			music+= " V5 I[Piano] rw rw rw rw rw rw rw rw rw rw ";
			
			for(int i=0; i<c-5; i++) {
				music+= m6;
			}
			ric++;
			if(ric>ricorsioni) break;			
		}
		//System.out.println(music);
		return music;
	}
	
	public void play() {
		player = new Player();
		player.play(music);
	}
	
	public String notes() {
		return m1+m2+m3+m4+m5+m6;
	}
	
	public String getRandomNote() {
		return notes[(int) Math.floor(Math.random() *(15 - 0 + 1) + 0)];
	}
	
	public String getRandomRecursion() {
		int a= (int) Math.floor(Math.random() *(6 - 1 + 1) + 1);
		return Integer.toString(a);
	}
	
	
	
}

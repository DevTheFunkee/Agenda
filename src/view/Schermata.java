package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import model.Agenda;
import model.Divertimento;
import model.Impegno;
import model.Lavoro;



public class Schermata {

	private Agenda agenda;
	private Scanner scan=new Scanner(System.in);
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public void avvioMenu() throws ParseException{
		System.out.println("--------Benvenuto!-----------");
		String scelta=null;
		do{
			System.out.println("Scegli una voce:");
			System.out.println("1: stampa impegni");
			System.out.println("2: aggiungi impegno");
			System.out.println("3: scheda impegno");
			System.out.println("4: elimina impegno");
			System.out.println("fine: per uscire dal menu");
			System.out.println("--------------------------");
			scelta=this.scan.nextLine();
			switch(scelta){
			case "1": this.stampaImpegni();break;
	        case "2": this.aggiungiImpegno();break;			
			case "3": this.stampaSchedaImpegno();break;
			case "4": this.eliminaImpegno();break;				
			case "fine": System.out.println("Fine del menu!") ;break;
			default: System.out.println("Inserisci un comando valido!");break;
			}		
		}
		while(!scelta.equals("fine"));
		System.out.println("------Arrivederci!--------");
	}
	
	
	public void stampaImpegni(){

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy – HH:mm:ss");
		List<Impegno> elenco = this.agenda.getElencoImpegni();
//		intestazione
	
		System.out.format("|+++++|+++++++++++++++++++++++++++++++++++"
				+ "|++++++++++++++++++|++++++++++++++++|++++++++++++++++++++|++++++++|%n");
		System.out.format("| %3s | %33s | %16s | %14s | %18s | %6s |%n",
				"Id","Data","Descrizione","Citta","Indirizzo","Civico");
		for(int i=0;i<elenco.size();i++){			
				System.out.format("| %-3s | %-33s | %-16s | %-14s | %18s | %6s |%n",
					elenco.get(i).getId(),
					elenco.get(i).getData().getTime(),
					elenco.get(i).getDescrizione(),
					elenco.get(i).getCitta(),
					elenco.get(i).getIndirizzo(),
					elenco.get(i).getCivico());
				
			
		} // fine for
		System.out.format("|+++++|+++++++++++++++++++++++++++++++++++"
				+ "|++++++++++++++++++|++++++++++++++++|+++++++++++++++++++++|++++++++|%n");
		
	
	}
	
	public boolean aggiungiImpegno() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH.mm.ss");
		 
		 GregorianCalendar c = new GregorianCalendar();
		 
		
		 
//		variabili locali di lavoro
		String input,tipo=null;
		String[] voci=null;
		String[] val=null;
		String anno =null;
		String mese =null;
		String giorno =null;
		String ore=null;
		String minuti=null;
		int i=0;
		boolean res=false;
		//messaggi
		System.out.println("Inserisci un' impegno:\nScegli un tipo tra:");
		System.out.println("l : lavoro\nd : divertimento\np o altro : impegno generico");
		System.out.println("---------------------");
		input=scan.nextLine();
		//compongo l'array
		switch(input){
			case "l":
				voci=new String[7];
				val=new String[7];
				voci[4]="nome azienda";
				voci[5]="motivo";
				voci[6]="extra";
				System.out.println("Impegno di LAVORO:");
			break;
			case "d":
				voci=new String[7];	
				val=new String[7];	
				voci[4]="amici";
				voci[5]="locale";
				voci[6]="extra";
				System.out.println("Impegno con AMICI:");
				break;
			default:
				voci=new String[4];
				val=new String[4];
				System.out.println("Stai inserendo un'IMPEGNO GENERICO:");
				break;
		}
		//voci comuni a tutti i tipi di contatto

		voci[0]="descrizione";	
		voci[1]="citta";	
		voci[2]="indirizzo";	
		voci[3]="civico";
//		conservo dato del tipo e uso input per la raccolta altri dati
		tipo=input;
		
	
		System.out.println("inserisci l'anno:");
		anno=scan.nextLine();
		System.out.println("inserisci mese:");
		mese=scan.nextLine();
		System.out.println("inserisci giorno:");
		giorno=scan.nextLine();
		System.out.println("inserisci ora:");
		ore=scan.nextLine();
		System.out.println("inserisci minuti:");
		minuti=scan.nextLine();
		 String miaData = ""+giorno+"/"+mese+"/"+anno+"-"+ore+"."+minuti+".00";
		 c.setTime(sdf.parse(miaData));
		do{	
			//raccolta dati input standard con un ciclo
			if(i==voci.length) break;
			System.out.println("inserisci "+voci[i]+":");
			input=scan.nextLine();
			val[i]=input;
			i++;
		}
		while(!input.equals("annulla"));
		
		//se si annulla si rompe l'esecuzione del metodo
		if(input.equals("annulla")){
			System.out.println("Inserimento annullato");
			return false;
		}
		//si va qui se non si è rotto il metodo
//		//aggiungo il contatto alla rubrica
		switch(tipo){
		case "l":
			Lavoro lv=new Lavoro(c,val);
			res=this.agenda.add(lv);			
			break;
		case "d":
			Divertimento dm=new Divertimento(c,val);
			res=this.agenda.add(dm);
			break;
		default:
			Impegno ip=new Impegno(c,val);
			res=this.agenda.add(ip);
			break;
	}		
//	//restituisco il risultato dell'operazione di rubrica.add(...)		
	return res;
	}	


	public void stampaSchedaImpegno(){
		System.out.println("Scegli un ID per vedere la scheda:");
		System.out.println("---------------------");
		int input=scan.nextInt();
		scan.nextLine();
		Impegno i=this.agenda.trovaImpegno(input);
		if(i!=null){
			System.out.format("+++++++++++++++++++++++++++++++%n");
			System.out.format("ID: %s %n", i.getId()+"".toUpperCase());
			System.out.format("Data: %s %n", i.getData().getTime());
			System.out.format("Descrizione: %s %n", (i.getDescrizione()==null)?"":i.getDescrizione());
			System.out.format("Citta: %s %n", (i.getCitta()==null)?"":i.getCitta());
			System.out.format("Indirizzo: %s %n", (i.getIndirizzo()==null)?"":i.getIndirizzo());
			System.out.format("Civico: %s %n", (i.getCivico()==null)?"":i.getCivico());
			if(i instanceof Divertimento){
				Divertimento d= (Divertimento)i;
				System.out.format("Amici: %s %n", (d.getAmici()==null)?"":d.getAmici().toUpperCase());
				System.out.format("Locali: %s %n", (d.getLocale()==null)?"":d.getLocale().toUpperCase());
				System.out.format("Extra: %s %n", (d.getExtra()==null)?"":d.getExtra().toUpperCase());
				System.out.format("Tipo: IMPEGNO DI DIVERTIMENTO %n" );
			}else{
				if(i instanceof Lavoro){
					Lavoro l=(Lavoro)i;
					System.out.format("Nome Azienda: %s %n", l.getNomeAzienda()==null?"":l.getNomeAzienda().toUpperCase());
					System.out.format("Motivo: %s %n", l.getMotivo()==null?"":l.getMotivo().toUpperCase());
					System.out.format("Extra: %s %n",l.getExtra()==null?"":l.getExtra().toUpperCase());
					System.out.format("Tipo: IMPEGNO DI LAVORO %n" );
				}else{
					System.out.format("Tipo: IMPEGNO GENERICO %n" );
				}
			}
			System.out.format("+++++++++++++++++++++++++++++++%n");
			}
			else{
				System.out.println("Nessuna persona per questo ID.");
			}
	}
		public boolean eliminaImpegno(){
	

		System.out.println("Scegli un ID per eliminare la persona:");
		System.out.println("---------------------");
		int input=scan.nextInt();
		scan.nextLine();
		Impegno i=this.agenda.trovaImpegno(input);	
		if(i==null){
			System.out.println("Elemento non trovato!");
			return false;
		}
		boolean ris = this.agenda.remove(input);
		if(ris==false){
			System.out.println("Elemento NON Eliminato!\n------\n");
		}
		else{
			System.out.println("Elemento "+i.getData()+" "+
					i.getDescrizione()+" Eliminato!\n------\n");
		}
		return ris;
	}
}
	


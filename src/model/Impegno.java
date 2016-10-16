package model;

import java.util.GregorianCalendar;

public class Impegno {
	private static int count;
	private int id;
	private GregorianCalendar data;
		private String descrizione;
		private String citta;	
		private String indirizzo;
		private String civico;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public GregorianCalendar getData() {
			return data;
		}
		public void setData(GregorianCalendar data) {
			this.data = data;
		}
		public String getDescrizione() {
			return descrizione;
		}
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
		public String getCitta() {
			return citta;
		}
		public void setCitta(String citta) {
			this.citta = citta;
		}
		public String getIndirizzo() {
			return indirizzo;
		}
		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}
		public String getCivico() {
			return civico;
		}
		public void setCivico(String civico) {
			this.civico = civico;
		}
		
		private void incrementaCount(){
			count++;
			this.id=count;		
		}
		public Impegno() {
			super();
			this.incrementaCount();
		}
		public Impegno(GregorianCalendar data, String descrizione, String citta, String indirizzo, String civico) {
			super();
			this.data = data;
			this.descrizione = descrizione;
			this.citta = citta;
			this.indirizzo = indirizzo;
			this.civico = civico;
			this.incrementaCount();
		}
		public Impegno(GregorianCalendar data, String descrizione) {
			super();
			this.data = data;
			this.descrizione = descrizione;
			this.incrementaCount();
		}
	
		public Impegno(GregorianCalendar data, String[] arr) {
			super();
			this.data = data;
			this.descrizione = arr[0];
			this.citta = arr[1];
			this.indirizzo = arr[2];
			this.civico = arr[3];
			this.incrementaCount();
		}
		

		
		
}

		
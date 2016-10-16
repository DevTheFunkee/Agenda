package model;

import java.util.GregorianCalendar;

public class Lavoro extends Impegno {
			
			private String nomeAzienda;
			private String motivo;
			private String extra;
			public String getNomeAzienda() {
				return nomeAzienda;
			}
			public void setNomeAzienda(String nomeAzienda) {
				this.nomeAzienda = nomeAzienda;
			}
			public String getMotivo() {
				return motivo;
			}
			public void setMotivo(String motivo) {
				this.motivo = motivo;
			}
			public String getExtra() {
				return extra;
			}
			public void setExtra(String extra) {
				this.extra = extra;
			}
		
			public Lavoro(String nomeAzienda, String motivo, String extra) {
				super();
				this.nomeAzienda = nomeAzienda;
				this.motivo = motivo;
				this.extra = extra;
			}
			public Lavoro(GregorianCalendar data, String descrizione, String citta, String indirizzo, String civico,
					String nomeAzienda, String motivo, String extra) {
				super(data, descrizione, citta, indirizzo, civico);
				this.nomeAzienda = nomeAzienda;
				this.motivo = motivo;
				this.extra = extra;
			}
			public Lavoro(GregorianCalendar data, String descrizione, String nomeAzienda, String motivo) {
				super(data, descrizione);
				this.nomeAzienda = nomeAzienda;
				this.motivo = motivo;
			}
	
			
			public Lavoro(GregorianCalendar data, String[] arr, String nomeAzienda, String motivo) {
				super(data, arr);
				this.nomeAzienda = nomeAzienda;
				this.motivo = motivo;
			}
			public Lavoro(GregorianCalendar data,String[] arr) {
				super(data,arr);
				this.nomeAzienda=arr[4];
				this.motivo=arr[5];
				this.extra=arr[6];
//				// TODO Auto-generated constructor stub
			}
			
			
			
}

package model;

import java.util.GregorianCalendar;

public class Divertimento extends Impegno {
			
			private String amici;
			private String locale;
			private String extra;
			public String getAmici() {
				return amici;
			}
			public void setAmici(String amici) {
				this.amici = amici;
			}
			public String getLocale() {
				return locale;
			}
			public void setLocale(String locale) {
				this.locale = locale;
			}
			public String getExtra() {
				return extra;
			}
			public void setExtra(String extra) {
				this.extra = extra;
			}
		
			public Divertimento(String amici, String locale, String extra) {
				super();
				this.amici = amici;
				this.locale = locale;
				this.extra = extra;
			}
			public Divertimento(GregorianCalendar data, String descrizione, String citta, String indirizzo,
					String civico, String amici, String locale, String extra) {
				super(data, descrizione, citta, indirizzo, civico);
				this.amici = amici;
				this.locale = locale;
				this.extra = extra;
			}
			public Divertimento(GregorianCalendar data, String descrizione, String amici, String locale) {
				super(data, descrizione);
				this.amici = amici;
				this.locale = locale;
			}
			
			
			public Divertimento(GregorianCalendar data, String[] arr) {
				super(data,arr);
				this.amici=arr[4];
				this.locale=arr[5];
				this.extra=arr[6];
			}
			
			
			
}

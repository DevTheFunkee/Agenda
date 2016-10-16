package init;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import model.Agenda;
import persistenza.Serializzatore;
import view.Schermata;
public class App {

	public static void main(String[] args) throws ParseException {
		Agenda model=null;
		try {
			model=Serializzatore.recupera();
		} catch (FileNotFoundException e) {
			//non c'è il file data.dat
			model=new Agenda();
		} catch (ClassNotFoundException e) {
			System.out.println("Problemi con la classe Agenda");
		} catch (IOException e) {
			System.out.println("Problemi I/O");
			try {
				Serializzatore.getCanaleRecupera().close();
			} catch (IOException e1) {
				System.out.println("problemi con la chiusura canale input");
			}
		}
		if(model!=null){
			Schermata view=new Schermata();
			view.setAgenda(model);
			view.avvioMenu();
		}

	}

}
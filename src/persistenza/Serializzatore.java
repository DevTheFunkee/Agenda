package persistenza;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.*;

public class Serializzatore {
	private static FileOutputStream out=null;
	private static ObjectOutputStream canaleSalva=null;
	private static FileInputStream in=null;
	private static ObjectInputStream canaleRecupera=null;
	
	public static void salva(Agenda r) 
			throws FileNotFoundException,IOException{
		File f=new File("data.dat");
		//creare il canale base di output
		out=new FileOutputStream(f);
		//arricchiamo il flusso di output
		canaleSalva=new ObjectOutputStream(out);
		canaleSalva.writeObject(r);
		//chiudo il canale
		canaleSalva.close();		
	}
	
	public static Agenda recupera() 
			throws FileNotFoundException,
			IOException,ClassNotFoundException{
		//creo il canale base di input/lettura
		in=new FileInputStream(new File("data.dat"));
		//arricchiamo il canale di input
		canaleRecupera=new ObjectInputStream(in);
		Agenda r=(Agenda)canaleRecupera.readObject();
		canaleRecupera.close();
		return r;
	}
	
	
	
	public static ObjectOutputStream getCanaleSalva() {
		return canaleSalva;
	}
	public static void setCanaleSalva(ObjectOutputStream canaleSalva) {
		Serializzatore.canaleSalva = canaleSalva;
	}
	public static ObjectInputStream getCanaleRecupera() {
		return canaleRecupera;
	}
	public static void setCanaleRecupera(ObjectInputStream canaleRecupera) {
		Serializzatore.canaleRecupera = canaleRecupera;
	}
	
}

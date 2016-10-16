package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import model.Agenda;
import model.Impegno;
import view.Schermata;


public class AppTest {

	
		@Test
		public void testSchermata() throws ParseException{
			
			List<Impegno> elenco=new ArrayList<Impegno>();
	
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 String miaData = "01/02/1990";
			 GregorianCalendar c = new GregorianCalendar();
			c.setTime(sdf.parse(miaData));
			elenco.add(new Impegno( c,"pini"));
			elenco.add(new Impegno( new GregorianCalendar(2016,Calendar.MAY,12),"mino"));
			elenco.add(new Impegno(new GregorianCalendar(2016,Calendar.AUGUST,12),"tino"));
			elenco.add(new Impegno(new GregorianCalendar(2016,Calendar.MARCH,12),"ciano"));
			elenco.add(new Impegno(new GregorianCalendar(2016,Calendar.MAY,12),"ano"));
			elenco.add(new Impegno( new GregorianCalendar(2016,Calendar.AUGUST,12),"clano"));
			elenco.add(new Impegno( new GregorianCalendar(2016,Calendar.APRIL,12),"cino"));
			elenco.add(new Impegno( new GregorianCalendar(2016,Calendar.JULY,12),"chino"));
			elenco.add(new Impegno(new GregorianCalendar(2016,Calendar.FEBRUARY,12),"nino"));
			
			Agenda model=new Agenda();
			model.setElencoImpegni(elenco);
			Schermata view=new Schermata();
			view.setAgenda(model);
			view.avvioMenu();
			
		}


}

package model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
		

	private List<Impegno> elencoImpegni=new ArrayList<Impegno>();
	
	

	public List<Impegno> getElencoImpegni() {
		return elencoImpegni;
	}

	public void setElencoImpegni(List<Impegno> elencoImpegni) {
		this.elencoImpegni = elencoImpegni;
	}

	public Agenda(List<Impegno> elencoImpegni) {
		super();
		this.elencoImpegni = elencoImpegni;
	}

	public Agenda() {
		super();
	}



	
	public int size() {
		return elencoImpegni.size();
	}

	public boolean add(Impegno e) {
		return elencoImpegni.add(e);
	}

	public boolean remove(int idogg) {
		Impegno i=this.trovaImpegno(idogg);
		return elencoImpegni.remove(i);
	}

	public Impegno get(int index) {
		return elencoImpegni.get(index);
	}

	public Impegno trovaImpegno(int idogg){
		for(Impegno i : this.elencoImpegni){
			if(i.getId()==idogg){
				return i;
			}
		}
		return null;
	}	
}

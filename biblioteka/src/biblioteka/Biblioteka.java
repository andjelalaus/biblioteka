package biblioteka;
import java.util.ArrayList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {

	//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
	private List<Knjiga> knjige=new ArrayList<Knjiga>();
	
	@Override
	public void addBook(Knjiga knjiga) {
		if(knjiga==null)
			throw new NullPointerException("Vuk kaze bolje validator");
		if(knjige.contains(knjiga))
			throw new IllegalArgumentException("Budalo jedna knjiga vec postoji");
		
		knjige.add(knjiga);

	}

	@Override
	public void deleteBook(Knjiga knjiga) {
		knjige.remove(knjiga);

	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
		//return null;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {

		if(autor==null && isbn<0 && naslov==null && izdavac==null)
			throw new IllegalArgumentException("Po cemu majke ti da pretrazim");
	
	List<Knjiga> rezultati=new ArrayList<Knjiga>();
	
	if(naslov!=null)
		for(Knjiga k:knjige)
			if(k.getNaslov().toLowerCase().contains(naslov.toLowerCase().trim()))
				rezultati.add(k);
		
		return rezultati;
	}

}

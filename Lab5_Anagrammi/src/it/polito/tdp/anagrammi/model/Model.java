package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;


public class Model {
	
	List<Lettera> lettere  = new ArrayList<Lettera> () ;
	
	
 	public Set<Anagramma> cercaAnagramma(String testoInserito){
 		Set<Anagramma> best = new HashSet<Anagramma> () ;
 		List<Lettera> parziale = new LinkedList<Lettera>() ;
		AnagrammaDAO dao = new AnagrammaDAO () ;
		System.out.println(testoInserito);
		
		for (int i = 0 ; i <testoInserito.length() ; i++){
			Lettera l = new Lettera (testoInserito.charAt(i), i) ;
			lettere.add(l) ;
		}
		
		
		int livello = 0 ;
		
		recursive (parziale, livello, best) ;
		
		lettere.clear();
		
		for(Anagramma a : best){
			a.setCorretta(dao.isCorrect(a.getNome()));
		}
		
		return best ;
	}
 	
	private void recursive(List<Lettera> parziale, int livello, Set<Anagramma> best) {
		
		if(parziale.size() == lettere.size()){
			String parola = "";
			for(Lettera l : parziale ){
				parola += l.getLettera();
			}
			Anagramma a = new Anagramma(parola) ;
			System.out.println(a);
			best.add(a) ;
		}
		
		
		for( Lettera l : lettere){
			if(!parziale.contains(l)){
				parziale.add(l);
				recursive(parziale, livello+1, best) ;
				parziale.remove(l) ;
			}
		}
		
	}

 	}

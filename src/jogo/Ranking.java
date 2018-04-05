package jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ranking {
	
	private final IJogo jogo;
	
	public Ranking(IJogo jogo) throws Exception
	{
		this.jogo = jogo;
		if(!jogo.getEncerrado())
			throw new Exception("O jogo deve estar encerrado para se criar um ranking.");
	}
	
	public List<IResultado> getOrdenadoPorPontos()
	{
		List<IResultado> re = jogo.getResultados();
		
		Collections.sort(re, new Comparator<IResultado>() {

			@Override
			public int compare(IResultado o1, IResultado o2) {
				return (int) (o1.getMetrica() - o2.getMetrica());
			}
			
		});	
		
		return re;
	}
	
}

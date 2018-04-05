package testes.jogo; 

import jogo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteJogo {

	private Jogo jogo;
	private Participante part1;
	
	@BeforeEach
	public void SetUp()
	{
		jogo = new Jogo("Joguinho");
		part1 = new Participante("Ronaldo");
	}
	
	//Rafael Zabeu
	@Test
	void naoPodeTerDoisResultadosDoMesmoJogador() throws Exception
	{
		jogo.anota(new Resultado(part1, 10));
		jogo.anota(new Resultado(part1, 20));
		
		assertEquals(1, jogo.getResultados().size());
	}
	
	//Rafael Sançon
	@Test
	void naoPodeEncerrarOJogoComApenasUmJogador() throws Exception {
		jogo.anota(new Resultado(part1, 20.0));
		assertThrows(Exception.class,
				()->{
					jogo.encerrar(); 
				});
	}
}


package testes; 

import jogo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteJogo {

	private Jogo jogo;
	private Participante part1;
	private Participante part2;
	private Participante part3;
	
	@BeforeEach
	public void SetUp()
	{
		jogo = new Jogo("Joguinho");
		part1 = new Participante("Ronaldo");
		part2 = new Participante("Jao");
		part3 = new Participante("Mari");
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
	
	//Alex Welerson Teles
	@Test
	void naoPodeAceitarParticipantesDepoisDeFechado() throws Exception
	{
		jogo.anota(new Resultado(part1, 10));
		jogo.anota(new Resultado(part2, 20));
		
		jogo.encerrar();
		
		assertThrows(Exception.class,() -> {
			jogo.anota(new Resultado(part3, 40));
		});
		
	}
	
}


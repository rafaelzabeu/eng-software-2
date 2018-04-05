package testes;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;



import jogo.IJogo;
import jogo.Ranking;

public class TesteRanking {
	
	@Mock
	private IJogo jogo;
	
	@BeforeEach
	private void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void soPodeAceitarJogosFechados()
	{
		when(jogo.getEncerrado()).thenReturn(false);
		assertThrows(Exception.class, () -> {
			new Ranking(jogo);
		});
	}
	
}

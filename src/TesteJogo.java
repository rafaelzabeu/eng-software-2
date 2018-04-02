import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TesteJogo {

	@Test()
	void quandoUmJogoForEncerradoComMenosDeDoisResultadosEntaoUmaExcecaoSeraDisparada() {
		Jogo jogo = new Jogo("Joguinho");
		jogo.anota(new Resultado(new Participante("Ronaldo"), 20.0));
		assertThrows(NullPointerException.class,
				()->{
					jogo.encerrar(); 
				});
	}

}


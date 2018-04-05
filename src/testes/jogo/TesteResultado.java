package testes.jogo;

import jogo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteResultado {

	private Jogo jogo;
	private Participante part1;

	@BeforeEach
	public void SetUp() {
		jogo = new Jogo("Joguinho");
		part1 = new Participante("Ronaldo");
	}

	// José Estevão
	@Test
	void metricaDeveSerPositiva() {
		assertThrows(Exception.class, () -> {
			Resultado resultado = new Resultado(part1, -10.0);
		});
	}

	
	
}

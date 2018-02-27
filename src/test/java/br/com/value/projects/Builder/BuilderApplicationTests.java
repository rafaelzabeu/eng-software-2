package br.com.value.projects.Builder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import br.com.value.projects.Ranking.Ranking;
import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Participante;
import br.com.value.projects.dominio.Resultado;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuilderApplicationTests {

	private Jogo jogo;

	private Participante joao;
	private Participante maria;
	private Participante pedro;

	@Before
	public void PreparaOJogo()
	{
		joao = new Participante("Joao");
        maria = new Participante("Maria");
        pedro = new Participante("Pedro");


        jogo = new Jogo("Teste de integraçao com o ranking");

        jogo.anota(new Resultado(joao, 10));
        jogo.anota(new Resultado(maria, 20));
        jogo.anota(new Resultado(pedro, 15));
	}

	@Test
    public void RankingJogoTest()
    {
        Ranking rank = new Ranking(jogo);

        List<Resultado> ordRank = rank.GetOrderedRanking();

        List<Resultado> res = new ArrayList<>();
        res.add(new Resultado(maria, 20));
        res.add(new Resultado(pedro, 15));
        res.add(new Resultado(joao, 10));

        assertThat(ordRank, is(res));
	}

	@Test
    public void UltimoAdicionado()
    {
        Resultado ultimoResultado = jogo.getUltimoResultadoVisto();
		Resultado resultadoDoJoao = new Resultado(pedro, 15);
		assertThat(ultimoResultado, is(resultadoDoJoao));
	}
	
	

}

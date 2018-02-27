package br.com.value.projects.Ranking;

import br.com.value.projects.dominio.Jogo;
import br.com.value.projects.dominio.Resultado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {
    private List<Resultado> resultados;

    public Ranking()
    {
        resultados = new ArrayList<Resultado>();
    }

    public Ranking(Jogo jogo)
    {
        resultados = new ArrayList<>(jogo.getResultados());
    }

    public void AddScore(Resultado res)
    {
        if(!HasThisParticipant(res.getParticipante().getNome()))
        {
            resultados.add(res);
        }
    }

    public List<Resultado> GetOrderedRanking()
    {
        Collections.sort(resultados, Collections.reverseOrder());
        return Collections.unmodifiableList(resultados);
    }

    private boolean HasThisParticipant(String name)
    {
        for (Resultado res : resultados)
        {
            if(res.getParticipante().getNome().equals(name))
                return true;
        }
        return false;
    }

}
